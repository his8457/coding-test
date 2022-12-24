package baekjoon._13_sum;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11659_1 {
	public static void main(String[] args) throws Exception {
		//11659 구간 합 구하기4
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
		String inputStr = br.readLine();
		int numCnt = Integer.parseInt(inputStr.split(" ")[0]); // 숫자 개수
		int pCnt = Integer.parseInt(inputStr.split(" ")[1]); //문제 개수
		
		String[] strNumArr = br.readLine().split(" ");
		int[] sumArr = new int[numCnt+1]; // 합 배열
		
		for(int i = 1; i < sumArr.length; i++) {
			sumArr[i] = sumArr[i-1] + Integer.parseInt(strNumArr[i-1]);
		}
		
		for(int i = 0; i < pCnt; i++) {
			String s = br.readLine();
			int to = Integer.parseInt(s.split(" ")[0]);
			int from = Integer.parseInt(s.split(" ")[1]);
			System.out.println(sumArr[from]-sumArr[to-1]); //from ~ to 까지 합
		}
	}
}
