package b1325_효율적인해킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		String[] inp = br.readLine().split(" ");
		int N = Integer.parseInt(inp[0]);
		int M = Integer.parseInt(inp[1]);

		int[] arr = new int[N + 1];

		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			graph.add(new ArrayList<>());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int end = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			graph.get(start).add(end);
		}

		int max = -1;
		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			q.offer(i);
			boolean [] visited=new boolean[N+1];
			visited[i] = true;
			int cnt = 0;

			while (!q.isEmpty()) {
				int tmp = q.poll();
				cnt++;
				for (int next : graph.get(tmp)) {
					if (!visited[next]) {
						visited[next] = true;
						q.offer(next);
					}
				}
			}
			arr[i] = cnt;
			if (max < cnt)
				max = cnt;
		}

		for(int i=1; i<=N; i++) {
			if(arr[i]==max)sb.append(i).append(" ");
		}sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
