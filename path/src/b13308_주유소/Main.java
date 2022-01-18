package b13308_주유소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	
	public static class Edge{
		int to;
		int distance;
		Edge link;
		public Edge(int to, int distance, Edge link) {
			super();
			this.to = to;
			this.distance = distance;
			this.link = link;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
//		int M=Integer.parseInt(st.nextToken());
		long [] cost=new long[N+1];
		long [] weight=new long[N+1];
		
		Edge[] graph=new Edge[N+1];
		
		
		
		
		
		st=new StringTokenizer(br.readLine()," ");
		for(int i=1;i<N;i++) {
			int from=i;
			int to=i+1;
			int dist=Integer.parseInt(st.nextToken());
			graph[from]=new Edge(to,dist,graph[from]);
			graph[to]=new Edge(from,dist,graph[to]);
					
		}
		st=new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=N;i++) weight[i]=Long.parseLong(st.nextToken());
		
		dijkstra(cost,weight,graph);
		
		System.out.println(cost[N]);
		System.out.println(Arrays.toString(cost));
	}

	private static void dijkstra(long[] cost, long[] weight, Edge[] graph) {
		
		Arrays.fill(cost, Long.MAX_VALUE);
		cost[1]=0;

		long[] dp=new long[cost.length];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1]=weight[1];
		
		PriorityQueue<long[]> pq=new PriorityQueue<>(new Comparator<long []>() {
			@Override
			public int compare(long[] o1, long[] o2) {
				if(o1[1]!=o2[1])
					return Long.compare(o1[1], o2[1]);
				else return Long.compare(o1[2], o2[2]);
			}
		});
		
		pq.add(new long[] {1,0,weight[1]});
		
		while(!pq.isEmpty()) {
			long[] curr=pq.poll();
			
			for(Edge e=graph[(int)curr[0]];e!=null;e=e.link) {
				
				long newCost=curr[1]+curr[2]*e.distance;
				
				if(newCost<cost[e.to]) {
					cost[e.to]=newCost;
					if(e.to==N) continue;
					pq.add(new long[] {e.to,newCost,Math.min(curr[2], weight[e.to])});
				}
				else if(dp[e.to]>curr[2]) {
					dp[e.to]=curr[2];
					pq.add(new long[] {e.to,newCost,curr[2]});
				}
			}
		}
	}
}
