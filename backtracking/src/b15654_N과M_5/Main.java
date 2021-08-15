package b15654_N과M_5;

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
	static int[] selected,arr;
	public static void makePermutation(int cnt,int flag) throws IOException {
		if (cnt == selected.length) {
			for(int n:selected)
				bw.write(n+" ");
			bw.write("\n");
			return;
		}
		
		for(int i=0;i<arr.length;i++) {
			if((flag&1<<i)!=0) continue;
			selected[cnt]=arr[i];
			makePermutation(cnt+1,flag|1<<i);
		}

	}

	public static void main(String[] args) throws IOException {
		String[] inp = br.readLine().split(" ");
		int N = Integer.parseInt(inp[0]);
		int M = Integer.parseInt(inp[1]);

		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int i=0;
		while(st.hasMoreTokens()) arr[i++]=Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		selected = new int[M];
		makePermutation(0,0);
		br.close();
		bw.close();
	}
}