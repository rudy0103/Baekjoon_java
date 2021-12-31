package b1300_K번째수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int K=Integer.parseInt(br.readLine());
		
		
		int left=1;
		int right=K;
		
		while(left<=right) {
			int mid=(left+right)/2;
			
			int cnt=0;
			
			for(int i=1;i<=N;i++) {
				cnt+=Math.min(mid/i,N);
			}
			
			if(cnt>=K) {
				right=mid-1;
			}else {
				left=mid+1;
			}
			
		}
		
		System.out.println(left);
	}

}
