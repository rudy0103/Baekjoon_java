package b4256_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] preorder = new int[1001];
	static int[] inorder = new int[1001];
	static int[] inOrderIdx;
	static int[] preOrderIdx;

	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 0; tc < T; tc++) {
			StringBuilder post = new StringBuilder();
			N = Integer.parseInt(br.readLine());
			inOrderIdx= new int[N+1];
			preOrderIdx = new int[N+1];

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= N; i++) {
				preorder[i] = Integer.parseInt(st.nextToken());
				preOrderIdx[preorder[i]]=i;
			}

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= N; i++) {
				inorder[i] = Integer.parseInt(st.nextToken());
				inOrderIdx[inorder[i]]=i;
			}
			int root = preorder[1];

			makeTree(root, 0, N + 1, post);

			sb.append(post.toString()).append("\n");
		}

		System.out.println(sb.toString());

	}

	private static void makeTree(int root, int leftIdx, int rightIdx, StringBuilder sb) {

		int rootIdx = inOrderIdx[root];

		int rootIdxInPre = preOrderIdx[root];
		int leftCnt = rootIdx - leftIdx - 1;

		if (rootIdxInPre + 1 <= N) {
			int idx=inOrderIdx[preorder[rootIdxInPre+1]];
			if (idx < rootIdx && idx > leftIdx) {
				makeTree(preorder[rootIdxInPre + 1], leftIdx, rootIdx, sb);
			}
		}

		if (rootIdxInPre + leftCnt + 1 <= N) {
			int idx=inOrderIdx[preorder[rootIdxInPre + leftCnt + 1]];
			if (idx < rightIdx && idx > rootIdx) {
				makeTree(preorder[rootIdxInPre + leftCnt + 1], rootIdx, rightIdx, sb);
			}
		}
		sb.append(root).append(" ");
	}
}
