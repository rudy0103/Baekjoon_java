package b16234_인구이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static int N, L, R;
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };
	static ArrayDeque<int[]> q = new ArrayDeque<>();
	static ArrayDeque<int[]> q2 = new ArrayDeque<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];

		int day = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			boolean flag = true;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					visited[i][j] = false;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j])
						continue;
					flag = bfs(i, j, map, visited) && flag;
				}
			}

			if (flag == true)
				break;
			day++;
		}

		System.out.println(day);

	}

	private static boolean bfs(int r, int c, int[][] map, boolean[][] visited) {
		
		int cnt = 0;
		int sum = 0;
		q.add(new int[] { r, c });
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			cnt++;
			sum += map[tmp[0]][tmp[1]];
			q2.add(tmp);
			for (int i = 0; i < 4; i++) {
				int rr = tmp[0] + dr[i];
				int cc = tmp[1] + dc[i];
				if (rr >= 0 && rr < N && cc >= 0 && cc < N) {
					if (!visited[rr][cc]) {
						int gap = Math.abs(map[tmp[0]][tmp[1]] - map[rr][cc]);
						if (gap >= L && gap <= R) {
							visited[rr][cc] = true;
							q.add(new int[] { rr, cc });
						}
					}
				}
			}
		}
		if (cnt == 1) {
			q2.clear();
			return true;
		}

		int p = sum / cnt;
		while (!q2.isEmpty()) {
			int[] tmp = q2.poll();
			map[tmp[0]][tmp[1]] = p;
		}

		return false;
	}

}
