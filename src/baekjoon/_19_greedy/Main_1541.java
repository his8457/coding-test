package baekjoon._19_greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1541 {
	public static void main(String[] args) throws Exception {
		// [백준] 1541 잃어버린 괄호
		/*
		 * 문제
			세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.
			그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
			괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.
			
			입력
			첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다. 
			그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다. 
			수는 0으로 시작할 수 있다. 입력으로 주어지는 식의 길이는 50보다 작거나 같다.
			
			출력
			첫째 줄에 정답을 출력한다.
			
			예제 입력 1 
			55-50+40
			예제 출력 1 
			-35
			예제 입력 2 +
			10+20+30+40
			예제 출력 2 
			100
			예제 입력 3 
			00009-00009
			예제 출력 3 
			0
		 * */
		
		solve();
	}

	private static void solve() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		String tempNum = "";
		boolean isOne = true;
		boolean isMinus = false;
		int result = 0;
		
		//1.식에 주어진 수의 개수 확인
		//주어진 문자열의 앞에서부터 탐색하면서 '+' 문자 또는 '-' 문자가 나올 때까지 탐색한다. 
		//'-' 문자가 나오기 이전까지의 수는 결과 변수에 더하고 '-' 문자가 나온 이후의 숫자는 뺀다.
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i)-'0' >= 0) {
				tempNum += input.charAt(i);
			}
			
			if(isMinus) {
				if(input.charAt(i) == '+' || input.charAt(i) == '-') {
					result += (Integer.parseInt(tempNum) * -1);
					tempNum = "";
				}
			}else {
				if(input.charAt(i) == '-') {
					isMinus = true;
				}
				
				if(input.charAt(i) == '+' || input.charAt(i) == '-') {
					isOne = false;
					result += Integer.parseInt(tempNum);
					tempNum = "";
				}
			}
		}
		
		if(isOne) { //2-1. 식에 주어진 수가 1개일 경우
			System.out.println(Integer.parseInt(input));
			return;
		}else { //2-2. 식에 주어진 수가 최소 2개 이상인 경우
			if(isMinus) {// '-' 부호가 확인된 경우 
				result += (Integer.parseInt(tempNum) * -1);
			}else {
				result += Integer.parseInt(tempNum);
			}
		}
		
		System.out.println(result);
	}
}
