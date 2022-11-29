package baekjoon._14_bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1012 {
	
	static BufferedReader br = null;
	
	static int[][] map = null;
	static boolean[][] visited = null; 
	
	static int M = 0; //배추밭 가로길이 M
	static int N = 0; //배추밭 세로길이 N
	static int K = 0; //배추 개수 K
	static int wormsCnt = 0; //지렁이 수
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		//테스트 케이스 개수 T
		int T = Integer.parseInt(br.readLine());
		
		for(int w = 0; w < T; w++) {
			M = N = K = wormsCnt = 0;
			
			String[] input = br.readLine().split(" ");
			M = Integer.parseInt(input[0]); //배추밭 가로길이 M
			N = Integer.parseInt(input[1]); //배추밭 세로길이 N
			K = Integer.parseInt(input[2]); //배추개수 K
			
			makeMap();
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						wormsCnt++;
						dfs(i, j);
					}
				}
			}
			
			System.out.println(wormsCnt);
		}
	}
	
	// DFS
	private static void dfs(int x, int y) { //
		if(x < 0 || y < 0 || x >= N || y >= M || visited[x][y] == true || map[x][y] == 0 ) {
			return;
		}
		
		visited[x][y] = true;

		dfs(x-1, y); //왼쪽으로 한칸 이동
		dfs(x+1, y); //오른쪽으로 한칸 이동
		dfs(x, y+1); //위로 한칸 이동
		dfs(x, y-1); //아래로 한칸 이동
	}

	public static void makeMap () throws IOException {
		map = new int[N][M]; //지도 배열 초기화
		visited = new boolean[N][M]; //방문 배열 초기화
		
		for(int i = 0; i < K; i++) { //지도 배열 생성
			String s = br.readLine();
			map[Integer.parseInt(s.split(" ")[1])][Integer.parseInt(s.split(" ")[0])] = 1;
		}
	}
}
