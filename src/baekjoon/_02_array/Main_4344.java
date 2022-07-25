package baekjoon._02_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4344 {
	public static void main(String[] args) {
		/*
		 * 문제
		 * 대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 
		 * 당신은 그들에게 슬픈 진실을 알려줘야 한다.
		 * 입력
		 * 첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
		 * 둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고, 이어서 N명의 점수가 주어진다. 
		 * 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
		 * 출력
		 * 각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.
		 * 예
		 * 5
		 * 5 50 50 70 80 100
		 * 7 100 95 90 80 70 60 50
		 * 3 70 90 80
		 * 3 70 90 81
		 * 9 100 99 98 97 96 95 94 93 91
		 * */
		
		printStudentsRate();
	}
	
	public static void printStudentsRate() {
		//1.입력받을 변수 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 0; //테스트 케이스 개수
		
		try {
			N = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(int k = 0; k < N; k++) {
			String inputData = null;
			try {
				inputData = br.readLine(); //테스트 케이스 문자열 입력
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
			String[] inputDataArr = inputData.split(" "); //입력된 문자열을 배열로 치환  입력 문자열 예) 5 50 50 70 80 100 
			int studentCnt = Integer.parseInt(inputDataArr[0]); //학생 수
			int[] studentScore = new int [studentCnt]; //각각의 학생이 받은 점수 (학생수만큼 점수가 있음)
			
			int sum = 0; // 학생들 점수 총합
			double everage = 0; // 학생들 점수 평균
			
			for(int i = 0; i < studentScore.length; i++) {
				studentScore[i] = Integer.parseInt(inputDataArr[i+1]); //(i+1)하는 이유는 배열의 1번 index부터 학생들 점수가 나오기 때문
				sum += studentScore[i]; // 총점
			}
			
			everage = sum / studentCnt; // 전체 점수의 평균
			
			int upEverageStudent = 0; //평균을 넘은 학생 수
			
			for(int i = 0; i < studentScore.length; i++) {
				if(studentScore[i] > everage) {
					upEverageStudent++;
				}
			}
			
			double result = ((double)upEverageStudent / (double)studentCnt) * 100; //평균을 넘는 학생들의 비율
			System.out.println(String.format("%.3f", result) + "%"); // 평균을 넘는 학생의 비율 출력
		}
	}
}
