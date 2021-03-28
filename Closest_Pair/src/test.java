import java.util.*;

public class test {

    static int[][] position;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);

        int N =sc.nextInt(); // 점의 개수

        position = new int[N][2]; // 각 점의 위치

        // 위치 입력
        for(int i=0; i<N; i++){
            position[i][0]=sc.nextInt(); // x값 위치
            position[i][1]=sc.nextInt(); // y값 위치
        }

        // x 중앙값 구하기
        int[] xArray = new int [N];
        for(int i=0; i<N; i++){
            xArray[i]=position[i][0];
        }
        double xMed = Xmedian(xArray);

        // 평면 2분할
        int firstNod=-1;
        int secondNod=-1;
        ArrayList<Integer> Divide1 = new ArrayList<Integer>();
        ArrayList<Integer> Divide2 = new ArrayList<Integer>();

        for(int i=0; i<N; i++){
            if(position[i][0]<=xMed){
                Divide1.add(i);
            }
            else{
                Divide2.add(i);
            }
        }

        // 각 분할에서 최소 값 선정 - 이재권
        double min1=1000;
        int node11 = -1;
        int node12 = -1;
        for(int i=0; i<Divide1.size()-1;i++){
            for(int j=i+1; j<Divide1.size();j++){
                int a = Divide1.get(i);
                int b = Divide1.get(j);
                double tmp = calDist(a,b);
                if(tmp<min1) min1=tmp; node11=a; node12=b;
            }
        }

        // 각 분할에서 최소 값 선정 - 이재권
        double min2=1000;
        int node21 = -1;
        int node22 = -1;
        for(int i=0; i<Divide2.size()-1;i++){
            for(int j=i+1; j<Divide2.size();j++){
                int a = Divide2.get(i);
                int b = Divide2.get(j);
                double tmp = calDist(a,b);
                if(tmp<min2) min1=tmp; node21=a; node22=b;
            }
        }

        // 두 분할 중 더 최소값을 선정
        double falsemin=0;
        if(min1<=min2) {
            falsemin=min1; firstNod=node11; secondNod=node12;
        }
        else {
            falsemin=min2; firstNod=node21; secondNod=node22;
        }

        // 중앙 부분 산정
        int medianXmin = (int) (xMed-falsemin)-1;
        int medianXmax = (int) (xMed+falsemin)+1;
        ArrayList<Integer> DivideMed = new ArrayList<Integer>();
        for(int i=0;i<N;i++){
            if((position[i][0]>medianXmin)&&(position[i][0]<medianXmax)){
                DivideMed.add(i);
            }
        }

        // 중앙 부분의 최소값 산정
        double realmin=falsemin;
        for(int i=0; i<DivideMed.size()-1;i++){
            for(int j=i+1; j<DivideMed.size();j++){
                int a = DivideMed.get(i);
                int b = DivideMed.get(j);
                double tmp = calDist(a,b);
                if(tmp<realmin) {
                    realmin=tmp; firstNod=a; secondNod=b;
                }
            }
        }

        System.out.println(realmin+" "+firstNod+" "+secondNod);

    }

    // 두점 사이의 거리를 구하는 공식
    public static double calDist(int a, int b){

        return Math.sqrt(Math.pow(position[a][0]-position[b][0],2)+Math.pow(position[a][1]-position[b][1],2));

    }

    // x 중앙값 구하기
    public static double Xmedian(int[] xArray){

        Arrays.sort(xArray);
        double answer=0;

        int size = xArray.length;
        // x 값이 짝수라면
        if(size % 2 == 0){
            int m = size / 2;
            int n = (size / 2) - 1;
            answer = (double)(xArray[m]+xArray[n])/2;
        }
        else{
            int m = size/2;
            answer = xArray[m];
        }

        return answer;

    }

}