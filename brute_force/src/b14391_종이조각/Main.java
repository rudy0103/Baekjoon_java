package b14391_종이조각;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int max;
	static int[][] map;
	static int N, M;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];
		boolean[][] garo = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String inpStr = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = inpStr.charAt(j) - '0';
			}
		}

		cutPaper(0, garo, N * M);

		System.out.println(max);

	}

	private static void cutPaper(int depth, boolean[][] garo, int L) {

		if (depth == L) {
			int sum = getSum(garo);
			if (sum > max)
				max = sum;
			return;
		}

		int r = depth / M;
		int c = depth % M;
		garo[r][c] = true;
		cutPaper(depth + 1, garo, L);
		garo[r][c] = false;
		cutPaper(depth + 1, garo, L);

	}

	private static int getSum(boolean[][] garo) {
		int sum = 0;
		
		for (int i = 0; i < N; i++)
			Arrays.fill(visited[i], false);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j])
					continue;
				int tmpSum = 0;
				boolean type = garo[i][j];
				int nr=i;
				int nc=j;
				while (true) {
					if(nr>=N||nc>=M||garo[nr][nc]!=type) break;
					tmpSum *= 10;
					tmpSum += map[nr][nc];
					visited[nr][nc]=true;
					if (type) {
						nc++;
					}else {
						nr++;
					}
				}
				sum += tmpSum;
			}
		}
		return sum;
	}

}
