package b1124_언더프라임;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}

		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A=sc.nextInt();
		int B=sc.nextInt();
		
		boolean [] prime=new boolean[100001];
		
		ArrayList<Integer>list = new ArrayList<>();
		
		for(int i=2;i<=100000;i++) if(isPrime(i)) {
			prime[i]=true;
			list.add(i);
		}
		
		int underPrimeCount=0;
		
		
		for(int i=A;i<=B;i++) {
			int j=0;
			int n=i;
			int cnt=0;
			while(n>1) {
				if(n%list.get(j)==0) {
					n/=list.get(j);
					cnt++;
				}else {
					j++;
				}
			}
			if(prime[cnt]) underPrimeCount++;
			
		}
		System.out.println(underPrimeCount);
		

	}

}
