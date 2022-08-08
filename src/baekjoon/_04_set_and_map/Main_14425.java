package baekjoon._04_set_and_map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_14425 {
	public static void main(String[] args) throws Exception {
		/*
		 * 문제
		 * 총 N개의 문자열로 이루어진 집합 S가 주어진다.
		 * 입력으로 주어지는 M개의 문자열 중에서 집합 S에 포함되어 있는 것이 총 몇 개인지 구하는 프로그램을 작성하시오.
		 * 입력
		 * 첫째 줄에 문자열의 개수 N과 M (1 ≤ N ≤ 10,000, 1 ≤ M ≤ 10,000)이 주어진다. 
		 * 다음 N개의 줄에는 집합 S에 포함되어 있는 문자열들이 주어진다.
		 * 다음 M개의 줄에는 검사해야 하는 문자열들이 주어진다.
		 * 입력으로 주어지는 문자열은 알파벳 소문자로만 이루어져 있으며, 길이는 500을 넘지 않는다. 
		 * 집합 S에 같은 문자열이 여러 번 주어지는 경우는 없다.
		 * 출력
		 * 첫째 줄에 M개의 문자열 중에 총 몇 개가 집합 S에 포함되어 있는지 출력한다.
		 * 
		 * 예제 입력 1 
		 * 5 11
		 * baekjoononlinejudge
		 * startlink
		 * codeplus
		 * sundaycoding
		 * codingsh
		 * baekjoon
		 * codeplus
		 * codeminus
		 * startlink
		 * starlink
		 * sundaycoding
		 * codingsh
		 * codinghs
		 * sondaycoding
		 * startrink
		 * icerink
		 * 예제 출력 1 
		 * 4
		 * */
		
		solve();
	}

	private static void solve() throws Exception{
		//1. 입력을 받을 변수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputString = br.readLine(); //문자열로 입력된 N과 M의 값
		
		//2. 입력받을 문자열의 개수 N과 M
		int N = Integer.parseInt(inputString.split(" ")[0]); //주어진 집합 N의 개수
		int M = Integer.parseInt(inputString.split(" ")[1]); //비교할 문자열의 개수 M
		
		//3. 집합S 
		Map<String, Integer> map = new HashMap<>();
		
		//4. 포함된 문자열의 개수
		int includeCount = 0;
		
		for(int i = 0; i < N; i++) {
			map.put(br.readLine(), 0); //집합 S 만들기
		}
		
		for(int i = 0; i < M; i++) {
			String key = br.readLine();
			
			if(map.containsKey(key)) {
				map.put(key, map.get(key)+1);
			}
		}
		
		//5. 집합에 포함된 문자열 개수 누적 합산 및 출력
		for(String key : map.keySet()) {
			includeCount += map.get(key);
		}
		
		System.out.println(includeCount);
	}
}
