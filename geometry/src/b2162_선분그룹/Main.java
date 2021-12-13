package b2162_선분그룹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	static int[] rep;
	static int[][] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());

		int groupCnt = 0;
		int max = 0;

		rep = new int[N + 1];
		int[] cnt = new int[N + 1];
		int[] rank = new int[N + 1];
		list= new int[N+1][4];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			list[i][0] = Integer.parseInt(st.nextToken());
			list[i][1] = Integer.parseInt(st.nextToken());
			list[i][2] = Integer.parseInt(st.nextToken());
			list[i][3] = Integer.parseInt(st.nextToken());
			rep[i] = i;
			
		}

		for (int i = 1; i < N; i++) {
			for (int j = i + 1; j <= N; j++) {
				union(i, j, rank);
			}
		}

		for (int i = 1; i <= N; i++) {
			cnt[find(i)]++;
		}

		for (int i = 1; i <= N; i++) {
			if (cnt[i] > 0)
				groupCnt++;
			if (cnt[i] > max)
				max = cnt[i];
		}

		System.out.println(groupCnt);
		System.out.println(max);

	}

	private static void union(int i, int j, int[] rank) {
		int setA = find(i);
		int setB = find(j);

		if (setA == setB)
			return;

		boolean flag = false;
		int[] p1 = list[i];
		int[] p2 = list[j];

		int x1 = p1[0];
		int y1 = p1[1];
		int x2 = p1[2];
		int y2 = p1[3];

		int x3 = p2[0];
		int y3 = p2[1];
		int x4 = p2[2];
		int y4 = p2[3];

		int ret1 = ccw(x1, y1, x2, y2, x3, y3);
		int ret2 = ccw(x1, y1, x2, y2, x4, y4);
		int ret3 = ccw(x3, y3, x4, y4, x1, y1);
		int ret4 = ccw(x3, y3, x4, y4, x2, y2);
		if (ret1 == 0) {
			if (check(x1, y1, x2, y2, x3, y3) == 0)
				flag = true;

		}
		if (ret2 == 0) {
			if (check(x1, y1, x2, y2, x4, y4) == 0)
				flag = true;

		}
		if (ret3 == 0) {
			if (check(x3, y3, x4, y4, x1, y1) == 0)
				flag = true;

		}
		if (ret4 == 0) {
			if (check(x3, y3, x4, y4, x2, y2) == 0)
				flag = true;
		}
		if (ret1 * ret2 < 0 && ret3 * ret4 < 0) {
			flag = true;
		}

		if (flag) {
			if (rank[setA] > rank[setB]) {
				rep[setB] = rep[setA];
			} else if (rank[setA] < rank[setB]) {
				rep[setA] = setB;
			} else {
				rep[setA] = setB;
				rank[setB]++;
			}
		}
	}

	private static int find(int x) {

		if (x == rep[x])
			return x;

		return rep[x] = find(rep[x]);
	}

	private static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {

		int a = x1 * y2 + x2 * y3 + x3 * y1;
		int b = x2 * y1 + x3 * y2 + x1 * y3;

		if (a - b < 0) {
			return 1;
		} else if (a == b) {
			return 0;
		} else
			return -1;
	}

	private static int check(int x1, int y1, int x2, int y2, int x3, int y3) {

		if (x3 >= Math.min(x1, x2) && x3 <= Math.max(x1, x2)) {
			if (y3 >= Math.min(y1, y2) && y3 <= Math.max(y1, y2)) {
				return 0;
			} else
				return 1;
		} else {
			return 1;
		}
	}

}
