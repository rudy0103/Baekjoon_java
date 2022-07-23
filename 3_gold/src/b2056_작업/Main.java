package b2056_작업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int v;
		Node link;

		public Node(int v, Node link) {
			super();
			this.v = v;
			this.link = link;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] time = new int[N + 1];
		int[] cnt = new int[N + 1];
		int[] cost = new int[N + 1];

		Node[] graph = new Node[N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			time[i] = t;
			int n = Integer.parseInt(st.nextToken());
			cnt[i] = n;
			for (int j = 0; j < n; j++) {
				int from = Integer.parseInt(st.nextToken());
				graph[from] = new Node(i, graph[from]);
			}
		}

		ArrayDeque<Integer> dq = new ArrayDeque<>();

		for (int i = 1; i <= N; i++) {
			if (cnt[i] == 0) {
				cost[i] = time[i];
				dq.add(i);
			}
		}

		int max = 0;
		while (!dq.isEmpty()) {
			int task = dq.poll();
			max = Math.max(max, cost[task]);

			for (Node node = graph[task]; node != null; node = node.link) {
				int next = node.v;

				cnt[next]--;
				cost[next] = Math.max(cost[next], cost[task] + time[next]);
				if (cnt[next] == 0) {
					dq.add(next);
				}
			}
		}

		System.out.println(max);

	}

}
