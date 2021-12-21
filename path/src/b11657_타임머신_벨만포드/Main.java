package b11657_타임머신_벨만포드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[] pathCost = new long[N + 1];
		Edge[] edgeList = new Edge[M];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			edgeList[i] = new Edge(from, to, c);
		}

		if (bellmanFord(1, pathCost, edgeList)) {
			if(N==1) sb.append(pathCost[1]).append("\n");
			for (int i = 2; i <= N; i++) {
				if(pathCost[i]!=Integer.MAX_VALUE)
					sb.append(pathCost[i]).append("\n");
				else sb.append("-1\n");
			}
			System.out.println(sb.toString());
		} else {
			System.out.println(-1);
		}

	}

	private static boolean bellmanFord(int start, long[] pathCost, Edge[] edgeList) {

		Arrays.fill(pathCost, Integer.MAX_VALUE);

		pathCost[start] = 0;

		for (int i = 1; i < pathCost.length; i++) {

			boolean isUpdated=false;
			for (int j = 0; j < edgeList.length; j++) {

				int from = edgeList[j].from;
				int to = edgeList[j].to;
				long cost = edgeList[j].cost;

				if (pathCost[from] == Integer.MAX_VALUE)
					continue;

				if (pathCost[to] > pathCost[from] + cost) {
					pathCost[to] = pathCost[from] + cost;
					isUpdated=true;
				}
			}
			if(isUpdated==false) break;
		}
		
		for (int j = 0; j < edgeList.length; j++) {

			int from = edgeList[j].from;
			int to = edgeList[j].to;
			long cost = edgeList[j].cost;

			if (pathCost[from] == Integer.MAX_VALUE)
				continue;

			if (pathCost[to] > pathCost[from] + cost) {
				pathCost[to] = pathCost[from] + cost;
				return false;
			}
		}


		return true;
	}

}
