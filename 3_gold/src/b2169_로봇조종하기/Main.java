package b2169_로봇조종하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N + 1][M + 1];
		int[][][] dp = new int[N + 2][M + 2][2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		for (int i = 0; i <= N + 1; i++) {
			for (int j = 0; j <= M + 1; j++) {
				dp[i][j][0] = -123456789;
				dp[i][j][1] = -123456789;
			}
		}
		dp[1][0][0] = 0;
		dp[1][1][0] = map[1][1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				dp[i][j][0] = Math.max(Math.max(dp[i - 1][j][0], dp[i - 1][j][1]) + map[i][j],
						dp[i][j - 1][0] + map[i][j]);
			}

			for (int j = M; j >= 1; j--) {
				dp[i][j][1] = Math.max(Math.max(dp[i - 1][j][0], dp[i - 1][j][1]) + map[i][j],
						dp[i][j + 1][1] + map[i][j]);
			}

		}

		System.out.println(Math.max(dp[N][M][0], dp[N][M][1]));

	}

}
