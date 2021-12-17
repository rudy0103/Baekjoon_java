package b1753_최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge{
	
	int vertex;
	int weight;
	Edge link;
	public Edge(int vertex, int weight, Edge link) {
		super();
		this.vertex = vertex;
		this.weight = weight;
		this.link = link;
	}
}


public class Main {
	
	public static void dijkstra(int start, Edge[] graph,int[] cost) {
		cost[start]=0;
		PriorityQueue<int[]> q= new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				 return o1[1]-o2[1];
			}
		});
		q.add(new int[] {start,cost[start]});
		boolean visited[]=new boolean[cost.length];
		
		while(!q.isEmpty()) {
			int []current=q.poll();
			if(visited[current[0]]) continue;
			visited[current[0]]=true;
			
			for(Edge curEdge=graph[current[0]];curEdge!=null;curEdge=curEdge.link) {
				int next=curEdge.vertex;
				int nextCost=curEdge.weight;
				int newCost=current[1]+nextCost;
				if(cost[next]>newCost) {
					cost[next]=newCost;
					q.add(new int[]{next,newCost});
				}
			}
		}
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String [] inp = br.readLine().split(" ");
		StringTokenizer st=null;
		int V=Integer.parseInt(inp[0]);
		int E=Integer.parseInt(inp[1]);
		int start=Integer.parseInt(br.readLine());
		
		int [] cost=new int[V+1];
		Arrays.fill(cost,Integer.MAX_VALUE);
		Edge[] graph=new Edge[V+1];

		for(int i=1;i<=E;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int from=Integer.parseInt(st.nextToken());
			int to=Integer.parseInt(st.nextToken());
			int weight=Integer.parseInt(st.nextToken());
			graph[from]=new Edge(to,weight,graph[from]);
		}
		
		dijkstra(start,graph,cost);
		
		for(int i=1;i<=V;i++) {
			if(cost[i]==Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(cost[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
