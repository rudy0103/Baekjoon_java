package b1701_Cubeditor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int max = 0;
	static int table[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String pattern = br.readLine();
		int L = pattern.length();

		table = new int[pattern.length()];

		if (L == 1) {
			System.out.println(0);
			return;
		}
		for (int i = 0; i < L; i++) {
			kmp(pattern.substring(i, L));
		}

		System.out.println(max);

	}

	private static void kmp(String pattern) {

		Arrays.fill(table, 0);
		for (int i = 1, j = 0; i < pattern.length(); i++) {
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = table[j - 1];
			}
			if (pattern.charAt(i) == pattern.charAt(j))
				table[i] = ++j;
		}
		for (int i = 0; i < pattern.length(); i++) {
			max = Math.max(max, table[i]);
		}
	}
}