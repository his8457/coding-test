package baekjoon._11_recursive;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2447 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//
		/*
		 * 문제
			재귀적인 패턴으로 별을 찍어 보자. N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양이다.
			크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.
			
			***
			* *
			***
			N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다. 예를 들어 크기 27의 패턴은 예제 출력 1과 같다.
			
			입력
			첫째 줄에 N이 주어진다. N은 3의 거듭제곱이다. 즉 어떤 정수 k에 대해 N=3k이며, 이때 1 ≤ k < 8이다.
			
			출력
			첫째 줄부터 N번째 줄까지 별을 출력한다.
			
			예제 입력 1 
			27
			예제 출력 1 
			***************************
			* ** ** ** ** ** ** ** ** *
			***************************
			***   ******   ******   ***
			* *   * ** *   * ** *   * *
			***   ******   ******   ***
			***************************
			* ** ** ** ** ** ** ** ** *
			***************************
			*********         *********
			* ** ** *         * ** ** *
			*********         *********
			***   ***         ***   ***
			* *   * *         * *   * *
			***   ***         ***   ***
			*********         *********
			* ** ** *         * ** ** *
			*********         *********
			***************************
			* ** ** ** ** ** ** ** ** *
			***************************
			***   ******   ******   ***
			* *   * ** *   * ** *   * *
			***   ******   ******   ***
			***************************
			* ** ** ** ** ** ** ** ** *
			***************************
		 * */
		
	        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        int N = Integer.parseInt(bf.readLine());
	        char[][] arr = new char[N][N];
	        
	        for (int i = 0; i < arr.length; i++) {
	            for (int j = 0; j < arr[i].length; j++) {
	                arr[i][j] = ' ';
	            }
	        }
	        
	        star(arr, 0, 0, N);

	        for (char[] chars : arr) {
	            for (char c : chars) {
	                bw.write(c);
	            }
	            bw.write("\n");
	        }
	        bw.flush();
	        bw.close();
	    }

	    public static void star(char[][] arr, int x, int y, int N) {
	        if (N == 1) {
	            arr[x][y] = '*';
	            return; // 종료
	        }

	        for (int i = 0; i < 3; i++) {
	            for (int j = 0; j < 3; j++) {
	                if (!(i == 1 && j == 1)) {
	                    star(arr, x + i * (N / 3), y + j * (N / 3), N / 3);
	                }
	            }
	        }
	    }
}
