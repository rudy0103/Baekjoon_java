package b11501_주식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc=0;tc<T;tc++) {
			int N=Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			long tot=0;
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			int high=arr[N-1];
			
			int idx=N-2;
			if(N==1) {
				sb.append("0\n");
				continue;
			}
			while(idx>=0) {
				if(arr[idx]<high) {
					tot+=high-arr[idx--];
				}
				else {
					high=arr[idx--];
				}
			}
			sb.append(tot+"\n");
			
		}
		System.out.println(sb.toString());
	}
}
