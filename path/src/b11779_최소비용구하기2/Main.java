package b11779_최소비용구하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static class Edge {
		int v;
		int weight;
		Edge link;

		public Edge(int v, int weight, Edge link) {
			super();
			this.v = v;
			this.weight = weight;
			this.link = link;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		Edge[] graph = new Edge[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph[from] = new Edge(to, weight, graph[from]);
		}

		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		long[] cost = new long[N + 1];
		LinkedList<Integer> list = dijkstra(graph, start, end, N, cost);

		sb.append(cost[end]).append("\n");
		sb.append(list.size()+1).append("\n");
		for (int n : list)
			sb.append(n).append(" ");
		sb.append(end);

		System.out.println(sb.toString());

	}

	private static LinkedList<Integer> dijkstra(Edge[] graph, int start, int end, int n, long[] cost) {

		Arrays.fill(cost, Long.MAX_VALUE);
		cost[start] = 0;

		PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
			public int compare(long[] o1, long[] o2) {
				// TODO Auto-generated method stub
				return Long.compare(o1[1], o2[1]);
			}
		});

		boolean visited[] = new boolean[n + 1];

		Stack<int[]> st = new Stack();

		pq.add(new long[] { start, 0, -1 });

		while (!pq.isEmpty()) {
			long[] curr = pq.poll();
			int from=(int) curr[0];
			if (visited[from])
				continue;
			visited[from] = true;
			st.add(new int[] {  (int) curr[2],from });
			if (curr[0] == end)
				break;

			for (Edge e = graph[from]; e != null; e = e.link) {
				int next = e.v;
				int weight = e.weight;

				if (cost[next] > cost[from] + weight) {
					cost[next]=cost[from] + weight;
					pq.add(new long[] { next, cost[from] + weight, curr[0] });
				}
			}
		}
		
		LinkedList<Integer> list = new LinkedList<>();

		int tmp=st.peek()[1];
		
		while(!st.empty()) {
			
			if(st.peek()[1]==tmp) {
				list.addFirst(st.peek()[0]);
				tmp=st.pop()[0];
			}else st.pop();
			if(tmp==start) break;
		}
		
		return list;
	}

}
