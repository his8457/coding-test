package baekjoon._11_recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_24060 {
	public static void main(String[] args) throws Exception {
		// [백준] 24060 알고리즘 수업- 병합 정렬 1
		/*
		 * 오늘도 서준이는 병합 정렬 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.
			N개의 서로 다른 양의 정수가 저장된 배열 A가 있다. 병합 정렬로 배열 A를 오름차순 정렬할 경우 배열 A에 K 번째 저장되는 수를 구해서 우리 서준이를 도와주자.
			
			크기가 N인 배열에 대한 병합 정렬 의사 코드는 다음과 같다.
			====================================================================================
			merge_sort(A[p..r]) { # A[p..r]을 오름차순 정렬한다.
			    if (p < r) then {
			        q <- ⌊(p + r) / 2⌋;       # q는 p, r의 중간 지점
			        merge_sort(A, p, q);      # 전반부 정렬
			        merge_sort(A, q + 1, r);  # 후반부 정렬
			        merge(A, p, q, r);        # 병합
			    }
			}
			
			# A[p..q]와 A[q+1..r]을 병합하여 A[p..r]을 오름차순 정렬된 상태로 만든다.
			# A[p..q]와 A[q+1..r]은 이미 오름차순으로 정렬되어 있다.
			merge(A[], p, q, r) {
			    i <- p; j <- q + 1; t <- 1;
			    while (i ≤ q and j ≤ r) {
			        if (A[i] ≤ A[j])
			        then tmp[t++] <- A[i++]; # tmp[t] <- A[i]; t++; i++;
			        else tmp[t++] <- A[j++]; # tmp[t] <- A[j]; t++; j++;
			    }
			    while (i ≤ q)  # 왼쪽 배열 부분이 남은 경우
			        tmp[t++] <- A[i++];
			    while (j ≤ r)  # 오른쪽 배열 부분이 남은 경우
			        tmp[t++] <- A[j++];
			    i <- p; t <- 1;
			    while (i ≤ r)  # 결과를 A[p..r]에 저장
			        A[i++] <- tmp[t++]; 
			}
			====================================================================================
			
			입력
			첫째 줄에 배열 A의 크기 N(5 ≤ N ≤ 500,000), 저장 횟수 K(1 ≤ K ≤ 108)가 주어진다.
			
			다음 줄에 서로 다른 배열 A의 원소 A1, A2, ..., AN이 주어진다. (1 ≤ Ai ≤ 109)
			
			출력
			배열 A에 K 번째 저장 되는 수를 출력한다. 저장 횟수가 K 보다 작으면 -1을 출력한다.
			
			예제 입력 1 
			5 7
			4 5 1 3 2
			예제 출력 1 
			3
			4 5 1 3 2 -> 
			4 5 1 3 2 ->
			4 5 1 3 2 -> 
			1 5 1 3 2 -> 
			1 4 1 3 2 -> 
			1 4 5 3 2 -> 
			1 4 5 2 2 -> 
			1 4 5 2 3 -> 
			1 4 5 2 3 -> 
			1 2 5 2 3 -> 
			1 2 3 2 3 -> 
			1 2 3 4 3 -> 
			1 2 3 4 5. 
			총 12회 저장이 발생하고 일곱 번째 저장되는 수는 3이다.
			
			예제 입력 2 
			5 13
			4 5 1 3 2
			예제 출력 2 
			-1
			저장 횟수 12가 K 보다 작으므로 -1을 출력한다.
		 * */
		solve();
	}
	
	static int K = 13; //저장횟수
	static int count = 0;
	static int result = -1;
	static int[] A, tmp;
	
	private static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]); //배열크기
		K = Integer.parseInt(input[1]); // 저장회수
		
		String[] s = br.readLine().split(" ");
		A = new int[N];
		
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(s[i]);
		}
		
		tmp = new int[N];
		merge_sort(A, 0, N-1);
		
		System.out.println(result);
	}
	
	public static void merge_sort(int[] A, int low, int high) {
		if(low < high) {
			int	mid = (low + high) / 2;
			merge_sort(A, low, mid); //전반부 정렬
			merge_sort(A, mid + 1, high); //후반부 정렬
			merge(A, low, mid, high);
		}
	}
	
	public static void merge(int[] A, int low, int mid, int high) {
		int i = low;
		int j = mid+1;
		int t = 0;
		
		while(i <= mid && j <= high) {
			if(A[i] <= A[j]) {
				tmp[t++] = A[i++];
			}else {
				tmp[t++] = A[j++];
			}
		}
		
		while(i <= mid) { //왼쪽 배열 부분이 남은 경우
			tmp[t++] = A[i++];
		}
		while(j <= high) { //오른쪽 배열 부분이 남은 경우
			tmp[t++] = A[j++];
		}
		
		i = low;
		t = 0;
		
		while(i <= high) {
			count++;
			if(count == K) {
				result = tmp[t];
				break;
			}
			A[i++] = tmp[t++];
		}
	}
}
