package b14466_소가길을건너간이유6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int size;
	static PriorityQueue<int[]> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); // 소
		int R = Integer.parseInt(st.nextToken()); // 길
		size = N * 2;
		boolean[][][] visited = new boolean[size][size][2];

		int[][] map = new int[size][size];

		int[][] cowList = new int[K][2];

		int totalPair = (K * (K - 1)) / 2;
		int cnt = 0;

		for (int i = 0; i < R; i++) { // 길 -1 //목초지 0
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int rPrime = Integer.parseInt(st.nextToken()) - 1;
			int cPrime = Integer.parseInt(st.nextToken()) - 1;
			map[(r * 2 + rPrime * 2) / 2][(c * 2 + cPrime * 2) / 2] = -1;
		}

		for (int i = 1; i <= K; i++) { // 소
			st = new StringTokenizer(br.readLine(), " ");
			int r = (Integer.parseInt(st.nextToken()) - 1) * 2;
			int c = (Integer.parseInt(st.nextToken()) - 1) * 2;
			map[r][c] = i;
			cowList[i - 1][0] = r;
			cowList[i - 1][1] = c;
		}

		pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		for (int i = 0; i < K; i++) {
			initVisited(visited);
			cnt += getCnt(cowList[i][0], cowList[i][1], map, visited);
		}

		System.out.println(totalPair - (cnt / 2));

	}

	private static int getCnt(int startR, int startC, int[][] map, boolean[][][] visited) {
		visited[startR][startC][0] = true;
		visited[startR][startC][1] = true;
		pq.clear();

		pq.add(new int[] { startR, startC, 0 });

		int cnt = -1;

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int isPassed = curr[2];
			if (map[curr[0]][curr[1]] > 0 && isPassed == 0) {
				cnt++;
			}
			for (int d = 0; d < 4; d++) {
				int rr = curr[0] + dr[d] * 2;
				int cc = curr[1] + dc[d] * 2;

				if (rr >= 0 && rr < size && cc >= 0 && cc < size && visited[rr][cc][isPassed] == false) {
					int nr = rr - dr[d];
					int nc = cc - dc[d];

					if (map[nr][nc] == -1) {// 건널 곳이 길이면
						visited[rr][cc][1] = true;
						pq.add(new int[] { rr, cc, 1 });
					} else {
						visited[rr][cc][isPassed] = true;
						pq.add(new int[] { rr, cc, isPassed });
					}
				}
			}

		}
		return cnt;
	}

	private static void initVisited(boolean[][][] visited) {
		// TODO Auto-generated method stub
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited.length; j++) {
				visited[i][j][0] = false;
				visited[i][j][1] = false;
			}
		}
	}

}
