package b2805_나무자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int res;

	public static void cutTree(int start, int end, int[] arr, int M) {
		if (start > end) {
			return;
		}

		long sum = 0;

		int mid = (start + end) / 2;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] - mid > 0)
				sum += (arr[i] - mid);
			if (sum > M)
				break;
		}

		if (sum == M) {
			res = mid;
		} else if (sum < M) {
			cutTree(start, mid - 1, arr, M);
		} else {
			res = mid;
			cutTree(mid + 1, end, arr, M);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String[] inp = br.readLine().split(" ");
		int N = Integer.parseInt(inp[0]);
		int M = Integer.parseInt(inp[1]);
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());

		int end = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] > end)
				end = arr[i];
		}
		cutTree(0, end, arr, M);
		System.out.println(res);
	}
}
