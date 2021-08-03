package b2798_블랙잭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int n, m;
	public static int max = -1;
	public static int[] arr;

	public static void bruteForce(int a, int l, int sum) {
		if (l == 3) {
			if (sum >= max && sum <= m) {
				max = sum;
			}
		} else {
			for (int i = a ; i < arr.length; i++) {
				bruteForce(i+1, l + 1, sum + arr[i]);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		String[] s = br.readLine().split(" ");
		arr = new int[s.length];
		int i = 0;
		for (String str : s) {
			arr[i++] = Integer.parseInt(str);
		}
		
		bruteForce(0, 0, 0);
		
		System.out.println(max);
	}
}
