package b15810_풍선공장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static long min;

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		long [] arr = new long[N];
		
		st=new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		min=arr[0]*M;
		
		long left=0,right=min;
		
		binarySearch(arr,left,right);
		
		System.out.println(min);
	}

	private static void binarySearch(long[] arr, long left, long right) {
		
		if(left>=right) {
			return;
		}
		
		long mid=(left+right)/2;
		
		long cnt=0;
		
		for(int i=0;i<N;i++) {
			cnt+=mid/arr[i];
			if(cnt>=M) break;
		}
		
		if(cnt>=M) {
			binarySearch(arr, left, mid);
			min=Math.min(min, mid);
		}else {
			binarySearch(arr, mid+1, right);
		}
	}
}
