package b1309_동물원;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		
		int[][] table=new int[N+1][3];
		
		table[1][0]=1;
		table[1][1]=1;
		table[1][2]=1;
		int m=9901;
		
		for(int i=2;i<=N;i++) {
			table[i][0]=(table[i-1][1]+table[i-1][2]+table[i-1][0])%m;
			table[i][1]=(table[i-1][0]+table[i-1][2])%m;
			table[i][2]=(table[i-1][0]+table[i-1][1])%m;
		}
		
		System.out.println((table[N][0]+table[N][1]+table[N][2])%m);
		
	}

}
