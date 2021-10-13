package b13458_시험감독;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine()," ");
		int B=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		
		long total=0;
		for(int i=0;i<N;i++) {
			arr[i]-=B;
			total++;
			if(arr[i]<=0) {
				continue;
			}else {
				if(arr[i]%C==0) total+=arr[i]/C;
				else total+=(arr[i]+C)/C;
			}
			
		}
		
		System.out.println(total);
	}

}
