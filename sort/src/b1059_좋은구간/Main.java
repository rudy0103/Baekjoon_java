package b1059_좋은구간;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int[] arr = new int[L];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < L; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int n = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		int max = arr[L - 1];
		int cnt = 0;

		for (int i = 1; i < max; i++) {
			for (int j = i + 1; j <= max; j++) {
				boolean f = false;
				if (i <= n && n <= j)
					f = true;
				if (!f)
					continue;
				for (int l = 0; l < L; l++) {
					if (i <= arr[l] && arr[l] <= j) {
						f = false;
					}
				}
				if (f)
					cnt++;
			}
		}

		System.out.println(cnt);

	}

}
