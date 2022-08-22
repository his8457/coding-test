package baekjoon._08_mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1037 {
	public static void main(String[] args) throws Exception {
		//[백준] 1037 약수
		/*
		 * 문제
		 * 양수 A가 N의 진짜 약수가 되려면, N이 A의 배수이고, A가 1과 N이 아니어야 한다. 
		 * 어떤 수 N의 진짜 약수가 모두 주어질 때, N을 구하는 프로그램을 작성하시오.
		 * 입력
		 * 첫째 줄에 N의 진짜 약수의 개수가 주어진다. 
		 * 이 개수는 50보다 작거나 같은 자연수이다. 
		 * 둘째 줄에는 N의 진짜 약수가 주어진다. 
		 * 1,000,000보다 작거나 같고, 2보다 크거나 같은 자연수이고, 중복되지 않는다.
		 * 
		 * 출력
		 * 첫째 줄에 N을 출력한다. N은 항상 32비트 부호있는 정수로 표현할 수 있다.
		 * 예제 입력 1 
		 * 2
		 * 4 2
		 * 예제 출력 1 
		 * 8
		 * 예제 입력 2 
		 * 1
		 * 2
		 * 예제 출력 2 
		 * 4
		 * 예제 입력 3 
		 * 6
		 * 3 4 2 12 6 8
		 * 예제 출력 3 
		 * 24
		 * 예제 입력 4 
		 * 14
		 * 14 26456 2 28 13228 3307 7 23149 8 6614 46298 56 4 92596
		 * 예제 출력 4 
		 * 185192
		 * */
		
		solve();
	}

	private static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int R = 0;
		String input = br.readLine();
		String[] inputArr = null;
		
		if(input.contains(" ")) {
			inputArr = input.split(" ");
			
			int[] tempArr = new int[inputArr.length];
			for(int i = 0; i < inputArr.length; i++) {
				tempArr[i] = Integer.parseInt(inputArr[i]);
			}
			
			int min = 0;
			int max = 0;
			
			min = tempArr[0];
			max = tempArr[0];
			for(int i = 1; i < tempArr.length; i++) {
				min = tempArr[i] < min ? tempArr[i] : min;
				max = tempArr[i] > max ? tempArr[i] : max;
			}
			R = min * max;
			
		}else {
			R = (int) Math.pow(Integer.parseInt(input), 2);
		}
		
		System.out.println(R);
	}
}
