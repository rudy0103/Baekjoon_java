import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char[][] map;
	static int R, C, N;
	static int[] col;

	static void printMap() {
		StringBuilder res = new StringBuilder();
		for (char[] arr : map) {
			res.append(String.valueOf(arr)).append("\n");
		}
		System.out.println(res);
	}

	public static void main(String[] args) throws IOException {

//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// R,C 입력값 받기
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		// map 입력값 받기
		map = new char[R][C];
		col = new int[C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (col[j] == 0 && map[i][j] == 'X') {
					col[j] = i - 1;
				}
			}
		}

		for (int i = 0; i < C; i++)
			if (col[i] == 0)
				col[i] = R - 1;
//		printMap();
		// 화산탄 개수
		N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			String inp = br.readLine();
			int c = Integer.parseInt(inp) - 1; // 열
			int r = col[c]; //

			while (true) {
				while (r + 1 < R && map[r + 1][c] == '.') // 아래 행이 유효범위고 '.'이면 내려감
					r++;
				if (r == R - 1 && map[r][c] == '.' || map[r + 1][c] == 'X') { // 만약 마지막 행이고'.'이거나 다음행이 'X'이면 굳음
					if (col[c] > r - 1)
						col[c] = r - 1;
					map[r][c] = 'O';
					break;
				} else if (map[r + 1][c] == 'O') {// 만약 화산탄이 굳어있다면
					if (c - 1 >= 0 && map[r + 1][c - 1] == '.'&& map[r][c - 1] == '.') {// 왼쪽이 비고 왼쪽아래도 비면
						c--;
						if (col[c] > r)
							r = col[c];
					} else if (c + 1 < C && map[r + 1][c + 1] == '.'&& map[r][c + 1] == '.' ) {// 오른쪽이 비고 오른쪽 아래도 비면
						c++;
						if (col[c] > r)
							r = col[c];
					} else {
						map[r][c] = 'O';// 왼쪽도 안되고 오른쪽도 안되면 굳음
						break;
					}
				}
			}
		}
		printMap();
	}
}
