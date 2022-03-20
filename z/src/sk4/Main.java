package sk4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();

		int N = 4;
		int [][] edges= {{0,1},{1,2},{2,3}};

		int[][] adj = new int[N][N];
		int[][] dp = new int[N][N];

		for (int i = 0; i < N-1; i++) {
			int r=edges[i][0];
			int c=edges[i][1];
			adj[r][c]=1;
			adj[c][r]=1;
			
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dp[i][j] = adj[i][j];
				if (dp[i][j] == 0)
					dp[i][j] = 12345678;
			}
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == j)
						continue;
					dp[i][j] = Math.min(dp[i][k] + dp[k][j], dp[i][j]);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(dp[i][j]!=12345678)
					sb.append(dp[i][j] + " ");
				else sb.append("0 ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
