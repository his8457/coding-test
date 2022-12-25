package baekjoon._16_two_pointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1253 {
	public static void main(String[] args) throws Exception {
		// [백준] 1253 좋다
		/*
		 * 문제
			N개의 수 중에서 어떤 수가 다른 수 두 개의 합으로 나타낼 수 있다면 그 수를 “좋다(GOOD)”고 한다.
			N개의 수가 주어지면 그 중에서 좋은 수의 개수는 몇 개인지 출력하라.
			수의 위치가 다르면 값이 같아도 다른 수이다.
			
			입력
			첫째 줄에는 수의 개수 N(1 ≤ N ≤ 2,000), 두 번째 줄에는 i번째 수를 나타내는 Ai가 N개 주어진다. 
			(|Ai| ≤ 1,000,000,000, Ai는 정수)
			
			출력
			좋은 수의 개수를 첫 번째 줄에 출력한다.
			
			예제 입력 1 
			10
			1 2 3 4 5 6 7 8 9 10
			예제 출력 1 
			8
		 * */
		
		solve();
	}

	private static void solve() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		String[] strInputNum = br.readLine().split(" ");
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(strInputNum[i]);
		}
		
		Arrays.sort(arr);
		
		for(int k = 0; k < N; k++) {
			int target = arr[k];
			int i = 0;
			int j = N - 1;
			
			//투 포인터 알고리즘
			while (i < j) {
				if(arr[i] + arr[j] == target) {
					if(i != k && j != k) {
						result++;
						break;
					}else if(i == k) {
						i++;
					}else if (j == k) {
						j--;
					}
				}else if(arr[i] + arr[j] < target) {
					i++;
				}else {
					j--;
				}
			}
		}
		System.out.println(result);
	}
}
