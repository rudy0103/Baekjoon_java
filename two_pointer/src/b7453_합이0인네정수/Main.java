package b7453_합이0인네정수;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N * 4];

		int idx = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[idx++] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		for (int j = 0; j < 4; j++) {
			arr[idx++] = Integer.parseInt(st.nextToken());
		}

	}
}
