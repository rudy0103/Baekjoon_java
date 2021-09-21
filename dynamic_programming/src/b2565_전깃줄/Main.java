package b2565_전깃줄;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N=Integer.parseInt(br.readLine());
		
		int [] arr = new int[501];
		int [] dp = new int[N+1];
		
		ArrayList<Integer> list= new ArrayList<>();
		
		
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<arr.length;i++) if(arr[i]!=0) list.add(arr[i]);
		
		for(int i=1;i<=N;i++) dp[i]=Integer.MAX_VALUE;
		
		int len=0;
		for(int i=0;i<list.size();i++) {
			int num=list.get(i);
			int tmp=Arrays.binarySearch(dp,0,len,num);
			tmp=Math.abs(tmp)-1;
			if(tmp==len) len++;
			dp[tmp]=num;
		}
		System.out.println(N-len);
	}
}
