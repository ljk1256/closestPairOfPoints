import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number_of_points = scanner.nextInt();
        start(number_of_points);
    }

    public static void start(int number_of_points){
        Random random = new Random();

        int[][] coordinates = new int[number_of_points][2];
        int[][] resultcoordinate = new int[2][2];
        double result_d;

        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i][0] = random.nextInt(50);
            coordinates[i][1] = random.nextInt(50);
        }
        Arrays.sort(coordinates);

        resultcoordinate = divideHalf(coordinates, 0, number_of_points);    // 최종 좌표 배열
        result_d = get_distance(resultcoordinate, 0, 1);      // 최종 좌표 거리

        System.out.printf("좌표는 (%d, %d) , (%d, %d) 거리는 %f 입니다. ", resultcoordinate[0][0], resultcoordinate[0][1], resultcoordinate[1][0], resultcoordinate[1][1], result_d);
    }

    public static int[][] divideHalf(int[][] coordinates, int left, int right) {
        int[][] Answer = new int[2][2];



        double smallest_distance = Math.min(min1, min2);
        int[][] smallest_center_points = find_smallest_in_center(coordinates, center_point, smallest_distance);
        if (smallest_distance < get_distance(smallest_center_points, 0, 1))
            Answer = smallest_center_points.clone();
        return Answer;
    }

    // 중앙에서 최소 거리를 이루는 점의 쌍이 있는지 찾기
    public static int[][] find_smallest_in_center(int[][] coordinates, int[] center_point, double max_distance) {
        double smallest_distance = max_distance;  // 최소 거리
        int[][] smallest_points = new int[][]{{9999, 9999}, {9999, 9999}};  // 최소 거리를 이루는 좌표쌍

        for (int i = 0; i < coordinates.length; i++)  // 좌표 x의 최대값까지
            for (int j = i + 1; j < coordinates[0].length; j++) {  // i와 i+1이랑 비교
                if (coordinates[i][0] <= center_point[0] - max_distance && coordinates[i][0] >= center_point[0] + max_distance)
                    if (smallest_distance > get_distance(coordinates, i, j)) {
                        smallest_distance = get_distance(coordinates, i, j);
                        smallest_points[0][0] = coordinates[i][0];
                        smallest_points[0][1] = coordinates[i][1];
                        smallest_points[1][0] = coordinates[j][0];
                        smallest_points[1][0] = coordinates[j][1];
                    }
            }
        return smallest_points;
    }

    // 두점 사이의 거리를 구하는 공식
    public static double get_distance(int[][] coordinates, int x1, int x2) {
        return Math.sqrt(Math.pow(coordinates[x1][0] - coordinates[x2][0], 2) + Math.pow(coordinates[x1][1] - coordinates[x2][1], 2));
    }

}
