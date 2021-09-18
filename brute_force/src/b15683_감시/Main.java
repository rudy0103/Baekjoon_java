package b15683_감시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class CCTV {
	int id;
	int row;
	int col;
	int[] dr, dc;
	int[][] dir;

	public CCTV(int id, int row, int col) {
		super();
		this.id = id;
		this.row = row;
		this.col = col;
		dr = new int[] { -1, 0, 1, 0 };// 0,1,2,3 상 우 하 좌
		dc = new int[] { 0, 1, 0, -1 };

		if (id == 1) {
			this.dir = new int[][] { { 0 }, { 1 }, { 2 }, { 3 } };
		} else if (id == 2) {
			this.dir = new int[][] { { 0, 2 }, { 1, 3 } };
		} else if (id == 3) {
			this.dir = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } };
		} else if (id == 4) {
			this.dir = new int[][] { { 3, 0, 1 }, { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 0 } };
		}

	}

	public void changeDir(int[][] map, int d, int z) {
		watch(map, d, z);
	}

	public void watch(int[][] map, int d, int z) {

		for (int j = 0; j < dir[d].length; j++) {

			int rr = this.row + dr[dir[d][j]];
			int cc = this.col + dc[dir[d][j]];

			while (rr >= 0 && rr < map.length && cc >= 0 & cc < map[0].length) {
				if (map[rr][cc] == 6)
					break;
				else if (map[rr][cc] <= 0)
					map[rr][cc] += z;
				rr += dr[dir[d][j]];
				cc += dc[dir[d][j]];
			}
		}
	}

}

public class Main {
	static int min;

	public static int getArea(int[][] map) {
		int cnt = 0;
		for (int[] a : map) {
			for (int n : a)
				if (n == 0)
					cnt++;
		}
		return cnt;
	}

	public static void getMinArea(int cnt, int start, int[][] map, ArrayList<CCTV> list) {
		if (cnt == list.size()) {
			int c = getArea(map);
			if (c < min)
				min = c;
			return;
		}

		CCTV cctv = list.get(start);
		for (int d = 0; d < cctv.dir.length; d++) {
			cctv.changeDir(map, d, -1);
			getMinArea(cnt + 1, start + 1, map, list);
			cctv.changeDir(map, d, 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<CCTV> list = new ArrayList<>();
		ArrayList<int[]> cctv5 = new ArrayList<>();
		StringTokenizer st = null;
		String[] inp = br.readLine().split(" ");
		int N, M;
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);
		int[][] origin = new int[N][M];
		min = Integer.MAX_VALUE;
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int j = 0;
			while (st.hasMoreTokens()) {
				origin[i][j] = Integer.parseInt(st.nextToken());
				if (origin[i][j] >= 1 && origin[i][j] <= 4) {
					list.add(new CCTV(origin[i][j], i, j));
				} else if (origin[i][j] == 5) {
					cctv5.add(new int[] { i, j });
				}
				j++;
			}
		}

		for (int[] a : cctv5) {
			for (int dir = 0; dir < 4; dir++) {
				int rr = a[0] + dr[dir];
				int cc = a[1] + dc[dir];
				while (rr >= 0 && rr < N && cc >= 0 & cc < M) {
					if (origin[rr][cc] == 6)
						break;
					else if (origin[rr][cc] == 0)
						origin[rr][cc] = 7;
					rr += dr[dir];
					cc += dc[dir];
				}
			}
		}
		getMinArea(0, 0, origin, list);
		System.out.println(min);

	}
}
