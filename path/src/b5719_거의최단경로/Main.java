package b5719_거의최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static class Edge{
		int from;
		int to;
		int weight;
		Edge link;
		boolean flag;
		public Edge(int from, int to, int weight, Edge link, boolean flag) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
			this.link = link;
			this.flag = flag;
		}
		
		
		
	}
	
	static class Point{
		int from;
		Edge edge;
		public Point(int from, Edge edge) {
			super();
			this.from = from;
			this.edge = edge;
		}
	}
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		while(N!=0&&M!=0) {
			
			Edge [] graph=new Edge[N];
			int[] cost=new int[N];
			Arrays.fill(cost, Integer.MAX_VALUE);
			st=new StringTokenizer(br.readLine()," ");
			int S=Integer.parseInt(st.nextToken());
			int D=Integer.parseInt(st.nextToken());
			
			cost[S]=0;
			for(int i=0;i<M;i++) {
				st=new StringTokenizer(br.readLine()," ");
				
				int from=Integer.parseInt(st.nextToken());
				int to=Integer.parseInt(st.nextToken());
				int c=Integer.parseInt(st.nextToken());
				graph[from]=new Edge(from,to, c, graph[from], true);
				
			}
			
			dijkstra(graph,cost,S,D,true);
			
			if(cost[D]==Integer.MAX_VALUE) {
				sb.append("-1\n");
				st=new StringTokenizer(br.readLine()," ");
				N=Integer.parseInt(st.nextToken());
				M=Integer.parseInt(st.nextToken());
				continue;
			}
			Arrays.fill(cost, Integer.MAX_VALUE);
			cost[S]=0;
			dijkstra(graph,cost,S,D,false);
			if(cost[D]==Integer.MAX_VALUE) {
				sb.append("-1\n");
			}else sb.append(cost[D]+"\n");
			
			st=new StringTokenizer(br.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			
			
		}
		System.out.println(sb.toString());
		
	}

	private static void dijkstra(Edge[] graph,int[]cost, int s, int d,boolean type) {
		
		PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		
		pq.add(new int[] {s,0});
		
		LinkedList<Edge> []minPath=new LinkedList[N];
		for(int i=0;i<N;i++) {
			minPath[i]=new LinkedList<>();
		}
		
		
		
		while(!pq.isEmpty()) {
			
			int[] curr=pq.poll();
			
			if(curr[0]==d) break;
			
			if(cost[curr[0]]<curr[1]) continue;
			
			for(Edge e=graph[curr[0]];e!=null;e=e.link) {
				if(e.flag==false) continue;
				int newCost=curr[1]+e.weight;
				
				if(newCost<cost[e.to]) {
					minPath[e.to].clear();
					minPath[e.to].add(e);
					cost[e.to]=newCost;
					pq.add(new int[] {e.to,newCost});
				}else if(newCost==cost[e.to]) {
					minPath[e.to].add(e);
				}
				
			}
		}
		if (type) {
			boolean[] check=new boolean[N];
			ArrayDeque<Integer> q = new ArrayDeque<>();
			q.add(d);
			check[d]=true;

			while (!q.isEmpty()) {
				int tmp = q.poll();
				for (Edge e : minPath[tmp]) {
					e.flag = false;
					if(!check[e.from]) {
						q.add(e.from);
						check[e.from]=true;
					}
				}
			}
		}
	}
}
