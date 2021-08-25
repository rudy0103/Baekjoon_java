package b1774_우주신과의교감;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge {
	int from;
	int to;
	double length;

	public Edge(int from, int to, double length) {
		super();
		this.from = from;
		this.to = to;
		this.length = length;
	}
}

public class Main {

	public static void make(int[] root) {
		for (int i = 1; i < root.length; i++) {
			root[i] = i;
		}
	}

	public static int find(int x, int[] root) {
		if (x == root[x])
			return x;
		return root[x] = find(root[x], root);
	}

	public static boolean union(int a, int b, int[] root) {
		int A = find(a, root);
		int B = find(b, root);
		if (A == B)
			return false;
		root[A] = B;
		return true;
	}

	public static double getDistance(int[] a, int[] b) {

		return (double) Math
				.pow((long) (a[0] - b[0]) * (long) (a[0] - b[0]) + (long) (a[1] - b[1]) * (long) (a[1] - b[1]), 0.5);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		double[][] length = new double[N + 1][N + 1];
		int[][] god = new int[N + 1][2];
		int[] root = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			god[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		}

		make(root);

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			union(from, to, root);
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Double.compare(o1.length, o2.length);
			}
		});

		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++) {
				if (j <= i)
					continue;
				length[i][j] = getDistance(god[i], god[j]);
				pq.add(new Edge(i, j, length[i][j]));
			}

		double totalLength = 0;
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if (union(edge.from, edge.to, root))
				totalLength += edge.length;
		}
		System.out.printf("%.2f\n", totalLength);
	}
}
