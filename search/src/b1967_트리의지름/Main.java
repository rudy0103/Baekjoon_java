package b1967_트리의지름;

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

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		for (int i = 0; i <= N; i++)
			tree.add(new ArrayList<int[]>());

		String inp = null;
		while ((inp = br.readLine()) != null) {
			st = new StringTokenizer(inp, " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			tree.get(from).add(new int[] { to, weight });
		}

		dfs(1);
		System.out.println(max);
	}

	private static int dfs(int n) {
		if (tree.get(n).size() == 0)
			return 0;

		int ret = 0;
		ArrayList<int[]> list = tree.get(n);
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		for (int i = 0; i < list.size(); i++) {
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
		pq.clear();
		return ret;
	}

}
