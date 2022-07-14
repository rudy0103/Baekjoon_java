package b1918_후위표기식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder inp = new StringBuilder(br.readLine());

		if (inp.charAt(0) == '+')
			inp.deleteCharAt(0);

		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < inp.length(); i++) {
			char ch = inp.charAt(i);

			if (ch == '+' || ch == '-') {
				if (stack.isEmpty()) {
					stack.add(ch);
				} else {
					while (!stack.isEmpty() && stack.peek() != '(') {
						sb.append(stack.pop());
					}
					stack.add(ch);
				}
			} else if (ch == '*' || ch == '/') {
				while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
					sb.append(stack.pop());
				}
				stack.add(ch);
			} else if (ch == '(') {
				stack.add(ch);
			} else if (ch == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
			} else {
				sb.append(ch);
			}
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		System.out.println(sb.toString());
	}

}
