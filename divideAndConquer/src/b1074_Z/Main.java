package b1074_Z;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n, target_r, target_c;
	static int target;

	static void divideAndConquer(int n, int left_r, int left_c, int right_r, int right_c, int start) {

		if (n == 1) {
			if (left_r == target_r && left_c == target_c) {
				target = start;
			}
			return;
		}
		if (target_r >= left_r && target_r <= right_r && target_c >= left_c && target_c <= right_c) {
			divideAndConquer(n / 2, left_r, left_c, right_r - n / 2, right_c - n / 2, start + 0*(n * n/4));
			divideAndConquer(n / 2, left_r, left_c + n / 2, right_r - n / 2, right_c, start + 1*(n * n/4));
			divideAndConquer(n / 2, left_r + n / 2, left_c, right_r, right_c - n / 2, start + 2*(n * n/4));
			divideAndConquer(n / 2, left_r + n / 2, left_c + n / 2, right_r, right_c, start + 3*(n * n/4));
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = br.readLine().split(" ");
		n = Integer.parseInt(inp[0]);
		target_r = Integer.parseInt(inp[1]); //문제에서 원하는 r
		target_c = Integer.parseInt(inp[2]); //문제에서 원하는 c

		divideAndConquer((int) Math.pow(2, n), 0, 0, (int) Math.pow(2, n), (int) Math.pow(2, n), 0);
		System.out.println(target); //문제에서 원하는 r행c열의 탐색 순서 출력
	}
}
