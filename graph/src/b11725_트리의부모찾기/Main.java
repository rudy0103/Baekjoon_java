package b11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int child;
		Node link;

		public Node(int child, Node link) {
			super();
			this.child = child;
			this.link = link;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] visited = new int[N + 1];

		Node[] graph = new Node[N + 1];

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[p] = new Node(c, graph[p]);
			graph[c] = new Node(p, graph[c]);
		}

		ArrayDeque<Integer> dq = new ArrayDeque<>();
		dq.add(1);
		visited[1] = 1;
		while (!dq.isEmpty()) {
			int v=dq.poll();
			
			for(Node node=graph[v];node!=null;node=node.link) {
				int child=node.child;
				if(visited[child]!=0) continue;
				visited[child]=v;
				dq.add(child);
			}
			
		}
		
		for(int i=2;i<=N;i++) {
			sb.append(visited[i]+"\n");
		}
		System.out.println(sb.toString());

	}

}
