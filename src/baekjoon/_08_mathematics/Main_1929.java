package baekjoon._08_mathematics;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1929 {
	public static void main(String[] args) throws Exception {
		// [백준] 1929 소수 구하기
		/*
		 * 문제
			M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
			
			입력
			첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. 
			(1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
			
			출력
			한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
			
			예제 입력 1 
			3 16
			예제 출력 1 
			3
			5
			7
			11
			13
		 * */
		solve();
	}

	private static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		boolean[] arr = new boolean[M+1];
		arr[0] = arr[1] = true;
        
		for(int i = 2; i < arr.length; i++) {
			for(int j = i+i; j < arr.length; j = j + i ) {
				arr[j] = true;
			}
		}
		
		for(int i = N; i <= M; i++) {
			if(arr[i] == false) {
				System.out.println(i);
			}
		}
	}
}