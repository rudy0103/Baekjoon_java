package b3025_돌던지기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	static Stack<int[]>[] stack;
	static int R, C;
	static char[][] map;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] inp = br.readLine().split(" ");

		R = Integer.parseInt(inp[0]);
		C = Integer.parseInt(inp[1]);

		map = new char[R + 1][C];

		stack = new Stack[C];

		for (int i = 0; i < C; i++)
			stack[i] = new Stack<int[]>();

		for (int i = 1; i <= R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int c = Integer.parseInt(br.readLine());
			throwStone(c-1);
		}

		for (int r = 1; r <= R; r++) {
			for (int c = 0; c < C; c++) {
				sb.append(map[r][c]);
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}

	private static void throwStone(int col) {

		while (!stack[col].isEmpty() && map[stack[col].peek()[0]][stack[col].peek()[1]] != '.') {
			stack[col].pop();
		}

		if (!stack[col].isEmpty()) {// 스택이 비어있지 않을 때
			check(stack[col].peek()[0], stack[col].peek()[1], col);
			return;
		}
		check(0, col, col);

	}

	private static void check(int row, int col, int s) {
		int r = row;
		int c = col;

		while (r <= R) {
			if (r + 1 > R || map[r + 1][c] == 'X') {
				map[r][c] = 'O';
				stack[s].pop();
				break;
			} else {
				if (map[r + 1][c] == '.') { // 돌이 내려갈 수 있다.
					stack[s].add(new int[] { r + 1, c });
					r += 1;
					continue;
				} else { // 한칸 밑에 돌이 있다.
					// 왼쪽
					if (c - 1 >= 0 && map[r + 1][c - 1] == '.' && map[r][c - 1] == '.') {
						stack[s].add(new int[] { r + 1, c - 1 });
						r += 1;
						c -= 1;
						continue;
					} else if (c + 1 < C && map[r + 1][c + 1] == '.' && map[r][c + 1] == '.') {
						stack[s].add(new int[] { r + 1, c + 1 });
						r += 1;
						c += 1;
						continue;
					} else {
						map[r][c] = 'O';
						stack[s].pop();
						break;
					}
				}
			}
		}
	}

}
