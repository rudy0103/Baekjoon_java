package b10951_A더하기B_4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		
		while(a!=0 && b!=0){
			System.out.println(a+b);
			
			
			if(sc.hasNextInt())
				a=sc.nextInt();
			else
				break;
			b=sc.nextInt();
		}
	}
}
