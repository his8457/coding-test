package baekjoon._03_basic_math2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2581 {

	public static void main(String[] args) throws Exception{
		/*
		 * 문제
		 * 자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 
		 * 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.
		 * 
		 * 예를 들어 M=60, N=100인 경우 60이상 100이하의 자연수 중 
		 * 소수는 61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로, 
		 * 이들 소수의 합은 620이고, 최솟값은 61이 된다.
		 * 
		 * 입력
		 * 입력의 첫째 줄에 M이, 둘째 줄에 N이 주어진다.
		 * M과 N은 10,000이하의 자연수이며, M은 N보다 작거나 같다.
		 * 
		 * 출력
		 * M이상 N이하의 자연수 중 소수인 것을 모두 찾아 첫째 줄에 그 합을, 
		 * 둘째 줄에 그 중 최솟값을 출력한다. 
		 * 단, M이상 N이하의 자연수 중 소수가 없을 경우는 첫째 줄에 -1을 출력한다.
		 * 
		 * 예제 입력 1 
		 * 60
		 * 100
		 * 예제 출력 1 
		 * 620
		 * 61

		 * 예제 입력 2 
		 * 64
		 * 65
		 * 예제 출력 2 
		 * -1
		 * */
		
		/**
		 * 이해한 내용
		 * 숫자 M, N이 주어질 떄 (10000 이하의 자연수)
		 * 1. M ~ N 사이의 소수의 합을 출력
		 * 2. 소수 중 최소 값을 출력
		 * ※ 소수가 없을 경우 -1 출력
		 * 
		 * 소수의 최소값은 M ~ N사이의 소수를 구할 때, M을 포함하여 첫번쨰로 등장하는 소수임
		 * */
		
		printSumAndMinPrimes();
	}

	private static void printSumAndMinPrimes() throws Exception{
		// 1. 두 수 M, N을 입력 받고, 결과를 입력받을 변수를 선언한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		int min = 0;
		
		// 2. 소수 및 소수의 합을 구한다.
		boolean isFirst = true;
		for(int i = M; i <= N; i++) {
			boolean isPrime = true;
			
			if(i == 1) {//1은 소수가 아니므로 소수 여부를 판단하지 않음.
				continue;
			}
			
			for(int k = 2; k < i; k++) {
				if(i % k == 0) {
					isPrime = false;
					break;
				}
			}
			
			if(isPrime) {
				sum += i;
				if(isFirst) {
					min = i;
					isFirst = false;
				}  
			}
		}
		
		if(sum == 0 && min == 0) {
			bw.append(-1 + ""); //소수가 없는 케이스는 -1을 출력한다.
		}else {
			bw.append(sum + ""); //소수의 합
			bw.append("\n");
			bw.append(min + ""); //소수중 최소 값
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
