package baekjoon._03_basic_math1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2869 {

	public static void main (String[] args) throws Exception {
		/*문제
		 * 땅 위에 달팽이가 있다. 
		 * 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
		 * 달팽이는 낮에 A미터 올라갈 수 있다. 
		 * 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 
		 * 또, 정상에 올라간 후에는 미끄러지지 않는다.
		 * 달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.
		 * 입력
		 * 첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. 
		 * (1 ≤ B < A ≤ V ≤ 1,000,000,000)
		 * 
		 * 출력
		 * 첫째 줄에 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력한다.
		 * 예제 입력 1 
		 * 2 1 5
		 * 예제 출력 1 
		 * 4
		 * 예제 입력 2 
		 * 5 1 6
		 * 예제 출력 2 
		 * 2
		 * 예제 입력 3 
		 * 100 99 1000000000
		 * 예제 출력 3 
		 * 999999901
		 */
		
		/**
		 * 문제 이해
		 * 길이가 V미터인 나무를 오를때 낮에는 A미터 오르고 밤에는 B미터 미끄러짐
		 * A(올라간거리), B(내려간거리), V(나무길이) 
		 * 매일 올라간 직후, 나무의 최대 길이와 비교하고 도착한 날이 며칠째인지 확인한다.
		 * 며칠째에 정상에 도달했는지 출력 
		 * */
		
		printArriveDays();
	}

	private static void printArriveDays() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputNums = br.readLine().split(" ");
		int A = Integer.parseInt(inputNums[0]); //하루에 올라간거리
		int B = Integer.parseInt(inputNums[1]); //하루에 미끄러진거리
		int V = Integer.parseInt(inputNums[2]); //나무의 길이
		
		int howManyDays = (V - A) / (A - B); //무조건 걸리는 기간
		
		if((howManyDays * (A - B)) + A >= V) {
			howManyDays = howManyDays + 1;
		}else {
			howManyDays = howManyDays + 2;
		}
		
		bw.append(howManyDays + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
