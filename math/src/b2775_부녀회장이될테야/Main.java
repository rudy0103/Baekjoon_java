package b2775_부녀회장이될테야;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		
		for(int t=0; t<T; t++) {
			sc.nextLine();
			int k=sc.nextInt();
			sc.nextLine();
			int n=sc.nextInt();
			int [][]arr = new int[k+1][n+1];
			for(int i =1; i<=n;i++) {
				arr[0][i]=i;
			}
			for(int i=1;i<=k;i++) {
				for(int j=1;j<=n;j++) {
					int sum=0;
					for(int l=1;l<=j;l++) {
						sum+=arr[i-1][l];
					}
					arr[i][j]=sum;
				}
			}
			System.out.println(arr[k][n]);
		}
	}
}
