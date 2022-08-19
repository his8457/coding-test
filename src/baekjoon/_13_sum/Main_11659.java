package baekjoon._13_sum;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11659 {
	public static void main(String[] args) throws Exception {
		//[백준] 11659 누적합 -> 구간 합 구하기4
		/*
		 * 문제
		 * 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
		 * 
		 * 입력
		 * 첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 
		 * 둘째 줄에는 N개의 수가 주어진다. 
		 * 수는 1,000보다 작거나 같은 자연수이다. 
		 * 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
		 * 
		 * 출력
		 * 총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.
		 * 
		 * 제한
		 * 1 ≤ N ≤ 100,000
		 * 1 ≤ M ≤ 100,000
		 * 1 ≤ i ≤ j ≤ N
		 * 예제 입력 1 
		 * 5 3
		 * 5 4 3 2 1
		 * 1 3
		 * 2 4
		 * 5 5
		 * 예제 출력 1 
		 * 12
		 * 9
		 * 1
		 * */
		
		solve();
	}

	private static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		String firstInput = br.readLine(); 
		String secondInput = br.readLine();
		
		int N = Integer.parseInt(firstInput.split(" ")[0]);
		int M = Integer.parseInt(firstInput.split(" ")[1]);
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(secondInput.split(" ")[i]);
		}
		
		int start = 0;
		int end = 0;
		for(int i = 0; i < M; i++) {
			String question = br.readLine();
			start = Integer.parseInt(question.split(" ")[0]) - 1;
			end = Integer.parseInt(question.split(" ")[1]) - 1;
			
			sb.append(sum(arr, start, end));
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	private static Object sum(int[] arr, int start, int end) {
		int sum = 0;
		
		for(int i = start; i <= end; i++) {
			sum += arr[i];
		}
		
		return sum;
	}
}
