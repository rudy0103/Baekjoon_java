package b7453_합이0인네정수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];
		int[] C = new int[N];
		int[] D = new int[N];

		int[] X = new int[N * N];
		int[] Y = new int[N * N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}

		int idx = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				X[idx] = A[i] + B[j];
				Y[idx++] = C[i] + D[j];

			}
		}
		Arrays.sort(X);
		Arrays.sort(Y);

		long cnt = 0;
		int len = N * N - 1;

		for (int i = 0; i <= len; i++) {
			int num = X[i] * -1;

			int leftPos = findLeft(Y, num, 0, len);
			if (leftPos == -1)
				continue;
			int rightPos = findRight(Y, num, 0, len);
			cnt += (rightPos - leftPos + 1);
		}
		System.out.println(cnt);
	}

	private static int findRight(int[] arr, int num,int left, int right) {
		int pos = -1;


		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid] > num) {
				right = mid - 1;
			} else if (arr[mid] < num) {
				left = mid + 1;
			} else {
				left = mid + 1;
				if (arr[mid] == num)
					pos = mid;
			}
		}

		return pos;
	}

	private static int findLeft(int[] arr, int num,int left, int right) {
		int pos = -1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid] > num) {
				right = mid - 1;
			} else if (arr[mid] < num) {
				left = mid + 1;
			} else {
				right = mid - 1;
				if (arr[mid] == num)
					pos = mid;
			}
		}

		return pos;
	}
}