package b15685_드래곤커브;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };
	static boolean[][] map;
	static int N;
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		map = new boolean[101][101];
		int res = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());

			dragon(r, c, d, g);
		}

		for (int i = 1; i <= 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == false)
					continue;
				int cnt = 0;
				int r = i;
				int c = j;
				int dd = 0;
				for (int d = 0; d < 4; d++) {
					r += dr[dd];
					c += dc[dd];
					if (map[r][c] == true)
						cnt++;
					dd = nextCurve(dd);
				}
				if (cnt == 4)
					res++;
			}
		}
		System.out.println(res);

	}

	private static void dragon(int r, int c, int d, int g) {

		map[r][c] = true;
		if (g == 0) {
			map[r + dr[d]][c + dc[d]] = true;
			return;
		}

		list.clear();
		list.add(d);

		int dd = d;
		int rr = r + dr[d];
		int cc = c + dc[d];
		map[rr][cc] = true;
		for (int i = 1; i <= g; i++) {
			int cnt = (int) Math.pow(2, i) / 2;
			int idx = (int) Math.pow(2, i) / 2 - 1;
			while (cnt-- > 0) {
				dd = nextCurve(list.get(idx));
				idx--;
				rr += dr[dd];
				cc += dc[dd];
				map[rr][cc] = true;
				list.add(dd);
			}
		}

	}

	private static int nextCurve(int i) {
		if (i == 3)
			return 0;
		else
			return i + 1;
	}

}
