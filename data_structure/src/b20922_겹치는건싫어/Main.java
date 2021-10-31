package b20922_겹치는건싫어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int [] arr = new int[100001];
		
		ArrayDeque<Integer> dq= new ArrayDeque<Integer>();
		int max=0;
		
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			int tmp=Integer.parseInt(st.nextToken());
			arr[tmp]++;
			dq.add(tmp);
			if(arr[tmp]>K) {
				while(dq.peekFirst()!=tmp) arr[dq.poll()]--;
				arr[dq.poll()]--;
			}
			if(dq.size()>max) max=dq.size();
		}
		
		System.out.println(max);

	}
}
