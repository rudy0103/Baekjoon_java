package b1766_문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Edge {
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] cnt = new int[N + 1];
		Edge[] graph = new Edge[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from] = new Edge(to, graph[from]);
			cnt[to]++;
		}

		List<Integer> res = topological(graph,cnt, N, M);
		for(int n:res) {
			sb.append(n).append(" ");
		}
		System.out.println(sb.toString());
	}

	private static List<Integer> topological(Edge[] graph,int[] cnt, int n, int m) {
		List<Integer> list = new LinkedList<Integer>();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		
		for(int i=1;i<cnt.length;i++) {
			if(cnt[i]==0) {
				pq.add(i);
			}
		}
		
		while(!pq.isEmpty()) {
			
			int curr=pq.poll();
			list.add(curr);
			
			for(Edge e=graph[curr];e!=null;e=e.link) {
				int next=e.to;
				cnt[next]--;
				if(cnt[next]==0) {
					pq.add(next);
				}
			}
		}
		
		
		
		
		
		
		return list;
	}
}
