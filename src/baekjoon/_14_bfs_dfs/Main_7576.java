package baekjoon._14_bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_7576 {
	public static void main(String[] args) throws Exception {
		// [백준] 7576 토마토 (그래프와 순회) 
		/*
		 * 문제
			철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다. 
			토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다. 
			창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 
			보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
			하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다. 
			대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 
			철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
			
			토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 
			며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 
			단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
			
			입력
			첫 줄에는 상자의 크기를 나타내는 두 정수 M,N이 주어진다. 
			M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다. 
			단, 2 ≤ M,N ≤ 1,000 이다. 둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다. 
			즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다. 
			하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다. 
			정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
			토마토가 하나 이상 있는 경우만 입력으로 주어진다.
			
			출력
			여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다. 
			만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 
			토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
			
			예제 입력 1 
			6 4
			0 0 0 0 0 0
			0 0 0 0 0 0
			0 0 0 0 0 0
			0 0 0 0 0 1
			예제 출력 1 
			8
			
			예제 입력 2 
			6 4
			0 -1 0 0 0 0
			-1 0 0 0 0 0
			0 0 0 0 0 0
			0 0 0 0 0 1
			예제 출력 2 
			-1
			
			예제 입력 3 
			6 4
			1 -1 0 0 0 0
			0 -1 0 0 0 0
			0 0 0 0 -1 0
			0 0 0 0 -1 1
			예제 출력 3 
			6
			
			예제 입력 4 
			5 5
			-1 1 0 0 0
			0 -1 -1 -1 0
			0 -1 -1 -1 0
			0 -1 -1 -1 0
			0 0 0 0 0
			예제 출력 4 
			14
			
			예제 입력 5 
			2 2
			1 -1
			-1 1
			예제 출력 5 
			0
		 * */
		
		int result = solve();
		System.out.println(result);
	}
	
	static int M = 0; //가로
	static int N = 0; //세로
	static int[][] map = null;
	static boolean[][] visited = null;
	static int[][] dir = {{-1, 0},{1, 0},{0, -1},{0, 1}};
	
	private static int solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		M = Integer.parseInt(input[0]); //가로
		N = Integer.parseInt(input[1]); //세로
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		// 문제 세팅 (토마토 상자)
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		//1. 토마토가 이미 모두 익어있는 경우 (Return 0)
		boolean isRipe = checkRipe();
		
		if(isRipe) {
			return 0;
		}
		
		//2. 토마토가 모두 익을 수 없는 경우 (Return -1)
		boolean cantRipe = checkCantRipe();
		
		if(cantRipe) {
			return -1;
		}
		
		//3. 토마토가 익을 수 있는 경우 (Return N)
		int N = 0;
		N = checkTomato();
		
		return N;
	}
	
	//3. 토마토가 익을 수 있는 경우 - 토마토 전체가 익는 일수 리턴 (Return N)
	private static int checkTomato() {
		int[][] ckMap = mapCopy();
		Queue<int[]> que = new LinkedList<>();
		
		for(int i = 0; i < ckMap.length; i++) {
			for(int j = 0; j < ckMap[i].length; j++) {
				if(ckMap[i][j] == 1) {
					que.add(new int[] {i,j});
				}
			}
		}
		
		while(!que.isEmpty()) {
			int[] position = que.poll();
			
			int x = position[0]; //세로 
			int y = position[1]; //가로
			
			for(int i = 0; i < dir.length; i++) {
				int[] d = dir[i];
				int x1 = x + d[0];
				int y1 = y + d[1];
				visited[x][y] = true;
				
				if(x1 >= 0 && y1 >= 0 && x1 < N && y1 < M && ckMap[x1][y1] == 0 && !visited[x1][y1]) {
					ckMap[x1][y1] = ckMap[x][y] + 1;
					visited[x1][y1] = true;
					que.add(new int[] {x1, y1});
				}
			}
		}
		
		int result = 0;
		for(int i = 0; i < ckMap.length; i++) {
			for(int j = 0; j < ckMap[i].length; j++) {
				result = result < ckMap[i][j] ? ckMap[i][j] : result;
			}
		}
		
		return result - 1;
	}
	
	//2. 토마토가 모두 익을 수 없는 경우 확인
	private static boolean checkCantRipe() {
		int[][] ckMap = mapCopy();
		
		Queue<int[]> que = new LinkedList<>();
		
		for(int i = 0; i < ckMap.length; i++) {
			for(int j = 0; j < ckMap[i].length; j++) {
				if(ckMap[i][j] == 1) {
					que.add(new int[] {i,j});
				}
			}
		}
		
		while(!que.isEmpty()) {
			int[] position = que.poll();
			
			int x = position[0]; //세로 
			int y = position[1]; //가로
			
			for(int i = 0; i < dir.length; i++) {
				int[] d = dir[i];
				int x1 = x + d[0];
				int y1 = y + d[1];
				
				if(x1 >= 0 && y1 >= 0 && x1 < N && y1 < M && ckMap[x1][y1] == 0) {
					ckMap[x1][y1] = 1;
					que.add(new int[] {x1, y1});
				}
			}
		}
		
		for(int i = 0; i < ckMap.length; i++) {
			for(int j = 0; j < ckMap[i].length; j++) {
				if(ckMap[i][j] == 0) {
					return true;
				}
			}
		}
		
		return false;
	}

	//1. 토마토가 이미 모두 익어있는 경우 확인
	private static boolean checkRipe() {
		boolean isRipe = true;
		
		loopOut : 
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 0) {
					isRipe = false;
					break loopOut;
				}
			}
		}
		
		return isRipe;
	}
	
	// 토마토 상자 : 2차원 배열 깊은 복사
	private static int[][] mapCopy(){
		int[][] result = new int[N][M];
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				result[i][j] = map[i][j];
			}
		}
		
		return result;
	}
}
