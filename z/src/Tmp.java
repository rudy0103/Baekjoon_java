

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Tmp {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int[] cost = new int[N + 1];
			int[] dp = new int[N + 1];
			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 1; i <= N; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
				dp[i] = cost[i];
			}
			int[] cnt = new int[N + 1];
			int[] tmpCnt = new int[N + 1];
			boolean[] visited = new boolean[N + 1];
			LinkedList<LinkedList<Integer>> graph = new LinkedList<>();

			for (int i = 0; i <= N; i++)
				graph.add(new LinkedList<Integer>());

			LinkedList<int[]> list = new LinkedList<>();
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				graph.get(from).add(to);
				tmpCnt[to]++;
				list.add(new int[] { from, to });
			}

			for (int i = 1; i <= N; i++) {
				if (tmpCnt[i] == 0) {
					ArrayDeque<Integer> q = new ArrayDeque<>();
					q.add(i);
					while (!q.isEmpty()) {
						int from = q.poll();

						for(int j = 0; j < graph.get(from).size(); j++) {
							int to = graph.get(from).get(j);
							if (visited[to])
								continue;
							if (cnt[from] + 1 > cnt[to]) {
								cnt[to] = cnt[from] + 1;
							}
							visited[to]=true;
							q.add(to);
						}
					}
				}
			}

			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});

			while (!list.isEmpty()) {
				int[] item = new int[3];
				int[] tmp = list.poll();
				item[0] = tmp[0];
				item[1] = tmp[1];
				item[2] = cnt[tmp[1]];
				pq.add(item);
			}

			while (!pq.isEmpty()) {
				int[] d = pq.poll();
				int from = d[0];
				int to = d[1];
				dp[to] = Math.max(dp[to], dp[from] + cost[to]);
			}

			int target = Integer.parseInt(br.readLine());

			sb.append(dp[target] + "\n");
		}
		System.out.println(sb.toString());
	}
}
