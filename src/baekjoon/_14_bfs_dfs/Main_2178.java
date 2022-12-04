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
	static int[][] input = null;
	static Queue<int[]> que = null;
	
	private static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputStr = br.readLine().split(" ");
		N = Integer.parseInt(inputStr[0]);
		M = Integer.parseInt(inputStr[1]);
		
		visited = new boolean[N][M];
		input = new int[N][M];
		que = new LinkedList<int[]>();
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				input[i][j] = s.charAt(j)-'0';
			}
		}
		
		bfs(0,0); //미로 시작 좌표(0,0) 부터 탐색 시작
		
		System.out.println(input[N-1][M-1]);
	}
	
	private static void bfs(int x, int y){
		int[] q = {x, y};
		que.add(q);
		
		visited[x][y] = true;
		
		while(!que.isEmpty()) {
			int[] i = que.poll();
			
			int[][] k = new int[4][2];
			k[0][0] = i[0]-1; k[0][1] = i[1];//위
			k[1][0] = i[0]+1; k[1][1] = i[1];//아래
			k[2][0] = i[0]; k[2][1] = i[1]-1;//왼쪽
			k[3][0] = i[0]; k[3][1] = i[1]+1;//오른쪽
			
			for(int[] j : k) {
				if(j[0] < 0 || j[1] < 0 || j[0] >= N || j[1] >= M || visited[j[0]][j[1]] || input[j[0]][j[1]] == 0) {
					continue;
				}else {
					que.add(j);
					visited[j[0]][j[1]] = true;
					input[j[0]][j[1]] += input[i[0]][i[1]];
				}
			}
		}
	}
}
