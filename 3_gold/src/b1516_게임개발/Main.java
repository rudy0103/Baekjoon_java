package b1516_게임개발;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static class Edge {
		int to;
		Edge link;

		public Edge(int to, Edge link) {
			this.to = to;
			this.link = link;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] times = new int[N + 1];
		int[] cnt = new int[N + 1];
		int[] cost = new int[N + 1];

		ArrayDeque<Integer> dq = new ArrayDeque<>();
		Edge[] graph = new Edge[N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			cost[i] = c;
			while (next != -1) {
				cnt[i]++;
				graph[next] = new Edge(i, graph[next]);
				next=Integer.parseInt(st.nextToken());
			}

			if (cnt[i] == 0) {
				times[i] = c;
				dq.add(i);
			}
		}

		while (!dq.isEmpty()) {
			int now = dq.poll();

			for (Edge edge = graph[now]; edge != null; edge = edge.link) {
				int to = edge.to;
				cnt[to]--;

				times[to] = Math.max(times[to], times[now] + cost[to]);
				if (cnt[to] == 0) {
					dq.add(to);
				}
			}

		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= N; i++)
			sb.append(times[i]).append("\n");

		System.out.println(sb.toString());

	}

}
