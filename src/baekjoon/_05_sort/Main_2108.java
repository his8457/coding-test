package baekjoon._05_sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_2108 {
	public static void main(String[] args) throws Exception {
		//[백준] 2108 정렬 -> 통계학
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
		//1.숫자의 개수 N을 입력받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//2.결과를 저장할 변수를 선언한다.
		int average = 0;   //산술평균
		int center = 0;    //중앙값
		int frequency = 0; //최빈값
		int range = 0;     //범위
		
		//3.N개의 수를 입력 받아 map에 저장한다.
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < N; i++) {
			map.put(Integer.parseInt(br.readLine()), map.getOrDefault(map, 0)+1);
		}
		
		//4.map의 정렬을 위해 key값을 List에 저장하고, 오름차순 정렬한다.
		List<Integer> keyset = new ArrayList<>(map.keySet());
		
		//5.key값 기준의 오름차순 정렬
		Collections.sort(keyset); //입력된 숫자의 오름차순 정렬
		
		//6.산술평균 값을 구한다.
		for(Integer i : keyset) {average += i;}
		average = average / N;
		
		//7.중앙값 (N은 반드시 홀수)
		center = keyset.get(keyset.size() / 2);
		
		//8.최빈값 : 여러개 있을 경우 두번째로 작은 값 출력
		//8.1 map에서 value값의 최대값을 찾
		Integer maxValue = Collections.max(map.values());
		List<Integer> keyArray = new ArrayList<>(); //max value에 해당하는 키들을 저장한다.
		
		for(Integer key : map.keySet()) {
			if(map.get(key) == maxValue) {
				keyArray.add(key);
			}
		}
		
		Collections.sort(keyArray); //오름순정렬 (value값이 같은 수들이 여러개일 경우 두번쨰로 작은 값을 찾기 위해 정렬)
		
		if(keyArray.size() > 1) {
			frequency = keyArray.get(1);
		}else {
			frequency = keyArray.get(0);
		}
		//9.범위
		range = keyset.get(keyset.size()-1) - keyset.get(0);
		
		System.out.println(average);
		System.out.println(center);
		System.out.println(frequency);
		System.out.println(range);
	}
}
