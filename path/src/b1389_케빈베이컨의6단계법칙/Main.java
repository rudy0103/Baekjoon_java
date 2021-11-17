package b1389_케빈베이컨의6단계법칙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] dp = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++)
			Arrays.fill(dp[i], 12345678);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dp[a][b] = 1;
			dp[b][a] = 1;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i == j)
						continue;
					dp[i][j] = Math.min(dp[i][k] + dp[k][j], dp[i][j]);
				}
			}
		}
		int min = Integer.MAX_VALUE;
		int idx = -1;
		for (int i = 1; i <= N; i++) {
			int tmp = 0;
			for (int j = 1; j <= N; j++) {
				if (dp[i][j] != 12345678)
					tmp += dp[i][j];
			}
			if (tmp < min) {
				min = tmp;
				idx = i;
			}
		}
		System.out.println(idx);
	}
}
