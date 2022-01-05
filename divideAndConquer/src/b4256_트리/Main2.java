package b4256_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

	static class Node {
		int v;
		int left;
		int right;

		public Node(int v, int left, int right) {
			super();
			this.v = v;
			this.left = left;
			this.right = right;
		}

	}

	static int[] preorder;
	static int[] inorder ;
	static Node[] tree = new Node[1001];

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < T; tc++) {
			StringBuilder post = new StringBuilder();
			N = Integer.parseInt(br.readLine());
			

			for (int i = 1; i <= N; i++) {
				tree[i] = new Node(i, -1, -1);
			}

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= N; i++) {
				preorder[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= N; i++) {
				inorder[i] = Integer.parseInt(st.nextToken());
			}
			int root = preorder[1];

			makeTree(root, tree, 0, N + 1);

			postOrder(tree[root], tree, post);
			sb.append(post.toString()).append("\n");
		}

		System.out.println(sb.toString());

	}

	private static void makeTree(int root, Node[] tree, int leftIdx, int rightIdx) {

		int rootIdx = getIdx(inorder, root);

		int rootIdxInPre = getIdx(preorder, root);
		int leftCnt = rootIdx - leftIdx - 1;

		if (rootIdxInPre + 1 <= N) {
			int idx = getIdx(inorder, preorder[rootIdxInPre + 1]);
			if (idx < rootIdx && idx > leftIdx) {
				tree[root].left = preorder[rootIdxInPre + 1];
				makeTree(tree[root].left, tree, leftIdx, rootIdx);
			}
		}

		if (rootIdxInPre + leftCnt + 1 <= N) {
			int idx = getIdx(inorder, preorder[rootIdxInPre + leftCnt + 1]);
			if (idx < rightIdx && idx > rootIdx) {
				tree[root].right = preorder[rootIdxInPre + leftCnt + 1];
				makeTree(tree[root].right, tree, rootIdx, rightIdx);
			}
		}
	}

	private static int getIdx(int[] arr, int key) {
		for (int i = 1; i <= N; i++) {
			if (arr[i] == key)
				return i;
		}
		return 0;
	}

	private static void postOrder(Node node, Node[] tree, StringBuilder sb) {

		if (node.left != -1) {
			postOrder(tree[node.left], tree, sb);
		}

		if (node.right != -1) {
			postOrder(tree[node.right], tree, sb);
		}

		sb.append(node.v).append(" ");
	}

}
