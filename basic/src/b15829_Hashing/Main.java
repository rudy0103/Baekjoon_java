package b15829_Hashing;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L=sc.nextInt();
		String inp=sc.next();
		long m=1234567891;
		long res=0;
		long k=1;
		for(int i=0;i<L;i++) {
			res+=((inp.charAt(i)-'a')+1)*(k%m);
			k=(k*31)%m;
		}
		System.out.println(res%m);
	}
}
