package b11404_플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2 {

	static int N;
	static int[][] adj;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		adj = new int[N + 1][N + 1];
		int M = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				adj[i][j] = 123456789;
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			adj[s][e] = Math.min(adj[s][e], Integer.parseInt(st.nextToken()));
		}

		int cost[] = new int[N + 1];
		int res[][] = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(cost, Integer.MAX_VALUE);
			dijkstra(i, cost);
			for (int j = 1; j <= N; j++) {
				if (cost[j] < 123456789)
					res[i][j] = cost[j];
				else
					res[i][j] = 0;
			}
		}

		for (

				int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sb.append(res[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	private static void dijkstra(int start, int[] cost) {

		cost[start] = 0;

		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		q.add(new int[] { start, start, cost[start] });

		while (!q.isEmpty()) {
			int[] current = q.poll();
			int now = current[1];
			for (int s = 1; s <= N; s++) {
				if (adj[now][s] == 123456789)
					continue;
				int nextCost = adj[now][s];
				int newCost = current[2] + nextCost;
				if (cost[s] > newCost) {
					cost[s] = newCost;
					q.add(new int[] { current[1], s, newCost });
				}
			}
		}
	}
}
