package b14728_벼락치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int[] times = new int[N + 1];
		int[] values = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			times[i] = Integer.parseInt(st.nextToken());
			values[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[T + 1];

		Arrays.fill(dp, -1);
		dp[0] = 0;
		int maxVal = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = T; j >= 0; j--) {
				if (j - times[i] >= 0 && dp[j - times[i]] != -1) {
					dp[j] = Math.max(dp[j], dp[j - times[i]] + values[i]);
				}
			}
		}
		for (int i = 0; i <= T; i++)
			maxVal = Math.max(maxVal, dp[i]);
		System.out.println(maxVal);

	}

}
