package b1068_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int cnt = 0;

	static class Node {
		int v;
		Node link;

		public Node(int v, Node link) {
			this.v = v;
			this.link = link;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int root = -1;

		StringTokenizer st = new StringTokenizer(br.readLine());

		Node[] tree = new Node[N];

		for (int i = 0; i < N; i++) {
			int p = Integer.parseInt(st.nextToken());
			if (p == -1) {
				root = i;
				continue;
			}
			tree[p] = new Node(i, tree[p]);
		}

		int removedNode = Integer.parseInt(br.readLine());

		searchTree(tree, root, removedNode);
		System.out.println(cnt);

	}

	private static void searchTree(Node[] tree, int root, int removedNode) {

		if(root==removedNode) return;
		ArrayDeque<Integer> dq = new ArrayDeque<>();

		dq.add(root);

		while (!dq.isEmpty()) {
			int v = dq.poll();

			boolean flag = false;
			for (Node node = tree[v]; node != null; node = node.link) {
				if (node.v == removedNode) {
					continue;
				}
				dq.add(node.v);
				flag = true;
			}
			if (flag == false)
				cnt++;
		}

	}

}
