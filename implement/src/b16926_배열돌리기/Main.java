package b16926_배열돌리기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static int n, m, r, min;
	public static int[][] arr;
	public static int[][] tmp;

	public static int[] dr = { 0, 1, 0, -1 }; // 오른쪽 ->아래->왼쪽->위 방향 순서
	public static int[] dc = { 1, 0, -1, 0 }; // 오른쪽 ->아래->왼쪽->위 방향 순서

	public static void rotate(int s, int bottom_r, int right_c, int rotator) {
		if (s > min)
			return;
		else {
			int ro=rotator%((bottom_r-s+right_c-s)*2); // 방향을 일정하게 하고 돌리게 되면 제자리로 돌아오는
													//경우를 구해 많이 돌리게 될시 연산을 줄이는 효과를 볼 수 있습니다.
			for (int i = 0; i < ro; i++) {
				int tmp = arr[s][s]; //기준이 되는 원소를 임시 저장해줘야 합니다.
				int dir = 0;
				int before_r = s;
				int before_c = s;
				int next_r = -1;
				int next_c = -1;

				while (dir <= 3) { //오른쪽 -> 아래 ->왼쪽 ->위 순서로 돌고나면 끝이나게 됩니다.
					if (before_r + dr[dir] >= s && before_r + dr[dir] <= bottom_r && before_c + dc[dir] >= s
							&& before_c + dc[dir] <= right_c) {
						next_r = before_r + dr[dir];
						next_c = before_c + dc[dir];
						arr[before_r][before_c] = arr[next_r][next_c];
						before_r = next_r;
						before_c = next_c;
					} else {
						dir++;
					}

				}

				arr[s + 1][s] = tmp; //기준이되는 원소 아래에 있는 원소는 다른원소(기준원소의 오른쪽)를 땡기게되므로
									//저장해 둔 임시원소를 덮어씁니다.
			}
			rotate(s + 1, bottom_r - 1, right_c - 1, rotator);//기준원소와 테두리 경계가 바뀌면서 함수 호출
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] inp = br.readLine().split(" ");
		n = Integer.parseInt(inp[0]);
		m = Integer.parseInt(inp[1]);
		r = Integer.parseInt(inp[2]);

		arr = new int[n][m];
		tmp = new int[n][m];
		min = (n < m ? n : m)/2-1; //배열 돌리기에서 끝나는 조건입니다.
		for (int i = 0; i < n; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < inp.length; j++)
				arr[i][j] = Integer.parseInt(inp[j]);
		}

		rotate(0, n - 1, m - 1, r);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				bw.write(arr[i][j] + " ");
			bw.write("\n");
		}
		bw.close();
	}
}
