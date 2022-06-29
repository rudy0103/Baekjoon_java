package b2668_숫자고르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		boolean[] isTrue = new boolean[N + 1];
		int[] arr = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=1;i<=N;i++) {
			
			if(checkGroup(arr,i,arr[i],0)) {
				isTrue[i]=true;
			}
			
		}
		int cnt=0;
		
		for(int i=1;i<=N;i++) {
			if(isTrue[i]) cnt++;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(cnt+"\n");
		
		for(int i=1;i<=N;i++) {
			if(isTrue[i]) sb.append(i).append("\n");
		}
		System.out.println(sb.toString());
		

	}

	private static boolean checkGroup(int[] arr,int start,int to, int cnt) {
		
		if(cnt>N) {
			return false;
		}
		if(start==to) {
			return true;
		}else {
			return checkGroup(arr,start, arr[to], cnt+1);
		}
		
	}

}
