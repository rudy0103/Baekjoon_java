package b2178_미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = br.readLine().split(" ");
		Queue<int[]> q = new LinkedList<int[]>();

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		int N = Integer.parseInt(inp[0]);
		int M = Integer.parseInt(inp[1]);
		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		q.add(new int[] { 0, 0 });
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			visited[tmp[0]][tmp[1]] = true;

			for (int dir = 0; dir < 4; dir++) {
				int rr = tmp[0] + dr[dir];
				int cc = tmp[1] + dc[dir];

				if (rr >= 0 && rr < N && cc >= 0 && cc < M && map[rr][cc] == 1 && visited[rr][cc] == false) {
					map[rr][cc] = map[tmp[0]][tmp[1]] + 1;
					q.add(new int[] { rr, cc });
				}

			}
		}
		System.out.println(map[N - 1][M - 1]);
	}
}
