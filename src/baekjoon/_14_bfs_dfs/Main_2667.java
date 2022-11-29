package baekjoon._14_bfs_dfs;

import java.util.Arrays;

public class Main_2667 {
	
	public static int[][] map = {{0,1,0,1},
							     {1,1,0,1},
							     {1,1,1,0},
							     {1,0,0,0}};
	
	public static int mapSize = map.length;
	public static boolean[][] visited = new boolean[mapSize][mapSize];
	
	public static int groupCnt = 0;
	public static int houseCnt = 0;
	
	public static int[] dirX = {0, 0, -1, 1}; //위, 아래, 왼쪽, 오른쪽
	public static int[] dirY = {1, -1, 0, 0}; //위, 아래, 왼쪽, 오른쪽
	
	public static int nextX = 0;
	public static int nextY = 0;
	
	public static void main(String[] args) {
		//처음 찾은 집을 기준으로 연결된 집들의 배열 번호를 5로 치환
		//고려할 사항 : 1. 행렬의 모서리에 위치한 집은 4방향으로 탐색 불가
		
		for(int i = 0; i < mapSize; i++) {
			for(int j = 0; j < mapSize; j++) {
				groupCnt++;
				System.out.println("groupCnt : " + groupCnt + ", [i][j] : [" + i + "][" + j + "]");
				dfs(i, j);
			}
		}
		
		for(int i[] : map) {
			System.out.println(Arrays.toString(i));
		}
	}

	public static boolean canSearch(int x, int y, int idx) {
		boolean result = true;
		
		int moveX = x + dirX[idx];
		int moveY = y + dirY[idx];
		System.out.println("moveX : " + moveX + ", moveY : " + moveY + ", canSearch : " + (moveX < 0 || moveY < 0 || moveX >= mapSize || moveY >= mapSize));
		if(moveX < 0 || moveY < 0 || moveX >= mapSize || moveY >= mapSize) {
			return false;
		}
		
		nextX = moveX;
		nextY = moveY;
		
		return result;
	}
	
	public static void dfs (int x, int y) {
		for(int i = 0; i < 4; i++) {
			if(canSearch(x, y, i) && !visited[nextX][nextY] && map[nextX][nextY] == 1) {
				visited[nextX][nextY] = true;
				map[nextX][nextY] = groupCnt;
				houseCnt++;
				dfs(nextX, nextY);
			}
		}
	}
}