package b1003_피보나치함수;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	

	static int [][] dp;
	static int[] fibonacci(int n) {
		if(dp[n][0]==0 &&dp[n][1]==0) {
			if(n==0) {
				dp[0][0]=1;
				return dp[0];
			}else if(n==1) {
				dp[1][1]=1;
				return dp[1];
			}else {
				
				dp[n][0]=fibonacci(n-1)[0]+fibonacci(n-2)[0];
				dp[n][1]=fibonacci(n-1)[1]+fibonacci(n-2)[1];
				return dp[n];
			}
		}
		else {
			return dp[n];
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int n=Integer.parseInt(br.readLine());
			dp=new int[n+1][2];
			fibonacci(n);
			bw.write(dp[n][0]+" "+dp[n][1]+"\n");
		}
		bw.close();
	}
}
