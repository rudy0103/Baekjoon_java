package b17413_단어뒤집기2;

import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] inp = sc.nextLine().split(" ");
		StringBuilder sb = new StringBuilder();
		boolean isTrue = false;

		Stack<Character> st = new Stack();

		for (int l = 0; l < inp.length; l++) {
			for (int i = 0; i < inp[l].length(); i++) {

				if (inp[l].charAt(i) == '<') {
					isTrue = true;
					while (!st.isEmpty()) {
						sb.append(st.pop());
					}
				} else if (inp[l].charAt(i) == '>') {
					isTrue = false;

					while (!st.isEmpty()) {
						sb.append(st.pop());
					}
				}

				if (isTrue || inp[l].charAt(i) == '>')
					sb.append(inp[l].charAt(i));
				else {
					st.add(inp[l].charAt(i));
				}

			}
			while (!st.isEmpty()) {
				sb.append(st.pop());
			}
			sb.append(" ");
		}

		System.out.println(sb.toString());

	}

}
