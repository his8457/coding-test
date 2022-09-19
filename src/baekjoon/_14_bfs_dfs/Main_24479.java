package baekjoon._14_bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main_24479 {
	public static void main(String[] args) throws Exception {
		//[백준] 24479 그래프와 순회 -> 알고리즘 수업-깊이 우선 탐색1
		/*
		 * 오늘도 서준이는 깊이 우선 탐색(DFS) 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.
		N개의 정점과 M개의 간선으로 구성된 무방향 그래프(undirected graph)가 주어진다. 정점 번호는 1번부터 N번이고 모든 간선의 가중치는 1이다. 정점 R에서 시작하여 깊이 우선 탐색으로 노드를 방문할 경우 노드의 방문 순서를 출력하자.
		깊이 우선 탐색 의사 코드는 다음과 같다. 인접 정점은 오름차순으로 방문한다.
		
		dfs(V, E, R) {  # V : 정점 집합, E : 간선 집합, R : 시작 정점
		    visited[R] <- YES;  # 시작 정점 R을 방문 했다고 표시한다.
		    for each x ∈ E(R)  # E(R) : 정점 R의 인접 정점 집합.(정점 번호를 오름차순으로 방문한다)
		        if (visited[x] = NO) then dfs(V, E, x);
		}
		
		입력
		첫째 줄에 정점의 수 N (5 ≤ N ≤ 100,000), 간선의 수 M (1 ≤ M ≤ 200,000), 시작 정점 R (1 ≤ R ≤ N)이 주어진다.
		다음 M개 줄에 간선 정보 u v가 주어지며 정점 u와 정점 v의 가중치 1인 양방향 간선을 나타낸다. (1 ≤ u < v ≤ N, u ≠ v) 모든 간선의 (u, v) 쌍의 값은 서로 다르다.
		
		출력
		첫째 줄부터 N개의 줄에 정수를 한 개씩 출력한다. i번째 줄에는 정점 i의 방문 순서를 출력한다. 시작 정점의 방문 순서는 1이다. 시작 정점에서 방문할 수 없는 경우 0을 출력한다.
		
		예제 입력 1 
		5 5 1
		1 4
		1 2
		2 3
		2 4
		3 4
		
		예제 출력 1 
		1
		2
		3
		4
		0
		 * */
		
		solve();
	}
	
	private static ArrayList<Integer>[] graph;
	private static boolean[] visited;
	private static int[] order;
	private static int visitCount = 1;
	
	private static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputNMR = br.readLine();
		int N = Integer.parseInt(inputNMR.split(" ")[0]); //노드 개수
		int M = Integer.parseInt(inputNMR.split(" ")[1]); //엣지 개수
		int R = Integer.parseInt(inputNMR.split(" ")[2]); //시작 노드
		
		graph = new ArrayList[N+1];
		
		//데이터 생성(초기화)
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		//간선 (u, v)
		for(int i = 0; i < M; i++) {
			String inputNE = br.readLine();
			int u = Integer.parseInt(inputNE.split(" ")[0]);
			int v = Integer.parseInt(inputNE.split(" ")[1]);
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		//오름차순 방문을 위한 배열 정렬
		for(int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}
		
		//방문배열 초기화
		visited = new boolean[N+1];
		
		//방문 순서 저장
		order = new int[visited.length-1];
		
		order[R-1] = 1;
		visited[R] = true;
		visitCount++;
		
		//깊이 우선 탐색 실행
		DFS(R);
		
		for(int i : order) {
			System.out.println(i);
		}
	}

	private static void DFS(int startNode) {
		for(int i : graph[startNode]) {
			if(visited[i]) {
				continue;
			}else {
				order[i-1] = visitCount;
				visitCount++;
				visited[i] = true;
				DFS(i);
			}
		}
	}
}
