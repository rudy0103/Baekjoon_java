package b1305_광고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L=Integer.parseInt(br.readLine());
		String pattern=br.readLine();
		
		int[] table = new int[pattern.length()];

		for (int i = 1, j = 0; i < pattern.length(); i++) {
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = table[j - 1];
			}
			if (pattern.charAt(i) == pattern.charAt(j))
				table[i] = ++j;
		}
		System.out.println(pattern.length()-table[L-1]);
	}}
