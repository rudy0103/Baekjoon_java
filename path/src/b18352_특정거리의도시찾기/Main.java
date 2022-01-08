package b18352_특정거리의도시찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static class Edge {
		int to;
		Edge link;

		public Edge(int to, Edge link) {
			super();
			this.to = to;
			this.link = link;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		Edge[] graph = new Edge[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from] = new Edge(to, graph[from]);
		}

		int[] cost = new int[N + 1];

		dijkstra(graph, X, cost);
		
		for(int i=1;i<=N;i++) {
			if(cost[i]==K) sb.append(i).append("\n");
		}
		if(sb.length()!=0)
			System.out.println(sb.toString());
		else System.out.println("-1");

	}

	private static void dijkstra(Edge[] graph, int x, int[] cost) {
		
		Arrays.fill(cost, Integer.MAX_VALUE);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		
		cost[x]=0;
		
		pq.add(new int[] {x,0});
		
		while(!pq.isEmpty()) {
			int[] curr=pq.poll();
			
			if(curr[1]>cost[curr[0]]) continue;
			
			for(Edge e=graph[curr[0]];e!=null;e=e.link) {
				int newCost=curr[1]+1;
				if(newCost<cost[e.to]) {
					cost[e.to]=newCost;
					pq.add(new int[] {e.to,newCost});
				}
				
			}
			
		}
		
		
	}

}
