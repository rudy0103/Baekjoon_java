package b2590_색종이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[7];
		for (int i = 1; i <= 6; i++)
			arr[i] = Integer.parseInt(br.readLine());

		cnt += arr[6];
		cnt += arr[5];

		arr[1] -= 11 * arr[5];

		while (arr[4] > 0) {
			cnt++;
			arr[4]--;

			int remain = 20;

			while (remain > 0) {
				if (arr[2] > 0) {
					remain -= 4;
					arr[2]--;
				}
				else if (arr[2] == 0) {
					if (arr[1] > 0) {
						remain--;
						arr[1]--;
					} else
						break;
				}
			}
		}

		cnt += arr[3] / 4;
		arr[3] %= 4;

		if (arr[3] == 3) {
			cnt++;
			arr[2] -= 1;
			arr[1] -= 5;
		} else if (arr[3] == 2) {
			cnt++;
			arr[2] -= 3;
			arr[1] -= 6;
		} else if (arr[3] == 1) {
			cnt++;
			arr[2] -= 5;
			arr[1] -= 7;
		}

		if (arr[2] > 0) {
			cnt += arr[2] / 9;
			arr[2] %= 9;
		}

		if (arr[2] > 0) {
			cnt++;
			arr[1] -= 36 - arr[2] * 4;
		} else {
			arr[1] += arr[2] * 4;
		}

		if (arr[1] > 0) {
			cnt += arr[1] / 36;
			arr[1] %= 36;
		}

		if (arr[1] > 0)
			cnt++;

		System.out.println(cnt);

	}

}
