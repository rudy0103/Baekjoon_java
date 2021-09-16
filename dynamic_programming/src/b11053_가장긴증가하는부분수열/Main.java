package b11053_가장긴증가하는부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int length = 0;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i]==dp[j]) break;
				if (arr[i] < dp[j] && arr[i] < dp[j + 1]) {
					dp[j] = arr[i];
					break;
				}
			}
		}

		for (int i = 0; i < dp.length; i++) {
			if (dp[i] != Integer.MAX_VALUE)
				length++;
			else
				break;
		}
		
		System.out.println(length);
	}
}
