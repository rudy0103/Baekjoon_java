package b1167_트리의지름;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Edge {
		int to;
		int weight;
		Edge link;

		public Edge(int to, int weight, Edge link) {
			super();
			this.to = to;
			this.weight = weight;
			this.link = link;
		}
	}

	static int N;
	static int max;
	static Edge[] tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		tree = new Edge[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			while (true) {
				int to = Integer.parseInt(st.nextToken());
				if (to == -1)
					break;
				int weight = Integer.parseInt(st.nextToken());
				tree[from] = new Edge(to, weight, tree[from]);
			}

		}
		dfs(1, 0);
		System.out.println(max);
	}

	private static int dfs(int n, int before) {

		if (tree[n] == null)
			return 0;

		int ret = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		for (Edge edge = tree[n]; edge != null; edge = edge.link) {
			int now = edge.to;
			if (now == before)
				continue;
			int tmp = dfs(now, n) + edge.weight;
			if (ret < tmp)
				ret = tmp;
			pq.add(tmp);
		}

		int A = 0;
		int B = 0;
		if (!pq.isEmpty())
			A = pq.poll();
		if (!pq.isEmpty())
			B = pq.poll();
		if (A + B > max)
			max = A + B;
		return ret;
	}

}
