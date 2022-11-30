package baekjoon._05_sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_2108 {
	public static void main(String[] args) throws Exception {
		// [백준] 정렬 : 통계학
		/*
		 * 문제
			수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.
			산술평균 : N개의 수들의 합을 N으로 나눈 값
			중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
			최빈값 : N개의 수들 중 가장 많이 나타나는 값
			범위 : N개의 수들 중 최댓값과 최솟값의 차이
			N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.
			
			입력
			첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 단, N은 홀수이다. 그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.
			
			출력
			첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
			둘째 줄에는 중앙값을 출력한다.
			셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
			넷째 줄에는 범위를 출력한다.
			
			예제 입력 1 
			5
			1
			3
			8
			-2
			2
			예제 출력 1 
			2
			2
			1
			10
		 * */
		
		solve();
	}

	private static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//주어지는 수의 개수 N
		int N = Integer.parseInt(br.readLine());
		
		//입력받은 수의 배열
		int[] input = new int[N];
		
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		//입력받은 수의 배열을 오름차순으로 정렬
		Arrays.sort(input);
		
		//1.산술평균 (소수점 첫째자리 반올림)
		int sum = 0;
		for(int i : input) {
			sum += i;
		}
		System.out.println(Math.round(sum/(float)N));
		
		//2.중앙값
		System.out.println(input[Math.round(N/2)]);
		
		//3.최빈값
		Map<Integer, Integer> freMap = new HashMap<>();
		for(int i = 0; i < N; i++) {
			freMap.put(input[i], freMap.getOrDefault(input[i], 0)+1);
		}
		
		int maxVal = Collections.max(freMap.values()); //가장 높은 빈도수
		
		List<Integer> maxValList = new ArrayList<>();
		
		for(Integer t : freMap.keySet()) {
			if(freMap.get(t) == maxVal) {
				maxValList.add(t);
			}
		}
		
		if(maxValList.size() == 1) {
			System.out.println(maxValList.get(0));
		}else {
			Collections.sort(maxValList);
			System.out.println(maxValList.get(1));
		}
		
		//4.범위(최댓값 - 최솟값)
		System.out.println(input[input.length-1]-input[0]);
	}
}
