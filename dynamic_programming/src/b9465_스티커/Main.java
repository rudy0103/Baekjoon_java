package b9465_스티커;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());

			int[][][] dp = new int[N + 1][2][2];

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

			int[][] sticker = new int[N + 1][2];

			for (int i = 1; i <= N; i++) {
				sticker[i][0] = Integer.parseInt(st.nextToken());
				sticker[i][1] = Integer.parseInt(st2.nextToken());
			}

			for (int i = 1; i <= N; i++) {

				// 위에 안뜯을 때 --> 전단계에서 가장 큰 값
				dp[i][0][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1]);
				dp[i][0][0] = Math.max(dp[i - 1][0][1], dp[i][0][0]);
				dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i][0][0]);

				// 위에 뜯을 때 --> 전단계에서 위에 안뜯을 때와 아래 뜯거나 안뜯거나
				dp[i][0][1] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1]);
				dp[i][0][1] = Math.max(dp[i - 1][0][0], dp[i][0][1]);
				dp[i][0][1] += sticker[i][0];
				
				
				// 아래에 안뜯을 때 --> 전단계에서 가장 큰 값
				dp[i][1][0] = Math.max(dp[i - 1][0][0], dp[i - 1][0][1]);
				dp[i][1][0] = Math.max(dp[i - 1][1][1], dp[i][1][0]);
				dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i][1][0]);

				// 아래 뜯을 때 --> 전단계에서 아래 안뜯을 때와 위에 뜯거나 안뜯거나
				dp[i][1][1] = Math.max(dp[i - 1][0][0], dp[i - 1][0][1]);
				dp[i][1][1] = Math.max(dp[i - 1][1][0], dp[i][1][1]);
				dp[i][1][1] += sticker[i][1];
				
			}
			int max=0;
			for(int i=0;i<2;i++) {
				for(int j=0;j<2;j++) {
					if(dp[N][i][j]>max) max=dp[N][i][j];
				}
			}
			sb.append(max+"\n");
		}
		System.out.println(sb.toString());
	}

}
