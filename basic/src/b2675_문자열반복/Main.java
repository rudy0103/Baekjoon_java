package b2675_문자열반복;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i<T;i++) {
			int N=sc.nextInt();
			String S=sc.next();
			for(int j=0;j<S.length();j++) {
				for(int k=0;k<N;k++)
					System.out.print(S.charAt(j));
			}
			System.out.println();
		}
	}

}
