package b11058_크리보드;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		long[] dp = new long[N + 5];

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		dp[4] = 4;

		for (int i = 4; i <= N; i++) {
			// 추가
			for (int j = 1; j + i <= N; j++) {
				dp[i + j] = Math.max(dp[i + j], dp[i] + j);// 추가
				dp[i + j] = Math.max(dp[i + j], dp[i - 3] + dp[i - 3] * (j+1));// 붙여넣기
			}

			for (int j = 4; i + j <= N; j += 4) {
				dp[i + j] = Math.max(dp[i + (j - 4)] * 2, dp[i + j]);
			}
		}

		System.out.println(dp[N]);
	}

}
