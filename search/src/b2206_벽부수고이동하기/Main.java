package b2206_벽부수고이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = br.readLine().split(" ");
		ArrayDeque<int[]> q = new ArrayDeque<int[]>();
		int N = Integer.parseInt(inp[0]);
		int M = Integer.parseInt(inp[1]);
		int[][] visited = new int[N][M];
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++)
				map[i][j] = input.charAt(j)-'0';
		}
		boolean flag = false;
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		map[0][0] = 1;
		visited[0][0] = 1;
		q.add(new int[] { 0, 0, 1, 1 });
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			if (tmp[0] == N - 1 && tmp[1] == M - 1) {
				System.out.println(tmp[3]);
				flag = true;
				break;
			}
			for (int d = 0; d < 4; d++) {
				int rr = tmp[0] + dr[d];
				int cc = tmp[1] + dc[d];
				if (rr >= 0 && rr < N && cc >= 0 & cc < M) {
					if (map[rr][cc] == 0 & visited[rr][cc] == 0) {
						if (tmp[2] == 1)
							visited[rr][cc] = 1;
						else
							visited[rr][cc] = 2;
						q.add(new int[] { rr, cc, tmp[2], tmp[3] + 1 });
					} else if (map[rr][cc] == 0 & visited[rr][cc] == 2 && tmp[2] == 1) {
						visited[rr][cc] = 1;
						q.add(new int[] { rr, cc, tmp[2], tmp[3] + 1 });
					} else if (map[rr][cc] == 1 && tmp[2] == 1) {
						q.add(new int[] { rr, cc, tmp[2] - 1, tmp[3] + 1 });
						visited[rr][cc] = 1;
					}
				}
			}
		}

		if (!flag)
			System.out.println(-1);

	}
}