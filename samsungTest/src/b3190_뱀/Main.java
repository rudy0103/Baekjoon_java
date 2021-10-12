package b3190_뱀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[] dr = { 0, 1, 0, -1 };// 우하좌상
		int[] dc = { 1, 0, -1, 0 };
		int time = 0;

		int[][] map = new int[N + 2][N + 2];

		for (int i = 0; i <= N+1; i++) { // 벽 1
			for (int j = 0; j <= N+1; j++) {
				if (i == 0 | j == 0 || i == N+1 || j == N+1)
					map[i][j] = -1;
			}
		}

		for (int i = 0; i < K; i++) {// K개의 사과 2;
			st = new StringTokenizer(br.readLine(), " ");
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 2;
		}
		int L = Integer.parseInt(br.readLine());

		ArrayDeque<int[]> tail = new ArrayDeque<>();// 꼬리위치 넣는 곳
		tail.add(new int[] { 1, 1 });
		map[1][1] = 1;// 처음 시작 뱀 길이 1

		boolean flag = false;
		int dir = 0;// 오른쪽
		int r = 1;
		int c = 1;
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int changDirTime = Integer.parseInt(st.nextToken());
			String direction = st.nextToken();
			while (time < changDirTime) { // 방향 바꾸기 전까지 이동하고
				r += dr[dir];
				c += dc[dir];
				if (map[r][c] == 1 || map[r][c] == -1) {
					flag = true;
					time++;
					break;
				} else if (map[r][c] == 0) {// 아무것도 없을 때
					map[r][c] = 1;// 머리이동
					tail.add(new int[] { r, c });
					int[] t = tail.poll();
					map[t[0]][t[1]] = 0;// 꼬리 줄어듬

				} else { // 사과먹을 때
					map[r][c] = 1;// 머리이동
					tail.add(new int[] { r, c });

				}
				time++;
				if (time == changDirTime) {
					dir = chanDir(dir, direction);
					if (i == L - 1 && flag == false) {
						changDirTime = Integer.MAX_VALUE;
					}
				}
			}
			if(flag) break;
		}

		// 출력
		System.out.println(time);
	}

	private static void printMap(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int chanDir(int dir, String direction) {
		// 우-0, 하 -1, 좌 -2, 상-3
		if (dir == 0 && direction.equals("L")) {
			return 3;
		} else if (dir == 3 && direction.equals("D")) {
			return 0;
		} else {
			if (direction.equals("L"))
				return dir - 1;
			else
				return dir + 1;
		}
	}

}
