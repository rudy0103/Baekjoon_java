package b9328_열쇠;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			char[][] map = new char[H][W];
			boolean[][] visited = new boolean[H][W];
			int res = 0;

			LinkedList<int[]> startPoint = new LinkedList<>();

			for (int i = 0; i < H; i++) {
				String inp = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = inp.charAt(j);
				}
			}
			HashSet<Character> keys = new HashSet<>();
			String inputKey = br.readLine();
			if (!inputKey.equals("0")) {
				for (int i = 0; i < inputKey.length(); i++)
					keys.add(inputKey.charAt(i));
			}

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if ((i == 0 || i == H - 1 || j == 0 || j == W - 1)) {
						if (map[i][j] >= 'a' && map[i][j] <= 'z') {
							keys.add(map[i][j]);
							map[i][j] = '.';
						}
					}
				}
			}

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if ((i == 0 || i == H - 1 || j == 0 || j == W - 1)) {
						if (map[i][j] == '.') {
							startPoint.add(new int[] { i, j });
						} else if (map[i][j] == '$') {
							res++;
							startPoint.add(new int[] { i, j });
							map[i][j] = '.';
						} else if (map[i][j] >= 'A' && map[i][j] <= 'Z') {
							if (keys.contains((char) (map[i][j] + 32))) {
								startPoint.add(new int[] { i, j });
								map[i][j] = '.';
							}
						}
					}
				}
			}

			ArrayDeque<int[]> q = new ArrayDeque<>();

			while (true) {
				int beforeKeysCnt = keys.size();

				for (int i = 0; i < H; i++) {
					for (int j = 0; j < W; j++) {
						if ((i == 0 || i == H - 1 || j == 0 || j == W - 1)) {
							if (map[i][j] >= 'A' && map[i][j] <= 'Z') {
								if (keys.contains((char) (map[i][j] + 32))) {
									startPoint.add(new int[] { i, j });
									map[i][j] = '.';
								}
							}
						}
					}
				}

				for (int i = 0; i < H; i++)
					Arrays.fill(visited[i], false);
				q.clear();

				for (int[] start : startPoint) {
					q.add(new int[] { start[0], start[1] });
					visited[start[0]][start[1]] = true;
				}

				while (!q.isEmpty()) {
					int[] curr = q.poll();

					for (int d = 0; d < 4; d++) {
						int nr = curr[0] + dr[d];
						int nc = curr[1] + dc[d];

						if (nr >= 0 && nr < H && nc >= 0 && nc < W && !visited[nr][nc]) {

							if (map[nr][nc] == '.') {
								q.add(new int[] { nr, nc });
								visited[nr][nc] = true;
							} else if (map[nr][nc] >= 'a' && map[nr][nc] <= 'z') {
								q.add(new int[] { nr, nc });
								keys.add(map[nr][nc]);
								map[nr][nc] = '.';
								visited[nr][nc] = true;
							} else if (map[nr][nc] >= 'A' && map[nr][nc] <= 'Z') {
								if (keys.contains((char) (map[nr][nc] + 32))) {
									q.add(new int[] { nr, nc });
									map[nr][nc] = '.';
									visited[nr][nc] = true;
								}
							} else if (map[nr][nc] == '$') {
								map[nr][nc] = '.';
								visited[nr][nc] = true;
								q.add(new int[] { nr, nc });
								res++;
							}
						}
					}

				}

				if (beforeKeysCnt == keys.size())
					break;
			}

			sb.append(res).append("\n");

		}
		System.out.println(sb.toString());
	}
}
