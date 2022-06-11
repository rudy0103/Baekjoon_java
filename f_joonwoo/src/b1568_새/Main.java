package b1568_새;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		
		int K=1;
		int time=0;
		
		while(true) {
			if(N==0) break;
			time++;
			if(K<=N) {
				N-=K;
				K++;
			}else {
				K=1;
				K++;
				N--;
			}
			
		}
		System.out.println(time);
	}

}
