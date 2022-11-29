package baekjoon._14_bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2667 {
	
	public static int[][] map = null;
	public static boolean[][] visited = null;
	public static int[] houseCntList = null;
	
	public static int mapSize = 0;
	public static int groupCnt = 0;
	public static int houseCnt = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//지도 크기 N
		mapSize = Integer.parseInt(br.readLine());
		//지도 배열
		map = new int[mapSize][mapSize];
		//지도 배열 (방문 여부)
		visited = new boolean[mapSize][mapSize];
		//단지별 집 수
		houseCntList = new int[mapSize * mapSize];
		
		//지도
		for(int i = 0; i < mapSize; i++) {
			String s = br.readLine();
			for(int j = 0; j < s.length(); j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		// 1. DFS 탐색 시작
		for(int i = 0; i < mapSize; i++) {
			for(int j = 0; j < mapSize; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					groupCnt++;
					houseCnt = 0;
					dfs(i, j);
					houseCntList[groupCnt] = houseCnt;
				}
			}
		}
		
		// 2. 결과 출력
		System.out.println(groupCnt);
		Arrays.sort(houseCntList);
		for(int i = 0; i < houseCntList.length; i++) {
			if(houseCntList[i] > 0) {
				System.out.println(houseCntList[i]);
			}
		}
	}

	public static void dfs (int x, int y) {
		if(x < 0 || y < 0 || x >= mapSize || y >= mapSize || visited[x][y] == true || map[x][y] == 0) {
			return;
		}
		
		visited[x][y] = true;
		houseCnt++;
		
		dfs(x - 1, y); // 왼쪽 한칸 이동
		dfs(x + 1, y); // 오른쪽 한칸 이동
		dfs(x, y + 1); // 위로 한칸 이동
		dfs(x, y - 1); // 아래로 한칸 이동
	}
}