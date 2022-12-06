package baekjoon._14_bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_7569 {
	public static void main(String[] args) throws Exception {
		// [백준] 7569 토마토 (3차원) - 그래프와 선회
		/*
		 * 
			문제
			철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다. 
			토마토는 아래의 그림과 같이 격자모양 상자의 칸에 하나씩 넣은 다음, 상자들을 수직으로 쌓아 올려서 창고에 보관한다.
			창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 
			보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다. 
			하나의 토마토에 인접한 곳은 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향에 있는 토마토를 의미한다. 
			대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 
			철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지 그 최소 일수를 알고 싶어 한다.
			토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,
			며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 
			단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
			
			입력
			첫 줄에는 상자의 크기를 나타내는 두 정수 M,N과 쌓아올려지는 상자의 수를 나타내는 H가 주어진다. 
			M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다. 
			단, 2 ≤ M ≤ 100, 2 ≤ N ≤ 100, 1 ≤ H ≤ 100 이다. 
			둘째 줄부터는 가장 밑의 상자부터 가장 위의 상자까지에 저장된 토마토들의 정보가 주어진다. 
			즉, 둘째 줄부터 N개의 줄에는 하나의 상자에 담긴 토마토의 정보가 주어진다. 
			각 줄에는 상자 가로줄에 들어있는 토마토들의 상태가 M개의 정수로 주어진다. 
			정수 1은 익은 토마토, 정수 0 은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다. 
			이러한 N개의 줄이 H번 반복하여 주어진다.
			토마토가 하나 이상 있는 경우만 입력으로 주어진다.
			
			출력
			여러분은 토마토가 모두 익을 때까지 최소 며칠이 걸리는지를 계산해서 출력해야 한다. 
			만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 
			토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
			
			예제 입력 1 
			5 3 1
			0  -1 0 0 0
			-1 -1 0 1 1
			0   0 0 1 1
			예제 출력 1 
			-1
			
			예제 입력 2 
			5 3 2
			0 0 0 0 0
			0 0 0 0 0
			0 0 0 0 0
			0 0 0 0 0
			0 0 1 0 0
			0 0 0 0 0
			예제 출력 2 
			4
			
			예제 입력 3 
			4 3 2
			1 1 1 1
			1 1 1 1
			1 1 1 1
			1 1 1 1
			-1 -1 -1 -1
			1 1 1 -1
			예제 출력 3 
			0
		 * */
		solve();
	}

	static int H = 2;//상자의 높이(단)
	static int N = 3;//상자의 세로 길이 
	static int M = 4;//상자의 가로 길이
	static boolean[][][] visited = null;
	static int[][] dir = {{0,-1, 0},{0, 1, 0},{0, 0, -1},{0, 0, 1}, {1,0,0}, {-1,0,0}};
	static int[][][] map = null;
	
	
	private static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		M = Integer.parseInt(input[0]); //가로
		N = Integer.parseInt(input[1]); //세로
		H = Integer.parseInt(input[2]); //높이
		
		map = new int[H][N][M];
		visited = new boolean[H][N][M];
		
		// 문제 세팅 (토마토 상자)
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				String[] str = br.readLine().split(" ");
				for(int k = 0; k < M; k++) {
					map[i][j][k] = Integer.parseInt(str[k]);
				}
			}
		}
		
			
		// 1.토마토가 모두 익어있는 경우
		if(isRipe()) {
			System.out.println(0);
			return;
		}
		
		// 2.토마토가 모두 익지 못하는 경우
		boolean cantRipe = checkCantRipe();
		if(cantRipe) {
			System.out.println(-1);
			return;
		}
		
		// 3.토마토가 익을 수 있는 경우
		int days = 0;
		days = checkTomato();
		System.out.println(days);
	}
	
	//3. 토마토가 익을 수 있는 경우 - 토마토 전체가 익는 일수 리턴 (Return N)
	private static int checkTomato() {
		int[][][] ckMap = mapCopy();
		Queue<int[]> que = new LinkedList<>();
		
		for(int i = 0; i < ckMap.length; i++) {
			for(int j = 0; j < ckMap[i].length; j++) {
				for(int k = 0; k < ckMap[i][j].length; k++) {
					if(ckMap[i][j][k] == 1) {
						que.add(new int[] {i,j,k});//H, N, M
					}
				}
			}
		}
		
		while(!que.isEmpty()) {
			int[] position = que.poll();
			
			int h = position[0]; //높이 
			int x = position[1]; //세로 
			int y = position[2]; //가로
			
			for(int i = 0; i < dir.length; i++) {
				int[] d = dir[i];
				
				int h1 = h + d[0];
				int x1 = x + d[1];
				int y1 = y + d[2];
				visited[h][x][y] = true;
				
				if(h1 >= 0 && x1 >= 0 && y1 >= 0 && h1 < H && x1 < N && y1 < M && ckMap[h1][x1][y1] == 0 && !visited[h1][x1][y1]) {
					ckMap[h1][x1][y1] = ckMap[h][x][y] + 1;
					visited[h1][x1][y1] = true;
					que.add(new int[] {h1, x1, y1});
				}
			}
		}
		
		int result = 0;
		for(int i = 0; i < ckMap.length; i++) {
			for(int j = 0; j < ckMap[i].length; j++) {
				for(int k = 0; k < ckMap[i][j].length; k++) {
					result = result < ckMap[i][j][k] ? ckMap[i][j][k] : result;
				}
			}
		}
		
		return result - 1;
	}
	
	//2. 토마토가 모두 익을 수 없는 경우 확인
	private static boolean checkCantRipe() {
		int[][][] ckMap = mapCopy();
		
		Queue<int[]> que = new LinkedList<>();
		
		for(int i = 0; i < ckMap.length; i++) {
			for(int j = 0; j < ckMap[i].length; j++) {
				for(int k = 0; k < ckMap[i][j].length; k++) {
					if(ckMap[i][j][k] == 1) {
						que.add(new int[] {i,j,k}); //H, N, M
					}
				}
			}
		}
		
		while(!que.isEmpty()) {
			int[] position = que.poll();
			
			int h = position[0]; //높이 
			int x = position[1]; //세로 
			int y = position[2]; //가로
			
			for(int i = 0; i < dir.length; i++) {
				int[] d = dir[i];
				
				int h1 = h + d[0];
				int x1 = x + d[1];
				int y1 = y + d[2];
				
				if(h1 >= 0 && x1 >= 0 && y1 >= 0 && h1 < H && x1 < N && y1 < M && ckMap[h1][x1][y1] == 0) {
					ckMap[h1][x1][y1] = 1;
					que.add(new int[] {h1, x1, y1});
				}
			}
		}
		
		for(int i = 0; i < ckMap.length; i++) {
			for(int j = 0; j < ckMap[i].length; j++) {
				for(int k = 0; k < ckMap[i][j].length; k++) {
					if(ckMap[i][j][k] == 0) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	//1. 토마토가 모두 익어있는 경우
	private static boolean isRipe() {
		boolean result = true;
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < M; k++) {
					if(map[i][j][k] == 0) {
						return false;
					}
				}
			}
		}
		return result;
	}
	
	// 토마토 상자 : 3차원 배열 깊은 복사
	private static int[][][] mapCopy(){
		int[][][] result = new int[H][N][M];
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				for(int k = 0; k < map[i][j].length; k++) {
					result[i][j][k] = map[i][j][k];
				}
			}
		}
		
		return result;
	}
}
