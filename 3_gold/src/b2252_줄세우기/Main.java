package b2252_줄세우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge{
		int to;
		Edge link;
		
		public Edge(int to, Edge link) {
			this.to=to;
			this.link=link;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];

		
		Edge[] graph=new Edge[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			graph[A]=new Edge(B, graph[A]);
			arr[B]++;
		}

		StringBuilder sb = new StringBuilder();
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		
		for(int i=1;i<=N;i++) {
			if(arr[i]==0) dq.add(i);
		}
		
		
		while(!dq.isEmpty()) {
			int s=dq.poll();
			
			sb.append(s).append(" ");
			
			for(Edge edge=graph[s];edge!=null;edge=edge.link) {
				int to=edge.to;
				arr[to]--;
				
				if(arr[to]==0) {
					dq.add(to);
				}
				
			}
			
		}
		System.out.println(sb.toString());
		
		

	}

}
