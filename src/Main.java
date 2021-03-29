import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int number_of_points = scanner.nextInt();
        int[][] coordinates = new int[number_of_points][2];

        // 최대 50의 정수 난수를 좌표 (x,y)에 대입
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i][0] = random.nextInt(50);
            coordinates[i][1] = random.nextInt(50);
        }

        Main closest_pair = new Main();
        closest_pair.find_pair(coordinates);
    }

    public int[] find_pair(int[][] coordinates) {
        public static double Xmedian ( int[] xArray){

            Arrays.sort(xArray);
            double answer = 0;

            int size = xArray.length;
            // x 값이 짝수라면
            if (size % 2 == 0) {
                int m = size / 2;
                int n = (size / 2) - 1;
                answer = (double) (xArray[m] + xArray[n]) / 2;
            } else {
                int m = size / 2;
                answer = xArray[m];
            }

            return answer;

        }


        // 두점 사이의 거리를 구하는 공식
        public static double get_distance ( int[][] coordinates, int x, int y){
            return Math.sqrt(Math.pow(coordinates[x][0] - coordinates[y][0], 2) + Math.pow(coordinates[x][1] - coordinates[y][1], 2));
        }
        // 중앙값 부분 산정
        int median_min = (int) (xMedian-falsemin)-1;
        int median_max = (int) (xMedian+falsemin)+1;
        ArrayList<Integer> Divide_Med = new ArrayList<Integer>();
        for(int i=0;i<N;i++){
            if((position[i][0]>median_min)&&(position[i][0]<median_max)){
                DivideMed.add(i);
            }
        }
    }
}



