package b18430_무기공학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, max;

	static int[][] shape = { { 0, 1, 3 }, { 0, 2, 3 }, { 0, 1, 4 }, { 0, 2, 4 } };
	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if (N != 1 || M != 1) {
			backtracking(map, 0, 0, new boolean[N][M]);
		}

		System.out.println(max);

	}

	private static void backtracking(int[][] map, int depth, int sum, boolean[][] visited) {

		if (depth >= N * M) {
			max = Math.max(max, sum);
			return;
		}

		int r = depth / M;
		int c = depth % M;

		for (int s = 0; s < 4; s++) {
			if(visited[r][c]) break;
			if (isPossible(visited, r, c, s)) {
				checkVisited(visited, r, c, s, true);
				int ss = sum + getSum(map, r, c, s);
				backtracking(map, depth + 1, ss, visited);
				checkVisited(visited, r, c, s, false);
			}
		}

		backtracking(map, depth + 1, sum, visited);

	}

	private static int getSum(int[][] map, int r, int c, int s) {
		int sum = 0;
		for (int i = 0; i < shape[s].length; i++) {
			int nr = r + dr[shape[s][i]];
			int nc = c + dc[shape[s][i]];
			if (i == 0) {
				sum += map[nr][nc] * 2;
			} else
				sum += map[nr][nc];
		}
		return sum;

	}

	private static boolean isPossible(boolean[][] visited, int r, int c, int s) {

		for (int i = 0; i < shape[s].length; i++) {
			int nr = r + dr[shape[s][i]];
			int nc = c + dc[shape[s][i]];
			if (!check(nr, nc, visited)) {
				return false;
			}
		}

		return true;

	}

	private static boolean check(int r, int c, boolean[][] visited) {

		if (r < 0 || r >= N || c < 0 || c >= M || visited[r][c])
			return false;

		return true;
	}

	private static void checkVisited(boolean[][] visited, int r, int c, int s, boolean b) {

		for (int i = 0; i < shape[s].length; i++) {
			int nr = r + dr[shape[s][i]];
			int nc = c + dc[shape[s][i]];
			visited[nr][nc] = b;
		}

	}

}
