package baekjoon._03_basic_math2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1978 {

	public static void main(String[] args) throws Exception{
		/*
		 * 문제
		 * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
		 * 입력
		 * 첫 줄에 수의 개수 N이 주어진다. 
		 * N은 100이하이다. 
		 * 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
		 * 출력
		 * 주어진 수들 중 소수의 개수를 출력한다.
		 * 
		 * 예제 입력 1 
		 * 4
		 * 1 3 5 7
		 * 예제 출력 1 
		 * 3
		 * */
		
		/**
		 * 주어진 수가 소수인지 판단하는 방법
		 * ※ 소수란 1과 자기자신만을 약수로 갖는 수를 말함
		 * 1은 소수가 아님
		 * 
		 * 소수 여부 판별 방법 : 1 ~ (주어진수 - 1) 까지 순차적으로 나눠 본 후, 
		 * 주어진 수를 제외한 다른 수로 나누어 떨어지면 소수가 아님
		 * */
		
		printCountPrime();
	}

	private static void printCountPrime() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int inputNumCount = Integer.parseInt(br.readLine());
		int[] inputNumbers = new int[inputNumCount];
		int primeCount = 0;
		
		int index = 0;
		for(String num : br.readLine().split(" ")) {
			inputNumbers[index] = Integer.parseInt(num);
			index++;
		}
		
		for(int inputNum : inputNumbers) {
			boolean isPrime = true;
			
			if(inputNum <= 1) {
				continue;
			}
			
			for(int i = 2; i < inputNum; i++) {
				if(inputNum % i == 0) {
					isPrime = false;
					break;
				}
			}
			
			if(isPrime) {
				primeCount++;
			}
		}
		
		bw.append(primeCount + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
