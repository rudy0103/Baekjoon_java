package b14938_서강그라운드;

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

	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[] items = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}

		Edge[] edgeList = new Edge[N + 1];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[from] = new Edge(to, weight, edgeList[from]);
			edgeList[to] = new Edge(from, weight, edgeList[to]);
		}

		for (int i = 1; i <= N; i++) {
			int[] cost = new int[N+1];
			int sum = 0;
			dijkstra(i, cost, edgeList);
			for (int j = 1; j <= N; j++) {
				if (cost[j] <= M)
					sum += items[j];
			}
			if (sum > max)
				max = sum;
		}
		System.out.println(max);

	}

	private static void dijkstra(int start, int[] cost, Edge[] edgeList) {
		Arrays.fill(cost, Integer.MAX_VALUE);
		cost[start] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		pq.add(new int[] { start, 0 });

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();

			for (Edge e = edgeList[curr[0]]; e != null; e = e.link) {
				int next = e.v;
				int newCost = cost[curr[0]] + e.weight;
				if (cost[next] > newCost) {
					cost[next] = newCost;
					pq.add(new int[] { next, newCost });
				}
			}
		}

	}

}
