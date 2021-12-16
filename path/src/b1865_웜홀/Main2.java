package b1865_웜홀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
	static class Edge {
		int from;
		int to;
		long cost;

		public Edge(int from, int to, long cost) {
			super();
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}

	static long[] pathCost;

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

			long[][] adj = new long[N][N];
			pathCost = new long[N];

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

			int numOfEdge = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (adj[i][j] != 0)
						numOfEdge++;
				}
			}

			Edge[] edgeList = new Edge[numOfEdge];

			int idx = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (adj[i][j] != 0) {
						edgeList[idx] = new Edge(i, j, adj[i][j]);
						idx++;
					}
				}
			}

			boolean flag = false;
			if (bellmanFord(edgeList, N) == true) {
				flag = true;
			}
			if (flag == true)
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
		System.out.println(sb.toString());

	}

	private static boolean bellmanFord(Edge[] edgeList, int N) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < edgeList.length; j++) {
				pathCost[edgeList[j].to] = Math.min(pathCost[edgeList[j].to],
						pathCost[edgeList[j].from] + edgeList[j].cost);
			}
		}

		for (int j = 0; j < edgeList.length; j++) {
			long tmp = pathCost[edgeList[j].to];
			pathCost[edgeList[j].to] = Math.min(pathCost[edgeList[j].to],
					pathCost[edgeList[j].from] + edgeList[j].cost);
			if (tmp != pathCost[edgeList[j].to]) {
				return true;
			}
		}
		return false;
	}
}
