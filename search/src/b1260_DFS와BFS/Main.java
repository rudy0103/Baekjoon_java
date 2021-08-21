package b1260_DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void dfs(int s, ArrayList<LinkedList<Integer>> list, boolean[] visited) {

		LinkedList<Integer> li = list.get(s);

		visited[s] = true;
		sb.append(s).append(" ");
		for (int n : li) {
			if (!visited[n]) {
				dfs(n, list, visited);
			}
		}
	}

	public static void bfs(int s, ArrayList<LinkedList<Integer>> list, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		visited[s] = true;
		while (!q.isEmpty()) {
			int e = q.poll();
			sb.append(e).append(" ");

			for (int n : list.get(e)) {
				if (!visited[n]) {
					q.add(n);
					visited[n]=true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = br.readLine().split(" ");

		int E = Integer.parseInt(inp[0]);
		int V = Integer.parseInt(inp[1]);
		int S = Integer.parseInt(inp[2]);
		ArrayList<LinkedList<Integer>> list = new ArrayList<>(E + 1);
		for (int i = 1; i <= E + 1; i++)
			list.add(new LinkedList<Integer>());

		for (int i = 0; i < V; i++) {
			inp = br.readLine().split(" ");
			list.get(Integer.parseInt(inp[0])).add(Integer.parseInt(inp[1]));
			list.get(Integer.parseInt(inp[1])).add(Integer.parseInt(inp[0]));
		}
		for (LinkedList<Integer> l : list) {
			Collections.sort(l);
		}

		dfs(S, list, new boolean[E + 1]);
		sb.append("\n");
		bfs(S, list, new boolean[E + 1]);

		System.out.println(sb.toString());

	}

}
