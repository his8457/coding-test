package baekjoon._05_sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main_11650 {
	public static void main(String[] args) throws Exception {
		// [백준] 11650 좌표 정렬하기
		/*
		 * 문제
			2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
			
			입력
			첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
			
			출력
			첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
			
			예제 입력 1 
			5
			3 4
			1 1
			1 -1
			2 2
			3 3
			예제 출력 1 
			1 -1
			1 1
			2 2
			3 3 
			3 4
		 * */
		
		solve();
	}

	private static void solve() throws Exception { //X좌표 기준으로 오름차순 정렬, X좌표가 같으면 Y좌표의 오름 차순 정렬
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int inputNum = Integer.parseInt(br.readLine());
		List<Position> positionList = new ArrayList<>();
		Main_11650 main = new Main_11650();
		
		for(int i = 0; i < inputNum; i++) {
			String strPosition = br.readLine();
			positionList.add(main.new Position(Integer.parseInt(strPosition.split(" ")[0]), Integer.parseInt(strPosition.split(" ")[1])));
		}
		
		Position p = main.new Position();
		Collections.sort(positionList, p); //정렬
		print(positionList); //출력
	}

	class Position implements Comparator<Position>{
		int x;
		int y;
		
		Position(){}
		
		Position(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compare(Position o1, Position o2) {
			if(o1.x > o2.x) {
				return 1;
			}else if(o1.x == o2.x) {
				if(o1.y > o2.y) {
					return 1;
				}
			}
			return -1;
		}
	}
	
	private static void print(List<Position> positionList) {
		for(Position p : positionList) {
			System.out.println(p.x + " " + p.y);
		}
	}
}
