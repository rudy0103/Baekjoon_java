package b1194_달이차오른다가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];

		ArrayDeque<int[]> q = new ArrayDeque<>();

		boolean[][][] visited = new boolean[N][M][(int) Math.pow(2, 6)];

		int startR = -1;
		int startC = -1;
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < tmp.length(); j++) {
				map[i][j] = tmp.charAt(j);
				if (map[i][j] == '0') {
					startR = i;
					startC = j;
					map[i][j] = '.';
				}
			}
		}

		q.add(new int[] { startR, startC, 0, 0 });
		visited[startR][startC][0] = true;

		boolean flag = false;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			if (map[r][c] == '1') {
				System.out.println(tmp[2]);
				flag = true;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int rr = r + dr[i];
				int cc = c + dc[i];
				if (rr < 0 || rr >= N || cc < 0 || cc >= M || map[rr][cc] == '#')
					continue;
				if (map[rr][cc] == '.' && visited[rr][cc][tmp[3]] == false) {
					q.add(new int[] { rr, cc, tmp[2] + 1, tmp[3] });
					visited[rr][cc][tmp[3]] = true;
				} else if (map[rr][cc] >= 'a' && map[rr][cc] <= 'f' && visited[rr][cc][tmp[3]] == false) {
					visited[rr][cc][tmp[3]] = true;
					q.add(new int[] { rr, cc, tmp[2] + 1, tmp[3] | (1 << (map[rr][cc] - 'a')) });
				} else if (map[rr][cc] >= 'A' && map[rr][cc] <= 'F' && visited[rr][cc][tmp[3]] == false) {
					if ((tmp[3] & 1 << map[rr][cc] - 'a') != 0) {
						visited[rr][cc][tmp[3]] = true;
						q.add(new int[] { rr, cc, tmp[2] + 1, tmp[3] });
					}
				} else if (map[rr][cc] == '1') {
					q.add(new int[] { rr, cc, tmp[2] + 1, tmp[3] });
				}
			}

		}
		if (!flag)
			System.out.println("-1");
	}
}
