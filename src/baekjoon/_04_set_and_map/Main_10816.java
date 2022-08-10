package baekjoon._04_set_and_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_10816 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//[백준] 집합과맵 [S4] 10816 숫자카드2
		/*
		 * 문제
		 * 숫자 카드는 정수 하나가 적혀져 있는 카드이다. 
		 * 상근이는 숫자 카드 N개를 가지고 있다. 
		 * 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.
		 * 
		 * 입력
		 * 첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 
		 * 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 
		 * 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
		 * 셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 
		 * 넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다. 
		 * 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
		 * 
		 * 출력
		 * 첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력한다.
		 * 
		 * 예제 입력 1 
		 * 10
		 * 6 3 2 10 10 10 -10 -10 7 3
		 * 8
		 * 10 9 -5 2 3 4 5 -10
		 * 예제 출력 1 
		 * 3 0 0 1 2 0 0 2
		 * 
		 * */
		
		solve();
	}

	private static void solve() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); //결과를 담을 변수
		Map<Integer, Integer> result = new HashMap<>(); //카드 배열을 취합한 Map (key : 카드에 적힌 수, value : key에 해당하는 카드의 개수)
		
		int N = Integer.parseInt(br.readLine()); //카드 개수
		int[] cards = new int[N]; //카드배열 
		
		int k = 0; 
		for(String strCardNum : br.readLine().split(" ")) {
			cards[k] = Integer.parseInt(strCardNum);
			k++;
		}
		
		int M = Integer.parseInt(br.readLine()); //비교대상 수
		int[] targets = new int[M]; //비교대상 배열
		
		k = 0;
		for(String strTargetNum : br.readLine().split(" ")) {
			targets[k] = Integer.parseInt(strTargetNum);
			k++;
		}
		
		for(int i = 0; i < cards.length; i++) {//카드 취합 MAP
			result.put(cards[i], result.getOrDefault(cards[i], 0)+1);
		}
		
		for(int i = 0; i < targets.length; i++) {//카드취합 배열에서 비교대상의 개수를 문자열로 저장
			if(result.get(targets[i]) != null) {
				sb.append(result.get(targets[i]) + " ");
			}else {
				sb.append("0 ");
			}
		}
		
		System.out.println(sb.toString()); //결과 출력
	}
}
