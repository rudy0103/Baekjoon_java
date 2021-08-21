package b7569_토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = br.readLine().split(" ");
		StringTokenizer st = null;
		Queue<int[]> q = new LinkedList<>();
		int M = Integer.parseInt(inp[0]);
		int N = Integer.parseInt(inp[1]);
		int H = Integer.parseInt(inp[2]);
		int[][][] map = new int[H][N][M];
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int j = 0;
				while (st.hasMoreTokens()) {
					map[h][i][j] = Integer.parseInt(st.nextToken());
					if (map[h][i][j] == 1)
						q.add(new int[] { h, i, j });
					j++;
				}
			}
		}
		if (q.isEmpty()) {
			System.out.println(-1);
			return;
		}
		int[] dh = { 0, 0, 0, 0, -1, 1 };
		int[] dr = { -1, 1, 0, 0, 0, 0 };
		int[] dc = { 0, 0, -1, 1, 0, 0 };
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int d = 0; d < 6; d++) {
				int hh = tmp[0] + dh[d];
				int rr = tmp[1] + dr[d];
				int cc = tmp[2] + dc[d];
				if (rr >= 0 && rr < N && cc >= 0 && cc < M && hh >= 0 && hh < H && map[hh][rr][cc] == 0) {
					map[hh][rr][cc] = map[tmp[0]][tmp[1]][tmp[2]] + 1;
					q.add(new int[] { hh, rr, cc });
				}
			}
		}
		int min = 0;
		for (int h = 0; h < H; h++)
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[h][i][j] == 0) {
						System.out.println(-1);
						return;
					} else if (map[h][i][j] > min)
						min = map[h][i][j];
				}
			}
		System.out.println(min - 1);
	}
}
