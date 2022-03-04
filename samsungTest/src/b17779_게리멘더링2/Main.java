package b17779_게리멘더링2;//50분 걸림

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int min = Integer.MAX_VALUE;
	static int[][] area;
	static int[] cnt = new int[6];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N + 1][N + 1];
		area = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				getD1D2(i, j, map, N);
			}
		}

		System.out.println(min);

	}

	private static void getD1D2(int x, int y, int[][] map, int N) {

		int[] d1 = new int[y - 1];
		int[] d2 = new int[N - y];

		for (int i = 0; i < d1.length; i++)
			d1[i] = i + 1;
		for (int i = 0; i < d2.length; i++)
			d2[i] = i + 1;

		for (int i = 0; i < d1.length; i++) {
			for (int j = 0; j < d2.length; j++) {
				if (d1[i] + d2[j] <= N - x) {
					getArea(x, y, map, N, d1[i], d2[j]);
				}
			}
		}

	}

	private static void getArea(int x, int y, int[][] map, int N, int d1, int d2) {

		for (int i = 1; i < area.length; i++)
			Arrays.fill(area[i], 0);

		area[x][y] = 5;

		for (int i = 1; i <= d1; i++)
			area[x + i][y - i] = 5;

		for (int i = 1; i <= d2; i++)
			area[x + i][y + i] = 5;

		for (int i = 1; i <= d2; i++)
			area[x + d1 + i][y - d1 + i] = 5;

		for (int i = 1; i <= d1; i++)
			area[x + d2 + i][y + d2 - i] = 5;

		for (int i = 1; i <= N; i++) {
			int left = -1;
			int right = -1;
			for (int j = 1; j <= N; j++) {
				if (area[i][j] == 5 && left == -1) {
					left = j;
					right = j;
				} else if (area[i][j] == 5) {
					right = j;
				}
			}
			if (left == -1)
				continue;

			for (int k = left + 1; k <= right - 1; k++)
				area[i][k] = 5;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (area[i][j] == 5)
					continue;
				if (i >= 1 && i < x + d1 && j >= 1 && j <= y)
					area[i][j] = 1;

				else if (i >= 1 && i <= x + d2 && j > y && j <= N)
					area[i][j] = 2;

				else if (i >= x + d1 && i <= N && j >= 1 && j < y - d1 + d2)
					area[i][j] = 3;

				else if (i > x + d2 && i <= N && j >= y - d1 + d2 && j <= N)
					area[i][j] = 4;

			}
		}

		getMin(N, map);

	}

	private static void getMin(int N, int[][] map) {

		Arrays.fill(cnt, 0);

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cnt[area[i][j]] += map[i][j];
			}
		}
		
		int maxSum=-1;
		int minSum=1234567890;
		for(int i=1;i<=5;i++) {
			maxSum=Math.max(maxSum, cnt[i]);
			minSum=Math.min(minSum, cnt[i]);
		}
		min=Math.min(min,maxSum-minSum);

	}

	private static void printArea(int x, int y, int d1, int d2) {

		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("x: " + x + " y: " + y + " d1: " + d1 + " d2: " + d2);
		for (int i = 1; i < area.length; i++) {
			for (int j = 1; j < area.length; j++) {
				System.out.print(area[i][j] + " ");
			}
			System.out.println();
		}

	}

}
