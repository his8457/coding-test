package baekjoon._05_sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10989 {

	public static void main(String[] args) throws Exception {
		// [백준] 10989 정렬 - 수 정렬하기3
		/*
		 * 문제
		 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
		 * 입력
		 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 
		 * 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
		 * 출력
		 * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
		 * 예제 입력 1 
		 * 10
		 * 5
		 * 2
		 * 3
		 * 1
		 * 4
		 * 2
		 * 3
		 * 5
		 * 1
		 * 7
		 * 예제 출력 1 
		 * 1
		 * 1
		 * 2
		 * 2
		 * 3
		 * 3
		 * 4
		 * 5
		 * 5
		 * 7
		 * */
		
		solve();
	}

	private static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		int[] arr = new int[cnt];
		
		for(int i = 0; i< cnt; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int maximum = arr[0];
		for(int i = 1; i <= arr.length-1; i++) {
			maximum = maximum < arr[i] ? arr[i] : maximum; 
		}
		
		int[] result = new int[maximum+1];
		
		for(int i = 0; i < arr.length; i++) {
			result[arr[i]]++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i < result.length; i++) {
			for(int j = 0; j < result[i]; j++) {
				sb.append(i + "\n");
			}
		}
		System.out.println(sb);
	}
}
