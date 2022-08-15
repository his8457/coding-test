package baekjoon._09_stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10828 {
	public static void main(String[] args) throws Exception {
		// [백준] 10828 stack-스택
		/*
		 * 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
		 * 명령은 총 다섯 가지이다.
		 * push X: 정수 X를 스택에 넣는 연산이다.
		 * pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		 * size: 스택에 들어있는 정수의 개수를 출력한다.
		 * empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
		 * top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		 * 
		 * 입력
		 * 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 
		 * 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 
		 * 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 
		 * 문제에 나와있지 않은 명령이 주어지는 경우는 없다.
		 * 
		 * 출력
		 * 출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
		 * 
		 * 예제 입력 1 
		 * 14
		 * push 1
		 * push 2
		 * top
		 * size
		 * empty
		 * pop
		 * pop
		 * pop
		 * size
		 * empty
		 * pop
		 * push 3
		 * empty
		 * top
		 * 
		 * 예제 출력 1 
		 * 2
		 * 2
		 * 0
		 * 2
		 * 1
		 * -1
		 * 0
		 * 1
		 * -1
		 * 0
		 * 3
		 * */
		
		solve();
	}
	public static StringBuilder sb = new StringBuilder();
	
	private static void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int inputCount = Integer.parseInt(br.readLine());
		String[] inputCommandArr = new String[inputCount];
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < inputCount; i++) {
			inputCommandArr[i] = br.readLine();
		}
		
		for(int i = 0; i < inputCommandArr.length; i++) {
			String command = inputCommandArr[i];
			if(command.contains(" ")) {//push
				push(stack, command);
			}else if("pop".equals(command)) {
				pop(stack);
			}else if("size".equals(command)) {
				sb.append(stack.size() + "\n");
			}else if("empty".equals(command)) {
				empty(stack);
			}else if("top".equals(command)) {
				top(stack);
			}
		}
		
		System.out.println(sb);
	}

	private static void top(Stack<Integer> stack) {
		if(stack.size() == 0) {
			sb.append(-1 + "\n");
		}else {
			int num = stack.pop();
			sb.append(num + "\n");
			stack.push(num);
		}
	}

	private static void empty(Stack<Integer> stack) {
		if(stack.empty()) {
			sb.append(1 + "\n");
		}else {
			sb.append(0 + "\n");
		}
	}

	private static void pop(Stack<Integer> stack) {
		if(stack.size() == 0) {
			sb.append(-1 + "\n");
		}else {
			sb.append(stack.pop() + "\n");
		}
	}

	private static void push(Stack<Integer> stack, String command) {
		stack.push(Integer.parseInt(command.split(" ")[1]));
	}
}
