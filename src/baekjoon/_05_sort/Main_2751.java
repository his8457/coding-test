package baekjoon._05_sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2751 {
	public static void main(String[] args) throws Exception {
		// [백준] 정렬 [S5] 2751 수 정렬하기2#42
		/*
		 * 문제
		 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
		 * 
		 * 입력
		 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 
		 * 둘째 줄부터 N개의 줄에는 수가 주어진다. 
		 * 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 
		 * 수는 중복되지 않는다.
		 * 출력
		 * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

		 * 예제 입력 1 
		 * 5
		 * 5
		 * 4
		 * 3
		 * 2
		 * 1
		 * 예제 출력 1 
		 * 1
		 * 2
		 * 3
		 * 4
		 * 5
		 * */
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int inputCount  = Integer.parseInt(br.readLine());
		
		int[] arr = new int[inputCount];
		
		for(int i = 0; i < inputCount; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		*/
		//int[] arr = {1,5,3,7,2,4,10,8,6,9};
		
		//solve(); //1. Arrays.sort() -> 시간초과      시간복잡도 : ??
		//bubbleSort(arr);  //2.Bubble 정렬 -> 시간초과  시간복잡도 : O(n^2)
		//simpleSelectSort(arr); //3.단순선택정렬 -> 시간초과  시간복잡도 : O(n^2)
		//simpleInsertSort(arr); //4.단순삽입정렬 -> 시간초과 시간복잡도 : O(n^2)
		//shellSort(arr); //5.셸 정렬 -> 맞음  시간복잡도 : O(n^1.25)
		//quickSort(arr, 0, arr.length-1); //6.퀵 정렬 -> 시간초과  시간복잡도 : O(nlogn) -> 최고 나쁠경우 O(n^2)
		
		countingSort();
		
		//printResult(arr);
		
	}
	
	// 
	private static void countingSort() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        
		boolean[] arr = new boolean[2000001];	
        
		int N = Integer.parseInt(br.readLine());
        
		for(int i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine()) + 1000000] = true;
		}
 
		for(int i = 0; i < arr.length; i++) {
			if(arr[i]) {
				sb.append((i - 1000000)).append('\n');
			}
		}
		System.out.print(sb);
	}
	
	//6.퀵 정렬
	private static void quickSort(int[] arr, int left, int right) {
		int n = arr.length;
		
		int pl = left; //왼쪽 시작인덱스
		int pr = right; //오른쪽 시작인덱스
		int x = arr[(pl + pr) / 2]; //pivot 
		
		do {
			while(arr[pl] < x)pl++;
			while(arr[pr] > x)pr--;
			if(pl <= pr) {
				int idx1 = pl++;
				int idx2 = pr--;
				int t = arr[idx1];
				arr[idx1] = arr[idx2];
				arr[idx2] = t;
			}
		}while (pl <= pr);
		
		if(left < pr) {
			quickSort(arr, left, pr);
		}
		
		if(pl < right) {
			quickSort(arr, pl, right);
		}
	}

	//5.셀 정렬
	private static void shellSort(int[] arr) {
		int n = arr.length;
		
		for(int h = n / 2; h > 0; h /= 2) {
			for(int i = h; i < n; i++) {
				int j;
				int tmp = arr[i];
				for(j = i - h; j >= 0 && arr[j] > tmp; j -= h) {
					arr[j+h] = arr[j];
				}
				arr[j+h] = tmp;
			}
		}
	}

	//4.단순삽입정렬
	private static void simpleInsertSort(int[] arr) {
		//2번째 인덱스부터 앞쪽 인덱스에 비교한 후, 적합한 인덱스에 삽입한다.
		for(int i = 1; i < arr.length; i++) {
			int index = 0;
			
			for(int j = i-1; j >= 0; j--) {
				if(arr[i] > arr[j]) {
					index = j+1;
					break;
				}
			}
			
			int tempValue = arr[i];
			int tempIndex = i;
			//index 위치에 arr[i] 가 들어가야 함.    i자리 까지 i-n의 값이 밀려와야 함.
			for(int k = 0; k < i-index; k++) {
				arr[tempIndex] = arr[tempIndex-1];
				tempIndex--;
			}
			
			arr[index] = tempValue;
		}
	}
	
	//3.단순선택정렬
	private static void simpleSelectSort(int[] arr) {
		for(int i = 0; i < arr.length-1; i++) {
			//최소값을 찾는다.
			int minIndex = i;
			int minValue = arr[i];
			
			for(int j = i; j < arr.length; j++) {
				if(minValue > arr[j]) {
					minValue = arr[j];
					minIndex = j;
				}
			}
			
			int tempValue = arr[i];
			arr[i] = minValue;
			arr[minIndex] = tempValue;
		}
	}
	
	//2.버블정렬
	private static void bubbleSort(int[] arr) {
		for(int i = arr.length-1; i > 0; i--) {
			for(int j = i-1; j >= 0; j--) {
				//내림차순 정렬
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	//1.Arrays.sort(); 
	private static void solve(int[] arr) {
		Arrays.sort(arr);
	}
	
	// ★★★출력★★★
	private static void printResult(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for(int a : arr) {
			sb.append(a + "\n");
		}
		System.out.println(sb);
	}
}
