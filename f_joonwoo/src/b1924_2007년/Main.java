package b1924_2007년;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x=sc.nextInt();
		int y=sc.nextInt();
		
		String []days=new String[] {"SUN","MON","TUE","WED","THU","FRI","SAT"};
		
		int []d= {0,31,28,31,30,31,30,31,31,30,31,30,31};
		
		int gap=0;
		
		if(x==1) {
			gap=y;
		}else {
			for(int i=1;i<x;i++) {
				gap+=d[i];
			}
			gap+=y;
		}
		
		System.out.println(days[gap%7]);
		
	}

}
