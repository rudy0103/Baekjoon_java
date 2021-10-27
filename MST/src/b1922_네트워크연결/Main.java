package b1922_네트워크연결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		arr = new int[N + 1];

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.add(new int[] { s, d, c });
		}

		for (int i = 1; i <= N; i++)
			arr[i] = i;

		int totalCost = 0;

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int a = curr[0];
			int b = curr[1];
			int c = curr[2];
			if (union(a, b))
				totalCost += c;

		}

		System.out.println(totalCost);
	}

	private static boolean union(int a, int b) {
		int A = find(a);
		int B = find(b);

		if (A == B)
			return false;
		else {
			arr[A] = B;
			return true;
		}
	}

	private static int find(int x) {
		if (x == arr[x])
			return x;
		else
			return arr[x] = find(arr[x]);
	}

}
