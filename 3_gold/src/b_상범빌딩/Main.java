package b_상범빌딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] dl = { 0, -1, 1 };
		int[] dr = { 0, -1, 1, 0, 0 };
		int[] dc = { 0, 0, 0, -1, 1 };

		while (L != 0) {
			int time = 0;
			char[][][] map = new char[L][R][C];
			boolean[][][] visited = new boolean[L][R][C];
			int sl = -1, sr = -1, sc = -1;

			for (int i = 0; i < L; i++) {
				for (int r = 0; r < R; r++) {
					map[i][r] = br.readLine().toCharArray();
					for (int c = 0; c < C; c++) {
						if (map[i][r][c] == 'S') {
							sl = i;
							sr = r;
							sc = c;
						}
					}
				}
				br.readLine();
			}

			ArrayDeque<int[]> dq = new ArrayDeque<>();

			dq.add(new int[] { sl, sr, sc, 0 });
			visited[sl][sr][sc] = true;

			while (!dq.isEmpty()) {
				int[] now = dq.poll();
				if (map[now[0]][now[1]][now[2]] == 'E') {
					time = now[3];
					break;
				}

				for (int l = 0; l < 3; l++) {

					int nl = now[0] + dl[l];

					if (nl < 0 || nl >= L)
						continue;
					
					int dir=4;
					if(nl!=now[0]) dir=0;
					
					for (int d = 0; d <= dir; d++) {
						int nr = now[1] + dr[d];
						int nc = now[2] + dc[d];

						if (nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nl][nr][nc] || map[nl][nr][nc] == '#')
							continue;
						visited[nl][nr][nc] = true;

						dq.add(new int[] { nl, nr, nc, now[3] + 1 });
					}
				}

			}

			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			if (time == 0) {
				sb.append("Trapped!");
			} else {
				sb.append("Escaped in ").append(time).append(" minute(s).");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}

}
