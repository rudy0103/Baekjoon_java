package b15664_N과M_10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] selected, arr;
	static StringBuilder sb =new StringBuilder();

	public static void makeCombination(int cnt, int start) throws IOException {
		if (cnt == selected.length) {
			for (int n : selected)
				sb.append(n).append(" ");
			sb.append("\n");
			return;
		}
		int before=0;
		for (int i = start; i < arr.length; i++) {
			if(arr[i]==before) continue;
			selected[cnt] = arr[i];
			before=arr[i];
			makeCombination(cnt + 1, i+1);
		}
	}

	public static void main(String[] args) throws IOException {
		String[] inp = br.readLine().split(" ");
		int N = Integer.parseInt(inp[0]);
		int M = Integer.parseInt(inp[1]);
		arr = new int[N];
		selected = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int i = 0;
		while (st.hasMoreTokens())
			arr[i++] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		makeCombination(0, 0);
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}