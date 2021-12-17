package b1219_오민식의고민;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static class Edge {
		int from;
		int to;
		long weight;

		public Edge(int from, int to, long weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Edge[] edgeArray = new Edge[M];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			long weight = Long.parseLong(st.nextToken());
			edgeArray[i] = new Edge(from, to, weight);
		}
		st = new StringTokenizer(br.readLine(), " ");
		long[] money = new long[N];
		long[] cost = new long[N];
		for (int i = 0; i < N; i++)
			money[i] = Integer.parseInt(st.nextToken());

		LinkedList<Integer> list = bellmanFord(S, E, edgeArray, money, cost);
		
		if(list==null) {
			System.out.println("gg");
		}else if(list.size()==0){
			System.out.println(-cost[E]);
		}else {
			boolean canGo=false;
			for(int start: list) {
				if(bellmanFord(start, E, edgeArray, money, new long[N])!=null) {
					canGo=true;
					break;
				}
			}
			if(canGo) System.out.println("Gee");
			else System.out.println(-cost[E]);
		}

	}

	private static LinkedList<Integer> bellmanFord(int s, int e, Edge[] edgeArray, long[] money, long[] cost) {

		int N = money.length;
		Arrays.fill(cost, Long.MAX_VALUE);
		cost[s] = -money[s];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < edgeArray.length; j++) {
				Edge edge = edgeArray[j];
				int from = edge.from;
				int to = edge.to;
				long weight = edge.weight;
				if (cost[from] == Long.MAX_VALUE)
					continue;

				if (cost[to] > cost[from] + weight - money[to]) {
					cost[to] = cost[from] + weight - money[to];
				}
			}
		}

		LinkedList<Integer> list = new LinkedList<>();

		for (int j = 0; j < edgeArray.length; j++) {
			Edge edge = edgeArray[j];
			int from = edge.from;
			int to = edge.to;
			long weight = edge.weight;
			if (cost[from] == Long.MAX_VALUE)
				continue;

			if (cost[to] > cost[from] + weight - money[to]) {
				cost[to] = cost[from] + weight - money[to];
				list.add(to);
			}
		}

		if(cost[e]==Long.MAX_VALUE) return null;
		return list;

	}
}
