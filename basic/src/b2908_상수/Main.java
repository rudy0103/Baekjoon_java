package b2908_상수;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A=sc.next();
		String B=sc.next();
		String s1="";
		String s2="";
		for(int i=2;i>=0;i--) {
			s1+=(A.charAt(i)+"");
			s2+=(B.charAt(i)+"");
		}
		if(Integer.parseInt(s1)>Integer.parseInt(s2)) System.out.println(s1);
		else System.out.println(s2);	
	}
}
