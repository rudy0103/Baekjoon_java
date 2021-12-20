package b3860_할로윈묘지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Edge {
		int from;
		int to;

		public Edge(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}
	}

	static int[][] nodes;
	static Edge[] edgeList;
	static int H, W, idx;
	static long[] cost;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());// 열
		H = Integer.parseInt(st.nextToken());// 행

		while (W != 0 && H != 0) {
			nodes = new int[H * W + 1][2];
			edgeList = new Edge[((H * W) + 1) * 4];
			int start = transToNode(H - 1, 0);
			int end = transToNode(0, W - 1);
			cost = new long[H * W + 1];

			// 묘비
			int G = Integer.parseInt(br.readLine());
			for (int i = 0; i < G; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = H - Integer.parseInt(st.nextToken()) - 1;
				int node = transToNode(r, c);
				nodes[node][0] = -1;
			}

			// 귀신구멍
			int E = Integer.parseInt(br.readLine());

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int c1 = Integer.parseInt(st.nextToken());
				int r1 = H - Integer.parseInt(st.nextToken()) - 1;
				int c2 = Integer.parseInt(st.nextToken());
				int r2 = H - Integer.parseInt(st.nextToken()) - 1;
				int weight = Integer.parseInt(st.nextToken());

				int in = transToNode(r1, c1);
				int out = transToNode(r2, c2);
				nodes[in][0] = out;
				nodes[in][1] = weight;
			}
			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };

			idx = 0;
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					int s = transToNode(r, c);
					if (nodes[s][0] == -1)
						continue;
					if (nodes[s][0] == 0) {// 평범한 잔디
						for (int d = 0; d < 4; d++) {
							int rr = r + dr[d];
							int cc = c + dc[d];

							if (rr >= 0 && rr < H && cc >= 0 && cc < W) {
								int e = transToNode(rr, cc);
								if (nodes[e][0] != -1) {
									edgeList[idx++] = new Edge(s, e);
								}
							}
						}
					} else { // 귀신구멍
						int e = nodes[s][0];
						edgeList[idx++] = new Edge(s, e);
					}
				}
			}

			boolean haveCycle = bellmanFord(start, end);
			if (haveCycle) {
				sb.append("Never\n");
			} else {
				if (cost[end] == Long.MAX_VALUE) {
					sb.append("Impossible\n");
				} else
					sb.append(cost[end] + "\n");
			}

			/////// 새로운 테케
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
		}
		///////////// 출력
		System.out.println(sb.toString());
	}

	private static boolean bellmanFord(int start, int end) {

		Arrays.fill(cost, Long.MAX_VALUE);
		cost[start] = 0;
		int len = H * W;
		for (int i = 0; i < len - 1; i++) {
			boolean isUpdated = false;

			for (int j = 0; j < idx; j++) {

				Edge e = edgeList[j];
				int from = e.from;
				int to = e.to;

				if (cost[from] == Long.MAX_VALUE)
					continue;
				if (nodes[from][0] == 0) {// 일반 잔디

					if (cost[to] > cost[from] + 1) {
						cost[to] = cost[from] + 1;
						isUpdated = true;
					}

				} else {// 귀신 구멍
					to = nodes[from][0];
					if (cost[to] > cost[from] + nodes[from][1]) {
						cost[to] = cost[from] + nodes[from][1];
						isUpdated = true;
					}
				}

			}

			if (isUpdated == false)
				break;
		}

		boolean haveCycle = false;

		for (int j = 0; j < idx; j++) {

			Edge e = edgeList[j];
			int from = e.from;
			int to = e.to;

			if (cost[from] == Long.MAX_VALUE)
				continue;

			if (nodes[from][0] == 0) {// 일반 잔디

				if (cost[to] > cost[from] + 1) {
					cost[to] = cost[from] + 1;
					return true;
				}

			} else {// 귀신 구멍
				to = nodes[from][0];
				if (cost[to] > cost[from] + nodes[from][1]) {
					cost[to] = cost[from] + nodes[from][1];
					return true;
				}
			}

		}
		if (haveCycle == true) {
			return true;
		}
		return false;
	}

	private static int transToNode(int r, int c) {
		return r * W + c + 1;
	}

}
