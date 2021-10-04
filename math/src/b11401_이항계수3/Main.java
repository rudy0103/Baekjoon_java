package b11401_이항계수3;

import java.util.Scanner;

public class Main {

	
	static long p=1000000007;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();
		
		long res = nCr(N,K);
		
		System.out.println(res);
		
	}

	private static long nCr(int n, int k) {
		if(k==0) return 1;
		if(k==1) return n;	

		return (factorial(n))*(power(factorial(n-k),p-2))%p*(power(factorial(k),p-2))%p;
	}

	private static long power(long x, long y) {
		long res = 1L;
		
		while(y>0) {
			if(y%2==1)
				res=(res*x)%p;
			y=y>>1;
			x=(x*x)%p;
		}
		
		return res;
	}

	private static long factorial(int n) {
		long res=1L;
		
		
		for(int i=1;i<=n;i++) {
			res*=i;
			res%=p;
		}
		
		return res;
	}

}
