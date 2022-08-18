package baekjoon._12_geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_4153 {
	public static void main(String[] args) throws Exception {
		// [백준] 4153 기하 - 직각삼각형
		/*
		 * 문제
		 * 과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다. 
		 * 주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.
		 * 
		 * 입력
		 * 입력은 여러개의 테스트케이스로 주어지며 마지막줄에는 0 0 0이 입력된다. 
		 * 각 테스트케이스는 모두 30,000보다 작은 양의 정수로 주어지며, 각 입력은 변의 길이를 의미한다.
		 * 
		 * 출력
		 * 각 입력에 대해 직각 삼각형이 맞다면 "right", 아니라면 "wrong"을 출력한다.
		 * 
		 * 예제 입력 1 
		 * 6 8 10
		 * 25 52 60
		 * 5 12 13
		 * 0 0 0
		 * 예제 출력 1 
		 * right
		 * wrong
		 * right
		 * */
		
		solve();
	}

	private static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		do {
			String s = br.readLine();
			if(s.equals("0 0 0")) {
				break;
			}
			
			String[] strTriLength = s.split(" ");
			int[] triLength = new int[3];
			
			for(int i = 0; i < strTriLength.length; i++) {
				triLength[i] = Integer.parseInt(strTriLength[i]);
			}
			
			//1.세 변의 길 중 최고 값을 구함 (빗변의 길이)
			int max = Math.max(Math.max(triLength[0], triLength[1]), triLength[2]);
			
			//2.배열에서 max값이 아닌 나머지 두 수의 제곱수의 합을 구한다.
			int index = 0;
			for(int i = 0; i < triLength.length; i++) {
				if(max == triLength[i]) {
					index = i;
					break;
				}
			}
			
			int sum = 0;
			for(int i = 0; i < triLength.length; i++) {
				if(i != index) {
					sum += (int)Math.pow(triLength[i],2);
				}
			}
			
			if((int)Math.pow(max, 2) == sum) {
				sb.append("right");
				sb.append("\n");
			}else {
				sb.append("wrong");
				sb.append("\n");
			}
		}while(true);
		System.out.println(sb);
	}
}
