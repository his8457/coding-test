package baekjoon._14_bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2606 {
	public static void main(String[] args) throws Exception {
		//[백준] 24445 그래프와 순회 -> 바이러스
		/*
		 * 신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다. 한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 
		 * 모든 컴퓨터는 웜 바이러스에 걸리게 된다.
			예를 들어 7대의 컴퓨터가 <그림 1>과 같이 네트워크 상에서 연결되어 있다고 하자. 
			1번 컴퓨터가 웜 바이러스에 걸리면 웜 바이러스는 2번과 5번 컴퓨터를 거쳐 3번과 6번 컴퓨터까지 전파되어 2, 3, 5, 6 네 대의 컴퓨터는 웜 바이러스에 걸리게 된다.
			하지만 4번과 7번 컴퓨터는 1번 컴퓨터와 네트워크상에서 연결되어 있지 않기 때문에 영향을 받지 않는다.
			어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 
			1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.
			1-2-3 4
			\/   /
			5-6 7
			
			입력
			첫째 줄에는 컴퓨터의 수가 주어진다. 컴퓨터의 수는 100 이하이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다. 
			둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다. 
			이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.
			
			출력
			1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.
			
			예제 입력 1 
			7
			6
			1 2
			2 3
			1 5
			5 2
			5 6
			4 7
			예제 출력 1 
			4
		 * */
		
		solve();
		
	}

	private static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int pcCount = Integer.parseInt(br.readLine()); //총 PC 수
		int edgeCount = Integer.parseInt(br.readLine()); //간선 수
		
		ArrayList<Integer>[] graph = new ArrayList[pcCount+1]; //간선
		boolean[] visited = new boolean[pcCount+1]; //PC 탐색 여부
		int infectionCount = 0; //감염된 PC 수
		
		//간선 배열 초기화
		for(int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
		//입력 데이터 저장(간선)
		for(int i = 1; i <= edgeCount; i++) {
			String inputNE = br.readLine();
			int u = Integer.parseInt(inputNE.split(" ")[0]);
			int v = Integer.parseInt(inputNE.split(" ")[1]);
			
			graph[u].add(v);
			graph[v].add(u);
		}
		
		//너비 우선 탐색 실행
		int startNode = 1; //1번 PC부터 탐색
		infectionCount = BFS(startNode, graph, visited);
		
		System.out.println(infectionCount);
	}
	
	private static int BFS(int startNode, ArrayList<Integer>[] graph, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(startNode);
		visited[startNode] = true;
		
		int infectionCount = 0;
		
		while(!queue.isEmpty()) {
			int currentNode = queue.poll();
			infectionCount++;
			
			for(int i : graph[currentNode]) {
				if(!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
		
		return infectionCount = infectionCount > 0 ? infectionCount-1 : 0;
	}
}
