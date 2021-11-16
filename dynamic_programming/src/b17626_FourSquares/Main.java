package b17626_FourSquares;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[50001];
		Arrays.fill(dp, Integer.MAX_VALUE);

		int max = 0;

		for (int i = 1; i * i <= 50000; i++) {
			dp[i * i] = 1;
			max = i;
		}

		for (int j = 1; j <= 50000; j++) {
			for (int k = 1; k <= max; k++) {
				if (j + k * k <= 50000) {
					if (dp[j + k * k] > dp[j] + dp[k * k])
						dp[j + k * k] = dp[j] + dp[k * k];
				} else {
					break;
				}
			}
		}
		System.out.println(dp[N]);

	}

}
