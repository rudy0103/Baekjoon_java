package b17135_캐슬디펜스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n, m, d, maxKill;
	static int[][] origin;
	static int[] archer = new int[3];
	static Queue<int[]> target = new LinkedList<>();

	static boolean isFinished(int[][] map, int turn) {
		for (int i = turn; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0)
					return false;
			}
		}
		return true;
	}

	static int doTurn(int[][] map, int turn) {

		int kill = 0;
		for (int a = 0; a < archer.length; a++) {
			int er = 99;
			int ec = 99;
			int dist = d;
			for (int r = n - 1; r >= turn; r--) {
				for (int c = 0; c < m; c++) {
					if (map[r][c] == 1) {
						int ed = Math.abs(n - r) + Math.abs(archer[a] - c);
						if (ed < dist) {
							dist = ed;
							er = r;
							ec = c;
						} else if (dist == ed && c <= ec) {
							er = r;
							ec = c;
						}
					}
				}
			}
			if(er!=99 || ec!=99)
				target.add(new int[] { er, ec });
		}

		while (!target.isEmpty()) {
			int[] t = target.poll();
			if (map[t[0]][t[1]] == 1) {
				kill++;
				map[t[0]][t[1]] = 0;
			}
		}

		for (int r = n - 1; r > turn; r--) {
			for (int c = 0; c < m; c++) {
				map[r][c] = map[r - 1][c];
			}
		}
		for (int c = 0; c < m; c++)
			map[0][c] = 0;

		return kill;
	}

	static void playGame() {
		int[][] map = new int[n][m];
		int kill = 0;
		int turn = 0;
		for (int i = 0; i < n; i++) {
			System.arraycopy(origin[i], 0, map[i], 0, m);
		}

		while (!isFinished(map, turn)) {
			kill += doTurn(map, turn);
			turn++;
		}

		maxKill = kill > maxKill ? kill : maxKill;
	}

	static void makeCombination(int cnt, int start) {
		if (cnt == 3) {
			playGame();
		} else {
			for (int i = start; i < m; i++) {
				archer[cnt] = i;
				makeCombination(cnt + 1, i + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] inp = br.readLine().split(" ");
		n = Integer.parseInt(inp[0]);
		m = Integer.parseInt(inp[1]);
		d = Integer.parseInt(inp[2]);
		origin = new int[n][m];
		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				origin[i][j] = Integer.parseInt(inp[j]);
			}
		}

		makeCombination(0, 0);
		bw.write(maxKill + "");
		bw.close();
	}
}
