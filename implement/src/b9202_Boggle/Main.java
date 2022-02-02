package b9202_Boggle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

	static HashSet<String> set = new HashSet<>();

	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, 1, -1, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int W = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < W; i++)
			set.add(br.readLine());

		br.readLine();

		int B = Integer.parseInt(br.readLine());
		char[][] board = new char[4][4];
		for (int i = 0; i < B; i++) {
			for (int j = 0; j < 4; j++) {
				board[j] = br.readLine().toCharArray();
			}

			boggle(board, sb);

			if (i != B - 1)
				br.readLine();
		}

		System.out.println(sb.toString());

	}

	private static void boggle(char[][] board, StringBuilder sb) {
		int score = 0;
		String longWord = "";
		int findCnt = 0;
		HashSet<String> found = new HashSet<>();
		boolean visited[][] = new boolean[4][4];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				String s = "" + board[i][j];
				visited[i][j]=true;
				dfs(s, 1, i, j, board, visited, found);
				visited[i][j]=false;
			}
		}
		findCnt = found.size();
		for (String str : found) {
			score += getScore(str);
			if (longWord.length() == str.length()) {
				if (longWord.compareTo(str) > 0)
					longWord = str;
			} else if (longWord.length() < str.length()) {
				longWord = str;
			}
		}
		sb.append(score).append(" ").append(longWord).append(" ").append(findCnt).append("\n");

	}

	private static int getScore(String str) {

		int len = str.length();

		if (len <= 2)
			return 0;
		else if (len <= 4)
			return 1;
		else if (len == 5)
			return 2;
		else if (len == 6)
			return 3;
		else if (len == 7)
			return 5;
		else if (len == 8)
			return 11;

		return 0;
	}

	private static void dfs(String s, int d, int r, int c, char[][] board, boolean[][] visited, HashSet<String> found) {

		if (d > 8)
			return;

		if (set.contains(s))
			found.add(s);

		for (int i = 0; i < 8; i++) {

			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 4 || nr < 0 || nc >= 4 || nc < 0 || visited[nr][nc])
				continue;

			visited[nr][nc] = true;
			dfs(s + board[nr][nc], d + 1, nr, nc, board, visited, found);
			visited[nr][nc] = false;
		}
		return;
	}
}