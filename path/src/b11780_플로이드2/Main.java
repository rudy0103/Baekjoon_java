package b11780_플로이드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[][] adj = new int[N + 1][N + 1];

		LinkedList<Integer>[][] list = new LinkedList[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (adj[s][e] == 0)
				adj[s][e] = c;
			else
				adj[s][e] = Math.min(adj[s][e], c);
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (adj[i][j] == 0)
					adj[i][j] = 123456789;
				list[i][j] = new LinkedList<>();
			}
		}

		// 경출도

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (i == k)
					continue;
				for (int j = 1; j <= N; j++) {
					if (j == k || j == i)
						continue;
					if (adj[i][j] > adj[i][k] + adj[k][j]) {
						adj[i][j] = adj[i][k] + adj[k][j];
						list[i][j].clear();
						for (int n : list[i][k]) {
							list[i][j].add(n);
						}
						list[i][j].add(k);
						for (int n : list[k][j]) {
							list[i][j].add(n);
						}
					}
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (adj[i][j] == 123456789)
					sb.append("0 ");
				else
					sb.append(adj[i][j] + " ");
			}
			sb.append("\n");
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (adj[i][j] >= 123456789)
					sb.append("0\n");
				else {
					sb.append(list[i][j].size() + 2 + " ");
					sb.append(i + " ");
					for (int k : list[i][j]) {
						sb.append(k + " ");
					}
					sb.append(j + "\n");
				}
			}
		}

		System.out.println(sb.toString());
	}
}
