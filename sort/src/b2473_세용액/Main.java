package b2473_세용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long min = Long.MAX_VALUE;

		long[] arr = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr);
		long[] res = new long[3];

		for (int i = 0; i < N - 2; i++) {
			int left = i + 1;
			int right = N - 1;

			while (left < right) {
				long sum = arr[i] + arr[left] + arr[right];
				long abs = Math.abs(sum);

				if (abs < min) {
					min = abs;
					res[0] = arr[i];
					res[1] = arr[left];
					res[2] = arr[right];
				}

				if (sum > 0) {
					right--;
				} else {
					left++;
				}
			}

		}

		System.out.println(res[0] + " " + res[1] + " " + res[2]);
	}
}
