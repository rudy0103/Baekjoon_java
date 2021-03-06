package b3109_빵집;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int R, C;
	static char[][] map;
	static boolean isTrue;
	static int max = 0;

	public static void backtracking(int start, int cnt, int id) {
		if (cnt == C - 1) {
			max++; //연결이 되면 개수 증가
			isTrue = true; // 더이상 분기 안되게 설정하는 flag
			return;
		}

		for (int i = start - 1; i <= start + 1; i++) {
			if (i >= 0 && i < R)
				if (map[i][cnt + 1] == '.') {
					map[i][cnt + 1] = 'p';
					backtracking(i, cnt + 1, id);
					if (isTrue) // 설치가 완료됐으면 빠져나가야함
						break;
				}
		}
	}

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = br.readLine().split(" ");

		R = Integer.parseInt(inp[0]);
		C = Integer.parseInt(inp[1]);
		map = new char[R][C];
		for (int i = 0; i < R; i++)
			map[i] = br.readLine().toCharArray();

		for (int id = 0; id < R; id++) { // 모든 행마다 설치 시도
			isTrue = false;
			backtracking(id, 0, id);
		}
		System.out.println(max);
	}
}
