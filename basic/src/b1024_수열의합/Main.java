package b1024_수열의합;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Long N=sc.nextLong();
		int L=sc.nextInt();
		
		
		long ans=-1;
		int ansL=-1;
		for(int l=L;l<=100;l++) {
			if(2*N-l*l+l<0) break;
			if((2*N-l*l+l)%(2*l)==0) {
				ans=(2*N-l*l+l)/(2*l);
				ansL=l;
				break;
			}
		}
		
		if(ans==-1) System.out.println(-1);
		else {
			StringBuilder sb = new StringBuilder();
			for(int i=(int)ans;i<ans+ansL;i++) {
				sb.append(i).append(" ");
			}
			System.out.println(sb.toString());
		}

		
	}

}
