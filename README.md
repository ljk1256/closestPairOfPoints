# Closest pair of points

### 팀G  201301608 이재권  202001677 최종민  201801658 김현성

최근접 점의 쌍을 찾는 분할 정복 알고리즘이다.

우선, `main` 메소드에서 생성할 점의 수를 사용자로부터 입력받는다.

`public static void start(int number_of_points)`에서, 
좌표값을 저장할 2차원 배열 `coordinates`에 난수를 저장해 `Arrays.sort()` 메소드를 사용하여 x값을 기준으로 정렬하였다.

`resultcoordinate`는 최근접 점을 이루는 점쌍을 저장할 2차원 배열이다.

`divideHalf(int[][] coordinates, int left, int right)`는 배열을 왼쪽 부분과 오른쪽 부분으로 분할해 최근접 점의 쌍을 찾는 메소드이다.

`closestPair(int[][] coordinates, int left, int right)`는 배열을 왼쪽 부분과 오른쪽 부분으로의 최소거리 좌표를 저장해 배열하는 메소드이다.

`find_smallest_in_center(int[][] coordinates, int left, int right, int mid, double max_distance)` 는 중앙부분에서 최소를 찾는 메소드이다.

또한 2차원 배열을 @Override를 통한 x좌표값을 기준으로 정렬하였다. 

이렇게 모은 값들 중에서 최종 좌표 배열과 거리를 찾아 호출한다. 


