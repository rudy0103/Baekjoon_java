package b6236_용돈관리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static long min;
	static int N,M,max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long K=0;
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			max=Math.max(max, arr[i]);
			K+=arr[i];
		}
		
		min=K;
		
		getMin(arr,1,K);
		
		System.out.println(min);
		
		
		
	}

	private static void getMin(int[] arr, long left, long right) {
		
		if(left>right) return;
		
		long mid=(left+right)/2;
		
		if(isPossible(arr,mid)) {
			min=Math.min(mid,min);
			right=mid-1;
			getMin(arr, left, right);
			
		}else {
			left=mid+1;
			getMin(arr, left, right);
		}
		
		
	}

	private static boolean isPossible(int[] arr, long mid) {
		if(mid<max) return false;
		
		int cnt=0;
		
		long curr=0;
		
		for(int i=0;i<N;i++) {
			if(arr[i]>curr) {
				curr=mid-arr[i];
				cnt++;
			}else {
				curr-=arr[i];
			}
		}
		
		if(cnt>M) return false;
		
		return true;
	}

}
