package b17070_파이프옮기기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		int map[][] = new int[N][N];
		int end = N - 1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][][] dp = new int[N][N][3];
		dp[0][1][0] = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1)
					continue;
				// 가로
				if (j - 1 >= 0) {
					dp[i][j][0] += dp[i][j - 1][0];
					dp[i][j][0] += dp[i][j - 1][2];
				}

				// 세로
				if (i - 1 >= 0) {
					dp[i][j][1] += dp[i - 1][j][1];
					dp[i][j][1] += dp[i - 1][j][2];
				}

				// 대각
				if (i - 1 >= 0 && j - 1 >= 0) {
					if (map[i - 1][j] == 0 && map[i][j - 1] == 0 && map[i - 1][j - 1] == 0) {
						dp[i][j][2] += dp[i - 1][j - 1][0];
						dp[i][j][2] += dp[i - 1][j - 1][1];
						dp[i][j][2] += dp[i - 1][j - 1][2];
					}
				}
			}
		}



		int sum = dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2];
		System.out.println(sum);
	}



}
