package b5582_공통부분문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] X = br.readLine().toCharArray();
		char[] Y = br.readLine().toCharArray();

		int[][] dp = new int[X.length+1][Y.length+1];
		int max = 0;

		for(int i = 1; i <=X.length; i++) {
			for(int j = 1; j <= Y.length; j++) {
				if(X[i-1] == Y[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}

		System.out.println(max);
	}

}
