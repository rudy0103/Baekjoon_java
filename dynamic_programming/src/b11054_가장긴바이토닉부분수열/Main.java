package b11054_가장긴바이토닉부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());
		
		st=new StringTokenizer(br.readLine()," ");
		
		int[] arr = new int[n];
		int[] increase=new int[n];
		int[] decrease=new int[n];
		int[] dp = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		

		Arrays.fill(dp, 9999);
		
		for(int size =1; size<=n;size++) {
			int len=0;
			for(int i=0; i<size;i++) {
				int tmp = Arrays.binarySearch(dp, 0, len, arr[i]);
				if (tmp >= 0)
					continue;
				tmp = Math.abs(tmp) - 1;
				dp[tmp] = arr[i];
				if (tmp == len)
					len++;
			}
			if(increase[size-1]<len) increase[size-1]=len;
			Arrays.fill(dp, 9999);
		}
		
		for(int size=n-1; size>=0;size--) {
			int len=0;
			for(int i=n-1; i>=0+size;i--) {
				int tmp = Arrays.binarySearch(dp, 0, len, arr[i]);
				if (tmp >= 0)
					continue;
				tmp = Math.abs(tmp) - 1;
				dp[tmp] = arr[i];
				if (tmp == len)
					len++;
			}
			if(decrease[size]<len) decrease[size]=len;
			Arrays.fill(dp, 9999);
		}
		
		int max=0;
		for(int i=0;i<n;i++) {
			if(increase[i]+decrease[i]>max) max=increase[i]+decrease[i];
		}
		
		System.out.println(max-1);

	}
}
