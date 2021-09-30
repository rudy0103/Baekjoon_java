package b9251_LCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmpA = br.readLine();
		String tmpB = br.readLine();
		int N,M;
		String A,B;
		if(tmpA.length()<=tmpB.length()) {
			N=tmpA.length();
			M=tmpB.length();
			A=tmpA;
			B=tmpB;
		}else {
			N=tmpB.length();
			M=tmpA.length();
			A=tmpB;
			B=tmpA;
		}
		
		int [][]dp=new int[N+1][M];
		
		for(int i=1;i<=N;i++) {
			for(int j=0;j<M;j++) {
				if(A.ca)
				
			}
		}
		
		
		
		
		

	}

}
