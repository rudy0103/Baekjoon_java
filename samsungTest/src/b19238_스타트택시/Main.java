package b19238_스타트택시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, F;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] goals;
	static boolean[][] visited;
	static PriorityQueue<int[]> pq;
	static ArrayDeque<int[]> q;

	static class Taxi {
		int r, c, moveToC, moveToD, f;

		public Taxi(int r, int c, int f) {
			this.r = r;
			this.c = c;
			this.f = f;
		}

		public void moveToC(int rr, int cc, int movedToC) {
			this.r = rr;
			this.c = cc;
			map[r][c] = 0;
			this.f -= movedToC;
		}

		public void moveToD(int rr, int cc, int movedToD) {
			this.r = rr;
			this.c = cc;
			this.f += movedToD;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		goals = new int[M + 1][2];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					map[i][j] = -99999;
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		int startR = Integer.parseInt(st.nextToken()) - 1;
		int startC = Integer.parseInt(st.nextToken()) - 1;

		Taxi taxi = new Taxi(startR, startC, F);

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int cr = Integer.parseInt(st.nextToken()) - 1;
			int cc = Integer.parseInt(st.nextToken()) - 1;
			int gr = Integer.parseInt(st.nextToken()) - 1;
			int gc = Integer.parseInt(st.nextToken()) - 1;
			map[cr][cc] = i;
			goals[i] = new int[] { gr, gc };
		}
		q = new ArrayDeque<>();
		pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[2] != o2[2])
					return o1[2] - o2[2];
				else if (o1[0] != o2[0])
					return o1[0] - o2[0];
				else
					return o1[1] - o2[1];
			}
		});

		int cnt = 0;
		while (cnt <= M) {
			if (findCustomer(taxi)) {
				int[] cust = pq.poll();
				int targetGoal = map[cust[0]][cust[1]];

				taxi.moveToC(cust[0], cust[1], cust[2]);

				if (goGoal(taxi, goals[targetGoal])) {
					cnt++;
				} else {
					break;
				}
			} else {
				break;
			}
		}
		if (cnt == M)
			System.out.println(taxi.f);
		else
			System.out.println(-1);

	}

	private static boolean goGoal(Taxi taxi, int[] target) {
		q.clear();

		q.add(new int[] { taxi.r, taxi.c, 0 });

		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
		}
		visited[taxi.r][taxi.c] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			int moved = curr[2];

			if (curr[0] == target[0] && curr[1] == target[1]) {
				taxi.moveToD(curr[0], curr[1], curr[2]);
				return true;
			}

			for (int d = 0; d < 4; d++) {
				int rr = r + dr[d];
				int cc = c + dc[d];
				if (check(rr, cc) && moved + 1 <= taxi.f) {
					visited[rr][cc] = true;
					q.add(new int[] { rr, cc, moved + 1 });
				}

			}

		}
		return false;
	}

	private static boolean findCustomer(Taxi taxi) {
		pq.clear();
		q.clear();
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], false);
		}

		q.add(new int[] { taxi.r, taxi.c, 0 });
		if (map[taxi.r][taxi.c] > 0) {
			pq.add(new int[] { taxi.r, taxi.c, 0 });
			return true;
		}
		visited[taxi.r][taxi.c] = true;

		int maxMoved = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			int moved = curr[2];

			if (moved <= maxMoved && moved <= taxi.f) {
				if (map[r][c] > 0) {
					pq.add(new int[] { r, c, moved });
					maxMoved = moved;
				}
			} else
				break;

			for (int d = 0; d < 4; d++) {
				int rr = r + dr[d];
				int cc = c + dc[d];
				if (check(rr, cc)) {
					visited[rr][cc] = true;
					q.add(new int[] { rr, cc, moved + 1 });
				}

			}
		}

		if (pq.isEmpty())
			return false;
		else
			return true;
	}

	private static boolean check(int rr, int cc) {
		if (rr >= 0 && rr < N && cc >= 0 && cc < N && visited[rr][cc] == false && map[rr][cc] != -99999)
			return true;
		return false;
	}
}
