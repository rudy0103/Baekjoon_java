package b1068_트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class Main {

	static class Node {
		int v;
		Node link;

		public Node(int v, Node link) {
			super();
			this.v = v;
			this.link = link;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int root = -1;
		int cnt = 0;

		Node[] tree = new Node[N];

		for (int i = 0; i < N; i++) {
			int parents = Integer.parseInt(st.nextToken());
			if (parents == -1)
				root = i;
			else {
				tree[parents] = new Node(i, tree[parents]);
			}
		}

		int removed = Integer.parseInt(br.readLine());
		
		int removedNodeParents = -1;
		tree[removed] = null;

		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(root);

		while (!q.isEmpty()) {
			int p = q.poll();
			if (tree[p] == null) {
				cnt++;
				continue;
			}

			for (Node n = tree[p]; n != null; n = n.link) {

				if (n.v == removed) {
					removedNodeParents = p;
					continue;
				}
				q.add(n.v);
			}
		}

		if (removedNodeParents != -1) {
			int tmpCnt = 0;
			for (Node n = tree[removedNodeParents]; n != null; n = n.link) {
				if (n.v != removed) {
					tmpCnt++;
					break;
				}
			}
			if (tmpCnt == 0)
				cnt++;
			System.out.println(cnt);
		}else {
			System.out.println(0);
		}

	}
}
