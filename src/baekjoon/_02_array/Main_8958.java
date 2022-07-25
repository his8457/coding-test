package baekjoon._02_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_8958 {

	public static void main(String[] args) {
		/*
		 * 문제 
		 * "OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. 
		 * O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 
		 * 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 
		 * 예를 들어, 10번 문제의 점수는 3이 된다. "OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다. 
		 * OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오. 
		 * 입력 
		 * 첫째 줄에 테스트 케이스의 개수가 주어진다. 
		 * 각 테스트 케이스는 한 줄로 이루어져 있고, 길이가 0보다 크고 80보다 작은 문자열이 주어진다.
		 * 문자열은 O와 X만으로 이루어져 있다. 출력 각 테스트 케이스마다 점수를 출력한다.
		 * 예 
		 * 5 
		 * OOXXOXXOOO 
		 * OOXXOOXXOO 
		 * OXOXOXOXOXOXOX 
		 * OOOOOOOOOO 
		 * OOOOXOOOOXOOOOX
		 * 
		 * 결과 
		 * 10 
		 * 9 
		 * 7 
		 * 55
		 * 30
		 */

		printResult();
	}
	
	/* 테스트 케이스를 입력받고 각 케이스에 해당하는 점수를 출력한다.*/
	public static void printResult() {
		// 1. 입력받을 변수를 선언한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = 0; // 테스트 케이스의 수
		int addedNum = 1; // O가 연속으로 나올때 더해지는 수
		int sum = 0; // O의 누적 합산 결과
		
		try { 
				N = Integer.parseInt(br.readLine()); 
			} catch (NumberFormatException e) { 
				e.printStackTrace(); 
			} catch (IOException e) { 
				e.printStackTrace(); 
			}
		
		for (int i = 0; i < N; i++) {
			addedNum = 1;
			sum = 0;
			String testCase = "";

			try {
				testCase = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			for (int k = 0; k < testCase.length(); k++) {
				if ('X' == testCase.charAt(k)) {
					addedNum = 1;
				} else {
					sum += addedNum;
					addedNum++;
				}
			}
			System.out.println(sum);
		}
	}
}
