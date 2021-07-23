package b11021_A더하기B_7;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i<T;i++)
			System.out.printf("Case #%d: %d%n",i+1,sc.nextInt()+sc.nextInt());
		
	}

}
