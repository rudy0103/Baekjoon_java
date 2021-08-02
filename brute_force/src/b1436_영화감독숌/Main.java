package b1436_영화감독숌;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt=0;
		int n = sc.nextInt();
		for(int i=666; i<=3000000;i++) {
			if(Integer.toString(i).contains("666")) {
				cnt++;
				if(cnt==n) {
					cnt=i;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}
