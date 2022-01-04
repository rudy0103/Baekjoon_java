package b10971_외판원순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int minCost = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());

		int[][] cost = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		travel(0, N, cost, new int[N], new boolean[N]);
		System.out.println(minCost);
	}

	private static void travel(int d, int N, int[][] cost, int[] selected, boolean[] visited) {

		if (d == N) {
			int tmpCost = 0;

			for (int i = 0; i < N; i++) {
				int start = selected[i];
				int next = -1;
				if (i != N - 1) {
					next = selected[i + 1];
				} else
					next = selected[0];
				int c=cost[start][next];
				if(c==0) return;
				tmpCost += cost[start][next];
			}

			minCost = Math.min(minCost, tmpCost);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			selected[d] = i;
			visited[i] = true;
			travel(d + 1, N, cost, selected, visited);
			visited[i] = false;

		}
	}
}
