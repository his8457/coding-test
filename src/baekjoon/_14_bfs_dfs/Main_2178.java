package baekjoon._14_bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2178 {
	public static void main(String[] args) throws Exception {
		// [백준] 2178 미로 탐색 - 그래프와 순회
		/*
		 * 문제
			N×M크기의 배열로 표현되는 미로가 있다.
			
			1	0	1	1	1	1
			1	0	1	0	1	0
			1	0	1	0	1	1
			1	1	1	0	1	1
			
			미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 
			이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 
			한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
			
			위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 
			칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
			
			입력
			첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 
			다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
			
			출력
			첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
			
			예제 입력 1 
			4 6
			101111
			101010
			101011
			111011
			
			예제 출력 1 
			15
		 * */
		
		solve();
		
	}
	
	static int N = 0; //미로의 세로 길이
	static int M = 0; //미로의 가로 길이
	
	static boolean[][] visited = null;
	static int[][] map = null;
	
	private static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputStr = br.readLine().split(" ");
		N = Integer.parseInt(inputStr[0]);
		M = Integer.parseInt(inputStr[1]);
		
		visited = new boolean[N][M];
		map = new int[N][M];
		
		//1. 미로 그리기
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		//2. 미로 탐색 (시작 좌표(0,0) 부터 탐색 시작)
		bfs(0,0); 
		
		//3. 결과 출력 (미로의 탈출 좌표에 도달 할때의 최소 이동 수)
		System.out.println(map[N-1][M-1]);
	}
	
	private static void bfs(int startX, int startY){
		
		//1. Queue를 생성하고 시작좌표 값 삽입, 방문배열 시작좌표 true로 설정
		Queue<int[]> que = new LinkedList<int[]>();
		que.add(new int[] {startX, startY});
		visited[startX][startY] = true;
		
		//2. 탐색 시작
		while(!que.isEmpty()) {
			int[] i = que.poll();
			int curX = i[0];
			int curY = i[1];
			
			//현재위치를 기준으로 북, 남, 서, 동 4방위 좌표를 구함
			int[][] points = new int[4][2];
			points[0][0] = curX-1; points[0][1] = curY;  //위
			points[1][0] = curX+1; points[1][1] = curY;  //아래
			points[2][0] = curX;   points[2][1] = curY-1;//왼쪽
			points[3][0] = curX;   points[3][1] = curY+1;//오른쪽
			
			for(int[] j : points) {
				int x = j[0];
				int y = j[1];
				
				if(x < 0 || y < 0 || x >= N || y >= M || visited[x][y] || map[x][y] == 0) {
					continue;
				}else {
					que.add(j);
					visited[x][y] = true;
					map[x][y] += map[curX][curY];
				}
			}
		}
	}
}
