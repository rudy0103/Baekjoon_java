package b10999_구간합구하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long[] tree;
	static long[] lazy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		long[] arr = new long[N];
		tree = new long[4 * N];
		lazy = new long[4 * N];

		for (int i = 0; i < N; i++)
			arr[i] = Long.parseLong(br.readLine());

		makeTree(arr, 1, 0, N - 1);

		int len = M + K;
		for (int i = 0; i < len; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			b--;
			c--;
			if (a == 1) {
				long d = Long.parseLong(st.nextToken());
				update(d, b, c, 1, 0, N - 1);
			} else {
				sb.append(getSum(b, c, 1, 0, N - 1)).append("\n");
			}

		}

		System.out.println(sb.toString());

	}

	private static long getSum(int left, int right, int node, int nodeLeft, int nodeRight) {

		updateLazy(node, nodeLeft, nodeRight);
		
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

	private static void update(long val, int b, int c, int node, int nodeLeft, int nodeRight) {

		updateLazy(node, nodeLeft, nodeRight);
		
		if (c < nodeLeft || b > nodeRight) {
			return;
		}

		//완전히 포함되는 범위
		if(nodeLeft>=b&&nodeRight<=c) {
			tree[node]+=(nodeRight-nodeLeft+1)*val;
			if(nodeLeft!=nodeRight) {
				lazy[node*2]+=val;
				lazy[node*2+1]+=val;
			}
			return;
		}

		int mid = (nodeLeft + nodeRight) / 2;

		update(val, b, c, node * 2, nodeLeft, mid);
		update(val, b, c, node * 2 + 1, mid + 1, nodeRight);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];

	}
	
	public static void updateLazy(int node, int left, int right) {
		//현재 노드의 lazy 값을 반영함
		if(lazy[node]!=0) {
			tree[node]+=(right-left+1)*lazy[node];
			if(left!=right) {
				//구간 노드라면, 양쪽 자식에 lazy 값을 물려줌
				lazy[node*2]+=lazy[node];
				lazy[node*2+1]+=lazy[node];
				
			}
			lazy[node]=0;
		}
	}

}
