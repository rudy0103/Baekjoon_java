package b17086_아기상어2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		ArrayDeque<int[]> dq = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					dq.add(new int[] { i, j, 1 });
				} else {
					map[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		int[] dr = { -1, 1, 0, 0, 1, 1, -1, -1 };
		int[] dc = { 0, 0, -1, 1, 1, -1, 1, -1 };

		while (!dq.isEmpty()) {
			int[] now = dq.poll();

			for (int d = 0; d < 8; d++) {
				int nr = now[0] + dr[d];
				int nc = now[1] + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] <= now[2] + 1)
					continue;
				map[nr][nc] = now[2] + 1;
				dq.add(new int[] { nr, nc, now[2] + 1 });
			}
		}

		int max = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1)
					continue;
				max = Math.max(max, map[i][j]);
			}
		}
		if(max==0) System.out.println(0);
		else System.out.println(max - 1);

	}

	private static void printMap(int[][] map) {
		System.out.println("=====================");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
