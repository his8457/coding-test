package baekjoon._08_mathematics;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2609 {
	public static void main(String[] args) throws Exception {
		// [백준] 2609 최대공약수와 최소공배수
		/*
		 * 문제
		 * 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
		 * 입력
		 * 첫째 줄에는 두 개의 자연수가 주어진다. 
		 * 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.
		 * 
		 * 출력
		 * 첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 
		 * 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
		 * 
		 * 예제 입력 1 
		 * 24 18
		 * 예제 출력 1 
		 * 6
		 * 72
		 * */
		
		solve();
	}

	private static void solve() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] strArr = str.split(" ");
		
		int N = Integer.parseInt(strArr[0]);
		int M = Integer.parseInt(strArr[1]);
		
		int minValue = N >= M ? M : N;//작은값 찾기
		int highestValue = 0;
		int minimum = 0; 
		
		for(int i = 1; i <= minValue; i++) {
			if(N % i == 0 && M % i == 0) {
				highestValue = i;
			}
		}
		
		minimum = N * M / highestValue;
		
		System.out.println(highestValue);
		System.out.println(minimum);
	}
}
