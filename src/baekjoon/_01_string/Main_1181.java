package baekjoon._01_string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main_1181 {
	public static void main(String[] args) throws Exception {
		//[백준] 1181 단어 정렬
		/*
		 * 문제
		알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
		길이가 짧은 것부터
		길이가 같으면 사전 순으로
		
		입력
		첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 
		주어지는 문자열의 길이는 50을 넘지 않는다.
		
		출력
		조건에 따라 정렬하여 단어들을 출력한다. 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.
		
		예제 입력 1 
		13
		but
		i
		wont
		hesitate
		no
		more
		no
		more
		it
		cannot
		wait
		im
		yours
		
		예제 출력 1 
		i
		im
		it
		no
		but
		more
		wait
		wont
		yours
		cannot
		hesitate
		 * */
		
		solve();
		
	}

	private static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int inputNum = Integer.parseInt(br.readLine());
		List<String> result = new ArrayList<>(); 
		
		for(int i = 0; i < inputNum; i++) {
			String str = br.readLine();
			
			if(i == 0) {
				result.add(str);
				continue;
			}else {
				if(result.indexOf(str) == -1) {
					result.add(str);
				}
			}
		}
		
		Comparator<String> compare = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() > o2.length()) {
					return 1;
				}else if (o1.length() == o2.length()) {
					if(o1.compareTo(o2) > 0) {
						return 1;
					}
				}
				return -1;
			}
		};
		
		Collections.sort(result, compare);
		
		for(String str : result) {
			System.out.println(str);
		}
	}
}
