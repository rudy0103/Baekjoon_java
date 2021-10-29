package b14466_소가길을건너간이유6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main2 {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N;
	static ArrayDeque<int[]> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); // 소
		int R = Integer.parseInt(st.nextToken()); // 길
		boolean[][] visited = new boolean[N][N];

		int[][] map = new int[N][N];
		int[][] cowList = new int[K][2];
		boolean[][][] isRoad = new boolean[N][N][4];

		int totalPair = (K * (K - 1)) / 2;
		int cnt = 0;

		for (int i = 0; i < R; i++) { // 길 -1 //목초지 0
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int rPrime = Integer.parseInt(st.nextToken()) - 1;
			int cPrime = Integer.parseInt(st.nextToken()) - 1;

			// 상하좌우
			if (r - rPrime == 0) {
				if (c - cPrime == -1) { // 우
					isRoad[r][c][3] = true;
					isRoad[rPrime][cPrime][2] = true;
				} else {// 좌
					isRoad[r][c][2] = true;
					isRoad[rPrime][cPrime][3] = true;
				}
			} else if (c - cPrime == 0) { // 상하
				if (r - rPrime == -1) {// 하
					isRoad[r][c][1] = true;
					isRoad[rPrime][cPrime][0] = true;
				} else { //상
					isRoad[r][c][0] = true;
					isRoad[rPrime][cPrime][1] = true;
				}
			}

		}

		for (int i = 1; i <= K; i++) { // 소
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			map[r][c] = i;
			cowList[i - 1][0] = r;
			cowList[i - 1][1] = c;
		}
		pq = new ArrayDeque<>();

		for (int i = 0; i < K; i++) {
			initVisited(visited);
			cnt += getCnt(cowList[i][0], cowList[i][1], map, visited, isRoad);
		}

		System.out.println(totalPair - (cnt / 2));

	}

	private static int getCnt(int startR, int startC, int[][] map, boolean[][] visited, boolean[][][] isRoad) {
		visited[startR][startC] = true;
		pq.clear();

		pq.add(new int[] { startR, startC });

		int cnt = -1;

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			if (map[curr[0]][curr[1]] > 0) {
				cnt++;
			}
			for (int d = 0; d < 4; d++) {
				int rr = curr[0] + dr[d];
				int cc = curr[1] + dc[d];

				if (rr >= 0 && rr < N && cc >= 0 && cc < N && visited[rr][cc] == false) {
					if (isRoad[curr[0]][curr[1]][d]) {// 건널 곳이 길이면
						continue;
					} else {
						visited[rr][cc] = true;
						pq.add(new int[] { rr, cc });
					}
				}
			}

		}
		return cnt;
	}

	private static void initVisited(boolean[][] visited) {
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited.length; j++) {
				visited[i][j] = false;
			}
		}
	}

}
