package b1654_랜선자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static long res;
	public static void cutLan(long start,long end,int [] arr,int K) {
		
		if(start>end) return;
		
		long mid=(start+end)/2;
		if(mid==0) mid=1;
		int cnt=0;
		for(int i=0;i<arr.length;i++) {
			cnt+=arr[i]/mid;
		}
		
		if(cnt>=K) {
			if(mid>res) res=mid;
			cutLan(mid+1, end, arr, K);
		}else {
			cutLan(start, mid-1, arr, K);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = br.readLine().split(" ");
		int N = Integer.parseInt(inp[0]);
		int K = Integer.parseInt(inp[1]);
		int[] arr = new int[N];
		int end = -1;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (end < arr[i])
				end = arr[i];
		}
		if (K == 1)
			System.out.println(end);
		else {
			cutLan(0, end, arr, K);
			System.out.println(res);
		}

	}

}
