package b15661_링크와스타트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int min = Integer.MAX_VALUE;
	static int[] startTeam, linkTeam;
	static boolean[] team;

	static int getSum(int[] team, int[][] arr) {
		int sum = 0;
		for (int i = 0; i < team.length - 1; i++)
			for (int j = i + 1; j < team.length; j++)
				sum += (arr[team[i]][team[j]] + arr[team[j]][team[i]]);

		return sum;
	}

	static void backtracking(int depth, int s, int[][] arr, int N) {
		if (depth == N ) {
			int idx = 0;
			for (int i = 0; i < team.length; i++)
				if (!team[i])
					linkTeam[idx++] = i;

			int gap = Math.abs(getSum(startTeam, arr) - getSum(linkTeam, arr));

			if (gap < min)
				min = gap;

			return;
		}
		for (int i = s; i < arr.length; i++) {
			startTeam[depth] = i;
			team[i] = true;
			backtracking(depth + 1, i + 1, arr, N);
			team[i] = false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N / 2; i++) {
			team = new boolean[N];
			startTeam = new int[i];
			linkTeam = new int[N-i];
			backtracking(0, 0, arr, i);
		}

		System.out.println(min);

	}
}
