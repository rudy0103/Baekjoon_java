package b7562_나이트의이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			int I = Integer.parseInt(br.readLine());
			String[] inp = br.readLine().split(" ");
			int[] src = { Integer.parseInt(inp[0]), Integer.parseInt(inp[1]) };
			inp = br.readLine().split(" ");
			int[] dst = { Integer.parseInt(inp[0]), Integer.parseInt(inp[1]) };
			sb.append((findMin(src, dst, I))).append("\n");
		}
		System.out.println(sb.toString());
	}

	static int findMin(int[] src, int[] dst, int I) {
		if (src[0] == dst[0] && src[1] == dst[1]) {
			return 0;
		}
		Queue<int[]> q = new LinkedList<>();
		int[][] map = new int[I][I];
		int[] dr = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int[] dc = { 1, 2, 2, 1, -1, -2, -2, -1 };
		q.add(src);
		map[src[0]][src[1]] = 1;
		while (!q.isEmpty()) {
			int[] n = q.poll();

			for (int d = 0; d < 8; d++) {
				int rr = n[0] + dr[d];
				int cc = n[1] + dc[d];
				if (rr >= 0 && rr < I && cc >= 0 && cc < I)
					if (map[rr][cc] == 0) {
						map[rr][cc] = map[n[0]][n[1]] + 1;
						q.add(new int[] { rr, cc });
						if (rr == dst[0] && cc == dst[1]) {
							return --map[rr][cc];
						}
					}
			}
		}
		return 0;
	}

}
