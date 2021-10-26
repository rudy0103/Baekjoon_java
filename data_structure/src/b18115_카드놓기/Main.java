package b18115_카드놓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Stack<String> stack = new Stack<>();
		LinkedList<Integer> list = new LinkedList<>();

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++)
			stack.add(st.nextToken());

		int cnt = 0;
		String s = null;
		while (!stack.isEmpty()) {
			s = stack.pop();
			if (s.equals("1")) {
				list.addFirst(++cnt);
			} else if (s.equals("2")) {
				list.add(1, ++cnt);
			} else {
				list.addLast(++cnt);
			}
		}

		for (int n : list)
			sb.append(n + " ");
		System.out.println(sb.toString());

	}
}
