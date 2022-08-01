package baekjoon._03_basic_math2;

import java.util.Scanner;

public class Main_1928 {

	public static void main(String[] args) throws Exception {
		/*
		 * 문제
		 * M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
		 * 입력
		 * 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) 
		 * M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
		 * 
		 * 출력
		 * 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
		 * 
		 * 예제 입력 1 
		 * 3 16
		 * 예제 출력 1 
		 * 3
		 * 5
		 * 7
		 * 11
		 * 13
		 * */
		
		printPrimes();
		
	}

	private static void printPrimes() {
		// 0, 1 번째 인덱스를 제외한 나머지를 true로 세팅
		boolean[] sosu = new boolean[1000000];
		sosu[0] = false;
		sosu[1] = false;
		for(int i = 2; i < sosu.length; i++) {
			sosu[i] = true;
		}
		// 에라토스테네스의 체를 이용하여 소수가 아닌 인덱스를 false로 변경
		for(int i = 2; i < sosu.length; i++) {
			if(sosu[i]) {
				for(int j = 2*i; j < sosu.length; j += i) {
					sosu[j] = false;
				}
			}
		}
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		// a에서 b 사이의 true(소수)인 인덱스 값을 출력
		for(int i = a; i <= b; i++) {
			if(sosu[i]) {
				System.out.println(i);
			}
		}
		sc.close();
	}	
}