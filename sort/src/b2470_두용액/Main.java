package b2470_두용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int min = Integer.MAX_VALUE;

		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int p1 = 0;
		int p2 = arr.length - 1;
		int[] res = new int[2];
		while (p1 != p2) {
			int sum = arr[p1] + arr[p2];
			if (Math.abs(sum) < min) {
				min = Math.abs(sum);
				res[0] = arr[p1];
				res[1] = arr[p2];
			}

			if (sum > 0)
				p2--;
			else
				p1++;
		}
		System.out.println(res[0] +" "+ res[1]);

	}

}
