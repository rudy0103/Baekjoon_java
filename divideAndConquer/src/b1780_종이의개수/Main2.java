package b1780_종이의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main2 {

	static int zeroCnt, oneCnt, minusOneCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		divideAndConquer(0, 0, N, map);

		System.out.println(minusOneCnt);
		System.out.println(zeroCnt);
		System.out.println(oneCnt);

	}

	private static void divideAndConquer(int startR, int startC, int len, int[][] map) {

		if (len == 1) {
			if (map[startR][startC] == -1) {
				minusOneCnt++;
			} else if (map[startR][startC] == 0) {
				zeroCnt++;
			} else {
				oneCnt++;
			}
			return;
		}

		if (isSame(startR, startC, len, map)) {
			if (map[startR][startC] == -1) {
				minusOneCnt++;
			} else if (map[startR][startC] == 0) {
				zeroCnt++;
			} else {
				oneCnt++;
			}
			return;
		}
		
		
		for(int i=0;i<9;i++) {
			int dr=i/3;
			int dc=i%3;
			int l=len/3;
			divideAndConquer(startR+dr*l, startC+dc*l, l, map);
		}
		
		

	}

	private static boolean isSame(int startR, int startC, int len, int[][] map) {

		int first = map[startR][startC];

		for (int i = startR; i < startR + len; i++) {
			for (int j = startC; j < startC + len; j++) {
				if (map[i][j] != first)
					return false;
			}
		}

		return true;
	}

}
