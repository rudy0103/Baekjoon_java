package b15652_N과M_4;  //중복조합

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n, m;
	static int a = 1;
	static int[] arr;

	static void backtracking(int cnt,int start) throws IOException {
		if (cnt == m) {

			for (int num : arr) {
				bw.write(num + " ");
			}
			bw.write("\n");
		} else {
			for (int i = start; i <= n; i++) {
				arr[cnt] =i;
				backtracking(cnt+1,i);
	
			}
		}
	}

	public static void main(String[] args) throws IOException {

		String[] inp = br.readLine().split(" ");
		n = Integer.parseInt(inp[0]);
		m = Integer.parseInt(inp[1]);
		arr = new int[m];

		backtracking(0,1);
		bw.flush();
		bw.close();
	}
}