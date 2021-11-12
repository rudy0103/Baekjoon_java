package b10282_해킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[] inspected;

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

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			inspected = new int[N + 1];
			for (int i = 0; i < N + 1; i++) {
				Arrays.fill(inspected, Integer.MAX_VALUE);
			}

			Edge[] graph = new Edge[N + 1];

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());

				graph[from] = new Edge(to, s, graph[from]);
			}

			dijkstra(C, graph);

			int cnt = 0;
			int max = 0;
			for (int i = 0; i <= N; i++) {
				if (inspected[i] != Integer.MAX_VALUE) {
					cnt++;
					if (max < inspected[i]) {
						max = inspected[i];
					}
				}
			}
			sb.append(cnt + " " + max + "\n");

		}
		System.out.println(sb.toString());

	}

	private static void dijkstra(int c, Edge[] graph) {
		inspected[c] = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		pq.add(new int[] { c, 0 });

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();

			for (Edge e = graph[curr[0]]; e != null; e = e.link) {
				int next = e.to;
				int cost = e.cost;
				int newCost = curr[1] + cost;
				if (newCost < inspected[next]) {
					inspected[next] = newCost;
					pq.add(new int[] { next, newCost });
				}
			}
		}

	}

}
