package b17471_게리맨더링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] adj;
	static int[] selected, population;
	static int[] divided;
	static int min = 12345678;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		population = new int[N+1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		adj = new int[N + 1][N + 1]; // 인접 행렬

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int to = Integer.parseInt(st.nextToken());
				adj[i][to] = 1;
			}
		}
		divided = new int[N + 1];

		for (int i = 1; i <= N - 1; i++) {
			selected = new int[i];
			makeCombination(0, i, 1);
		}
		if (min == 12345678)
			System.out.println(-1);
		else
			System.out.println(min);

	}

	private static void makeCombination(int d, int end, int start) {
		if (d == end) {
			Arrays.fill(divided, 2);
			for (int i = 1; i < selected.length; i++) {
				divided[selected[i]] = -2;
			}
			divided[selected[0]]++;
			dfs(selected[0], 1);
			for (int i = 1; i <= N; i++)
				if (divided[i] == -2)
					return;

			for (int i = 1; i <= N; i++) {
				if (divided[i] == 2) {
					divided[i]--;
					dfs(i, -1);
					break;
				}
			}
			for (int i = 1; i <= N; i++)
				if (divided[i] == 2)
					return;
			int tmpA=0;
			int tmpB=0;
			for(int i=1;i<=N;i++) {
				if(divided[i]==1) tmpA+=population[i];
				else tmpB+=population[i];
			}
			
			if(Math.abs(tmpA-tmpB)<min) min=Math.abs(tmpA-tmpB);
			return;

		}

		for (int i = start; i <= N; i++) {
			selected[d] = i;
			makeCombination(d + 1, end, i + 1);
		}

	}

	private static void dfs(int start, int k) {

		for (int i = 1; i <= N; i++) {
			if (adj[start][i] == 1 && divided[i] == k * (-2)) {
				divided[i] += k;
				dfs(i, k);
			}
		}

	}

}
