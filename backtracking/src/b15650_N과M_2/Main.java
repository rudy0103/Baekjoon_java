package b15650_N과M_2; //조합

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n, m;
	static int[] arr;

	static void combination(int cnt, int next) throws IOException {
		if (cnt == m) {
			for (int num : arr) {
				bw.write(num + " ");
			}
			bw.write("\n");
		} else {
			for (int i = next; i <= n; i++) {
				arr[cnt] = i;
				combination(cnt + 1, i + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {

		String[] inp = br.readLine().split(" ");
		n = Integer.parseInt(inp[0]);
		m = Integer.parseInt(inp[1]);
		arr = new int[m];
		combination(0, 1);
		bw.flush();
		bw.close();

	}
}
