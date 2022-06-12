package b1009_분산처리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb =  new StringBuilder();
		
		for(int t=0;t<T;t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			int res=1;
			
			for(int i=1;i<=b;i++) {
				res*=a;
				res%=10;
			}
			if(res==0)
				sb.append(10+"\n");
			else sb.append(res+"\n");
			
			
		}
		
		System.out.println(sb.toString());

	}

}
