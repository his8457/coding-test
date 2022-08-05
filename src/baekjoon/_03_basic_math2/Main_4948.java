package baekjoon._03_basic_math2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
		
		printPrimeCount();
	}

	private static void printPrimeCount() throws Exception{
		//1. 주어진 수를 입력받을 변수를 선언한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> inputString = new ArrayList<>();
		
		while(true) {
			int temp = Integer.parseInt(br.readLine());
			System.out.println(temp);
			if(temp == 0) {
				break;
			}else {
				inputString.add(temp);
			}
		}
		
		//2. 결과를 담을 변수를 선언한다.
		StringBuffer sb = new StringBuffer();
		
		//3. 구간을 담을 두 수 N1, N2을 선언한다.
		int N1, N2, count; 
		
		for(int i = 0; i < inputString.size(); i++) {
			N1 = inputString.get(i); //주어진 수 N
			N2 = N1 * 2; //주어진 수 2N
			count = 0;
			
			for(int k = N1+1; k <= N2; k++) {
				if(isPrime(k)) {
					count++;
				}
			}
			sb.append(count + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	private static boolean isPrime(int num) {
		boolean result = true;
		if(num == 1) {//1은 소수가 아니므로 제외
			return false;
		}
		
		for(int i = 2; i < num; i++) {
			if(i < num && num % i == 0) {
				return false;
			}
		}
		
		return result;
	}
}
