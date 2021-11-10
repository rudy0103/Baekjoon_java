package b1238_파티;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge {

		int vertex;
		int weight;
		Edge link;

		public Edge(int vertex, int weight, Edge link) {
			super();
			this.vertex = vertex;
			this.weight = weight;
			this.link = link;
		}
	}

	public static void dijkstraXtoN(int start, Edge[] graph, int[] cost) {
		cost[start] = 0;
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		q.add(new int[] { start, cost[start] });

		while (!q.isEmpty()) {
			int[] current = q.poll();

			for (Edge curEdge = graph[current[0]]; curEdge != null; curEdge = curEdge.link) {
				int next = curEdge.vertex;
				int nextCost = curEdge.weight;
				int newCost = current[1] + nextCost;
				if (cost[next] > newCost) {
					cost[next] = newCost;
					q.add(new int[] { next, newCost });
				}
			}
		}
	}

	public static int dijkstraNtoX(int start, int X, Edge[] graph, int[] cost) {
		cost[start] = 0;
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		q.add(new int[] { start, cost[start] });

		while (!q.isEmpty()) {
			int[] current = q.poll();

			if (current[0] == X)
				return cost[X];

			for (Edge curEdge = graph[current[0]]; curEdge != null; curEdge = curEdge.link) {
				int next = curEdge.vertex;
				int nextCost = curEdge.weight;
				int newCost = current[1] + nextCost;
				if (cost[next] > newCost) {
					cost[next] = newCost;
					q.add(new int[] { next, newCost });
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		int[] XtoNcost = new int[N + 1];
		int[] NtoXcost = new int[N + 1];
		Arrays.fill(XtoNcost, Integer.MAX_VALUE);
		Edge[] graph = new Edge[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[from] = new Edge(to, weight, graph[from]);
		}

		dijkstraXtoN(X, graph, XtoNcost);

		int max = 0;
		for (int i = 1; i <= N; i++) {
			Arrays.fill(NtoXcost, Integer.MAX_VALUE);
			int c = dijkstraNtoX(i, X, graph, NtoXcost);
			if (XtoNcost[i] + c > max)
				max = XtoNcost[i] + c;
		}
		System.out.println(max);
	}
}
