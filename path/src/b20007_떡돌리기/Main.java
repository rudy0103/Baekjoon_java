package b20007_떡돌리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int to;
		int w;
		Node link;

		public Node(int to, int w, Node link) {
			super();
			this.to = to;
			this.w = w;
			this.link = link;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		int[] cost = new int[N];

		Node[] gragh = new Node[N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			gragh[from] = new Node(to, w, gragh[from]);
			gragh[to] = new Node(from, w, gragh[to]);
		}
		
		dijkstra(cost,Y,gragh);
		
		boolean possible =true;
		
		for(int c:cost) {
			if(c*2>X) possible=false;
		}

		
		if(possible) {
			int day=1;
			Arrays.sort(cost);
			int dist=X;
			
			for(int i=0;i<N;i++) {
				if(dist-cost[i]*2>=0) dist-=cost[i]*2;
				else {
					day++;
					dist=X-cost[i]*2;
				}
			}
			
			System.out.println(day);
			
			
		}else System.out.println(-1);
		

	}

	private static void dijkstra(int[] cost, int y,Node[] gragh) {
		
		Arrays.fill(cost, Integer.MAX_VALUE);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		
		cost[y]=0;
		pq.add(new int[] {y,0});
		
		while(!pq.isEmpty()) {
			int [] curr=pq.poll();
			
			int now=curr[0];
			
			if(cost[now]<curr[1]) continue;
			
			
			for(Node node=gragh[now];node!=null;node=node.link) {
				
				int next=node.to;
				int nextCost=curr[1]+node.w;
				
				if(nextCost<cost[next]) {
					cost[next]=nextCost;
					pq.add(new int[] {next,nextCost});
				}
				
			}
			
		}
		
		
	}

}
