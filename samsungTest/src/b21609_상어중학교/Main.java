package b21609_상어중학교;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] origin, copy;
	static int[][] visited;
	static ArrayDeque<int[]> q;
	static PriorityQueue<int[]> pq;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		origin = new int[N][N];
		copy = new int[N][N];
		visited = new int[N][N];
		int score = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				origin[i][j] = Integer.parseInt(st.nextToken());
		}

		pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0])
					return o2[0] - o1[0];
				else if (o1[1] != o2[1])
					return o2[1] - o1[1];
				else if (o1[2] != o2[2])
					return o2[2] - o1[2];
				else
					return o2[3] - o1[3];
			}
		});
		q = new ArrayDeque<>();
		ArrayDeque<int[]> removeQ = new ArrayDeque<>();
		while (true) {
			int g = 0;
			pq.clear();
			for (int i = 0; i < N; i++)
				Arrays.fill(visited[i], 0);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] == 0 && origin[i][j] > 0) {
						g++;
						bfs(i, j, origin[i][j], g);
					}
				}
			}
			if (pq.isEmpty())
				break;
			else {
				int[] tmp = pq.poll();
				score += (tmp[0] * tmp[0]);
				boolean[][] removed = new boolean[N][N];
				int r = tmp[2];
				int c = tmp[3];
				int n = origin[r][c];
				removeQ.add(new int[] { r, c });
				removed[r][c] = true;
				while (!removeQ.isEmpty()) {
					int[] curr = removeQ.poll();
					origin[curr[0]][curr[1]] = -2;

					for (int d = 0; d < 4; d++) {
						int rr = curr[0] + dr[d];
						int cc = curr[1] + dc[d];
						if (rr >= 0 && rr < N && cc >= 0 && cc < N && !removed[rr][cc]) {
							if (origin[rr][cc] == 0 || origin[rr][cc] == n) {
								removeQ.add(new int[] { rr, cc });
								removed[rr][cc] = true;
							}
						}
					}
				}
				gravity();
				turnMap();
				gravity();
			}
		}

		System.out.println(score);

	}
	private static void printMap(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == -2)
					System.out.print(" " + " ");
				else
					System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("==========");
	}


	private static void bfs(int r, int c, int v, int g) {
		q.clear();

		visited[r][c] = g;
		q.add(new int[] { r, c });

		int cnt = 1;
		int rainCnt = 0;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();

			for (int d = 0; d < 4; d++) {
				int rr = tmp[0] + dr[d];
				int cc = tmp[1] + dc[d];
				if (rr >= 0 && rr < N && cc >= 0 && cc < N && visited[rr][cc] != g) {
					if (origin[rr][cc] == -1)
						continue;
					if (origin[rr][cc] == 0) {
						q.add(new int[] { rr, cc });
						visited[rr][cc] = g;
						rainCnt++;
						cnt++;
					} else if (origin[rr][cc] == v) {
						q.add(new int[] { rr, cc });
						visited[rr][cc] = g;
						cnt++;
					}
				}
			}
		}
		if (cnt >= 2) {
			pq.add(new int[] { cnt, rainCnt, r, c, g });
		}

	}

	public static void gravity() {


		for (int c = 0; c < N; c++) {
			int r = N - 2;
			int pos = N - 1;

			while (pos > 0 && r >= 0) {
				if (origin[pos][c] != -2) {
					pos--;
				} else {
					if (r >= pos)
						r = pos - 1;
					if (r >= 0 && origin[r][c] >= 0) {
						origin[pos][c] = origin[r][c];
						origin[r][c] = -2;
						pos--;
						r--;
					} else if (origin[r][c] == -1) {
						r--;
						pos = r;
					} else if (origin[r][c] == -2) {
						r--;
					}
				}

			}
		}
	}

	public static void turnMap() {
		for (int i = 0; i < N; i++)
			System.arraycopy(origin[i], 0, copy[i], 0, N);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				origin[i][j] = copy[j][N - 1 - i];
			}
		}
	}
}
