package b1197_최소스패닝트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge {
	int from;
	int to;
	int weight;

	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

}

public class Main {

	public static void make(int[] parent) {
		for (int i = 1; i < parent.length; i++)
			parent[i] = i;
	}

	public static int find(int x, int[] parent) {
		if (x == parent[x])
			return x;
		return parent[x] = find(parent[x], parent);
	}

	public static boolean union(int a, int b, int[] parent) {
		int A = find(a, parent);
		int B = find(b, parent);
		if (A == B)
			return false;
		else {
			parent[A] = B;
			return true;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String[] inp = br.readLine().split(" ");
		int V = Integer.parseInt(inp[0]);
		int E = Integer.parseInt(inp[1]);

		int[] parent = new int[V + 1];

		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.weight, o2.weight);
			}
		});

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}
		make(parent);
		int cnt = 0;
		int res = 0;
		while (cnt < V - 1) {
			Edge edge = pq.poll();
			if (union(edge.from, edge.to, parent)) {
				res += edge.weight;
				cnt++;
			}
		}

		System.out.println(res);
	}
}
