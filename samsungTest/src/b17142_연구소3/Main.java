package b17142_연구소3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int size;
	static int minTime = Integer.MAX_VALUE;
	static int[][] map;
	static int[][][] spread;
	static int[][] merged;
	static int[] selected;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static ArrayList<int[]> virus = new ArrayList<>();
	static ArrayDeque<int[]> q = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		merged = new int[N][N];
		selected = new int[M];

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virus.add(new int[] { i, j });
					cnt++;
					map[i][j] = -2;
				} else if (map[i][j] == 1) {
					map[i][j] = -1;
				} else {
					map[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		spread = new int[cnt][N][N];

		size = virus.size();
		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < N; j++)
				System.arraycopy(map[j], 0, spread[i][j], 0, N);
			bfs(i);
		}

		simul(0, 0);
		if (minTime == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(minTime);

	}

	private static void bfs(int i) {
		int[] start = virus.get(i);
		int r = start[0];
		int c = start[1];

		q.add(new int[] { r, c, 0 });

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			for (int d = 0; d < 4; d++) {
				int rr = curr[0] + dr[d];
				int cc = curr[1] + dc[d];
				if (rr >= 0 && rr < N && cc >= 0 && cc < N
						&& (spread[i][rr][cc] == Integer.MAX_VALUE || spread[i][rr][cc] == -2)) {
					q.add(new int[] { rr, cc, curr[2] + 1 });
					spread[i][rr][cc] = curr[2] + 1;
				}
			}

		}

	}

	private static void simul(int d, int start) {
		if (d == M) {

			for (int i = 0; i < N; i++)
				System.arraycopy(map[i], 0, merged[i], 0, N);

			int time = Integer.MIN_VALUE;

			for (int k = 0; k < M; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						merged[i][j] = Math.min(merged[i][j], spread[selected[k]][i][j]);
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (merged[i][j] == Integer.MAX_VALUE)
						return;
					else if (merged[i][j] >= 0)
						time = Math.max(time, merged[i][j]);
				}
			}

			if (time < minTime)
				minTime = time;
			if (minTime == Integer.MIN_VALUE)
				minTime = 0;
			return;
		}

		for (int i = start; i < size; i++) {
			selected[d] = i;
			simul(d + 1, i + 1);
		}

	}

}
