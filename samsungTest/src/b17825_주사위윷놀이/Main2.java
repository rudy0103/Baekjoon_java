package b17825_주사위윷놀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main2 {

	static int max = 0;
	static int[][] before = new int[10][2];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] map = new int[4][22];
		int[] dice = new int[10];
		HashMap<Integer, Integer> hmap = new HashMap<>();

		for (int i = 0; i < 10; i++)
			dice[i] = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= 20; i++) {
			map[0][i] = i;
			hmap.put(i, i * 2);
		}
		hmap.put(25, 25);
		hmap.put(26, 30);
		hmap.put(27, 35);
		hmap.put(22, 13);
		hmap.put(23, 16);
		hmap.put(24, 19);
		hmap.put(25, 25);
		hmap.put(28, 22);
		hmap.put(29, 24);
		hmap.put(30, 28);
		hmap.put(31, 27);
		hmap.put(32, 26);
		map[0][21] = 21;
		// 21은 끝
		map[1] = new int[] { 5, 22, 23, 24, 25, 26, 27, 20, 21 };
		map[2] = new int[] { 10, 28, 29, 25, 26, 27, 20, 21 };
		map[3] = new int[] { 15, 30, 31, 32, 25, 26, 27, 20, 21 };

		int[][] horses = new int[4][2];

		playGame(0, map, horses, dice, 0, hmap);

		System.out.println(max);
	}

	private static void playGame(int d, int[][] map, int[][] horses, int[] dice, int score,
			HashMap<Integer, Integer> hmap) {

		if (d == 10) {
			if (score > max)
				max = score;
			return;
		}

		for (int i = 0; i < 4; i++) {

			if (map[horses[i][0]][horses[i][1]] == 21)
				continue;

			before[d][0] = horses[i][0];
			before[d][1] = horses[i][1];

			int s = 0;
			if (horses[i][0] == 0 && map[horses[i][0]][horses[i][1]] % 5 == 0) {
				if (map[horses[i][0]][horses[i][1]] != 20) {
					horses[i][0] = map[horses[i][0]][horses[i][1]] / 5;
					horses[i][1] = 0;
				}
			}

			int next = horses[i][1];
			for (int j = 1; j <= dice[d]; j++) {
				if (map[horses[i][0]][++next] != 21) {
					s = hmap.get(map[horses[i][0]][next]);
				} else {
					s = 0;
					break;
				}
			}

			horses[i][1] = next;

			boolean possible = true;
			for (int j = 0; j < 4; j++) {
				if (map[horses[i][0]][horses[i][1]] == 21)
					break;
				if (i == j)
					continue;
				if (map[horses[j][0]][horses[j][1]] == map[horses[i][0]][horses[i][1]]) {
					possible = false;
					break;
				}
			}
			if (!possible) {
				horses[i][0] = before[d][0];
				horses[i][1] = before[d][1];
				continue;
			}

			playGame(d + 1, map, horses, dice, score + s, hmap);

			horses[i][0] = before[d][0];
			horses[i][1] = before[d][1];
		}

	}

}
