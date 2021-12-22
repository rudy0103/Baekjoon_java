package b1701_Cubeditor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String pattern = br.readLine();
		int L = pattern.length();

		int[] table = new int[pattern.length()];

		if (L == 1) {
			System.out.println(0);
			return;
		}
		int idx=1;
		int max = 0;
		for (int k = L - 1; k >= 0; k--) {
			Arrays.fill(table, idx-1);
			for (int i = idx, j = idx-1; i < pattern.length(); i++) {
				while (j > idx-1 && pattern.charAt(i) != pattern.charAt(j)) {
					j = table[j - 1];
				}
				if (pattern.charAt(i) == pattern.charAt(j))
					table[i] = ++j;
			}
			for (int i = idx; i < table.length; i++) {
				max = Math.max(max, table[i]-idx+1);
			}
			idx++;
		}

		System.out.println(max);

	}
}