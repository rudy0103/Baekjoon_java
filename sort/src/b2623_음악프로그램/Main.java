package b2623_음악프로그램;

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
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		LinkedList<LinkedList<Integer>> graph = new LinkedList<>();
		for (int i = 0; i <= N; i++)
			graph.add(new LinkedList<>());

		int[] cnt = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int K = Integer.parseInt(st.nextToken());
			if (K <= 1)
				continue;
			int from = Integer.parseInt(st.nextToken());
			for (int j = 0; j < K - 1; j++) {
				int to = Integer.parseInt(st.nextToken());
				cnt[to]++;
				graph.get(from).add(to);
				from = to;
			}
		}

		// topologicalSort
		LinkedList<Integer> res = new LinkedList<>();
		boolean flag = true;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (cnt[i] == 0)
				q.add(i);
		}

		for (int i = 0; i < N; i++) {
			if (q.isEmpty()) {
				flag = false;
				break;
			}
			int now = q.poll();
			res.add(now);
			
			for(int n:graph.get(now)) {
				cnt[n]--;
				if(cnt[n]==0) {
					q.add(n);
				}
			}
		}

		if (flag == false) {
			System.out.println(0);
		} else {
			for (int n : res) {
				sb.append(n).append("\n");
			}
			System.out.println(sb.toString());
		}

	}

}
