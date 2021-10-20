package b20056_마법사상어와파이어볼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K;
	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static LinkedList<FireBall>[][] map;

	static class FireBall {
		int r, c, m, s, d, moved;

		public FireBall(int r, int c, int m, int s, int d, int moved) {
			super();
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
			this.moved = moved;
		}

		public void move() {
			int ss = s;

			if (d == 0 || d == 2 || d == 4 || d == 6) {
				ss = s % N;
			}
			int rr = r;
			int cc = c;

			while (ss-- > 0) {
				rr += dr[d];
				cc += dc[d];

				if (rr == -1)
					rr = N - 1;
				else if (rr == N)
					rr = 0;
				if (cc == -1)
					cc = N - 1;
				else if (cc == N)
					cc = 0;
			}
			this.moved++;
			this.r = rr;
			this.c = cc;
			map[rr][cc].add(this);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new LinkedList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new LinkedList<FireBall>();
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map[r][c].add(new FireBall(r, c, m, s, d, 0));
		}

		for (int i = 0; i < K; i++) {
			command(i);
			mergeAndDivide(i);
		}
		System.out.println(getMass());
	}

	private static void mergeAndDivide(int moved) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].size() < 2)
					continue;
				int totalM = 0;
				int totalS = 0;
				int size = map[i][j].size();
				int dir = map[i][j].peek().d % 2;
				boolean flag = true;
				while (!map[i][j].isEmpty()) {
					FireBall f = map[i][j].poll();
					totalM += f.m;
					totalS += f.s;
					if (f.d % 2 != dir)
						flag = false;
				}
				if (totalM < 5)
					continue;
				int m = totalM / 5;
				int s = totalS / size;
				for (int a = 0; a < 4; a++) {
					int d = a * 2;
					if (!flag)
						d++;
					map[i][j].addLast(new FireBall(i, j, m, s, d, moved + 1));
				}
			}
		}
	}

	private static int getMass() {

		int res = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].size() == 0)
					continue;
				for (FireBall f : map[i][j]) {
					res += f.m;
				}
			}
		}

		return res;
	}

	private static void command(int k) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].size() == 0)
					continue;
				while (!map[i][j].isEmpty()) {
					FireBall f = map[i][j].pollFirst();
					if (f.moved > k) {
						map[i][j].addLast(f);
						break;
					}
					f.move();
				}
			}
		}
	}
}
