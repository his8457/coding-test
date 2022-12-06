package baekjoon._14_bfs_dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1697 {
	public static void main(String[] args) throws Exception {
		// [백준] 1697 숨바꼭질 - 그래프와 순회
		/*
		 * 문제
			수빈이는 동생과 숨바꼭질을 하고 있다. 
			수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 
			수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 
			순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
			수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
			
			입력
			첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
			
			출력
			수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
			
			예제 입력 1 
			5 17
			예제 출력 1 
			4
			
			힌트
			수빈이가 5-10-9-18-17 순으로 가면 4초만에 동생을 찾을 수 있다.
		 * */
		
		solve();
	}

	static int N; //시작위치(수빈)
	static int K; //목표위치(동생)
	static int MAX = 100000;
	static int count = 0;
	static boolean[] visited = new boolean[MAX+1];
			
	private static void solve() throws Exception {
		//N은 현재 위치, K는 목표 위치
		//걸으면 → 1초에 N-1 or N+1
		//순간이동 → 1초에 2 * N
		//힌트 5 → 10 → 9 → 18 → 17 (4번 이동)
		
		//배열
		//[0] [1] [2] [3] [4] [5] [6] [7] [8] [9] [10] [11] [12] [13] [14] [15] [16] [17] [18] [19] [20]
		//                     S                                                      T
		// 1회 이동          1       1                1
		// 2회 이동      2               2   2   2        2    2                                       2
		// 3회 이동   3                                              3    3         3         3
		// 4회 이동                                                           4         4          4
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]); //시작위치(수빈)
		K = Integer.parseInt(str[1]); //목표위치(동생)
		
		bfs(); //탐색시작
		
		System.out.println(count); //결과 출력
	}

	private static void bfs() {
		//※ 탐색 시작 시, 수빈이와 동생이 같은 위치에 있으면 탐색 종료
		if(N == K) {
			return;
		}
		
		// 1.시작 노드를 Queue에 넣고 탐색 시작
		Queue<ArrayList<Integer>> que = new LinkedList<>();
		ArrayList<Integer> nextP = new ArrayList<>();
		nextP.add(N);
		que.add(nextP);
		
		visited[N] = true; //시작위치 방문여부 true로 설정
		boolean isFind = false; //목표 위치 도착 여부
		
		// 2.탐색 시작 : 현재 노드들의 -1위치, +1위치, *2 위치 및 목표위치에 도달여부를 확인
		while(!que.isEmpty() && !isFind) {
			ArrayList<Integer> curP = que.poll();
			nextP = new ArrayList<>();
			
			for(int i = 0; i < curP.size(); i++) {
				int p = curP.get(i);
				
				if(p == K) {//현재 위치와 목표 위치가 같은지 확인
					isFind = true;
					break;
				}
				
				if(p-1 >= 0 && p-1 <= MAX && !visited[p-1]) {
					nextP.add(p-1);
					visited[p-1] = true;
					if(p-1 == K) {
						isFind = true;
						break;
					}
				}
				
				if(p+1 >= 0 && p+1 <= MAX && !visited[p+1]) {
					nextP.add(p+1);
					visited[p+1] = true;
					if(p+1 == K) {
						isFind = true;
						break;
					}
				}
				
				if(p*2 >= 0 && p*2 <= MAX && !visited[p*2]) {
					nextP.add(p*2);
					visited[p*2] = true;
					if(p*2 == K) {
						isFind = true;
						break;
					}
				}
			}
			
			// 3.다음 탐색 노드들을 queue에 넣음
			if(nextP.size() > 0) {
				que.add(nextP);
			}
			
			count++;
		}
	}
}
