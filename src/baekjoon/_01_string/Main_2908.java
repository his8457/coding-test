package baekjoon._01_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2908 {

	public static void main(String[] args) {
		//서로 같지 않으며 숫자에 0이 포함되지 않은 3자리 수 A와 B가 있을 때, 
		//A, B를 거꾸로 읽었을 때 큰 수 구하기 ex) 734 893  -> 437 398 -> result 437
		
		printResult();
	}
	
	public static void printResult() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//1.사용할 변수 및 결과를 출력할 변수를 선언한다.
		String input = ""; //입력
		int result = 0;//결과
		int A = 0;
		int B = 0;
		
		//2.입력된 값을 변수에 저장한다.
		try {
			input = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//3. 입력 값 validation (3자리 수가 아닌 값이 들어오거나 값이 없는 경우 어떻게 할 건지?)
		if(input.length() != 7) {//두 숫자의 구분을 공백으로 한다면 입력되는 문자열 길이는 반드시 7임
			System.out.println("입력 오류!");
			return;
		}
		
		StringBuffer sb = new StringBuffer(input);
		input = sb.reverse().toString(); //입력된 값을 미리 뒤집어서 저장한다. 입력값이 456 789 이면 → 987 654 가 저장된다.
		
		//4.공백은 문자열에서 3번 index이므로 문자열 A에는 0 ~ 2까지 담고, B는 4부터 6번 index까지 분리 해서 담는다. 
		A = Integer.parseInt(input.substring(0, 3));
		B = Integer.parseInt(input.substring(4));
		
		if(A >= B) {
			result = A;
		}else {
			result = B;
		}
		
		System.out.println(result);
	}
}