package b17406_배열돌리기4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int n, m, k;
	public static int[][] origin;
	public static int[][] selected;
	public static int[][] command;
	public static boolean[] isSelected;
	public static int min = Integer.MAX_VALUE;

	public static int[] dr = { 1, 0, -1, 0 };
	public static int[] dc = { 0, 1, 0, -1 };

	public static void makePermutaion(int cnt) throws IOException {
		if (cnt == k) {
			int[][] arr = new int[n][m]; // 연산의 순서를 다르게 해서 여러번 수행하기 때문에
											// 기존의 값을 복사해서 사용해야 합니다.

			for (int i = 0; i < n; i++) { // 기존의 배열을 복사
				System.arraycopy(origin[i], 0, arr[i], 0, origin[i].length);
			}
			 //rotate라는 함수에 연산자를 순서대로 파라미터로 넘겨 수행
			//selected[i][0]는 i번 째 연산의  r값
			//selected[i][1]는 i번 째 연산의  c값
			//selected[i][1]는 i번 째 연산의  s값
			for (int i = 0; i < k; i++) {
				rotate(selected[i][0] - selected[i][2], selected[i][1] - selected[i][2],
						selected[i][0] + selected[i][2], selected[i][1] + selected[i][2], arr);
			}
			for (int i = 0; i < n; i++) {
				int sum = 0;
				for (int j = 0; j < m; j++)  //각행의 합을 구함
					sum += arr[i][j];
				min = sum < min ? sum : min; //각행의 합과 min을 비교해 최소값을 갱신
			}
		} else {
			for (int i = 0; i < k; i++) {
				if (isSelected[i])
					continue;
				isSelected[i] = true;
				selected[cnt] = command[i];
				makePermutaion(cnt + 1);
				isSelected[i] = false;
			}
		}
	}

	public static void rotate(int r, int c, int bottom_r, int right_c, int[][] arr) {
		if (r == bottom_r || c == right_c) {
			return;
		} else {
			int tmp = arr[r][c];
			int dir = 0;
			int before_r = r;
			int before_c = c;
			int next_r = -1;
			int next_c = -1;

			while (dir <= 3) {  //반시계 방향으로 돌리기 배열 돌리기 1 참조
				next_r = before_r + dr[dir];
				next_c = before_c + dc[dir];
				if (next_r >= r && next_r <= bottom_r && next_c >= c && next_c <= right_c) {
					arr[before_r][before_c] = arr[next_r][next_c];
					before_r = next_r;
					before_c = next_c;
				} else {
					dir++;
				}
			}
			arr[r][c + 1] = tmp;
			rotate(r + 1, c + 1, bottom_r - 1, right_c - 1, arr);
		}
	}

	public static void main(String[] args) throws IOException {

		String[] inp = br.readLine().split(" ");
		n = Integer.parseInt(inp[0]);
		m = Integer.parseInt(inp[1]);
		k = Integer.parseInt(inp[2]);

		origin = new int[n][m];
		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < inp.length; j++)
				origin[i][j] = Integer.parseInt(inp[j]);
		}

		isSelected = new boolean[k];
		command = new int[k][3];
		selected = new int[k][3];

		for (int i = 0; i < k; i++) {
			inp = br.readLine().split(" ");
			command[i][0] = Integer.parseInt(inp[0]) - 1;
			command[i][1] = Integer.parseInt(inp[1]) - 1;
			command[i][2] = Integer.parseInt(inp[2]);
		}

		makePermutaion(0); // 연산의 순열을 구하는 함수
		bw.write(min + "\n");
		bw.close();
	}
}
