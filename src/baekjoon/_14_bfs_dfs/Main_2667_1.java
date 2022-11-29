package baekjoon._14_bfs_dfs;

import java.util.*;
import java.io.*;

public class Main_2667_1 {
	static int arr[][]= {{0,1,1,1,1,0,0},
						 {0,1,1,0,1,0,1},
						 {1,1,1,0,1,0,1},
						 {0,0,0,0,1,1,1},
						 {0,1,0,0,0,0,0},
						 {0,1,1,1,1,1,0},
						 {0,1,1,1,0,0,0}};
	
	static boolean visit[][];
	static int dirX[] = {0, 0, -1, 1};
	static int dirY[] = {-1, 1, 0, 0};
	static int count = 0, number = 0;
	static int nowX, nowY, N;

	static int dfsDepth = 0;
	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> list = new ArrayList<>();

		N = 7;
		visit = new boolean[N][N];
		int startidx = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visit[i][j] == false && arr[i][j] == 1) {
					count = 0;
					number++;
					System.out.println(startidx++  + " : [" + i + "][" + j + "]");
					dfsDepth = 0;
					System.out.println("1================DFS함수 밖에서 호출됨");
					DFS(i, j);	
					list.add(count);
				}

			}
		}

		Collections.sort(list);
		bw.append(number + "\n");
		for(int num : list) {
			bw.append(num + "\n");
		}
		
		for(int[] i : arr) {
			System.out.println(Arrays.toString(i));
		}

		bw.flush();
		bw.close();
	} // End of main

	static void DFS(int x, int y) {
		System.out.println("DFS depth : " + ++dfsDepth  + "      [" + x + "][" + y + "]");
		visit[x][y] = true;
		arr[x][y] = number;
		count ++;

		for(int i=0; i<4; i++) {
			nowX = dirX[i] + x;
			nowY = dirY[i] + y;
			
			String aa = (nowX >= 0 && nowX < N && nowY >= 0 && nowY < N) ?  "     visit[nowX][nowY] : " + visit[nowX][nowY] + "        arr[nowX][nowY] : " + arr[nowX][nowY] : "    OutofBound Exception";
			System.out.println("X : " + x + ", Y : " + y + ", nowX : " + nowX + ", nowY : " + nowY  + aa);
			
			if(Range_check() && visit[nowX][nowY] == false && arr[nowX][nowY] == 1) {
				System.out.println("2================DFS함수 안에서 호출됨");
				visit[nowX][nowY] = true;
				arr[nowX][nowY] = number;
				DFS(nowX, nowY);
			}
		}		

	} // End of DFS

	static boolean Range_check() {
		return (nowX >= 0 && nowX < N && nowY >= 0 && nowY < N);
	} // End of Range_check
}
