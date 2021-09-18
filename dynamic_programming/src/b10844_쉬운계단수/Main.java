package b10844_쉬운계단수;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		if (N == 1)
			System.out.println(9);
		else if (N == 2)
			System.out.println(17);
		else {
			int[][] dp = new int[N+1][10];
			int mod=1000000000;
			for(int i=1;i<=9;i++) dp[1][i]=1;
			
			for (int i = 2; i <= N; i++) {
				dp[i][0]=dp[i-1][1];
				dp[i][9]=dp[i-1][8];
				for(int j=1;j<=8;j++) {
					dp[i][j]=(dp[i-1][j-1]%mod+dp[i-1][j+1]%mod)%mod;
				}
			}
			int res=0;
			for(int i=0;i<10;i++) {
				res+=dp[N][i];
				res%=mod;
			}
			System.out.println(res);
			System.out.println(Arrays.deepToString(dp));
		}
	}
}
