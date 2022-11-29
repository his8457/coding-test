package baekjoon._14_bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260 {
	public static void main(String[] args) throws Exception {
		// DFS와 BFS
		/*
		 * 문제
			그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
			단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 
			더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
			
			입력
			첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
			다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 
			어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 
			입력으로 주어지는 간선은 양방향이다.
			
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
		 * 
		 * */
		solve();
	}
    public static int nodeCnt;
    public static LinkedList<Integer>[] nodeList;
    
    
    @SuppressWarnings("unchecked")
	private static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
        nodeCnt = Integer.parseInt(st.nextToken()); // 4
        int lineCnt = Integer.parseInt(st.nextToken()); // 5
        int startNode = Integer.parseInt(st.nextToken()); // 1
        
        nodeList = new LinkedList[nodeCnt+1];
        
        for(int i=0; i <= nodeCnt; i++) {
            nodeList[i] = new LinkedList<Integer>();
        }
        
        for(int i=0; i < lineCnt; i++) {
            st = new StringTokenizer(br.readLine());
            
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            
            nodeList[node1].add(node2);
            nodeList[node2].add(node1);
            
            Collections.sort(nodeList[node1]);
            Collections.sort(nodeList[node2]);
        }
        
        for(LinkedList<Integer> i : nodeList) {
        	System.out.println(i.toString());
        }
        
        
        StringBuilder dfsResult = new StringBuilder();
        StringBuilder bfsResult = new StringBuilder();
        
        boolean[] dfsVisited = new boolean[nodeCnt+1];
        boolean[] bfsVisited = new boolean[nodeCnt+1];
        
        dfs(startNode, dfsVisited, dfsResult);
        bfs(startNode, bfsVisited, bfsResult);
        
        System.out.println(dfsResult + "\n" + bfsResult);
	}

    public static void dfs(int node, boolean[] visited, StringBuilder sb) {
        if(visited[node]) return;
        
        visited[node] = true;
        sb.append(node + " ");
        for(int nextNode:nodeList[node]) {
        	dfs(nextNode, visited, sb);
        }
    }
    
    public static void bfs(int node, boolean[] visited, StringBuilder sb) {
        Queue<Integer> queue = new LinkedList<Integer>();
        
        queue.offer(node);
        
        while(!queue.isEmpty()) {
            node = queue.poll();
            
            if(visited[node]) continue;
            
            visited[node] = true;
            sb.append(node + " ");
            
            for(int nextNode:nodeList[node]) {
                queue.add(nextNode);
            }
        }
    }
}
