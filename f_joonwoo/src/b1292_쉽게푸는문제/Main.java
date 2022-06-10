package b1292_쉽게푸는문제;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A=sc.nextInt();
		int B=sc.nextInt();
		
		int sum=0;
		
	
		int now=1;
		int cnt=1;
		for(int i=1;i<=B;i++) {	
			if(i>=A) {
				sum+=now;
			}
			if(--cnt==0) {
				now++;
				cnt=now;
			}	
		}
		
		
		
		System.out.println(sum);
		
		

	}

}
