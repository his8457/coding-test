package baekjoon._05_sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main_18870 {
	public static void main(String[] args) throws Exception {
		//[백준] 18870 좌표압축 - 정렬
		/*
		 * 문제
			수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.
			Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.
			X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.
			
			입력
			첫째 줄에 N이 주어진다.
			둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.
			
			출력
			첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.
			
			제한
			1 ≤ N ≤ 1,000,000
			-109 ≤ Xi ≤ 109
			
			예제 입력 1 
			5
			2 4 -10 4 -9
			
			예제 출력 1 
			2 3 0 3 1
			
			예제 입력 2 
			6
			1000 999 1000 999 1000 999
			
			예제 출력 2 
			1 0 1 0 1 0
		 * */
		
		solve();
	}

	private static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" "); //원본 문제 배열(문자열)
		
		int[] orgInputArr = new int[N]; //원본 문제 배열(정수)
		int[] sortInputArr = new int[N]; //압축 번호를 부여하기 위해 원본 문제 배열을 오름차순으로 정렬할 배열
		
		// 1.입력된 문제를 배열에 담기
		for(int i = 0; i < N; i++) {
			orgInputArr[i] = Integer.parseInt(s[i]);
			sortInputArr[i] = orgInputArr[i];
		}
		
		// 2.입력받은 배열을 오름차순으로 정렬
		Arrays.sort(sortInputArr);
		
		// 3.입력받은 배열의 값을 압축된 값으로 매핑
		Map<Integer, Integer> map = new HashMap<>();
		int compNum = 0;
		int num = sortInputArr[0]; //오름차순으로 정렬된 배열에서 가장 작은 값을 초기값으로 설정
		map.put(num, compNum); //정렬된 배열의 가장 작은 값을 압축번호(0)으로 매핑
		
		for(int i = 1; i < sortInputArr.length; i++) {
			if(num == sortInputArr[i]) {
				continue;
			}else {
				num = sortInputArr[i];
				compNum++;
				map.put(num, compNum); //정렬된 배열의 가장 작은 값을 압축번호(0)으로 매핑
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			sb.append(map.get(orgInputArr[i]) + " ");
		}
		
		System.out.println(sb.toString());
	}
}
