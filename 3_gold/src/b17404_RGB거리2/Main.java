package b17404_RGB거리2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		int[][] cost = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int min = 123456789;
		min = Math.min(min, getMin(0, cost));
		min = Math.min(min, getMin(1, cost));
		min = Math.min(min, getMin(2, cost));

		System.out.println(min);

	}

	private static int getMin(int RGB, int[][] cost) {

		int[][] arr = new int[N + 1][3];
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 3; j++)
				arr[i][j] = cost[i][j];
		}

		for (int i = 0; i < 3; i++) {
			if (i != RGB)
				arr[1][i] = 123456789;
		}

		arr[N][RGB] = 123456789;

		int[][] dp = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {

			dp[i][0] = Math.min(dp[i - 1][1] + arr[i][0], dp[i - 1][2] + arr[i][0]);
			dp[i][1] = Math.min(dp[i - 1][0] + arr[i][1], dp[i - 1][2] + arr[i][1]);
			dp[i][2] = Math.min(dp[i - 1][0] + arr[i][2], dp[i - 1][1] + arr[i][2]);

		}

		int min = 123456789;
		for (int i = 0; i < 3; i++)
			min = Math.min(min, dp[N][i]);

		return min;
	}

}
