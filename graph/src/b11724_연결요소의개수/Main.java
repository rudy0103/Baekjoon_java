package b11724_연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Node{
	int vertex;
	Node link;
	public Node(int vertex, Node link) {
		super();
		this.vertex = vertex;
		this.link = link;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = br.readLine().split(" ");
		StringTokenizer st = null;
		int N = Integer.parseInt(inp[0]);
		int M = Integer.parseInt(inp[1]);
		Node[] graph = new Node[N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from]=new Node(to, graph[from]);
			graph[to]= new Node(from,graph[to]);
		}

		boolean[] visited = new boolean[N + 1];

		ArrayDeque<Integer> q = new ArrayDeque<>();
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (visited[i] == false) {
				cnt++;
				visited[i] = true;
				q.add(i);
				while (!q.isEmpty()) {
					int node=q.poll();
					for (Node curr=graph[node] ;curr!=null; curr=curr.link) {
						if (!visited[curr.vertex]) {
							q.add(curr.vertex);
							visited[curr.vertex]=true;
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
