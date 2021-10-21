package b21610_마법사상어와비바라기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] cloud;
	static int[] dr = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { -1, -1, 0, 1, 1, 1, 0, -1 };

	static ArrayDeque<int[]> q = new ArrayDeque<>();
	static ArrayDeque<int[]> q2 = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		cloud = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		q.add(new int[] { N - 1, 0 });
		q.add(new int[] { N - 1, 1 });
		q.add(new int[] { N - 2, 0 });
		q.add(new int[] { N - 2, 1 });
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			viva(d - 1, s);
		}
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				res += map[i][j];
			}
		}
		System.out.println(res);
	}

	private static void viva(int d, int s) {

		int tmpS = s;
		if (d == 0 || d == 2 || d == 4 || d == 6) {
			tmpS %= N;
		}

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];

			int ss = tmpS;

			while (ss-- > 0) {
				r += dr[d];
				c += dc[d];
				if (r == -1)
					r = N - 1;
				else if (r == N)
					r = 0;
				if (c == -1)
					c = N - 1;
				else if (c == N)
					c = 0;
			}
			cloud[r][c] = true;
			map[r][c]++;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cloud[i][j])
					copyWater(i, j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cloud[i][j]) {
					cloud[i][j] = false;
				} else if (map[i][j] >= 2) {
					map[i][j] -= 2;
					q.add(new int[] { i, j });
				}
			}
		}

	}

	private static void copyWater(int r, int c) {
		int cnt = 0;

		for (int d = 1; d <= 7; d += 2) {
			int rr = r + dr[d];
			int cc = c + dc[d];
			if (rr >= 0 && rr < N && cc >= 0 && cc < N && map[rr][cc] >= 1) {
				cnt++;
			}
		}
		map[r][c] += cnt;

	}

}
