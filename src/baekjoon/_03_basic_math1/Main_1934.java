package baekjoon._03_basic_math1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1934 {
	public static void main(String[] args) throws Exception {
		//[백준] 1934 최소공배수
		/*문제
		 * 두 자연수 A와 B에 대해서, A의 배수이면서 B의 배수인 자연수를 A와 B의 공배수라고 한다. 
		 * 이런 공배수 중에서 가장 작은 수를 최소공배수라고 한다. 
		 * 예를 들어, 6과 15의 공배수는 30, 60, 90등이 있으며, 최소 공배수는 30이다.
		 * 두 자연수 A와 B가 주어졌을 때, A와 B의 최소공배수를 구하는 프로그램을 작성하시오.
		 * 
		 * 입력
		 * 첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 
		 * 둘째 줄부터 T개의 줄에 걸쳐서 A와 B가 주어진다. (1 ≤ A, B ≤ 45,000)
		 * 출력
		 * 첫째 줄부터 T개의 줄에 A와 B의 최소공배수를 입력받은 순서대로 한 줄에 하나씩 출력한다.
		 * 
		 * 예제 입력 1 
		 * 3
		 * 1 45000
		 * 6 10
		 * 13 17
		 * 예제 출력 1 
		 * 45000
		 * 30
		 * 221
		 * */
		
		solve();
	}

	private static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int numberOfQuestions = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < numberOfQuestions; i++) {
			String question = br.readLine();
			int A = Integer.parseInt(question.split(" ")[0]);
			int B = Integer.parseInt(question.split(" ")[1]);
			int min = Math.min(A, B); //최소값
			int maxP = 0; //최대공약수
			
			//최대공약수 x (A / 최대공약수) x (B / 최대공약수) = 최소공배수
			for(int j = 1; j <= min; j++) {
				if(A % j == 0 && B % j == 0) {
					maxP = j;
				}
			}
			
			int result = maxP * (A / maxP) * (B / maxP);
			sb.append(result);
			sb.append(System.getProperty("line.separator"));
		}
		System.out.println(sb);
	}
}
