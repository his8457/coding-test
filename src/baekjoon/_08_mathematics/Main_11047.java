package baekjoon._08_mathematics;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11047 {
	public static void main(String[] args) throws Exception {
		//[백준] 11047 동전
		/*
		 * 문제
			준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
			동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 
			이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
			
			입력
			첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
			둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. 
			(1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
			
			출력
			첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.
			
			예제 입력 1 
			10 4200
			1
			5
			10
			50
			100
			500
			1000
			5000
			10000
			50000
			예제 출력 1 
			6
		 * */
		
		solve();
	}

	private static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		//1.동전 종류의 개수와 총액을 입력받는다.
		int typeCount = Integer.parseInt(input.split(" ")[0]);
		int coinSum = Integer.parseInt(input.split(" ")[1]);
		
		//2.동전 종류(금액)를 담을 배열과 총액이 되는 최소 동전의 수(결과)를 담을 변수를 선언한다.
		int[] coinType = new int[typeCount];
		int minCoinCount = 0;
		
		//3.동전 종류를 배열에 담는다
		for(int i = 0; i < typeCount; i++) {
			coinType[i] = Integer.parseInt(br.readLine());
		}
		
		//4.총액을 총액보다 작은 동전으로 나누며 결과를 구한다.
		do {
			for(int i = 0; i < coinType.length; i++) {
				if(coinType[i] == coinSum) {
					minCoinCount += coinSum / coinType[i];
					coinSum = coinSum % coinType[i];
					break;
				}
				
				if(coinType[i] > coinSum) {
					int n = i == 0 ? 0 : i-1;
					minCoinCount += coinSum / coinType[n];
					coinSum = coinSum % coinType[n];
					break;
				}
				
				if(coinType[coinType.length-1] < coinSum) {
					minCoinCount += coinSum / coinType[coinType.length-1];
					coinSum = coinSum % coinType[coinType.length-1];
					break;
				}
			}
			
		}while(coinSum != 0);
			
		System.out.println(minCoinCount);
	}
}
