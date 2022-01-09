package b1748_수이어쓰기1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		
		int cnt=0;
		
		int d=0;
		int num=1;
		
		while(N>=num) {
			num*=10;
			d++;
		}
		num/=10;
		
//		System.out.println(num);
//		System.out.println(d);
		
		
		while(d>0) {
			int gap=N-num+1;
			cnt+=d*gap;
			N-=gap;
			d--;
			num/=10;
		}
		
		
		
		System.out.println(cnt);
		
	}

}
