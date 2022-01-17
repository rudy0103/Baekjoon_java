package b2042_구간합구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		long[] arr = new long[N];
		tree = new long[4 * N];

		for (int i = 0; i < N; i++)
			arr[i] = Long.parseLong(br.readLine());

		makeTree(arr, 1, 0, N - 1);

		int len = M + K;
		for (int i = 0; i < len; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (a == 1) {
				long c = Long.parseLong(st.nextToken());
				b--;
				long val = c - arr[b];
				arr[b] = c;
				update(val, b, 1, 0, N - 1);
			} else {
				int c = Integer.parseInt(st.nextToken());
				b--;
				c--;
				sb.append(getSum(b, c, 1, 0, N - 1)).append("\n");
			}

		}

		System.out.println(sb.toString());

	}

	private static long getSum(int left, int right, int node, int nodeLeft, int nodeRight) {

		if (left > nodeRight || right < nodeLeft)
			return 0;

		if (nodeLeft >= left && nodeRight <= right)
			return tree[node];

		int mid = (nodeLeft + nodeRight) / 2;

		long leftVal = getSum(left, right, node * 2, nodeLeft, mid);
		long rightVal = getSum(left, right, node * 2 + 1, mid + 1, nodeRight);

		return leftVal + rightVal;
	}

	private static long makeTree(long[] arr, int node, int left, int right) {

		if (left == right)
			return tree[node] = arr[left];

		int mid = (left + right) / 2;

		long leftVal = makeTree(arr, node * 2, left, mid);
		long rightVal = makeTree(arr, node * 2 + 1, mid + 1, right);

		return tree[node] = leftVal + rightVal;

	}

	private static long update(long val, int b, int node, int nodeLeft, int nodeRight) {

		if (b < nodeLeft || b > nodeRight) {
			return 0;
		}

		if (nodeLeft == nodeRight)
			return tree[node] += val;

		int mid = (nodeLeft + nodeRight) / 2;

		update(val, b, node * 2, nodeLeft, mid);
		update(val, b, node * 2 + 1, mid + 1, nodeRight);
		return tree[node] += val;

	}
}
