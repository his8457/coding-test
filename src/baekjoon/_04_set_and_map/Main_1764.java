package baekjoon._04_set_and_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main_1764 {
	public static void main(String[] args) throws IOException {
		/*
		 * [백준] 집합과 맵 [S4] 1764 듣보잡
		 * 문제
		 * 김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.
		 * 입력
		 * 첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다. 
		 * 이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과, N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다. 
		 * 이름은 띄어쓰기 없이 알파벳 소문자로만 이루어지며, 그 길이는 20 이하이다. N, M은 500,000 이하의 자연수이다.
		 * 듣도 못한 사람의 명단에는 중복되는 이름이 없으며, 보도 못한 사람의 명단도 마찬가지이다.
		 * 출력
		 * 듣보잡의 수와 그 명단을 사전순으로 출력한다.
		 * 
		 * 예제 입력 1 
		 * 3 4
		 * ohhenrie
		 * charlie
		 * baesangwook
		 * obama
		 * baesangwook
		 * ohhenrie
		 * clinton
		 * 예제 출력 1 
		 * 2
		 * baesangwook
		 * ohhenrie
		 * */
		
		solve();
	}

	private static void solve() throws IOException {
		//1.입력을 받을 변수를 선언한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String numberOfPeople = br.readLine();
		
		int N = Integer.parseInt(numberOfPeople.split(" ")[0]);
		int M = Integer.parseInt(numberOfPeople.split(" ")[1]);
		
		Set<String> setN = new HashSet<>();
		Set<String> setM = new HashSet<>();
		
		//2. 입력받은 사람들의 이름을 Set에 담는다. (집합 N, 집합 M)
		for(int i = 0; i < N; i++) {
			setN.add(br.readLine());
		}
		
		for(int i = 0; i < M; i++) {
			setM.add(br.readLine());
		}
		
		//3. 집합 N, M의 교집합을 구한다. (듣지도 보지도 못한 사람)
		setN.retainAll(setM);
		
		//4. 지합N,M의 교집합 결과를 오름차순으로 정렬하고 출력한다.
		Iterator<String> iter = setN.iterator();
		String[] names = new String[setN.size()];
		int i = 0;
		while(iter.hasNext()) {
			names[i] = iter.next();
			i++;
		}
			
		Arrays.sort(names);
		
		StringBuilder sb = new StringBuilder();
		sb.append(names.length + "\n"); //듣보잡의 수
		
		for(int k = 0; k < names.length; k++) {
			sb.append(names[k] + "\n");
		}
		
		System.out.println(	sb.toString());
		
	}
}
