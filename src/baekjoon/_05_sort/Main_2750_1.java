package baekjoon._05_sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2750_1 {
	public static void main(String[] args) throws Exception {
		//[백준] 정렬 2750 수 정렬하기
		/*
		 *문제
		 *N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
		 *입력
		 *첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 
		 *둘째 줄부터 N개의 줄에는 수 주어진다. 
		 *이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 
		 *수는 중복되지 않는다.
		 *
		 *출력
		 *첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
		 *
		 *예제 입력 1 
		 *5
		 *5
		 *2
		 *3
		 *4
		 *1
		 *
		 *예제 출력 1 
		 *1
		 *2
		 *3
		 *4
		 *5 
		 * */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//정렬
		//int N1 = N;
		//int[] arr1 = {5,2,3,4,1};
		//mySort(N1, arr1, "ASC"); //탐색횟수 10회
		
		//버블정렬
		int N2 = N;
		int[] arr2 = arr;
		bubbleSort(N2, arr2, "ASC"); //탐색횟수 10회
		
		//선택정렬
		//int N3 = N;
		//int[] arr4 = {5,2,3,4,1};
		//selectionSort(N3, arr4, "ASC"); //탐색횟수 10회

		//삽입정렬
		//int N4 = N;
		//int[] arr3 = {5,2,3,4,1};
		//insertSort(N4, arr3, "ASC"); //탐색횟수 10회
	}
	

	/**
	 * insertSort
	 * 설명 : 배열의 2번째 인덱스부터 시작해서 인덱스 앞의 숫자와 비교하면서 적합한 자리에 배치하는 알고리즘
	 * 전체 탐색 횟수 : 10회
	 * */
	private static void insertSort(int n, int[] arr, String orderBy) {
		int searchCnt = 0;
		
		for(int i = 1; i < n; i++) {
			int index = -1;
			int temp = 0;
			
			for(int j = i-1; j >= 0; j--) {
				if(arr[i] < arr[j]) {
					index = j;
				}
				searchCnt++;
			}
			
			if(index >= 0) {
				temp = arr[i];
				for(int k = i; k > index; k--) {
					arr[k] = arr[k-1];
				}
				arr[index] = temp;
			}
		}
		print("insertSort", arr, searchCnt);
	}

	/**
	 * bubbleSort
	 * 설명 : 배열의 앞에서부터 2개씩 비교해서 오름차순으로 정렬하는 알고리즘
	 * 전체 탐색 횟수 : 
	 * */
	private static void bubbleSort(int n, int[] arr, String orderBy) {
		int searchCnt = 0;
		
		for(int i = 0; i < n-1; i++) {
			for(int j = n-1; j > i; j--) {
				swap(arr, j-1, j, orderBy);
				searchCnt++;
			}
		}
		print("bubbleSort", arr, searchCnt);
	}
	
	/**
	 * selectionSort
	 * 설명 : 배열의 유효인덱스를 탐색하며 가장작은 값들을 배열의 앞에서 부터 채워나가는 정렬 알고리즘
	 * 전체 탐색 횟수 : 
	 * */
	private static void selectionSort(int n, int[] arr, String string) {
		int searchCnt = 0;
		arr = new int[] {4,1,5,3,2};
		/*
		 * index 0 1 2 3 4
		 * value 5 2 3 4 1
		 * n = 5
		 * n - 1 = 4
		 * */
		
		for(int i = 0; i < n-1; i++) {
			int min = arr[i];
			int index = i;
			
			for(int j = i+1; j < n; j++) {
				if(min > arr[j]) {
					System.out.println(i + ", " + j);
					index = j;
					min = arr[j];
				}
				searchCnt++;
			}
			System.out.println(Arrays.toString(arr));
			arr[index] = arr[i];
			arr[i] = min;
		}
		
		print("selectionSort", arr, searchCnt);
	}
	
	/**
	 * mySort (선택정렬과 유사)
	 * 설명 : 배열의 0번째 인덱스부터 최소값을 찾아 넣어 오름차순으로 정렬하는 알고리즘
	 * 전체 탐색 횟수 : 10회
	 * */
	private static void mySort(int n, int[] arr, String orderBy) {
		int searchCnt = 0;
		
		for(int i = 0; i < n-1; i++) {
			for(int j = i+1; j < n; j++) {
				swap(arr, i, j, orderBy);
				searchCnt++;
			}
		}
		print("mySort", arr, searchCnt);
	}
	
	/**
	 * <pre>
	 * 설명 : 오름차순, 내림차순 구분해서 배열 위치 변경
	 * Parameter : arr[정렬할 배열], 
	 *             i[비교할 수 중 낮은인덱스], 
	 *             j[비교할 수 중 높은인덱스], 
	 *             type[오름차순(ASC)/내림차순(DESC)]
	 * </pre>
	 * */
	public static void swap(int[] arr, int i, int j, String type) {
		if("ASC".equals(type)) {
			if(arr[i] > arr[j]) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}else {
			if(arr[i] < arr[j]) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}
	
	/**
	 * 설명 : 메서드명, 배열, 연산횟수를 매개변수로 받아 출력한다.
	 * */
	public static void print(String name, int[] arr, int cnt) {
		/*
		System.out.println("=============== " + name + " Result ===============");
		System.out.println(Arrays.toString(arr));
		System.out.println("탐색횟수 : " + cnt);
		*/
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
