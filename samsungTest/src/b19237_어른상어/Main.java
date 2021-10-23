package b19237_어른상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K, remain;
	static LinkedList<Shark> sharks;
	static int[][][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Shark implements Comparable<Shark> {

		int num, r, c, d;
		int[][] dir;

		public Shark(int num, int r, int c) {
			super();
			this.num = num;
			this.r = r;
			this.c = c;
			this.dir = new int[4][4];
		}

		public void setD(int d) {
			this.d = d;
		}

		public void setDir(int i, int[] d) {
			this.dir[i] = d;
		}

		@Override
		public int compareTo(Shark o) {
			return this.num - o.num;
		}

		public void findSpace(int n) {

			for (int i = 0; i < 4; i++) {
				int nd = this.dir[this.d][i];
				int rr = r + dr[nd];
				int cc = c + dc[nd];
				if (rr >= 0 && rr < N && cc >= 0 && cc < N) {
					if (n == 0) {
						if (map[rr][cc][0] == 0 && map[rr][cc][1] == 0) {
							this.r = rr;
							this.c = cc;
							this.d = nd;
							return;
						}
					} else if (map[rr][cc][0] == this.num) {
						this.r = rr;
						this.c = cc;
						this.d = nd;
						return;
					}

				}
			}
			this.findSpace(1);
		}

		public boolean smell() {

			if (map[r][c][0] == 0) {
				map[r][c][0] = num;
				map[r][c][1] = K;
			} else if (map[r][c][0] < num) {
				return false;
			} else {
				map[r][c][0] = num;
				map[r][c][1] = K;
			}
			return true;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		remain = M;
		map = new int[N][N][2];

		sharks = new LinkedList<>();
		int time = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp > 0) {
					map[i][j][0] = tmp;
					map[i][j][1] = K;
					Shark shark = new Shark(tmp, i, j);
					sharks.add(shark);
				} else {
					map[i][j] = new int[] { 0, 0 };
				}
			}
		}

		Collections.sort(sharks);// 한번 정렬;

		st = new StringTokenizer(br.readLine(), " ");

		for (Shark s : sharks) {
			s.setD(Integer.parseInt(st.nextToken()) - 1);
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int[] tmp = { Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
						Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1 };
				sharks.get(i).setDir(j, tmp);
			}
		}

		while (++time <= 1000) {
			if (sharks.size() == 1) {
				break;
			}

			for (Shark s : sharks) {
				s.findSpace(0);
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j][0] > 0) {
						map[i][j][1]--;
						if (map[i][j][1] == 0)
							map[i][j][0] = 0;
					}
				}
			}

			int size = sharks.size();

			while (size-- > 0) {
				Shark s = sharks.pollFirst();
				if (s.smell()) {
					sharks.addLast(s);
				}
			}
		}
		if (sharks.size() > 1)
			System.out.println(-1);
		else
			System.out.println(time - 1);

	}

}
