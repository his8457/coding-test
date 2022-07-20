package baekjoon._01_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1152 {
	public static void main(String[] args) {
		//영어 대소문자와 공백으로 이루어진 문자열이 주어진다.
		//이 문자열에는 몇개의 단어가 있을까?
		//주어진 문자열은 공백으로 시작하거나 끝날 수 있다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str ="";
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(countWord(str));
		
	}
	
	public static int countWord(String str) {
		//0.결과를 담을 변수를 선언한다.
		int result = 0;
		int startIndex = 0; //문자가 시작되는 인덱스
		int endIndex = 0; //문자가 조요되는 인덱스

		//0.1 입력값을 validation 한다.
		if(str == null) {
			return 0;
		}else if(str.length() == 0){
			return 0;
		}else {//전체가 공백만 있는 문자열일 경우
			String temp = str.replaceAll(" ", ""); //모든 공백 제거
			if(temp.length() == 0) {
				return 0;
			}
		}
		
		//1.문자열의 앞뒤에 공백을 삭제 한다.
		//1-1. 문자열의 시작부분에 존재하는 공백은 무시하고 첫 문자가 시작하는 Index를 찾는다.
		for(int i = 0; i < str.length(); i++) {
			//문자열의 앞에서 부터 검색해서 공백이 아닌 문자가 시작하는 index를 찾는다.
			if(str.charAt(i) != ' ') {
				startIndex = i;
				break;
			}
		}
		
		//1-2. 문자열의 끝부분에 존재하는 공백은 무시하고 가장 마지막에 문자로 끝나는 Index를 찾는다.
		for(int i = str.length()-1; i > 0; i--) {
			//문자열의 앞에서 부터 검색해서 공백이 아닌 문자가 시작하는 index를 찾는다.
			if(str.charAt(i) != ' ') {
				endIndex = i;
				break;
			}
		}
		
		//2. 앞뒤 공백이 제거된 문자열을 다시 담는다.
		String trimStr = str.substring(startIndex, endIndex+1);
		//3. 문자와 문자 사이에 존재하는 공백의 개수를 파악하고 +1 한다.
		for(int i = 0; i < trimStr.length(); i++) {
			if(trimStr.charAt(i) == ' ') {
				result++;
			}
		}
		
		result++;
		
		return result;
	}
}