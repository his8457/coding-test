package baekjoon._14_bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1260 {
	
	static String result = "";
	static boolean[] visited;
	static int[][] graph;
	static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int N, M, V;
		N = Integer.parseInt(input[0]); // 1 ~ N 까지 수
		M = Integer.parseInt(input[1]); // 간선의 수 M
		V = Integer.parseInt(input[2]); // 시작 정점
		
		graph = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			String[] strArr = str.split(" ");
			int a = Integer.parseInt(strArr[0]);
			int b = Integer.parseInt(strArr[1]);
			
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		dfs(V);
		System.out.println(result);
		
		//결과 변수 초기화
		result = "";
		//방문 체크 배열 초기화
		visited = new boolean[N+1];
		
		bfs(V);
		System.out.println(result);
	}

	private static void bfs(int node) {
		q.add(node);
		visited[node] = true;
		
		while(!q.isEmpty()) {
			node = q.poll();
			result += node + " ";
			
			for(int i = 1; i < visited.length; i++) {
				if(graph[node][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}

	private static void dfs(int node) {
		result += node + " ";
		visited[node] = true;
		
		for(int j = 1; j < visited.length; j++) {
			if(graph[node][j]==1 && !visited[j]) {
				dfs(j);
			}
		}
	}
}