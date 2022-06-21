package b23797_개구리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inp = br.readLine();
		int len = inp.length();

		int[] cnt = new int[2];

		for (int i = 0; i < len; i++) {
			if (inp.charAt(i) == 'K') {
				if (cnt[1] > 0)
					cnt[1]--;
				cnt[0]++;
			} else {
				if (cnt[0] > 0)
					cnt[0]--;
				cnt[1]++;
			}
		}
		System.out.println(cnt[0] + cnt[1]);
	}
}
