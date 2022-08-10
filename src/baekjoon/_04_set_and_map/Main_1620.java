package baekjoon._04_set_and_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_1620 {
	public static void main(String[] args) throws IOException {
		//[백준] 집합과맵 [S4] 1620 나는야 포켓몬 마스터
		/*
		 * 입력
		 * 첫째 줄에는 도감에 수록되어 있는 포켓몬의 개수 N이랑 내가 맞춰야 하는 문제의 개수 M이 주어져. 
		 * N과 M은 1보다 크거나 같고, 100,000보다 작거나 같은 자연수인데, 자연수가 뭔지는 알지? 
		 * 모르면 물어봐도 괜찮아. 나는 언제든지 질문에 답해줄 준비가 되어있어.
		 * 둘째 줄부터 N개의 줄에 포켓몬의 번호가 1번인 포켓몬부터 N번에 해당하는 포켓몬까지 한 줄에 하나씩 입력으로 들어와. 
		 * 포켓몬의 이름은 모두 영어로만 이루어져있고, 또, 음... 첫 글자만 대문자이고, 나머지 문자는 소문자로만 이루어져 있어. 
		 * 아참! 일부 포켓몬은 마지막 문자만 대문자일 수도 있어. 
		 * 포켓몬 이름의 최대 길이는 20, 최소 길이는 2야. 
		 * 그 다음 줄부터 총 M개의 줄에 내가 맞춰야하는 문제가 입력으로 들어와. 
		 * 문제가 알파벳으로만 들어오면 포켓몬 번호를 말해야 하고, 숫자로만 들어오면, 포켓몬 번호에 해당하는 문자를 출력해야해. 
		 * 입력으로 들어오는 숫자는 반드시 1보다 크거나 같고, N보다 작거나 같고, 입력으로 들어오는 문자는 반드시 도감에 있는 포켓몬의 이름만 주어져. 그럼 화이팅!!!
		 * 
		 * 출력
		 * 첫째 줄부터 차례대로 M개의 줄에 각각의 문제에 대한 답을 말해줬으면 좋겠어!!!. 
		 * 입력으로 숫자가 들어왔다면 그 숫자에 해당하는 포켓몬의 이름을, 
		 * 문자가 들어왔으면 그 포켓몬의 이름에 해당하는 번호를 출력하면 돼. 그럼 땡큐~
		 * 
		 * 이게 오박사님이 나에게 새로 주시려고 하는 도감이야. 너무 가지고 싶다ㅠㅜ. 꼭 만점을 받아줬으면 좋겠어!! 파이팅!!!
		 * 
		 * 예제 입력 1 
		 * 26 5
		 * Bulbasaur
		 * Ivysaur
		 * Venusaur
		 * Charmander
		 * Charmeleon
		 * Charizard
		 * Squirtle
		 * Wartortle
		 * Blastoise
		 * Caterpie
		 * Metapod
		 * Butterfree
		 * Weedle
		 * Kakuna
		 * Beedrill
		 * Pidgey
		 * Pidgeotto
		 * Pidgeot
		 * Rattata
		 * Raticate
		 * Spearow
		 * Fearow
		 * Ekans
		 * Arbok
		 * Pikachu
		 * Raichu    <- 26개
		 * 25
		 * Raichu
		 * 3
		 * Pidgey
		 * Kakuna
		 * 
		 * 예제 출력 1 
		 * Pikachu
		 * 26
		 * Venusaur
		 * 16
		 * 14
		 * */
		
		solve();
	}

	private static void solve() throws IOException {
		//1. 입력받을 변수를 선언한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputNumbers = br.readLine();
		
		int N = Integer.parseInt(inputNumbers.split(" ")[0]); //포켓몬 리스트
		int M = Integer.parseInt(inputNumbers.split(" ")[1]); //문제 수
		
		//2. 몬소터의 번호로 검색할 수 있는 배열을 만든다. (배열의 인덱스는 몬스터의 번호, 배열의 값은 몬스터의 이름)
		String[] monsterNameList = new String[N+1];
		for(int i = 1; i <= N; i++) { monsterNameList[i] = br.readLine(); }
		
		//3. 몬스터의 이름으로 검색할 수 있는 배열을 만든다. (맵의 Key는 몬스터의 이름 value는 몬스터의 번호)
		Map<String, Integer> monsterNumberList = new HashMap<>();
		for(int i = 1; i < monsterNameList.length; i++) {
			monsterNumberList.put(monsterNameList[i], i);
		}
		
		//4. 문제를 담긴 배열을 만든다.
		String[] questions = new String[M];
		for(int i = 0; i < M; i++) {
			questions[i] = br.readLine();
		}
		
		//5. 문제에서 주어진 문자열이 숫자이면 배열에서 몬스터 이름을 찾아 출력하고, 
		//          주어진 문자열이 문자열이면 맵에서 몬스터 번호를 찾아 출력한다.
		for(int i = 0; i < questions.length; i++) {
			if(questions[i].charAt(0) - '0' < 10) { //숫자 -> 몬스터 번호 [i] 번째의 이름을 출력한다.
				System.out.println(monsterNameList[Integer.parseInt(questions[i])]);
			}else {//문자 -> Map에서 몬스터 이름(key)로 get하여 몬스터 번호를 출력한다.
				System.out.println(monsterNumberList.get(questions[i]));
			}
		}
	}
}
