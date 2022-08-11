package baekjoon._05_sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2750 {
	public static void main(String[] args) throws Exception {
		//[백준] 정렬 [B2] 2750 수 정렬하기 #41
		/*
		 *문제
		 *N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
		 *입력
		 *첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 
		 *둘째 줄부터 N개의 줄에는 수 주어진다. 
		 *이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 
		 *수는 중복되지 않는다.
		 *
		 *출력
		 *첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
		 *
		 *예제 입력 1 
		 *5
		 *5
		 *2
		 *3
		 *4
		 *1
		 *
		 *예제 출력 1 
		 *1
		 *2
		 *3
		 *4
		 *5 
		 * */
		
		solve();
	}

	private static void solve() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		for(int i : arr) {
			System.out.println(i);
		}
	}
}
