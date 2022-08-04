package baekjoon._04_set_and_map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_10815 {

	public static void main(String[] args) throws Exception{
		/*
		 * 문제
		 * 숫자 카드는 정수 하나가 적혀져 있는 카드이다. 
		 * 상근이는 숫자 카드 N개를 가지고 있다. 
		 * 정수 M개가 주어졌을 때, 
		 * 이 수가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지를 구하는 프로그램을 작성하시오.
		 * 입력
		 * 첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 
		 * 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 
		 * 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다. 
		 * 두 숫자 카드에 같은 수가 적혀있는 경우는 없다.
		 * 셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 
		 * 넷째 줄에는 상근이가 가지고 있는 숫자 카드인지 아닌지를 구해야 할 M개의 정수가 주어지며, 
		 * 이 수는 공백으로 구분되어져 있다. 
		 * 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다
		 * 출력
		 * 첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 가지고 있으면 1을, 
		 * 아니면 0을 공백으로 구분해 출력한다.
		 * 
		 * 예제 입력 1 
		 * 5
		 * 6 3 2 10 -10
		 * 8
		 * 10 9 -5 2 3 4 5 -10
		 * 
		 * 예제 출력 1 
		 * 1 0 0 1 1 0 0 1
		 * 
		 * */
		
		printSolve();
	}

	private static void printSolve() throws Exception{
		//1. 입력받을 변수를 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//2. 카드의 개수만큼 카드에 적힌 숫자를 담는다.
		int N = Integer.parseInt(br.readLine());
		String[] strArrN = br.readLine().split(" ");
		int [] cardNumbers = new int[N];

		for(int i = 0; i < N; i++) {
			cardNumbers[i] = Integer.parseInt(strArrN[i]);
		}
		
		//3. 비교할 숫자의 개수만큼 배열을 만들고 숫자를 담는다.
		int M = Integer.parseInt(br.readLine());
		String[] strArrM = br.readLine().split(" ");
		int [] ComparativeGroup = new int[M];

		for(int i = 0; i < M; i++) {
			ComparativeGroup[i] = Integer.parseInt(strArrM[i]);
		}
		
		//4. 결과를 출력할 변수를 선언한다.
		StringBuffer sb = new StringBuffer();
		
		
		//5. 카드에 적힌 숫자를 map에 담고 비교할 숫자가 담긴 배열과 비교하여 
		//   해당 숫자가 있으면 1을 없으면 0을 buffer에 담는다.
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			map.put(cardNumbers[i], cardNumbers[i]);
		}
		
		for(int i = 0; i < M; i++) {
			if(map.containsKey(ComparativeGroup[i])) {
				sb.append(1);
				sb.append(' ');
			}else {
				sb.append(0);
				sb.append(' ');
			}
		}
		
		//6. 결과를 출력한다.
		System.out.println(sb.toString());
	}
}
