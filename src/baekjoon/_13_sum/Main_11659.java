package baekjoon._13_sum;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11659 {
	public static void main(String[] args) throws Exception {
		//[백준] 11659 구간합 구하기4
		/*
		 * 문제
			수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
			
			입력
			첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 
			둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다. 
			셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
			
			출력
			총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.
			
			제한
			1 ≤ N ≤ 100,000
			1 ≤ M ≤ 100,000
			1 ≤ i ≤ j ≤ N
			예제 입력 1 
			5 3
			5 4 3 2 1
			1 3
			2 4
			5 5
			예제 출력 1 
			12
			9
			1
		 * */
		
		solve();
	}

	private static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputStr = br.readLine().split(" ");
		
		int N = Integer.parseInt(inputStr[0]); //주어진 수의 개수
		int M = Integer.parseInt(inputStr[1]); //합을 구해야 하는 횟수
		
		//문제 배열 생성
		int[] input = new int[N+1];
		int[] sumArr = new int[N+1];
		inputStr = br.readLine().split(" ");
		
		for(int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(inputStr[i-1]);
			sumArr[i] = sumArr[i-1] + input[i];
		}
		
		//i에서 j까지 지문
		int sum = 0;
		
		for(int k = 0; k < M; k++) {
			sum = 0;
			
			String[] s = br.readLine().split(" ");
			int i = Integer.parseInt(s[0]); //i
			int j = Integer.parseInt(s[1]); //j
			
			sum = sumArr[j] - sumArr[i-1];

			System.out.println(sum);
		}
	}
}
