import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("생성할 점의 개수를 입력하세요: ");
        int number_of_points = scanner.nextInt();

        start(number_of_points);
        scanner.close();
    }

    // 두 점의 거리를 구하는 메소드
    public static double get_distance(int[][] coordinates, int x1, int x2) {
        return Math.sqrt(Math.pow(coordinates[x1][0] - coordinates[x2][0], 2) + Math.pow(coordinates[x1][1] - coordinates[x2][1], 2));
    }

    // 분할,정복 재귀적 호출
    public static int[][] divideHalf(int[][] coordinates, int left, int right) {
        int[][] Answer;

        if (right - left + 1 <= 3) {  // 점의 개수가 2개나 3개일 때
            return closestPair(coordinates, left, right);
        } else {
            int mid = left + (right - left) / 2;  // 중앙값 인덱스
            int[][] min1 = divideHalf(coordinates, left, mid);  // 분할된 왼쪽 부분
            int[][] min2 = divideHalf(coordinates, mid + 1, right);  // 분할된 오른쪽 부분

            Answer = get_distance(min1, 0, 1) < get_distance(min2, 0, 1) ? min1 : min2;  // min1과 min2중 더 작은 거리
            double smallest_distance = Math.min(get_distance(min1, 0, 1), get_distance(min2, 0, 1));  // min1과 min2중 더 작은거리를 갖는 점쌍

            int[][] smallest_center_points = find_smallest_in_center(coordinates, left, right, mid, smallest_distance);  // 중앙부분에서 탐색
            if (smallest_distance > get_distance(smallest_center_points, 0, 1))  // 중앙부분에서 탐색한 쌍이 더 작은지 비교
                Answer = smallest_center_points.clone();
        }
        return Answer;
    }

    public static int[][] closestPair(int[][] coordinates, int left, int right) {
        double min = 10000000;  // 최소 거리
        int[][] mincoordinate = new int[][]{{0, 0}, {1000000, 1000000}};  // 최소거리 좌표 저장 배열

        for (int i = left; i < right; i++) {  // left 인덱스부터 right 인덱스까지 탐색
            for (int j = i + 1; j < right; j++) {
                double d = get_distance(coordinates, i, j);
                if (d <= min) {  // 구한 거리 d가 min보다 작으면 d를 min으로 저장, mincoordinate에 점쌍 저장
                    min = d;
                    mincoordinate[0][0] = coordinates[i][0];
                    mincoordinate[0][1] = coordinates[i][1];
                    mincoordinate[1][0] = coordinates[j][0];
                    mincoordinate[1][1] = coordinates[j][1];
                }
            }
        }
        return mincoordinate;
    }

    public static int[][] find_smallest_in_center(int[][] coordinates, int left, int right, int mid, double max_distance) {
        double smallest_distance = max_distance;  // 최소 거리
        int[][] smallest_points = new int[][]{{0, 0}, {100000, 100000}};  // 최소 거리를 이루는 점쌍

        for (int i = left; i < right; i++)
            for (int j = i + 1; j < right; j++) {  // i와 i+1이랑 비교
                if (coordinates[i][0] <= coordinates[mid][0] - max_distance && coordinates[i][0] >= coordinates[mid][0] + max_distance)  // +- max_distance만큼 탐색
                    if (smallest_distance > get_distance(coordinates, i, j)) {  // 구한 거리가 최소 거리보다 작으면 최소 거리로 저장, smallest_points에 점쌍 저장
                        smallest_distance = get_distance(coordinates, i, j);
                        smallest_points[0][0] = coordinates[i][0];
                        smallest_points[0][1] = coordinates[i][1];
                        smallest_points[1][0] = coordinates[j][0];
                        smallest_points[1][0] = coordinates[j][1];
                    }
            }
        return smallest_points;
    }

    public static void start(int number_of_points) {
        Random random = new Random();

        int[][] coordinates = new int[number_of_points][2];  // 점쌍을 저장할 2차원 배열
        int[][] resultcoordinate = new int[2][2];  // 최소 거리를 이루는 점쌍
        double result_d;  // 최소 거리

        for (int i = 0; i < coordinates.length; i++) {  // 난수를 발생해 [i][0]에는 x값, [i][1]에는 y값 저장
            coordinates[i][0] = random.nextInt(100);
            coordinates[i][1] = random.nextInt(100);
        }

        Arrays.sort(coordinates, new Comparator<int[]>() {  // 2차원 배열을 x좌표값을 기준으로 정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        });

        resultcoordinate = divideHalf(coordinates, 0, number_of_points - 1);  // 최종 좌표 배열
        result_d = get_distance(resultcoordinate, 0, 1);  // 최종 좌표 거리

        System.out.printf("최근접 점의 쌍 (%d, %d), (%d, %d)의 거리는 %f입니다. ", resultcoordinate[0][0], resultcoordinate[0][1], resultcoordinate[1][0], resultcoordinate[1][1], result_d);
    }

}