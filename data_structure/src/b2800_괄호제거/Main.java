package b2800_괄호제거;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	static boolean[] selected;
	static LinkedList<int[]> index;
	static StringBuilder sb = new StringBuilder();
	static HashSet<String> hSet = new HashSet<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inp = sc.next();
		Stack<Integer> stack = new Stack<>();
		index = new LinkedList<>();
		for (int i = 0; i < inp.length(); i++) {
			if (inp.charAt(i) == '(') {
				stack.add(i);
			} else if (inp.charAt(i) == ')') {
				int tmp = stack.pop();
				index.add(new int[] { tmp, i });
			}
		}

		selected = new boolean[inp.length()];
		remove(0, index.size(), inp);

		LinkedList<String> list = new LinkedList<>(hSet);
		Collections.sort(list);
		for (String s : list)
			sb.append(s);

		System.out.println(sb.toString());
	}

	private static void remove(int d, int maxDepth, String str) {
		if (d == maxDepth) {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < str.length(); i++) {
				if (selected[i] == true)
					continue;
				else
					sb.append(str.charAt(i));
			}
			sb.append("\n");

			if (sb.toString().length() - 1 != str.length())
				hSet.add(sb.toString());
			return;
		}

		selected[index.get(d)[0]] = true;
		selected[index.get(d)[1]] = true;
		remove(d + 1, maxDepth, str);
		selected[index.get(d)[0]] = false;
		selected[index.get(d)[1]] = false;
		remove(d + 1, maxDepth, str);
	}

}
