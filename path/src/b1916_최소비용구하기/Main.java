package b1916_최소비용구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Edge {
		int v;
		int weight;
		Edge link;

		public Edge(int v, int weight, Edge link) {
			super();
			this.v = v;
			this.weight = weight;
			this.link = link;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		Edge[] graph = new Edge[N+1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph[from] = new Edge(to, weight, graph[from]);
		}

		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		int[] cost = new int[N + 1];
		dijkstra(start, graph, cost);

		System.out.println(cost[end]);

	}

	private static void dijkstra(int start, Edge[] graph, int[] cost) {

		Arrays.fill(cost, Integer.MAX_VALUE);
		int len = cost.length;
		boolean[] visited = new boolean[len];
		cost[start] = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[1], o2[1]);
			}
		});
		pq.add(new int[] { start, 0 });

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			if (visited[curr[0]])
				continue;
			visited[curr[0]] = true;

			for (Edge e = graph[curr[0]]; e != null; e = e.link) {
				int next = e.v;
				int weight = e.weight;
				int newCost = curr[1] + weight;

				if (newCost < cost[next]) {
					cost[next] = newCost;
					pq.add(new int[] { next, newCost });
				}
			}
		}
	}
}
