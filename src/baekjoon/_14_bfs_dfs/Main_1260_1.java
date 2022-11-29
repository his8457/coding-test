package baekjoon._14_bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main_1260_1 {
	
	private static boolean[] visited; // 정점 방문 여부
	private static List<Integer>[] listArr; // 정점 및 간선 표현 배열
	private static String result = ""; // 시작 정점에서 부터 방문 순서(결과)
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" "); 
		
		// 1.정점 번호 N, 간선 개수 M, 시작 정점 V 선언 및 초기화
		int N = Integer.parseInt(input[0]);  //정점 번호 N
		int M = Integer.parseInt(input[1]);  //간선 개수 M (간선은 양방향)
		int V = Integer.parseInt(input[2]);  //시작 정점 V
		
		// 2.방문여부 배열, 정점 및 간선 표현 배열(정점 연결 관계) 초기화
		visited = new boolean[N+1];
		listArr = new ArrayList[N+1];
				
		for(int i = 0; i < listArr.length; i++) {
			listArr[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			String p = br.readLine();
			int firstN = Integer.parseInt(p.split(" ")[0]);
			int secondN = Integer.parseInt(p.split(" ")[1]);
			listArr[firstN].add(secondN);
			listArr[secondN].add(firstN);
		}
		
		// 3.정점에 연결된 정점 오름차순 정렬
		for(int i = 0; i < listArr.length; i++) {
			ArrayList<Integer> y = (ArrayList<Integer>) listArr[i];
			Collections.sort(y, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					if(o1 > o2) {
						return 1;
					}
					return -1;
				}
			});
		}
		
		// 4.DFS 실행 및 결과 출력
		visited[0] = true;
		dfs(V);
		System.out.println(result);
		
		// 5. BFS 실행 및 결과 출력
		result = ""; //결과값 초기화
		visited = new boolean[N+1]; //방문여부 배열 초기화
		visited[0] = true;
		
		bfs(V);
		System.out.println(result);
	}
	
	// DFS (depth - first - search)
	private static void dfs(int v) {//시작 정점    3 1 2 5 4 
		visited[v] = true;
		result += v + " ";
		
		for(int i = 0; i < listArr[v].size(); i++) {
			if(visited[(Integer)listArr[v].get(i)] == true) {
				continue;
			}else {
				dfs((Integer)listArr[v].get(i));
			}
		}
	}
	
	// BFS (breath - first - search)
	private static void bfs(int v) {
		LinkedList<Integer> queue = new LinkedList<>();
		visited[v] = true;
		queue.add(v);
		
		while(!queue.isEmpty()) {
			v = queue.poll();
			result += v + " ";
			
			for(Integer i : listArr[v]) {
				if(!visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
