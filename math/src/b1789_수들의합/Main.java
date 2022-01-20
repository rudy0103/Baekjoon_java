package b1789_수들의합;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long S=sc.nextLong();
		
		long i=1;
		
		while(((i)*(i+1))/2<=S) {
			i++;
		}
		System.out.println(--i);
	}

}
