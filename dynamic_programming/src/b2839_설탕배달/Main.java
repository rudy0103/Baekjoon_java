package b2839_설탕배달;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		
		int [] arr = new int[5001];
		for(int i=1;i<=N;i++) {
			arr[i]=99999;
		}
		arr[3]=1; arr[5]=1;
	
		
		for(int i=5;i<=N;i++) {
			arr[i]=Math.min(arr[i],arr[i-3]+1);
			arr[i]=Math.min(arr[i],arr[i-5]+1);
		}
		
		if(arr[N]>=99999) {
			System.out.println(-1);
		}else System.out.println(arr[N]);
	}
}
