package b14719_빗물;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int[] arr = new int[W + 1];
		int[] left = new int[W + 1];
		int[] right = new int[W + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= W; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int l = 0;

		for (int i = 1; i <= W; i++) {
			if (l > arr[i]) {
				left[i] = l;
			} else {
				left[i] = arr[i];
				l = arr[i];
			}
		}

		int r = 0;

		for (int i = W; i >= 1; i--) {
			if (r > arr[i]) {
				right[i] = r;
			} else {
				right[i] = arr[i];
				r = arr[i];
			}
		}

		int sum = 0;

		for (int i = 1; i <= W; i++) {
			int h = Math.min(left[i], right[i]);
			if (h > arr[i])
				sum += (h - arr[i]);
		}
		System.out.println(sum);

	}

}
