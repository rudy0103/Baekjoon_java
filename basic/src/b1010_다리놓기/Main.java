package b1010_다리놓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			String [] inp=br.readLine().split(" ");
			int N=Integer.parseInt(inp[0]);
			int M=Integer.parseInt(inp[1]);
			
			if(N==0 || M==0) {
				sb.append("0\n");
				continue;
			}
			
			sb.append(getComb(N,M)).append("\n");
		}
		System.out.println(sb.toString());

	}

	private static long getComb(int n, int m) {
		long ret=1;
		
		for(int i=0;i<n;i++) {
			ret*=(m-i);
			ret/=(i+1);
		}
		return ret;
	}
}
