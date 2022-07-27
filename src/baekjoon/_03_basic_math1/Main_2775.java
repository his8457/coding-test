package baekjoon._03_basic_math1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2775 {
	public static void main(String[] args) throws Exception {
		/*
		 * 문제
		 * 평소 반상회에 참석하는 것을 좋아하는 주희는 이번 기회에 부녀회장이 되고 싶어 
		 * 각 층의 사람들을 불러 모아 반상회를 주최하려고 한다.
		 * 이 아파트에 거주를 하려면 조건이 있는데, 
		 * “a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다” 는 
		 * 계약 조항을 꼭 지키고 들어와야 한다.
		 * 아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정했을 때, 
		 * 주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있는지 출력하라. 
		 * 단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.
		 * 입력
		 * 첫 번째 줄에 Test case의 수 T가 주어진다. 
		 * 그리고 각각의 케이스마다 입력으로 첫 번째 줄에 정수 k, 두 번째 줄에 정수 n이 주어진다
		 * 출력
		 * 각각의 Test case에 대해서 해당 집에 거주민 수를 출력하라.
		 * 제한
		 * 1 ≤ k, n ≤ 14
		 * 
		 * 예제 입력 
		 * 2 (테스트 케이스 수)
		 * 1 (case1 - 첫번째 입력 = K:층)
		 * 3 (case1 - 두번째 입력 = N:호)
		 * 2 (case2 - 첫번째 입력)
		 * 3 (case2 - 두번째 입력)
		 * 
		 * 예제 출력 
		 * 6 (case1 결과)
		 * 10 (case2 결과)
		 * */
		
		/**
		 * 4층 | 1호(1명) | 2호(6명) | 3호(21명) | 4호(56명).. | N호
		 * 3층 | 1호(1명) | 2호(5명) | 3호(15명) | 4호(35명).. | N호
		 * 2층 | 1호(1명) | 2호(4명) | 3호(10명) | 4호(20명).. | N호
		 * 1층 | 1호(1명) | 2호(3명) | 3호(6명)  | 4호(10명).. | N호
		 * 0층 | 1호(1명) | 2호(2명) | 3호(3명)  | 4호(4명)..  | N호(N명)
		 * 
		 * -----------------------  수식적용  ------------------------
		 * 4층 | 1호(1명) | 2호(6명) | 3호(21명) | 4호(56명).. | N호
		 * 3층 | 1호(1명) | 2호(5명) | 3호(15명) | 4호(35명).. | N호
		 * 2층 | 1호(1명) | 2호(4명) | 3호(10명) | 4호(20명).. | N호
		 * 1층 | 1호(1명) | 2호(N-1호 + K-1층의 N호) | 3호(6명)  | 4호(10명).. | N호
		 * 0층 | 1호(1명) | 2호(2명) | 3호(3명)  | 4호(4명)..  | N호(N명)
		 * 
		 * 규칙
		 * 0층에는 각 호수와 일치하는 사람이 거주함. (8호 -> 8명)
		 * 층에 상관없이 모든 층의 1호 거주자는 1명임
		 * 
		 * 0층 -> N호 (N)
		 * 1층 이상 -> N호 (K-1층의 1호 ~ N호 거주자의 합)
		 * */
		
		/**
		 * 이해
		 * 1. 아파트의 K층의 N호에 거주하려면 K-1층의 1 ~ N호에 사는 사람 수를 합한 만큼 사람이 있어야함.
		 * 2. 예의 case1 1층 3호 -> 6
		 * */
		
		printCountPerson();
	}

	private static void printCountPerson() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCaseCount = Integer.parseInt(br.readLine());
		
		for(int k = 0; k < testCaseCount; k++) {
			int K = Integer.parseInt(br.readLine()); //층
			int N = Integer.parseInt(br.readLine()); //호
			int resultPersonCount = 0; //결과값 (K층 N호의 거주민 수)
			
			
			//2차원 배열로 풀기
			int[][] apartment = new int[K+1][N]; //[]배열자리에는 층의 개수가 들어가야 하므로 K+1 (0층부터 존재하기 때문)
			
			for(int i = 0; i < apartment.length; i++) { //i : 층
				for(int j = 0; j < apartment[i].length; j++) { //j : 호
					if(i == 0) {
						apartment[i][j] = j+1; //0층일때 각 호실의 거주자는 호실의 번호와 같음. 1호면 1명, 2호면 2명 
					}else {
						if(j == 0) { //j가 0이면 -> 1호
							apartment[i][j] = 1;
						}else {
							apartment[i][j] = apartment[i][j-1] + apartment[i-1][j];
						}
					}
				}
			}
			resultPersonCount = apartment[K][N-1]; //호수는 1호부터 존재하므로 N호의 호수는 N-1 index에 있음. 
			System.out.println(resultPersonCount);
		}
	}
}
