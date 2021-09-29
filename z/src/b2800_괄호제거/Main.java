package b2800_괄호제거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static int N, M; // N : row , M : column
	static boolean[][][] visited; // 방문 처리 할거
	static char[][] map; // 맵 생성
	static Queue<moon> queue;
	static int answer = -1;

	static class moon {
		int r;
		int c;
		int flag;
		int count;

		public moon(int r, int c, int flag, int count) {
			this.r = r;
			this.c = c;
			this.flag = flag;
			this.count = count;
		}

	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		queue = new LinkedList<>();
		N = sc.nextInt();
		M = sc.nextInt();

		map = new char[N][M];
		// visit 을 어떻게 처리해야할까? ==> 각각 키를 가지고 있는 경우의 수를 배열로 처리하자.
		visited = new boolean[N][M][1 << 6];
		int startX = 0;
		int startY = 0;
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);

				if (map[i][j] == '0') {
					startX = i;
					startY = j;
				}

			}

		}

		queue.add(new moon(startX, startY, 0, 0));
		bfs();

		System.out.println(answer);
	}

	static public void bfs() {

		while (!queue.isEmpty()) {
			moon Cur = queue.poll();

			if (map[Cur.r][Cur.c] == '1') { // 도착지점이라면
				answer = Cur.count;
				System.out.println(Cur.flag);
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nr = Cur.r + dr[d];
				int nc = Cur.c + dc[d];
				int flag = Cur.flag;
				int count = Cur.count;

				// boundary check, 벽도 못가게 , 해당 키 보유한 녀석이 기존에 방문했는지
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == '#' || visited[nr][nc][flag])
					continue;

				// 키를 발견했을 때,
				if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {

					visited[nr][nc][flag | 1 << map[nr][nc] - 'a'] = true;
					queue.add(new moon(nr, nc, flag | 1 << map[nr][nc] - 'a', count + 1));
				}
				// 대문 발견했을 때,
				else if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {

					if ((flag & (1 << map[nr][nc] - 'A')) != 0) { // 키를 가지고 있다면
						// 키 없으면 못나와 ~

						visited[nr][nc][flag] = true; // 방문처리하고
						queue.add(new moon(nr, nc, flag, count + 1)); // 큐에 추가
					}
				}
				// 그냥 통로
				else {

					visited[nr][nc][flag] = true;
					queue.add(new moon(nr, nc, flag, count + 1));

				}

			}
		}
	}

}