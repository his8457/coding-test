package baekjoon._03_basic_math1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_10757 {
	public static void main(String[] args) throws Exception {
		/*
		 * 문제
		 * 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
		 * 
		 * 입력
		 * 첫째 줄에 A와 B가 주어진다. (0 < A,B < 1010000)
		 * 
		 * 출력
		 * 첫째 줄에 A+B를 출력한다.
		 * 
		 * 예제 입력 1 
		 * 9223372036854775807 9223372036854775808
		 * 
		 * 예제 출력 1 
		 * 18446744073709551615
		 * */
		
		/**
		 * 이해한 내용
		 * 주어진 두 수는 JAVA에서 표현 가능한 최대 정수의 범위를 벗어남 
		 * (Long의 표현범위 : -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807)
		 * 
		 * 따라서 각 자리의 숫자를 별도로 더한 후, 결과를 문자열로 표현해야 함.
		 * */
		
		printResultSum();
	}
	
	private static void printResultSum() throws Exception {
		//1.두 정수 A, B를 입력 받음.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//2.입력받을 변수 및 결과를 출력할 변수 선언
		String[] inputNums = br.readLine().split(" ");
		String A = inputNums[0]; //숫자 A
		String B = inputNums[1]; //숫자 B
		StringBuffer sum = new StringBuffer();
		
		//3.두 수의 길이를 확인하고 길이가 서로 다를 경우 큰 수에 맞춰 작은수의 앞자리에 0을 붙여준다.
		//  두 수의 각 자리의 합을 더하는 작업을 할 것이므로 자리수를 맞춰줘야 함.
		if(A.length() > B.length()) {
			B = addZeroString(B, A.length() - B.length());
		}else if(B.length() > A.length()) {
			A = addZeroString(A, B.length() - A.length());
		}
		
		//4.문자열의 가장 끝의 숫자부터 A, B값을 더하고 10보다 크다면 다음자리의 수에 1을 더한다.
		for(int i = A.length()-1; i >= 0; i--) {
			char aNum = A.charAt(i);
			char bNum = B.charAt(i);
			
			if(A.length() == 1) {//문자열 전체 길이가 한자리일 경우 예) A:5 , B:7
				sum.append(sumCharacters(aNum, bNum));
				break;
			}
			
			if(i == A.length()-1) {//1의자리 덧셈인 경우
				sum.append(sumCharacters(aNum, bNum) % 10);//1의 자리수에 들어갈 값
			}else if(i == 0) {//최고자리 덧셈인 경우
				if(sumCharacters(A.charAt(i+1), B.charAt(i+1)) >= 10) {
					sum.append(sumCharacters(aNum, bNum)+1);//1의 자리수에 들어갈 값
				}else {
					sum.append(sumCharacters(aNum, bNum));//1의 자리수에 들어갈 값
				}
			}else {
				if(sumCharacters(A.charAt(i+1), B.charAt(i+1)) >= 10) {
					sum.append((sumCharacters(aNum, bNum)+1) % 10);//1의 자리수에 들어갈 값
				}else {
					sum.append(sumCharacters(aNum, bNum) % 10);//1의 자리수에 들어갈 값
				}
			}
		}
		
		if(A.length() > 1) {//숫자의 전체 길이가 10의 자리 수 이상일 경우만 문자를 reverse함.
			sum = sum.reverse();
		}
		bw.append(sum);
		bw.flush();
		
		br.close();
		bw.close();
	}
	
	/**
	 * 파라미터 : String number, int count
	 * 설명 : 파라미터로 넘어온 number의 앞자리에 count 만큼 문자열 "0"을 붙인다. ex) number : 1234, count : 4 -> 00001234 를 return한다.
	 * */
	private static String addZeroString(String number, int count) {
		StringBuffer zeroNum = new StringBuffer();
		
		for(int i = 0; i < count; i++) {
			zeroNum.append("0");
		}
		
		return zeroNum + number;
	}
	
	private static int sumCharacters(char a, char b) {
		return (a - '0') + (b - '0');
	}
}
