package b2243_사탕상자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int len=1000005;
		int[] tree = new int[len*4];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			String A = st.nextToken();
			if (A.charAt(0) == '1') {// B는 꺼낼 사탕의 순위
				int B = Integer.parseInt(st.nextToken());
				int f=find(tree, B, 1, 1, len, 0);
				update(tree, f, -1, 1, 1, len);
				sb.append(f).append("\n");
			} else {//
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				update(tree, B, C, 1, 1, len);
			}

		}
		System.out.println(sb.toString());
	}

	private static int find(int[] tree, long b, int node, int left, int right, int cnt) {

		if (left == right) {
			return  left;
		}

		int leftVal = tree[node * 2];
		int mid = (left + right) / 2;
		if (cnt + leftVal < b) {
			return find(tree, b, node * 2 + 1, mid + 1, right, leftVal + cnt);
		} else {
			return find(tree, b, node * 2, left, mid, cnt);
		}

	}

	private static void update(int[] tree, int index, int val, int node, int left, int right) {

		if (index < left | index > right)
			return;

		if (left == right) {
			tree[node] += val;
			return;
		}

		int mid = (left + right) / 2;

		if (index <= mid) {
			update(tree, index, val, node * 2, left, mid);
		} else {
			update(tree, index, val, node * 2 + 1, mid + 1, right);
		}

		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}
}
