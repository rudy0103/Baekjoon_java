package b1240_노드사이의거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int n;
		int d;
		Node link;

		public Node(int n, int d, Node node) {
			super();
			this.n = n;
			this.d = d;
			this.link = node;
		}
	}

	static int[][] distance;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Node[] tree = new Node[N + 1];

		distance = new int[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}

		boolean[] visited = new boolean[N + 1];

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			tree[a] = new Node(b, d, tree[a]);
			tree[b] = new Node(a, d, tree[b]);

		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {

			Arrays.fill(visited, false);
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if (distance[start][end] != Integer.MAX_VALUE) {
				sb.append(distance[start][end] + "\n");
				continue;
			} else {
				dfs(start, start, end, visited, tree, 0);
				sb.append(distance[start][end] + "\n");
			}
		}

		System.out.println(sb.toString());
	}

	private static boolean dfs(int start, int now, int end, boolean[] visited, Node[] tree, int dist) {

		visited[now] = true;

		if (now == end) {
			return true;
		}

		for (Node node = tree[now]; node != null; node = node.link) {

			if (!visited[node.n]) {
				distance[start][node.n] = dist + node.d;
				distance[node.n][start] = dist + node.d;
				if (dfs(start, node.n, end, visited, tree, dist + node.d)) {
					distance[now][end] = distance[start][end] - dist;
					return true;
				}
			}

		}
		return false;
	}

}
