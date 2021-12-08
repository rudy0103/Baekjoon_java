package b9376_탈옥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] visitedA;
	static int[][] visitedB;
	static int[][] visitedC;
	static int H, W, min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			min = 0;
			char[][] map = new char[H][W];
			LinkedList<int[]> target = new LinkedList<>();
			for (int i = 0; i < H; i++) {
				String inp = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = inp.charAt(j);
					if (map[i][j] == '$') {
						target.add(new int[] { i, j, 0 });
					}
				}
			}
			visitedA = new int[H][W];
			visitedB = new int[H][W];
			visitedC = new int[H][W];
			min += bfs(target.get(0), 0, map);
			min += bfs(target.get(1), 1, map);
//			System.out.println(min);
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					int tmp = visitedA[i][j] + visitedB[i][j];
					if (map[i][j] == '#')
						tmp--;
					if (tmp < min)
						pq.add(new int[] { i, j, tmp });
				}
			}
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					visitedC[i][j] = visitedA[i][j] + visitedB[i][j];
				}
			}
//			
//			printMap(visitedA);
//			printMap(visitedB);
			

			while (!pq.isEmpty()) {
				int[] tmp = pq.poll();
				if (tmp[2] < min) {
					min = Math.min(min, tmp[2] + bfs(new int[] { tmp[0], tmp[1], tmp[2] }, 3, map));
				}

			}

			sb.append(min).append("\n");
			printMap(visitedC);
		}
		System.out.println(sb.toString());
	}

	private static void printMap(int[][] visitedA2) {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@");
		for (int i = 0; i < visitedA2.length; i++) {
			for (int j = 0; j < visitedA2[i].length; j++) {
				if (visitedA2[i][j] >= 123456789)
					System.out.print(0 + " ");
				else
					System.out.print(visitedA2[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int bfs(int[] t, int type, char[][] map) {

		int[][] visited = null;
		if (type == 0) {
			visited = visitedA;
			for (int i = 0; i < H; i++)
				Arrays.fill(visited[i], 123456789);
		} else if (type == 1) {
			visited = visitedB;
			for (int i = 0; i < H; i++)
				Arrays.fill(visited[i], 123456789);
		} else {
			visited = visitedC;
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		pq.add(new int[] { t[0], t[1], t[2] });

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();

			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];

				if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
					if (map[nr][nc] == '*')
						continue;
					if (map[nr][nc] == '#' && visited[nr][nc] > curr[2] + 1) {
						pq.add(new int[] { nr, nc, curr[2] + 1 });
						visited[nr][nc] = curr[2] + 1;
					} else if (visited[nr][nc] > curr[2]) {
						pq.add(new int[] { nr, nc, curr[2] });
						visited[nr][nc] = curr[2];
					}
				} else {
					return curr[2];
				}
			}
		}
		return -1234;
	}
}
