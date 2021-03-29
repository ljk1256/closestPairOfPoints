import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number_of_points = scanner.nextInt();

        Main main = new Main();
        main.start(number_of_points);

    }

    public static double get_distance(int [][]coordinates, int x, int y) {
        return Math.sqrt(Math.pow(coordinates[x][0] - coordinates[y][0], 2) + Math.pow(coordinates[x][1] - coordinates[y][1], 2));
    }
    
    //분할,정복 재귀적 호출
    public static int[][] divideHalf(int [][]coordinates, int left, int right){

        if(right - left <= 5){
           return closestPair(coordinates, int left, int right);
        }
        else {
            int mid = left + (right - left)/2;
            int[][] min1 = divideHalf(coordinates, left, mid);
            int[][] min2 = divideHalf(coordinates, mid+1, right);
        }

    }

    public static int[][] closestPair(int [][] coordinates, int left, int right){
        double min = 10000000000;    
        int [][] mincoordinate = new int[2][2];    // 최소거리 좌표 저장 배열

        for(int i=left; i<right; i++){
            for(int j=0; j<right; j++){
                double d = get_distance(coordinates, i, j);
                if(d <= min)
                    min = d;
                    mincoordinate[0][0] = coordinates[i][0];
                    mincoordinate[0][1] = coordinates[i][1];
                    mincoordinate[1][0] = coordinates[j][0];
                    mincoordinate[1][1] = coordinates[j][1];
            }
        }
        return mincoordinate;
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

        resultcoordinate = divideHalf(coordinates, 0, number_of_points);    // 최종 좌표 배열
        result_d = get_distance(resultcoordinate, 0, 1);      // 최종 좌표 거리

        System.out.println("좌표는 (%d, %d) , (%d, %d) 거리는 %f 입니다. ", resultcoordinate[0][0], resultcoordinate[0][1], resultcoordinate[1][0], resultcoordinate[1][1], result_d);
    }

}
