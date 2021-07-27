package b2292_벌집;

import java.util.Scanner;

public class Main {
	//1 7 19 37 61
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int i=1;
		int next=1;
		
		while(true) {
			if(next<N) {
				next+=6*i;
				i++;
			}else
				break;
		}
		System.out.println(i);
	}
}
