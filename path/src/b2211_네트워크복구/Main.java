package b2211_네트워크복구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Edge[] graph = new Edge[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[from] = new Edge(to, c, graph[from]);
			graph[to] = new Edge(from, c, graph[to]);

		}

		if (N == 1) {
			System.out.println(0);
		} else {
			int[] res = new int[N + 1];
			StringBuilder sb = new StringBuilder();
			dijkstra(graph,res);
			int cnt = 0;
			
			for(int i=2;i<=N;i++) if(res[i]!=0) cnt++;
			
			sb.append(cnt).append("\n");
			
			for (int i = 2; i <= N; i++) {
				if(res[i]!=0) sb.append(i).append(" ").append(res[i]).append("\n");
			}
			System.out.println(sb.toString());
		}

	}

	private static void dijkstra(Edge[] graph, int[] res) {
		
		int [] cost = new int[res.length];
		
		Arrays.fill(cost, Integer.MAX_VALUE);
		
		cost[1]=0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		
		pq.add(new int[] {1,0});
		
		while(!pq.isEmpty()) {
			int []curr=pq.poll();
			
			if(curr[1]>cost[curr[0]]) continue;
			
			for(Edge e = graph[curr[0]];e!=null;e=e.link) {
				
				int newCost=curr[1]+e.weight;
				if(newCost<cost[e.to]) {
					cost[e.to]=newCost;
					pq.add(new int[] {e.to,newCost});
					res[e.to]=curr[0];
				}
			}
		}
	}
}
