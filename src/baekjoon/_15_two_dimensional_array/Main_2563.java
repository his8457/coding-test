package baekjoon._15_two_dimensional_array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2563 {
	public static void main(String[] args) throws Exception {
		//색종이
		/*
		 * 문제
			가로, 세로의 크기가 각각 100인 정사각형 모양의 흰색 도화지가 있다. 
			이 도화지 위에 가로, 세로의 크기가 각각 10인 정사각형 모양의 검은색 색종이를 색종이의 변과 도화지의 변이 평행하도록 붙인다. 
			이러한 방식으로 색종이를 한 장 또는 여러 장 붙인 후 색종이가 붙은 검은 영역의 넓이를 구하는 프로그램을 작성하시오.
			예를 들어 흰색 도화지 위에 세 장의 검은색 색종이를 그림과 같은 모양으로 붙였다면 검은색 영역의 넓이는 260이 된다.
			
			입력
			첫째 줄에 색종이의 수가 주어진다. 이어 둘째 줄부터 한 줄에 하나씩 색종이를 붙인 위치가 주어진다. 
			색종이를 붙인 위치는 두 개의 자연수로 주어지는데 첫 번째 자연수는 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리이고, 
			두 번째 자연수는 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리이다. 색종이의 수는 100 이하이며, 색종이가 도화지 밖으로 나가는 경우는 없다
			
			출력
			첫째 줄에 색종이가 붙은 검은 영역의 넓이를 출력한다.
			
			예제 입력 1 
			3
			3 7
			15 7
			5 2
			
			예제 출력 1 
			260
		 * */
		
		solve();
	}

	private static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] canvas = new boolean[100][100]; //도화지
		int paperCnt = Integer.parseInt(br.readLine()); //색종이 개수
		int leftDistance = 0; //도화지 왼쪽부터 떨어진 거리
		int downDistance = 0; //도화지 아래부터 떨어진 거리
		int resultCnt = 0;
		
		for(int i = 0; i < paperCnt; i++) {
			String input = br.readLine();
			leftDistance = Integer.parseInt(input.split(" ")[0]);
			downDistance = Integer.parseInt(input.split(" ")[1]);
			for(int j = leftDistance; j < leftDistance+10; j++) {
				for(int k = downDistance; k < downDistance+10; k++) {
					canvas[j][k] = true;
				}
			}
		}
		
		for(int i = 0; i < canvas.length; i++) {
			for(int j = 0; j < canvas[i].length; j++) {
				if(canvas[i][j] == true) {
					resultCnt++;
				}else {
				}
			}
		}
		
		System.out.println(resultCnt);
	}
}
