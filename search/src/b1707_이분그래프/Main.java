package b1707_이분그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st =null;
		for (int tc = 0; tc < T; tc++) {
			String[] inp = br.readLine().split(" ");
			int V = Integer.parseInt(inp[0]);
			int E = Integer.parseInt(inp[1]);
			int[] visited = new int[V + 1];
			ArrayList<Integer>[] list = new ArrayList[V + 1];
			for (int i = 1; i <= V; i++)
				list[i] = new ArrayList<>();

			for (int i = 0; i < E; i++) {
				st=new StringTokenizer(br.readLine()," ");
				int s = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				list[s].add(d);
				list[d].add(s);
			}
			boolean flag = true;
			for (int i = 1; i <= V; i++) {
				if (!flag)
					break;
				Queue<Integer> q = new LinkedList<>();
				if (visited[i] == 0) {
					visited[i] = 1;
					q.add(i);
					while (!q.isEmpty()) {
						int tmp = q.poll();
						for (int v : list[tmp]) {
							if (visited[v] == 0) {
								visited[v] = visited[tmp] * -1;
								q.add(v);
							} else if (visited[v] == visited[tmp]) {
								flag = false;
								break;
							}
						}
					}
				}
			}
			if (flag)
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
		System.out.println(sb.toString());
	}
}
