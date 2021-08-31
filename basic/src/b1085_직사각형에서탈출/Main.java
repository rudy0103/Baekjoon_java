package b1085_직사각형에서탈출;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x=sc.nextInt();
		int y=sc.nextInt();
		int w=sc.nextInt();
		int h=sc.nextInt();
		
		int min=Integer.MAX_VALUE;
		
		if(min>Math.abs(x-w)) min=Math.abs(x-w);
		if(min>Math.abs(x-0)) min=Math.abs(x-0);
		if(min>Math.abs(y-h)) min=Math.abs(y-h);
		if(min>Math.abs(y-0)) min=Math.abs(y-0);
		System.out.println(min);
	}

}
