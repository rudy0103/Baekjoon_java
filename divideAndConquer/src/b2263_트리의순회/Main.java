package b2263_트리의순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] inOrder;
	static int[] postOrder;
	static int[] inOrderIdx;
	static int[] postOrderIdx;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		inOrder = new int[N + 1];
		postOrder = new int[N + 1];
		inOrderIdx= new int[N+1];
		postOrderIdx = new int[N+1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			inOrder[i] = Integer.parseInt(st.nextToken());
			inOrderIdx[inOrder[i]]=i;
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			postOrder[i] = Integer.parseInt(st.nextToken());
			postOrderIdx[postOrder[i]]=i;
		}
		int root = postOrder[N];

		preOrder(root, 0, N + 1, sb);
		System.out.println(sb.toString());

	}

	private static void preOrder(int root, int leftIdx, int rightIdx, StringBuilder sb) {
		sb.append(root).append(" ");

		int rootIdxInInOrder =inOrderIdx[root];
		int rootIdxInPostOrder = postOrderIdx[root];

		int rightCnt = rightIdx - rootIdxInInOrder - 1;// 

		int left = postOrder[rootIdxInPostOrder - rightCnt - 1];
		int leftChildIdx = inOrderIdx[left];
		if (leftChildIdx > leftIdx && leftChildIdx < rootIdxInInOrder) {
			preOrder(left, leftIdx, rootIdxInInOrder, sb);
		}

		int right = postOrder[rootIdxInPostOrder - 1];
		int rightChildIdx = inOrderIdx[right];
		if (rightChildIdx > rootIdxInInOrder && rightChildIdx < rightIdx) {
			preOrder(right, rootIdxInInOrder, rightIdx, sb);
		}

	}


}
