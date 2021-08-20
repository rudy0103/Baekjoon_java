package b1987_알파벳;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int R, C, max;
	static char[][] map;
	static boolean[] cantGo;// 해당 칸으로 갈 수 있는지 알파벳으로 체크
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void alpha(int row, int col, int step) {

		if (step > max)
			max = step; // 매 칸을 지날 때 마다 step과 max를 비교하여 갱신

		for (int i = 0; i < 4; i++) { // 4가지 방향으로 분기
			int rr = row + dr[i];
			int cc = col + dc[i];
			if (rr >= 0 && rr < R && cc >= 0 && cc < C && !cantGo[map[rr][cc] - 'A']) {// 분기 조건 체크
				cantGo[map[rr][cc] - 'A'] = true; // 지나간 알파벳을 true로 바꿈
				alpha(rr, cc, step + 1);
				cantGo[map[rr][cc] - 'A'] = false; // 탐색후에 다시 false로 바꿈
			}
		}
	};

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = br.readLine().split(" ");
		R = Integer.parseInt(inp[0]);
		C = Integer.parseInt(inp[1]);
		cantGo = new boolean[26]; // A~Z 알파벳을 지나갔는지 체크하는 boolean 배열
		map = new char[R][C];
		for (int i = 0; i < R; i++)
			map[i] = br.readLine().toCharArray();
		cantGo[map[0][0] - 'A'] = true; // 초기 상태 알파벳은 밟았다고 가정
		alpha(0, 0, 1); // 초기 상태는 0,0에서 시작, step1 부터 시작
		System.out.println(max);
	}
}
