package b2579_계단오르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] scores = new int[N + 1];
		int[][] DP = new int[N + 1][2];

		for (int i = 1; i <= N; i++) {
			scores[i] = Integer.parseInt(br.readLine());
		}
		DP[1][0] = scores[1]; // 0 은 그 전 계단을 밟았을 때
		DP[1][1] = scores[1]; // 1 은 그 전 계단을 안 밟았을 경우
		
		if (N >= 2) {
			DP[2][0] = scores[1] + scores[2];
			DP[2][1] = scores[2];
			for (int i = 3; i <= N; i++) {
				DP[i][0] = DP[i - 1][1] + scores[i];
				DP[i][1] = Math.max(DP[i - 2][1], DP[i - 2][0]) + scores[i];
			}
		}
		System.out.println(Math.max(DP[N][0], DP[N][1]));
	}
}
