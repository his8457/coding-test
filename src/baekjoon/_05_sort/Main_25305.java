package baekjoon._05_sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_25305 {

	public static void main(String[] args) throws Exception {
		// [백준] 25305 정렬-커트라인
		/*
		 * 문제
		 * 2022 연세대학교 미래캠퍼스 슬기로운코딩생활에 N명의 학생들이 응시했다.
		 * 이들 중 점수가 가장 높은 k명은 상을 받을 것이다. 
		 * 이 때, 상을 받는 커트라인이 몇 점인지 구하라.
		 * 커트라인이란 상을 받는 사람들 중 점수가 가장 가장 낮은 사람의 점수를 말한다.
		 * 
		 * 입력
		 * 첫째 줄에는 응시자의 수 N과 상을 받는 사람의 수 k가 공백을 사이에 두고 주어진다.
		 * 둘째 줄에는 각 학생의 점수 x가 공백을 사이에 두고 주어진다.
		 * 
		 * 출력
		 * 상을 받는 커트라인을 출력하라.
		 * 
		 * 제한
		 * 1 ≤ N ≤ 1,000 
		 * 1 ≤ k ≤ N 
		 * 0 ≤ x ≤ 10,000 
		 * 
		 * 예제 입력 1 
		 * 5 2
		 * 100 76 85 93 98
		 * 예제 출력 1 
		 * 98
		 * */
		
		solve();
	}

	private static void solve() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int N = Integer.parseInt(input.split(" ")[0]); //응시자의 수
		int k = Integer.parseInt(input.split(" ")[1]); //상을 받는 사람 수
		
		String inputScore = br.readLine();
		int[] scores = new int[inputScore.split(" ").length];
		
		int u = 0;
		for(String s : inputScore.split(" ")) {
			scores[u] = Integer.parseInt(s);
			u++;
		}
		
		int cutLineScore = 0;
		int[] scoresCount = new int[10001]; //점수 범위 0점 ~ 10000점
		
		for(int i = 0; i < scores.length; i++) {
			scoresCount[scores[i]]++;
		}
		
		int kTemp = 0;
		for(int i = scoresCount.length-1; i > 0; i--) {
			if(scoresCount[i] >= 0) {
				kTemp += scoresCount[i]; 

				if(kTemp >= k) {
					cutLineScore = i;
					break;
				}
			}
		}
		System.out.println(cutLineScore);
	}

}
