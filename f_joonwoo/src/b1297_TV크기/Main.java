package b1297_TV크기;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int d=sc.nextInt();
		int h=sc.nextInt();
		int w=sc.nextInt();
		double D=d*d;
		double tmp=D/(h*h+w*w);
		double tt=Math.sqrt(tmp);		
		System.out.println((int)(tt*h));
		System.out.println((int)(tt*w));
	}

}
