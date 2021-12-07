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

	private static boolean kmp(String t, String p) {
		// 찾으면 true

		// 부분 일치 테이블 배열 만들기
		//t가 본문 p가 찾고자 하는 문자열
		int[] pi = new int[p.length()];
		int tLen = t.length();
		int pLen = p.length();
		for (int i = 1, j = 0; i < pLen; i++) {
			while (j > 0 && p.charAt(i) != p.charAt(j)) {
				j = pi[j - 1];
			}
			if (p.charAt(i) == p.charAt(j))
				pi[i] = ++j;
		}

		for (int i = 0, j = 0; i < tLen; i++) {
			if (t.charAt(i) == p.charAt(j)) {
				j++;
				if (j == pLen) {
					j = pi[j - 1];
					return true;
				}
			} else {
				while (j - 1 >= 0) {
					j = pi[j - 1];
					if (t.charAt(i) == p.charAt(j)) {
						j++;
						break;
					}
				}
			}
		}

		// 못찾으면 false
		return false;
	}

}
