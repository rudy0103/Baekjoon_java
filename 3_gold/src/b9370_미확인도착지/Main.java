package b9370_미확인도착지;

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
		int c;
		Edge link;

		public Edge(int to, int c, Edge link) {
			super();
			this.to = to;
			this.c = c;
			this.link = link;
		}

	}

	static Edge[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			boolean[] candidate = new boolean[n + 1];
			graph = new Edge[n + 1];
			int[] cost = new int[n + 1];
			int[] costG = new int[n + 1];
			int[] costH = new int[n + 1];

			Arrays.fill(cost, Integer.MAX_VALUE);
			Arrays.fill(costG, Integer.MAX_VALUE);
			Arrays.fill(costH, Integer.MAX_VALUE);

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());

				graph[A] = new Edge(B, C, graph[A]);
				graph[B] = new Edge(A, C, graph[B]);
			}

			for (int i = 0; i < t; i++) {
				int candi = Integer.parseInt(br.readLine());
				candidate[candi] = true;
			}

			dijkstra(s, cost);
			dijkstra(g, costG);
			dijkstra(h, costH);
			

			int gtoh=costG[h];

			for (int i = 1; i <= n; i++) {
				if (candidate[i] == false)
					continue;
				//s->t == s->g->h->t or s->t == s->h->g->t;
				int stot=cost[i];
				
				if (stot==(cost[g]+gtoh+costH[i])||stot==(cost[h]+gtoh+costG[i])) {
					sb.append(i).append(" ");
				}
			}
			sb.setLength(sb.length()-1);
			sb.append("\n");

		}

		System.out.println(sb.toString());

	}

	private static void dijkstra(int s, int[] cost) {

		cost[s] = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		pq.add(new int[] { s, 0 });

		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int from = now[0];

			for (Edge e = graph[from]; e != null; e = e.link) {

				int newCost = now[1] + e.c;

				if (cost[e.to] > newCost) {
					cost[e.to] = newCost;
					pq.add(new int[] { e.to, newCost });
				}
			}

		}

	}

}
