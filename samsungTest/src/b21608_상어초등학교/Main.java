package b21608_상어초등학교;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static int[][][] room;
	public static int[][] student;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		int N = Integer.parseInt(br.readLine()); // 3<=N<=20;
		room = new int[N + 1][N + 1][2];
		student = new int[N * N + 1][5];

		for (int i = 1; i <= N * N; i++) { // N^2 명의 학생을 배열에 넣음
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			student[i][0] = s;
			for (int j = 1; j <= 4; j++)
				student[i][j] = Integer.parseInt(st.nextToken());
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) { // 좋아하는 사람 수, 빈칸, 위쪽, 왼쪽
				if (o1[0] != o2[0])
					return o2[0] - o1[0];
				if (o1[1] != o2[1])
					return o2[1] - o1[1];
				if (o1[2] != o2[2])
					return o1[2] - o2[2];
				if (o1[3] != o2[3])
					return o1[3] - o2[3];
				return 0;
			}
		});

		for (int i = 1; i <= N * N; i++) {
			pq.clear();

			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					if (room[r][c][0] != 0)
						continue;

					int prefer = 0;
					int empty = 0;

					for (int d = 0; d < 4; d++) {
						int rr = r + dr[d];
						int cc = c + dc[d];
						if (rr >= 1 && rr <= N && cc >= 1 && cc <= N) {
							if (room[rr][cc][0] == 0)
								empty++;
							for (int k = 1; k <= 4; k++) {
								if (room[rr][cc][0] == student[i][k])
									prefer++;
							}
						}
					}
					pq.add(new int[] { prefer, empty, r, c });

				}
			}
			room[pq.peek()[2]][pq.peek()[3]][0] = student[i][0];
			room[pq.peek()[2]][pq.peek()[3]][1] = i;

		}

		System.out.println(getSatisfaction(N)); // 만족도 구하기
	}

	private static int getSatisfaction(int N) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int sum = 0;

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				int s = room[r][c][1];

				int prefer = 0;

				for (int d = 0; d < 4; d++) {
					int rr = r + dr[d];
					int cc = c + dc[d];
					if (rr >= 1 && rr <= N && cc >= 1 && cc <= N) {
						for (int k = 1; k <= 4; k++) {
							if (room[rr][cc][0] == student[s][k])
								prefer++;
						}
					}
				}
				if (prefer == 1)
					sum++;
				else if (prefer == 2)
					sum += 10;
				else if (prefer == 3)
					sum += 100;
				else if (prefer == 4)
					sum += 1000;

			}
		}

		return sum;
	}

}
