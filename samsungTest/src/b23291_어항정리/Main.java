package b23291_어항정리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//20:05~22:50
public class Main {

	static int N, K, time;
	static int min = 1234567;
	static int max = 0;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] plus;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[][] map = new int[N + 1][N + 1];
		int[] fish = new int[N];
		plus = new int[N + 1][N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			fish[i] = Integer.parseInt(st.nextToken());
			min = Math.min(min, fish[i]);
			max = Math.max(max, fish[i]);
		}

		while (getRes(fish)) {
			func(map, fish);
			time++;
		}
		System.out.println(time);

	}


	private static void func(int[][] map, int[] fish) {

		pushFish(fish);
		
		stackFish(map, fish);
		divideFish(map);
		serializeFish(map, fish);
		
		stackFish2(map, fish);
		divideFish(map);
		serializeFish(map, fish);

	}

	private static void stackFish2(int[][] map, int[] fish) {

		for (int i = 0; i <= N; i++)
			Arrays.fill(map[i], 0);

		for (int i = 0; i < N; i++) {
			map[N][i] = fish[i];
		}

		for (int c = 0; c < N / 2; c++) {
			map[N - 1][N - c - 1] = map[N][c];
			map[N][c] = 0;
		}


		for (int c = 0; c < N / 4; c++) {
			map[N - 2][N - c - 1] = map[N - 1][N / 2 + c];
			map[N - 1][N / 2 + c] = 0;
			map[N - 3][N - c - 1] = map[N][N / 2 + c];
			map[N][N / 2 + c] = 0;
		}


	}

	private static void stackFish(int[][] map, int[] fish) {
		for (int i = 0; i <= N; i++)
			Arrays.fill(map[i], 0);

		for (int i = 0; i < N; i++) {
			map[N][i] = fish[i];
		}

		int length = N;

		int[] st = { 0, 1 }; // 행, 열

		while (true) {

			if (st[0] <= st[1])
				st[0]++;
			else
				st[1]++;

			length -= st[1];

			if (length < st[0])
				break;

			int c = N - length;
			for (int i = 0; i < st[1]; i++) {// 열
				for (int j = 0; j < st[0]; j++) {// 행

					map[N - (i + 1)][c + j] = map[N - j][c - i - 1];
					map[N - j][c - i - 1] = 0;
				}
			}


		}

	}

	private static void serializeFish(int[][] map, int[] fish) {

		int idx = 0;

		for (int c = 0; c <= N; c++) {
			for (int r = N; r >= 0; r--) {
				if (map[r][c] == 0)
					break;
				fish[idx++] = map[r][c];
			}
		}
	}

	private static void divideFish(int[][] map) {

		for (int i = 0; i <= N; i++)
			Arrays.fill(plus[i], 0);

		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				if (map[i][j] == 0)
					continue;

				for (int d = 0; d < 4; d++) {

					int nr = i + dr[d];
					int nc = j + dc[d];

					if (nr < 0 || nr > N || nc < 0 || nc > N || map[nr][nc] == 0)
						continue;
					int gap = (map[i][j] - map[nr][nc]) / 5;

					if (gap <= 0)
						continue;
					else {
						plus[i][j] -= gap;
						plus[nr][nc] += gap;
					}
				}
			}
		}


		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				map[i][j] += plus[i][j];
			}
		}

	}
	
	private static boolean getRes(int[] fish) {
		min=1234567;
		max=0;
	
		for (int i = 0; i < N; i++) {
			min = Math.min(min, fish[i]);
			max = Math.max(max, fish[i]);
		}
		
		if(max-min>K) return true;
		return false;
	}
	
	private static void pushFish(int[] fish) {
		for (int i = 0; i < N; i++) {
			if (fish[i] == min)
				fish[i]++;	
		}
		
	}


}
