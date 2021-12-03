package b1005_ACM_Craft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

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
			LinkedList<LinkedList<Integer>> graph = new LinkedList<>();

			for (int i = 0; i <= N; i++)
				graph.add(new LinkedList<Integer>());

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				graph.get(from).add(to);
				cnt[to]++;
			}

			int target = Integer.parseInt(br.readLine());
			totologicalSort(target, graph, cnt, dp, cost);
			sb.append(dp[target] + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void totologicalSort(int target, LinkedList<LinkedList<Integer>> graph, int[] cnt, int[] dp,
			int[] cost) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		int N = cnt.length - 1;
		for (int i = 1; i <= N; i++) {
			if (cnt[i] == 0)
				q.add(i);
		}

		for (int i = 1; i <= N; i++) {
			int from = q.poll();
			for (int next : graph.get(from)) {
				cnt[next]--;
				dp[next] = Math.max(dp[next], dp[from] + cost[next]);
				if (cnt[next] == 0) {
					q.add(next);
					if(next==target) return;
				}
			}
		}
	}
}
