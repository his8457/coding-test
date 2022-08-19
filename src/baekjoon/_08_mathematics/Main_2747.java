package baekjoon._08_mathematics;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2747 {
	public static void main(String[] args) throws Exception {
		//[백준] 2747 수학 -> 피보나치 수
		/*
		 * 문제
		 * 피보나치 수는 0과 1로 시작한다. 
		 * 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 
		 * 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
		 * 이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
		 * n=17일때 까지 피보나치 수를 써보면 다음과 같다.
		 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
		 * n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
		 * 
		 * 입력
		 * 첫째 줄에 n이 주어진다. 
		 * n은 45보다 작거나 같은 자연수이다.
		 * 
		 * 출력
		 * 첫째 줄에 n번째 피보나치 수를 출력한다.
		 * 예제 입력 1 
		 * 10
		 * 예제 출력 1 
		 * 55
		 * */
		solve();
	}

	private static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] fibonacci = new int[n+1];
		
		for(int i = 0; i < n+1; i++) {
			if(i == 0) {
				fibonacci[i] = 0;
			}else if (i == 1) {
				fibonacci[i] = 1;
			}else {
				fibonacci[i] = fibonacci[i-1] + fibonacci[i-2]; 
			}
		}
		
		System.out.println(fibonacci[n]);
	}
}
