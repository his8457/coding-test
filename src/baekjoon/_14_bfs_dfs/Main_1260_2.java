package baekjoon._14_bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1260_2 {
	
	static ArrayList<Integer>[] line = null;
	static boolean[] visited = null;
	static int N; //정점의 개수
	static int M; //간선의 개수
	static int V; //정점의 번호
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// [백준] 1260 DFS와 BFS
		/*
		 * 문제
		그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
		단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 
		더 이상 방문할 수 있는 점이 없는 경우 종료한다. 
		정점 번호는 1번부터 N번까지이다.
		
		입력
		첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 
		탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 
		어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
		
		출력
		첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
		
		예제 입력 1 
		4 5 1
		1 2
		1 3
		1 4
		2 4
		3 4
		예제 출력 1 
		1 2 4 3
		1 2 3 4
		
		예제 입력 2 
		5 5 3
		5 4
		5 2
		1 2
		3 4
		3 1
		예제 출력 2 
		3 1 2 5 4
		3 1 4 2 5
		
		예제 입력 3 
		1000 1 1000
		999 1000
		예제 출력 3 
		1000 999
		1000 999
		 * */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		V = Integer.parseInt(input[2]);
		
		String[] strArr = new String[M];
		for(int i = 0; i < M; i++) {
			strArr[i] = br.readLine();
		}
		
		line = new ArrayList[N+1];
		visited = new boolean[N+1];
		visited[0] = true;
		
		//1. 간선을 담을 배열 초기화
		for(int i = 0; i < line.length; i++) {
			line[i] = new ArrayList<Integer>();
		}
		
		//2. 노드간의 연결리스트를 배열에 담음.
		for(int i = 0; i < M; i++) {
			String[] str = strArr[i].split(" ");
			int node1 = Integer.parseInt(str[0]); 
			int node2 = Integer.parseInt(str[1]);
			
			line[node1].add(node2);
			line[node2].add(node1);
		}
		
		//3. 노드에 연결된 작은 노드부터 탐색해야 하므로 배열의 각 리스트를 오름차순으로 정렬
		for(int i = 1; i < line.length; i++) {
			Collections.sort(line[i]);
		}
		
		//4. DFS탐색
		DFS(V);
		
		//4-1. DFS결과 출력
		System.out.println(sb.toString());
		
		visited = new boolean[N+1];
		sb = new StringBuilder();
		
		//5. BFS탐색
		BFS(V);
		System.out.println(sb.toString());
	}
	
	//BFS
	private static void BFS(int v) {
		Queue<Integer> que = new LinkedList<>();
		que.add(v);
		
		while(!que.isEmpty()) {
			int node = que.poll();
			
			if(!visited[node]) {
				visited[node] = true;
				sb.append(node + " ");
				for(int i = 0; i < line[node].size(); i++) {
					que.add(line[node].get(i));
				}
			}
		}
	}

	//DFS
	private static void DFS(int v) {
		if(!visited[v]) {
			visited[v] = true;
			sb.append(v + " ");
			for(int i : line[v]) {
				DFS(i);
			}
		}
	}	
}
