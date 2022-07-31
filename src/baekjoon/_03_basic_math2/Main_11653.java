package baekjoon._03_basic_math2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_11653 {

	public static void main(String[] args) throws Exception {
		/*
		 * 문제
		 * 정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.
		 * 입력
		 * 첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.
		 * 출력
		 * N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력한다. 
		 * N이 1인 경우 아무것도 출력하지 않는다.
		 * 
		 * 예제 입력 1 
		 * 72
		 * 예제 출력 1 
		 * 2
		 * 2
		 * 2
		 * 3
		 * 3
		 * 
		 * 예제 입력 2 
		 * 3
		 * 예제 출력 2 
		 * 3
		 * */
		
		/**
		 * 이해한 내용
		 * 주어진 숫자를 소인수 분해 하여 오름차순으로 출력
		 * 단, 1인 경우 아무것도 출력하지 않음.
		 * 
		 * 주어진 수의 특수케이스에 대한 유효성 검사가 필이 필요할 것으로 보임.
		 * 특수케이스 : 1이주어지거나, 소수인 경우 등
		 * */
		
		printPrimeFactorization();
	}

	private static void printPrimeFactorization() throws Exception{

		//1. 정수 N을 입력 받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		//2. N을 소인수 분해하고 결과를 한줄에 하나씩 출력한다. (주어진 수가 1일경우 아무것도 출력하지 않고 프로그램을 종료한다.)
		if(N > 1) {
			int divisor = 2; //정수 N(피제수)을 나누는 제수 (최소값 2)
			int dividend = N; //피제수
			
			while(dividend != 1) {
				if(dividend % divisor == 0) {
					dividend = dividend / divisor;
					bw.append(divisor+"\n");
					divisor = 2; //초기화
				}else {
					divisor++;
				}
			}
			
			bw.flush();
			bw.close();
			br.close();
		}
	}
}
