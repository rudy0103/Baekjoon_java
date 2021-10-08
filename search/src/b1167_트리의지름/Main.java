package b1167_트리의지름;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int max;
	static ArrayList<ArrayList<int[]>> tree = new ArrayList<>();
	static boolean[] visited = new boolean[100001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i <= N; i++)
			tree.add(new ArrayList<int[]>());

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			while (true) {
				int to = Integer.parseInt(st.nextToken());
				if (to == -1)
					break;
				int weight = Integer.parseInt(st.nextToken());
				tree.get(from).add(new int[] { to, weight });
			}

		}
		dfs(1);
		System.out.println(max);
	}

	private static int dfs(int n) {
		visited[n] = true;

		if (tree.get(n).size() == 0)
			return 0;

		int ret = 0;
		ArrayList<int[]> list = tree.get(n);
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		for (int i = 0; i < list.size(); i++) {
			if (visited[list.get(i)[0]])
				continue;
			int tmp = dfs(list.get(i)[0]) + list.get(i)[1];
			if (ret < tmp)
				ret = tmp;
			pq.add(tmp);
		}

		int A = 0;
		int B = 0;
		if (!pq.isEmpty())
			A = pq.poll();
		if (!pq.isEmpty())
			B = pq.poll();
		if (A + B > max)
			max = A + B;
		return ret;
	}

}
