package b2011_암호코드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inp = br.readLine();

		boolean flag = false;

		if (inp.charAt(0) == '0') {
			flag = true;
		}

		int m = 1000000;
		int len = inp.length();
		int[][] dp = new int[len + 10][2];
		dp[0][0] = 1;
		dp[1][0] = 1;

		for (int i = 2; i <= len; i++) {
			if (inp.charAt(i - 1) == '0') {
				if (inp.charAt(i - 2) > '2' || inp.charAt(i - 2) == '0') {
					flag = true;
					break;
				}
				dp[i][0] = dp[i - 2][0];
				dp[i][1] = dp[i - 2][1];

			} else {

				dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % m;
				if (inp.charAt(i - 2) == '0')
					continue;
				if (isPossible(i - 2, i - 1, inp)) {
					dp[i][1] = dp[i - 1][0];
				}
			}

		}

		if (flag) {
			System.out.println("0");
		} else {
			System.out.println((dp[len][0] + dp[len][1]) % m);
		}
	}

	private static boolean isPossible(int i, int j, String inp) {

		int a = inp.charAt(i) - '0';
		int b = inp.charAt(j) - '0';
		int n = a * 10 + b;

		if (n <= 26)
			return true;

		return false;
	}

}
