package b1920_수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static boolean findNumber(int left, int right, int a, int[] arr) {

		if (left > right)
			return false;
		
		int mid = (left + right) / 2;
		if (arr[mid] == a) {
			return true;
		}

		if (a < arr[mid]) {
			return findNumber(left, mid-1, a, arr);
		} else {
			return findNumber(mid + 1, right, a, arr);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int idx = 0;
		while (st.hasMoreTokens())
			arr[idx++] = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int[] arr2 = new int[M];
		idx = 0;
		while (st.hasMoreTokens())
			arr2[idx++] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		for (int i = 0; i < M; i++) {
			if (findNumber(0, arr.length-1, arr2[i], arr)) {
				sb.append("1").append("\n");
			} else
				sb.append("0").append("\n");
		}
		System.out.println(sb.toString());
	}
}
