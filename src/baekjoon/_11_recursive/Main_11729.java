package baekjoon._11_recursive;

import java.util.Scanner;

public class Main_11729 {
	public static void main(String[] args) {
		// [백준] 11729 하노이 탑 이동 순서
		/*
		 *	세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다. 
		 *  각 원판은 반경이 큰 순서대로 쌓여있다. 이제 수도승들이 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 한다.
			한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
			쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
			이 작업을 수행하는데 필요한 이동 순서를 출력하는 프로그램을 작성하라. 
			단, 이동 횟수는 최소가 되어야 한다.
			아래 그림은 원판이 5개인 경우의 예시이다.
			
			입력
			첫째 줄에 첫 번째 장대에 쌓인 원판의 개수 N (1 ≤ N ≤ 20)이 주어진다.
			
			출력
			첫째 줄에 옮긴 횟수 K를 출력한다.
			두 번째 줄부터 수행 과정을 출력한다. 두 번째 줄부터 K개의 줄에 걸쳐 두 정수 A B를 빈칸을 사이에 두고 출력하는데, 
			이는 A번째 탑의 가장 위에 있는 원판을 B번째 탑의 가장 위로 옮긴다는 뜻이다.
		 * 
		 * */
		solve();
	}

	static StringBuilder sb = new StringBuilder();
	static int count = 0;
	
	private static void solve() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		System.out.println("########## 최초 함수 Call");
		System.out.println("N : " + n + "  A : " + 1 + "  B : " + 2 + "  C : " + 3);
		System.out.println();
		Hanoi(n, 1, 2, 3, 0);

		System.out.println(count);
		System.out.println(sb);
	}
	
	static int number = 1;
	public static void Hanoi(int N, int A, int B, int C, int Q) {
		if (N == 0) {
			System.out.println("N : " + N + "  A : " + A + "  B : " + B + "  C : " + C);
			String t = (Q == 1) ? "첫번째 함수" : "두번째 함수";
			System.out.println(number++ + " : " + t + " Return");
			System.out.println();
			return;
		}
		else {
			count++;
			
			// A -> C로 옮긴다고 가정할 떄,
			// STEP 1 : N-1개를 A에서 B로 이동 (= start 지점의 N-1개의 원판을 mid 지점으로 옮긴다.)
			System.out.println("순번 " + number++ + " : 첫번째 함수 Call");
			System.out.print("N : " + N + "  A : " + A + "  B : " + B + "  C : " + C  + " ─────────────> ");
			System.out.println("N-1 : " + (N-1) + "  A : " + A + "  B : " + C + "  C : " + B);
			System.out.println();
			Hanoi(N - 1, A, C, B, 1);
			// STEP 2 : 1개를 A에서 C로 이동 (= start 지점의 N번째 원판을 to지점으로 옮긴다.)
			sb.append(A + " " + C + "\n");
	    
			// STEP 3 : N-1개를 B에서 C로 이동 (= mid 지점의 N-1개의 원판을 to 지점으로 옮긴다.)
			System.out.println(number++ + " : 두번째 함수 Call");
			System.out.print("N : " + N + "  A : " + A + "  B : " + B + "  C : " + C  + " ─────────────> ");
			System.out.println("N-1 : " + (N-1) + "  A : " + B + "  B : " + A + "  C : " + C);
			System.out.println();
			Hanoi(N - 1, B, A, C, 2);
		}
	}
}
