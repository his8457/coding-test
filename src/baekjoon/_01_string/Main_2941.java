package baekjoon._01_string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2941 {
	public static void main(String[] args) {
		/* 예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다. 따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.
		 * 크로아티아 알파벳	변경
		 * č	c=
		 * ć	c-
		 * dž	dz=
		 * đ	d-
		 * lj	lj
		 * nj	nj
		 * š	s=
		 * ž	z=
		 * 예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다. 
		 * 단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
		 * dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다. 
		 * lj와 nj도 마찬가지이다. 위 목록에 없는 알파벳은 한 글자씩 센다.
		 * 입력
		 * 첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.
		 * 단어는 크로아티아 알파벳으로 이루어져 있다. 문제 설명의 표에 나와있는 알파벳은 변경된 형태로 입력된다.
		 * 출력
		 * 입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
		 */
		
		printCharacterCnt();
	}
	
	public static void printCharacterCnt() {
		
		//1.입력 받을 변수 및 출력할 변수 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer input = new StringBuffer();
		
		try {
			input.append(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//2.크로아티아 알파벳 선언
		String[] croatiaCharacter = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		
		//3.입력된 문자에서 크로아티아 알파벳 검색
		for(int i = 0; i < croatiaCharacter.length; i++) {
			while(input.indexOf(croatiaCharacter[i]) > -1) {
				//입력된 문자열을 앞에서부터 검색 후 크로아티아 알파벳이 있으면 결과 변수의 count를 1증가 시키고 해당 알파벳을 *로 치환한다.
				//동일한 알파벳이 여러개 있을 경우 앞에서 부터 하나씩 치환됨
				int startIndex = input.indexOf((croatiaCharacter[i]));
				input = input.replace(startIndex, startIndex+(croatiaCharacter[i].length()), "*");
			}
		}
		
		//4.알파벳 개수를 구한다.
		System.out.println(input.length());
	}
}
