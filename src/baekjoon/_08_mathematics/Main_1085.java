package baekjoon._08_mathematics;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1085 {
	public static void main(String[] args) throws Exception {
		//[백준] 1085 수학 -> 직사각형에서 탈출
		/*
		 * 문제
		 * 한수는 지금 (x, y)에 있다. 
		 * 직사각형은 각 변이 좌표축에 평행하고, 왼쪽 아래 꼭짓점은 (0, 0), 오른쪽 위 꼭짓점은 (w, h)에 있다. 
		 * 직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.
		 * 
		 * 입력
		 * 첫째 줄에 x, y, w, h가 주어진다.
		 * 
		 * 출력
		 * 첫째 줄에 문제의 정답을 출력한다.
		 * 
		 * 제한
		 * 1 ≤ w, h ≤ 1,000
		 * 1 ≤ x ≤ w-1
		 * 1 ≤ y ≤ h-1
		 * x, y, w, h는 정수
		 * 예제 입력 1 
		 * 6 2 10 3
		 * 예제 출력 1 
		 * 1
		 * 예제 입력 2 
		 * 1 1 5 5
		 * 예제 출력 2 
		 * 1
		 * 예제 입력 3 
		 * 653 375 1000 1000
		 * 예제 출력 3 
		 * 347
		 * 예제 입력 4 
		 * 161 181 762 375
		 * 예제 출력 4 
		 * 161
		 * */
		
		solve();
	}

	private static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] inputArr = input.split(" ");
		//입력받은 x, y, w, h
		int x = Integer.parseInt(inputArr[0]);
		int y = Integer.parseInt(inputArr[1]);
		int w = Integer.parseInt(inputArr[2]);
		int h = Integer.parseInt(inputArr[3]);
		
		//경계선과 가장 가까운 거리는 x, y, w-x, h-y 중의 최소값
		int min = Math.min(Math.min(Math.min(x, y), w-x), h-y);
		
		//결과 출력
		System.out.println(min);
	}
}
