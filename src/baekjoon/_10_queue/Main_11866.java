package baekjoon._10_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_11866 {
	public static void main(String[] args) throws Exception {
		// [백준] 11866 큐 -> 요세푸스 문제 0
		/*
		 * 문제
		요세푸스 문제는 다음과 같다.
		1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 
		양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다. 
		한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 
		이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 
		원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 
		예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
		N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
		입력
		첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 1,000)
		출력
		예제와 같이 요세푸스 순열을 출력한다.
		예제 입력 1 
		7 3
		예제 출력 1 
		<3, 6, 2, 7, 5, 1, 4>
		 * */
		solve();
	}

	private static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String question = br.readLine();
		
		int inputNum = Integer.parseInt(question.split(" ")[0]);
		int n = Integer.parseInt(question.split(" ")[1]);
		List<Integer> result = new ArrayList<>();
		
		//1. 큐 만들기
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= inputNum; i++) {
			queue.add(i);
		}
		
		//2. 주어진 조건과 같이 매번 3번째에 위치한 값을 찾음.
		int cnt = 1;
		if(inputNum > 1) {
			while(queue.size() > 1) {
				if(cnt < n) { //
					int i = queue.poll();
					queue.add(i);
					cnt++;
				}else {
					result.add(queue.poll());
					cnt = 1;
				}
			}
		}
		result.add(queue.poll());
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i = 0; i < result.size(); i++) {
			sb.append(result.get(i));
			
			if(i != result.size() - 1) {
				sb.append(", ");
			}else {
				sb.append(">");
			}
		}
		System.out.println(sb);
	}
}
