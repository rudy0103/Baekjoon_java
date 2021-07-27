package b1193_분수찾기;

import java.util.Scanner;

public class Main {
	//1 7 19 37 61
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int i=1;
		int next=0;
		
		while(true) {
			if(next<N) {
				next+=i;
				i++;
			}else
				break;
		}
		i--;
		if(i%2==1) {
			System.out.println(((next-N)+1)+"/"+(i-(next-N)));
		}else {
			System.out.println((i-(next-N))+"/"+((next-N)+1));
		}
		
	}
}