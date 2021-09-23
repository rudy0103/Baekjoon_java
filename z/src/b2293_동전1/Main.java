package b2293_동전1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int k = Integer.parseInt(inp[1]);
		int[] coins = new int[n];

		int[] dp = new int[10001];

		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = 1;
		
		

		System.out.println(dp[k]);
	}
}
