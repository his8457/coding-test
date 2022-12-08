package baekjoon._05_sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1427 {
	public static void main(String[] args) throws Exception {
		// [백준] 1427 소트인사이드
		/*문제
			배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
			
			입력
			첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
			
			출력
			첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.
			
			예제 입력 1 
			2143
			예제 출력 1 
			4321
			예제 입력 2 
			999998999
			예제 출력 2 
			999999998
			예제 입력 3 
			61423
			예제 출력 3 
			64321
			예제 입력 4 
			500613009
			예제 출력 4 
			965310000
		 * 
		 * */
		
		solve();
	}

	private static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int size =  s.length();
		int[] input = new int[size];
		int index = 0; //input 배열에서 최대값의 index
		int max = 0; //최대값
		
		//주어진 수를 배열에 담음
		for(int i = 0; i < size; i++) {
			input[i] = s.charAt(i) - '0';
		}
		
		//내림차순 정렬 (선택정렬)
		for(int i = 0; i < size; i++) {
			max = i;
			for(int j = i+1; j < size; j++) {
				if(input[j] > input[max]){
					max = j;
				}
			}
			
			if(input[i] < input[max]) {
				int temp = input[i];
				input[i] = input[max];
				input[max] = temp;
			}
		}
		
		//결과 출력
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < input.length; i++) {
			sb.append(input[i]);
		}
		
		System.out.println(sb);
	}
}
