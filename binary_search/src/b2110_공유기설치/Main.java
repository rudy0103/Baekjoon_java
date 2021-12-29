package b2110_공유기설치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, C, res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		if (C == 2) {
			System.out.println(arr[N - 1] - arr[0]);
		} else {
			int left=0;
			int right=arr[N-1]-arr[0];
			
			while(left<=right) {
				int mid=(left+right)/2;
				
				if(checkDistance(arr,mid)) {
					res=mid;
					left=mid+1;
				}else right=mid-1;
				
			}
			System.out.println(res);
		}

	}

	private static boolean checkDistance(int[] arr, int mid) {
		
		int cnt=1;
		int j=0;
		
		for(int i=1;i<N;i++) {
			if(arr[i]-arr[j]>=mid) {
				j=i;
				cnt++;
			}
		}
		
		if(cnt>=C) {
			return true;
		}
		return false;
	}
}
