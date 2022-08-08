package baekjoon._03_basic_math2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_4948 {
	public static void main(String[] args) throws Exception {
		/*
		 * 문제
		 * 베르트랑 공준은 임의의 자연수 n에 대하여, n보다 크고, 2n보다 작거나 같은 소수는 적어도 하나 존재한다는 내용을 담고 있다.
		 * 이 명제는 조제프 베르트랑이 1845년에 추측했고, 파프누티 체비쇼프가 1850년에 증명했다.
		 * 예를 들어, 10보다 크고, 20보다 작거나 같은 소수는 4개가 있다. (11, 13, 17, 19) 또, 14보다 크고, 28보다 작거나 같은 소수는 3개가 있다. (17,19, 23)
		 * 자연수 n이 주어졌을 때, n보다 크고, 2n보다 작거나 같은 소수의 개수를 구하는 프로그램을 작성하시오. 
		 * 입력
		 * 입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 케이스는 n을 포함하는 한 줄로 이루어져 있다.
		 * 입력의 마지막에는 0이 주어진다.
		 * 출력
		 * 각 테스트 케이스에 대해서, n보다 크고, 2n보다 작거나 같은 소수의 개수를 출력한다.
		 * 제한
		 * 1 ≤ n ≤ 123,456
		 * 
		 * 예제 입력 1 
		 * 1
		 * 10
		 * 13
		 * 100
		 * 1000
		 * 10000
		 * 100000
		 * 0
		 * 예제 출력 1 
		 * 1
		 * 4
		 * 3
		 * 21
		 * 135
		 * 1033
		 * 8392
		 * */
		
//	printPrimeCount();
		findPrimeNumbers();
	}
	
	/*
	 * 제한 범위 내의 배열을 미리 선언하고 소수여부를 구해논 후에
	 * 수가 주어지면 해당 범위 안에 있는 소수의 개수만 센다. 
	 * */
	private static void findPrimeNumbers() throws Exception {
		//1. 0부터 123456*2(246912) 만큼 배열을 만들고 에라토스테네스의 체를 이용하여 소수를 미리 구한다.
		int N = 246913;
		boolean[] primeArr = new boolean[N];
		primeArr[0] = true; //0은 소수가 아님 (특수케이스)
		primeArr[1] = true; //1은 소수가 아님 (특수케이스)
		
		//소수가 아닌수는 배열에서 true로 값을 변경한다.
		//소수 : false, 소수가 아닌수 : true
		for(int i = 2; i <= Math.sqrt(N); i++) {
			if(primeArr[i] == true) {
				continue;
			}
			
			//에라토스테네스의 체
			for(int j=i*i; j < N; j=j+i) {
				primeArr[j] = true;
			}
		}
		
		//2. 입력받은 수+1 부터 입력받은 수 x 2 까지(포함) 수중 소수인 수의 개수를 센어 출력한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int K = Integer.parseInt(br.readLine());
			int primeCount = 0;

			if(K == 0) {//입력값이 0이면 종료한다.
				break;
			}
			
			for(int i=K+1; i <= K*2; i++) {
				if(primeArr[i] == false) {
					primeCount++;
				}
			}
			
			System.out.println(primeCount);
		}
		
		br.close();
	}
}
