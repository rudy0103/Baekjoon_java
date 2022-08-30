package b2644_촌수계산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine());

		int[] parents = new int[n + 1];

		for (int i = 1; i <= n; i++)
			parents[i] = i;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());// pa
			int y = Integer.parseInt(st.nextToken());// ch
			parents[y] = x;
		}
		int root = getRoot(parents, a, b);
		if (root != 0) {
			int chonA = getChon(parents, a, root, 0);
			int chonB = getChon(parents, b, root, 0);
			System.out.println(chonA + chonB);
		} else
			System.out.println("-1");

	}

	private static int getRoot(int[] parents, int a, int b) {

		boolean[] check = new boolean[parents.length];

		checkRoot(check, parents, a);

		int root = b;

		while (check[root] == false) {
			root = parents[root];
			if (root == parents[root])
				break;
		}

		if (check[root])
			return root;
		return 0;

	}

	private static void checkRoot(boolean[] check, int[] parents, int a) {
		check[a] = true;
		if (parents[a] == a)
			return;
		else
			checkRoot(check, parents, parents[a]);
	}

	private static int getChon(int[] parents, int a, int root, int chon) {
		if (a == root)
			return chon;
		return getChon(parents, parents[a], root, chon + 1);
	}

}
