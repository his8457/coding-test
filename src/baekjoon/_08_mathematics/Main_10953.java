package baekjoon._08_mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10953 {
	public static void main(String[] args) throws IOException, Exception {
		//[백준] 10953 A+B-6
		/*
		 * 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
		 * */
		
		solve();
	}

	private static void solve() throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCaseNumber = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testCaseNumber; i++) {
			String[] input = br.readLine().split(",");
			sb.append(Integer.parseInt(input[0]) + Integer.parseInt(input[1]));
			sb.append(System.getProperty("line.separator"));
		}
		System.out.println(sb);
	}
}
