package baekjoon._05_sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main_11651 {
	public static void main(String[] args) throws Exception {
		//[백준] 11651 좌표 정렬하기2
		/*
		 * 문제
			2차원 평면 위의 점 N개가 주어진다. 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
			
			입력
			첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
			
			출력
			첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
			
			예제 입력 1 
			5
			0 4
			1 2
			1 -1
			2 2
			3 3
			
			예제 출력 1 
			1 -1
			1 2
			2 2
			3 3
			0 4
		 * */
		
		solve();
	}

	private static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Object[] obj = new Object[N];
		
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			
			int[] t = new int[2];
			t[0] = Integer.parseInt(s[0]);
			t[1] = Integer.parseInt(s[1]);
			
			obj[i] =  t;
		}
		
		//1. Y좌표가 증가하는 순으로 정렬, 만일 Y가 같으면 X가 증가하는 순서로 정렬
		Arrays.sort(obj, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				int[] k1 = (int[])o1;
				int[] k2 = (int[])o2;
				
				if(k1[1] == k2[1]) {//선행원소 Y값과 후행원소 Y값이 같으면 X값을 기준으로 오름차순 정렬
					return k1[0] - k2[0];
				}else{//선행원소 Y값과 후행원소 Y값이 다르면 Y값을 기준으로 오름차순 정렬
					return k1[1] - k2[1];
				}
			}
		});
		
		for(Object o : obj) {
			int[] a = (int[])o;
			System.out.println(a[0] + " " + a[1]);
		}
	}
}
