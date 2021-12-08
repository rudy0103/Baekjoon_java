package b16171_나는친구가적다small;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String keyWord = sc.next();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9')
				continue;
			sb.append(str.charAt(i));
		}

		if (kmp(sb.toString(), keyWord)) {
			System.out.println(1);
		} else
			System.out.println(0);
	}

	private static boolean kmp(String text, String pattern) {
		// 찾으면 true

		// 부분 일치 테이블 배열 만들기
		// t가 본문 p가 찾고자 하는 문자열
		int[] table = makeTable(pattern);

		for (int i = 0, j = 0; i < text.length(); i++) {
			while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
				j = table[j - 1];
			}

			if (text.charAt(i) == pattern.charAt(j)) {
				if (j == pattern.length() - 1) {
					return true;
				} else {
					j++;
				}
			}
		}

		// 못찾으면 false
		return false;
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
