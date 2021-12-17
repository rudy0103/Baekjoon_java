package b1219_오민식의고민;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Edge {
		int from;
		int to;
		int weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Edge[] edgeArray = new Edge[M];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeArray[i] = new Edge(from, to, weight);
		}
		st = new StringTokenizer(br.readLine(), " ");
		int[] money = new int[N];
		int[] cost = new int[N];
		for (int i = 0; i < N; i++)
			money[i] = Integer.parseInt(st.nextToken());

		boolean haveCycle;
		haveCycle = bellmanFord(S, E, edgeArray, money, cost);

		if (cost[E] == Integer.MAX_VALUE)
			System.out.println("gg");
		else if (haveCycle == true) {
			System.out.println("Gee");
		} else {
			System.out.println(-cost[E]);
		}

	}

	private static boolean bellmanFord(int s, int e, Edge[] edgeArray, int[] money, int[] cost) {

		int N = money.length;
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[s] = -money[s];

		for (int i = 0; i < N - 1; i++) {
			boolean isUpdated = false;
			for (int j = 0; j < edgeArray.length; j++) {
				Edge edge = edgeArray[j];
				int from = edge.from;
				int to = edge.to;
				int weight = edge.weight;
				if (cost[from] == Integer.MAX_VALUE)
					continue;

				if (cost[to] > cost[from] + weight - money[to]) {
					cost[to] = cost[from] + weight - money[to];
					isUpdated = true;
				}
			}
			if (isUpdated == false)
				break;
		}

		for (int j = 0; j < edgeArray.length; j++) {
			Edge edge = edgeArray[j];
			int from = edge.from;
			int to = edge.to;
			int weight = edge.weight;

			if (cost[to] > cost[from] + weight - money[to]) {
				cost[to] = cost[from] + weight - money[to];
				return true;
			}
		}
		return false;

	}

}
