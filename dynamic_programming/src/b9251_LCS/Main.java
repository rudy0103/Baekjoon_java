package b9251_LCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmpA = br.readLine();
		String tmpB = br.readLine();
		int N=tmpA.length(), M=tmpB.length();
		char[] A, B;
		A = new char[N + 1];
		B = new char[M + 1];
		for (int i = 1; i <= N; i++)
			A[i] = tmpA.charAt(i - 1);
		for (int i = 1; i <= M; i++)
			B[i] = tmpB.charAt(i - 1);

		int[][] dp = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (A[i] == B[j]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		System.out.println(dp[N][M]);

	}

}
