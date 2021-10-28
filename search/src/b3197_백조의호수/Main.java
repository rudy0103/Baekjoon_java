package b3197_백조의호수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int R, C, targetR, targetC;
	static final int ICE = Integer.MAX_VALUE;
	static boolean[][][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		int[][] dp = new int[R][C];
		int startR = -1;
		int startC = -1;
		targetR = -1;
		targetC = -1;

		ArrayDeque<int[]> q = new ArrayDeque<>();

		for (int i = 0; i < R; i++) {
			String inp = br.readLine();
			for (int j = 0; j < C; j++) {
				if (inp.charAt(j) == 'X')
					map[i][j] = ICE;
				else if (inp.charAt(j) == '.')
					q.add(new int[] { i, j, 0 });
				else {
					if (startR == -1) {
						startR = i;
						startC = j;
					} else {
						targetR = i;
						targetC = j;
					}
					q.add(new int[] { i, j, 0 });
				}
				dp[i][j] = Integer.MAX_VALUE;
			}
		}

		while (!q.isEmpty()) { // 일단 얼음 다 녹이기
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			int day = curr[2];

			for (int d = 0; d < 4; d++) {
				int rr = r + dr[d];
				int cc = c + dc[d];

				if (rr >= 0 && rr < R && cc >= 0 && cc < C && map[rr][cc] == ICE) {
					map[rr][cc] = day + 1;
					q.add(new int[] { rr, cc, day + 1 });
				}
			}

		}

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		pq.add(new int[] { startR, startC, 0 });
		dp[startR][startC] = 0;

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int r = curr[0];
			int c = curr[1];
			int day = curr[2];
			if(r==targetR&&c==targetC) break;

			for (int d = 0; d < 4; d++) {
				int rr = r + dr[d];
				int cc = c + dc[d];
				if (rr >= 0 && rr < R && cc >= 0 && cc < C) {
					if (dp[rr][cc] > day) {
						dp[rr][cc] = day;
						pq.add(new int[] { rr, cc, Math.max(map[rr][cc], day) });
					}
				}
			}

		}
		System.out.println(dp[targetR][targetC]);
	}
}
