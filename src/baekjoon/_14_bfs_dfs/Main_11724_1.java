package baekjoon._14_bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main_11724_1 {
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
		
		// DFS 깊이우선 탐색
		DFS(); //type: recursive, stack 
	}

	static ArrayList<Integer>[] list = null;
	static boolean[] visited = null;
	static Stack<Integer> stack = new Stack<>();
	
	private static void DFS() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]); //노드(정점)의 개수
		int M = Integer.parseInt(NM[1]); //간선의 개수
		int result = 0; // 연결 요소의 개수
		
		String[] nodeLine = new String[M];
		for(int i = 0; i < M; i++) {
			nodeLine[i] = br.readLine();
		}
		
		list = new ArrayList[N+1]; //연결노드 
		visited = new boolean[N+1]; //방문배열
		
		//1. 연결노드 배열 초기화
		for(int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		
		//2. 연결노드 배열 만들기
		for(int i = 0; i < M; i++) {
			String[] s = nodeLine[i].split(" ");
			int node1 = Integer.parseInt(s[0]);
			int node2 = Integer.parseInt(s[1]);
			
			//간선 표현
			list[node1].add(node2); 
			list[node2].add(node1);
		}
		
		//3-1 재귀함수(DFS)
		for(int i = 1; i < visited.length; i++) {
			if(!visited[i]) {
				recursiveImpl(i);
				result++;
			}
		}
		
		//3-2 스택(DFS) -> 시간초과
		/*
		for(int i = 1; i < visited.length; i++) {
			if(!visited[i]) {
				stackImpl(i);
				result++;
			}
		}
		*/
		
		System.out.println(result);
	}

	//1.재귀함수(DFS)
	private static void recursiveImpl(Integer node) {
		if(!visited[node]) {
			visited[node] = true;
			for(int i = 0; i < list[node].size(); i++) {
				recursiveImpl(list[node].get(i));
			}
		}
	}

	//2.스택(DFS)
	private static void stackImpl(Integer node) {
		stack.add(node);
		
		while(!stack.isEmpty()) {
			int n = stack.pop();
			visited[n] = true;
			
			for(int j = 0; j < list[n].size(); j++) {
				if(!visited[list[n].get(j)]) {
					stack.add(list[n].get(j));
				}
			}
		}
	}
}
