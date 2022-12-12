package baekjoon._14_bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_11724 {
	public static void main(String[] args) throws Exception {
		// [백준] 11724 연결 요소의 개수
		/*
		 * 문제
			방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
			
			입력
			첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 
			둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
			
			출력
			첫째 줄에 연결 요소의 개수를 출력한다.
			
			예제 입력 1 
			6 5
			1 2
			2 5
			5 1
			3 4
			4 6
			예제 출력 1 
			2
			예제 입력 2 
			6 8
			1 2
			2 5
			5 1
			3 4
			4 6
			5 4
			2 4
			2 3
			예제 출력 2 
			1
		 * */
		
		solve();
	}

	static int N = 0; //노드
	static int M = 0; //간선
	static  ArrayList<Integer>[] input = null;
	static boolean[] visited = null;
	static int cnt = 0;
	
	private static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		input = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i = 0; i < N+1; i++) {
			input[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			String[] s = br.readLine().split(" ");
			int node1 = Integer.parseInt(s[0]); 
			int node2 = Integer.parseInt(s[1]); 

			input[node1].add(node2);
			input[node2].add(node1);
		}
		
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				cnt++;
				dfs(i);
			}
		}
		
		System.out.println(cnt);
	}
	
	private static void dfs(int param) {
		if(visited[param]) {
			return;
		}
		visited[param] = true;
		
		for(int i = 0; i < input[param].size(); i++) {
			int k = input[param].get(i);
			if(!visited[k]) {
				dfs(k);
			}
		}
	}
}
