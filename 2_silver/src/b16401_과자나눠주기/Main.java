package b16401_과자나눠주기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int max=0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		
		int[] arr =new int[N];
		for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		
		binarySearch(arr,1,1000000000,M);
		System.out.println(max);
	}

	private static void binarySearch(int[] arr,int left, int right, int m) {
		
		
		int mid=(left+right)/2;
		if(mid==0) return;
		int cnt=0;
		
		int idx=Arrays.binarySearch(arr, mid);
		
		if(idx<0) {
			idx=-(idx+1);
		}else {
			while(idx>0&&arr[idx]>=mid) {
				idx--;
			}
		}
		
		for(int i=idx;i<arr.length;i++) {
			cnt+=arr[i]/mid;
		}
		
		if(left>=right) {
			if(cnt>=m) max=Math.max(mid, max);
			return;
		}
		
		if(cnt>=m) {
			binarySearch(arr, mid+1, right, m);
			max=Math.max(mid, max);
		}else {
			binarySearch(arr, left, mid, m);
		}
		
	}

}
