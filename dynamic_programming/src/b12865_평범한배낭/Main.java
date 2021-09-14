package b12865_평범한배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String [] inp = br.readLine().split(" ");
		
		int N=Integer.parseInt(inp[0]);
		int K=Integer.parseInt(inp[1]);
		
		ArrayList<int []> list = new ArrayList<>();
		int [] values=new int[K+1];
		
		for(int i=1;i<=K;i++) values[i]=-1;
		
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			int W=Integer.parseInt(st.nextToken());
			int V=Integer.parseInt(st.nextToken());
			list.add(new int[] {W,V});
		}
		
		for(int[] a:list) {
			int idx=-1;
			int tmp=-1;
			for(int i=0;i<=K-a[0];i++) {
				if(values[i]>tmp) {
					tmp=values[i];
					idx=i;
				}
			}
			values[idx+a[0]]=values[idx]+a[1];
		}
		
		int max=0;
		for(int i=1;i<=K;i++)
			if(values[i]>max) max=values[i];
		System.out.println(max);
	}
}
