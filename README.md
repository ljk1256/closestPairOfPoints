# Closest-pair-of-points

### 팀G  201301608 이재권  202001677 최종민  201801658 김현성

최근접 점의 쌍을 찾는 분할 정복 알고리즘이다.

최소 거리를 구하기 위해 점쌍을 저장할 2차원 배열(Arrays.sort(coordinates, new Comparator<int[]>()) , Random 함수를 통한 난수를 발생하여 x좌표값을 기준으로 정렬한다.
~~~
if (right - left + 1 <= 3) return closestPair(coordinates, left, right); 점의 개수가 2개나 3개일 때
int[][] min1 = divideHalf // 분활된 왼쪽 부분
int[][] min2 = divideHalf // 분활된 오른쪽 부분
int mid = left + (right - left) / 2;  // 중앙값 인덱스
Answer = smallest_center_points.clone(); //중앙 영역에 속하는 점들 중에서 최근접 점의 쌍을 찾아서 리턴한다.
return Answer; 
~~~
