package baekjoon._01_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1316 {
	public static void main(String[] args) {
		/*
		 * 문제
		 * 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 
		 * 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, 
		 * aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
		 * 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
		 * 입력
		 * 첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 
		 * 둘째 줄부터 N개의 줄에 단어가 들어온다. 
		 * 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.
		 * 출력
		 * 첫째 줄에 그룹 단어의 개수를 출력한다.
		 * */
		
		printGroupWordsCount();
	}
	
	/* 기능 설명 : N개의 단어를 입력받고 그룹단어 여부를 검사 후, 그룹단어어 해당하는 단어의 개수를 출력한다. */
	public static void printGroupWordsCount() {
		//1.입력받을 변수를 선언한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 0;
		
		try {
			N = Integer.parseInt(br.readLine()); //첫째 줄에 입력된 단어의 개수 N
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//2.그룹 단어로 확인된 단어의 개수를 저장할 변수 (result)
		int groupWordsCount = 0;
		
		//3.문자열이 그룹 단어인지 검사하고, 그룹단어라면 그룹단어 개수를 1증가시킨다.
		for(int i = 0; i < N; i++) {
			try {
				if(isGroupWord(br.readLine())) groupWordsCount++;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(groupWordsCount);
	}
	
	/* 기능 설명 : 그룹단어 여부를 검사하고 맞으면 true, 아니면 false를 return 한다.*/
	public static boolean isGroupWord(String word) {
		boolean result = true;
		/* 그룹단어의 조건 문자열의 앞에서 확인된 문자가 연속되는 것은 상관없으나, 
		 * 연속되는 부분이 중단된 이후 동일한 문자가 다시 등장하면 그룹단어가 아님 */
		
		String firstIndexCharacter = "";
		
		while(word.length() > 0) {
			firstIndexCharacter = word.substring(0, 1);//단어의 첫번째 문자를 뽑음
			
			/* 1. 뽑아낸 문자와 동일한 문자의 마지막 index를 찾는다. 
			 *    만일, 마지막 index가 0이라면 뽑은 문자가 하나뿐인 것이므로
			 *    공백으로 치환 후, 다음 문자를 검색한다. */
			
			int lastIndex = word.lastIndexOf(firstIndexCharacter);
			if(lastIndex == 0) {
				word = word.replaceAll(firstIndexCharacter, ""); //찾은 문자를 공백으로 치환한다.
				continue;
			}else {
				//2. 뽑아낸 문자와 동일한 문자가 있는 마지막 index 문자 사이에 뽑아낸 문자와 다른 문자가 포함되어 있다면 그룹 단어가 아님
				for(int i = 1; i <= lastIndex; i++) {
					if(!firstIndexCharacter.equals(word.substring(i, i+1))) {
						result = false;
					}
				}
				word = word.replaceAll(firstIndexCharacter, ""); //찾은 문자를 공백으로 치환한다.
			}
		}
		
		return result;
	}
}