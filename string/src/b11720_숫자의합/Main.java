package b11720_숫자의합;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();
		String s=sc.nextLine();
		int sum=0;
		for(int i=0;i<s.length();i++) {
			sum+=Integer.parseInt(s.charAt(i)+"");
		}
		System.out.println(sum);
	}

}
