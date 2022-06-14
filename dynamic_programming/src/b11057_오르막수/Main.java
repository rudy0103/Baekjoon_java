package b11057_오르막수;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int N=sc.nextInt();
		
		int[][]dp=new int[N+3][10];
		
		int m=10007;
		
		for(int i=0;i<=9;i++) dp[1][i]=1;
		
		for(int i=2;i<=N;i++) {
			for(int j=0;j<=9;j++) {
				for(int k=j;k<=9;k++) {
					dp[i][j]+=dp[i-1][k];
					dp[i][j]%=m;
				}
			}
		}
		
		int sum=0;
		
		for(int i=0;i<=9;i++) {
			sum+=dp[N][i];
			sum%=m;
		}
		System.out.println(sum);
		
		
	}

}
