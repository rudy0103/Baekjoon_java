package b10157_자리배정;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] inp = br.readLine().split(" ");
		int C = Integer.parseInt(inp[0]);
		int R = Integer.parseInt(inp[1]);

		int[][] arr = new int[R][C];
		int K = Integer.parseInt(br.readLine());

		// 상 우 하 좌
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int dir = 0;
		int num = 1;
		
		if (K > R * C)
			bw.write("0");
		else {
			int start_r = R - 1;
			int start_c = 0;
			arr[start_r][start_c] = num;
			while (num < K) {
				int next_r = start_r + dr[dir];
				int next_c = start_c + dc[dir];
				if (next_r >= 0 && next_r < R && next_c >= 0 && next_c < C) {
					if (arr[next_r][next_c] == 0) {
						start_r = next_r;
						start_c = next_c;
						arr[start_r][start_c] = ++num;
						if(num== K) {
							break;
						}
					} else {
						dir++;
						if (dir == 4)
							dir = 0;
					}
				} else {
					dir++;
					if (dir == 4)
						dir = 0;
				}
			}
			bw.write((start_c+1)+" "+(R-start_r));
		}
		bw.close();
	}
}