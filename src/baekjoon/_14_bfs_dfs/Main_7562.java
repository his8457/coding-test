package baekjoon._14_bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_7562 {
	public static void main(String[] args) throws Exception {
		// [백준] 7562 나이트의 이동 (그래프와 순회)
		/*
		 * 문제
			체스판 위에 한 나이트가 놓여져 있다. 
			나이트가 한 번에 이동할 수 있는 칸은 아래 그림에 나와있다. 
			나이트가 이동하려고 하는 칸이 주어진다. 
			나이트는 몇 번 움직이면 이 칸으로 이동할 수 있을까?
			
			입력
			입력의 첫째 줄에는 테스트 케이스의 개수가 주어진다.
			각 테스트 케이스는 세 줄로 이루어져 있다. 
			첫째 줄에는 체스판의 한 변의 길이 l(4 ≤ l ≤ 300)이 주어진다. 
			체스판의 크기는 l × l이다. 
			체스판의 각 칸은 두 수의 쌍 {0, ..., l-1} × {0, ..., l-1}로 나타낼 수 있다. 
			둘째 줄과 셋째 줄에는 나이트가 현재 있는 칸, 나이트가 이동하려고 하는 칸이 주어진다.
			
			출력
			각 테스트 케이스마다 나이트가 최소 몇 번만에 이동할 수 있는지 출력한다.
			
			예제 입력 1 
			3
			8
			0 0
			7 0
			100
			0 0
			30 50
			10
			1 1
			1 1
			
			예제 출력 1 
			5
			28
			0
		 * */
		
		solve();
	}

	static int L = 0; //체스판 크기 (L x L)
	static int[] cur = new int[2]; //(X, Y)일떄, 나이트 현재 위치의 (세로, 가로) 좌표
	static int[] tar = new int[2]; //(X, Y)일떄, 목표 위치의 (세로, 가로) 좌표
	static int[][] map = null;
	
	private static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < testCase; i++) {
			L = Integer.parseInt(br.readLine());
			String[] curXY = br.readLine().split(" ");
			String[] tarXY = br.readLine().split(" ");
			
			cur[0] = Integer.parseInt(curXY[0]);
			cur[1] = Integer.parseInt(curXY[1]);
			tar[0] = Integer.parseInt(tarXY[0]);
			tar[1] = Integer.parseInt(tarXY[1]);
			
			map = new int[L][L]; //맵 초기화
			map[cur[0]][cur[1]] = 0; //시작 
			
			bfs();
			
			System.out.println(map[tar[0]][tar[1]]);
		}
	}

	private static void bfs() {
		if(cur[0] == tar[0] && cur[1] == tar[1]) {
			return;
		}
		
		Queue<int[]> que = new LinkedList<>();
		
		// 현재위치 기준으로 이동 가능한 위치
		// 위, 왼쪽 (-2,-1)    위, 오른쪽(-2, +1)
		// 위, 왼쪽 (-1, -2)   위, 오른쪽(-1, +2)   
		//아래, 왼쪽 (+1, -2)  아래, 오른쪽(+1, +2)
		//아래, 왼쪽 (+2, -1)  아래, 오른쪽(+2, +1)
		
		que.add(cur); //현재 위치 큐에 넣기
		
		while(!que.isEmpty() && map[tar[0]][tar[1]] == 0) {
			int[] t = que.poll();
			int x = t[0];
			int y = t[1];

			if((x-2 >= 0 && x-2 < L) && (y-1 >= 0 && y-1 < L) && map[x-2][y-1] == 0) {
				que.add(new int[] {x-2, y-1});
				map[x-2][y-1] = map[x][y] + 1;
			}
			if((x-2 >= 0 && x-2 < L) && (y+1 >= 0 && y+1 < L) && map[x-2][y+1] == 0) {
				que.add(new int[] {x-2, y+1});
				map[x-2][y+1] = map[x][y] + 1;
			}
			
			if((x-1 >= 0 && x-1 < L) && (y-2 >= 0 && y-2 < L) && map[x-1][y-2] == 0) {
				que.add(new int[] {x-1, y-2});
				map[x-1][y-2] = map[x][y] + 1;
			}
			if((x-1 >= 0 && x-1 < L) && (y+2 >= 0 && y+2 < L) && map[x-1][y+2] == 0) {
				que.add(new int[] {x-1, y+2});
				map[x-1][y+2] = map[x][y] + 1;
			}

			if((x+1 >= 0 && x+1 < L) && (y-2 >= 0 && y-2 < L) && map[x+1][y-2] == 0) {
				que.add(new int[] {x+1, y-2});
				map[x+1][y-2] = map[x][y] + 1;
			}
			if((x+1 >= 0 && x+1 < L) && (y+2 >= 0 && y+2 < L) && map[x+1][y+2] == 0) {
				que.add(new int[] {x+1, y+2});
				map[x+1][y+2] = map[x][y] + 1;
			}
			
			if((x+2 >= 0 && x+2 < L) && (y-1 >= 0 && y-1 < L) && map[x+2][y-1] == 0) {
				que.add(new int[] {x+2, y-1});
				map[x+2][y-1] = map[x][y] + 1;
			}
			if((x+2 >= 0 && x+2 < L) && (y+1 >= 0 && y+1 < L) && map[x+2][y+1] == 0) {
				que.add(new int[] {x+2, y+1});
				map[x+2][y+1] = map[x][y] + 1;
			}
		}
	}
}
