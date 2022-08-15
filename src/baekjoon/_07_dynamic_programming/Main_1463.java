package baekjoon._07_dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1463 {
	public static void main(String[] args) throws Exception {
		// [백준] 1463 다이나믹프로그래밍
		/*
		 * 문제
		 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
		 * X가 3으로 나누어 떨어지면, 3으로 나눈다.
		 * X가 2로 나누어 떨어지면, 2로 나눈다.
		 * 1을 뺀다.
		 * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 
		 * 연산을 사용하는 횟수의 최솟값을 출력하시오.
		 * 
		 * 입력
		 * 첫째 줄에 1보다 크거나 같고, 10^6보다 작거나 같은 정수 N이 주어진다.
		 * 출력
		 * 첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
		 * 예제 입력 1 
		 * 2
		 * 예제 출력 1 
		 * 1
		 * 예제 입력 2 
		 * 10
		 * 예제 출력 2 
		 * 3
		 * */
		
		//1로 만들때까지 연산의 최소횟수 구하기
		//10 -> 9(1을뺌) -> 3(3으로나눔) -> 1(3으로나눔)
		
		solve();
	}

	private static void solve() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int inputNum = Integer.parseInt(br.readLine());
		int calcCount = 0;
		
		while(inputNum != 1) {
			if(inputNum % 3 == 0) {
				inputNum = inputNum / 3;
				calcCount++;
			}else if((inputNum - 1) % 3 == 0) {
				inputNum = inputNum - 1;
				calcCount++;
				
				inputNum = inputNum / 3;
				calcCount++;
			}else if ((inputNum + 1) % 3 == 0) {
				inputNum = inputNum - 1;
				calcCount++;
			}
			
			if (inputNum % 2 == 0) {
				inputNum = inputNum / 2;
				calcCount++;
			}
		}
		
		System.out.println(calcCount);
	}
}
