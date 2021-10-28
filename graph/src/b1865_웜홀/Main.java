package b1865_웜홀;

//플로이드 워샬,, 
//벨만포드로 다시 한번 풀어보기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			int[][] dp = new int[N][N];
			int[][] adj = new int[N][N];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken()) - 1;
				int d = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken());

				if (adj[s][d] == 0) {
					adj[s][d] = c;
					adj[d][s] = adj[s][d];
				} else {
					adj[s][d] = Math.min(adj[s][d], c);
					adj[d][s] = adj[s][d];
				}
			}

			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken()) - 1;
				int d = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken()) * -1;

				adj[s][d] = Math.min(adj[s][d], c);
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dp[i][j] = adj[i][j];
					if (dp[i][j] == 0)
						dp[i][j] = Integer.MAX_VALUE;
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
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (dp[i][j] + dp[j][i] < 0) {
						flag = true;
						break;
					}
				}
				if (flag)
					break;
			}

			if (flag)
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
		System.out.println(sb.toString());
	}

}
