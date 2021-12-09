package b4354_문자열제곱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String s = "";

		while (true) {
			s = br.readLine();
			if (s.equals("."))
				break;
			if (s.equals(""))
				sb.append("0\n");
			else
				sb.append(kmp(s)).append("\n");
		}
		System.out.println(sb.toString());

	}

	private static int kmp(String s) {

		int[] table = makeTable(s);
		int cnt = 0;
		int maxNum = 0;
		int idx = -1;
		for (int i = 0; i < table.length; i++) {
			if (table[i] == 0) {
				cnt++;
			} else if (table[i] == 1) {
				idx = i;
			}
			if (table[i] > maxNum)
				maxNum = table[i];
		}
		if (cnt == 1)
			return maxNum + 1;
		else if (cnt >= 2) {
			int len = idx;
			if (len == -1)
				return 1;
			if (s.length() % len == 0 && table[s.length() - 1] != 0) {
				return s.length() / len;
			} else
				return 1;
		}else return 1;

	}

	private static int[] makeTable(String pattern) {
		int[] table = new int[pattern.length()];

		for (int i = 1, j = 0; i < pattern.length(); i++) {
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = table[j - 1];
			}
			if (pattern.charAt(i) == pattern.charAt(j))
				table[i] = ++j;
		}

		return table;
	}

}
