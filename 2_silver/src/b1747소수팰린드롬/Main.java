package b1747소수팰린드롬;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		
		boolean [] isPrime=new boolean[2000000];
		
		Arrays.fill(isPrime,true);
		isPrime[1]=false;
		
		for(int i=2;i*i<2000000;i++) {
			if(isPrime[i]==false) continue;
			for(int j=i*i;j<2000000;j+=i) {
				isPrime[j]=false;
			}
		}
		
		int min=-1;
		
		for(int i=N;i<2000000;i++) {
			if(isPrime[i]) {
				if(isPlindrome(i)) {
					min=i;
					break;
				}
			}
		}
		System.out.println(min);
			
	}

	private static boolean isPlindrome(int num) {
		
		String str=String.valueOf(num);
		
		
		int left=0;
		int right=str.length()-1;
		
		while(left<=right) {
			if(str.charAt(left++)!=str.charAt(right--)) return false;
		}
		
		return true;
	}

}
