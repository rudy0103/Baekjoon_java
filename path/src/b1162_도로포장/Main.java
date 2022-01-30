package b1162_도로포장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Edge {

		int to;
		int cost;
		Edge link;

		public Edge(int to, int cost, Edge link) {
			super();
			this.to = to;
			this.cost = cost;
			this.link = link;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Edge[] graph = new Edge[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph[from] = new Edge(to, cost, graph[from]);
			graph[to] = new Edge(from, cost, graph[to]);

		}

		long[][] cost = new long[K + 1][N + 1];
		dijkstra(graph, cost, K);
		long res = Long.MAX_VALUE;
		for (int i = 0; i <= K; i++)
			res = Math.min(cost[i][N], res);
		System.out.println(res);
	}

	private static void dijkstra(Edge[] graph, long[][] cost, int k) {

		for (int i = 0; i <= k; i++) {
			Arrays.fill(cost[i], Long.MAX_VALUE);
		}

		cost[0][1] = 0;

		PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
			@Override
			public int compare(long[] o1, long[] o2) {
				if (o1[2] != o2[2])
					return Long.compare(o1[2], o2[2]);
				else
					return Long.compare(o1[1], o2[1]);
			}
		});

		pq.add(new long[] { 1, 0, 0 });

		while (!pq.isEmpty()) {

			long[] curr = pq.poll();

			int from = (int) curr[0];
			int idx = (int) curr[2];
			if (curr[1] > cost[idx][from])
				continue;
			long c = curr[1];

			for (Edge e = graph[from]; e != null; e = e.link) {
				long newCost = c + e.cost;
				if (newCost < cost[idx][e.to]) {
					cost[idx][e.to] = newCost;
					pq.add(new long[] { e.to, newCost, idx });
				}

				if (idx + 1 <= k) {
					if (c < cost[idx][e.to] && c < cost[idx + 1][e.to]) {
						cost[idx + 1][e.to] = c;
						pq.add(new long[] { e.to, c, idx + 1 });
					}
				}
			}
		}

	}

}
