package b20299_3대측정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int L=Integer.parseInt(st.nextToken());
		
		
		int[] arr = new int[3];
		int cnt=0;
		
		for(int i=0;i<N;i++) {
			 st = new StringTokenizer(br.readLine()," ");
			 int sum=0;
			 boolean flag=true;
			 for(int j=0;j<3;j++) {
				 arr[j]=Integer.parseInt(st.nextToken());
				 if(arr[j]<L) {
					 flag=false;
					 break;
				 }
				 sum+=arr[j];
			 }
			 
			 if(flag&&sum>=K) {
				 cnt++;
				 for(int j=0;j<3;j++) {
					 sb.append(arr[j]).append(" ");
				 }
			 }
			 
		}
		System.out.println(cnt);
		System.out.println(sb.toString());
		
	}

}
