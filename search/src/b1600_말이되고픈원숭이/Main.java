package b1600_말이되고픈원숭이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int k = Integer.parseInt(br.readLine());
		String[] inp = br.readLine().split(" ");
		int W = Integer.parseInt(inp[0]);
		int H = Integer.parseInt(inp[1]);

		int[][] map = new int[H][W];
		boolean[][][] visited = new boolean[H][W][k+1]; // 방문

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int[] dhr = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int[] dhc = { 1, 2, 2, 1, -1, -2, -2, -1 };

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 0, k, 0 });
		for (int i = 0; i < k+1; i++) {
			visited[0][0][i] = true;
		}
		
		boolean flag = false;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int r = now[0];
			int c = now[1];
			int horse = now[2];
			int move = now[3];

			if (r == H - 1 && c == W - 1) {
				System.out.println(move);
				flag = true;
				break;
			}

			if (horse > 0) {
				for (int i = 0; i < 8; i++) {
					int rr = r + dhr[i];
					int cc = c + dhc[i];
					if (rr >= 0 && rr < H && cc >= 0 && cc < W) {
						if (map[rr][cc] == 1 || visited[rr][cc][horse - 1])
							continue;
						visited[rr][cc][horse - 1] = true;
						q.add(new int[] { rr, cc, horse - 1, move + 1 });
					}
				}
			}

			for (int i = 0; i < 4; i++) {
				int rr = r + dr[i];
				int cc = c + dc[i];
				if (rr >= 0 && rr < H && cc >= 0 && cc < W) {
					if (map[rr][cc] == 1 || visited[rr][cc][horse])
						continue;
					visited[rr][cc][horse] = true;
					q.add(new int[] { rr, cc, horse, move + 1 });
				}
			}
		}
		if (flag == false)
			System.out.println(-1);
	}
}
