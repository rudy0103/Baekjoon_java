package b1546_평균;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int [] arr=new int[N];
		int max=-1;
		double sum=0;
		double avg;
		
		for(int i =0;i<N;i++) {
			arr[i]=sc.nextInt();
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		
		for(int i=0;i<N;i++) {
			sum+=(double)arr[i]/max*100;
		}
		
		avg=sum/N;
		
		System.out.println(avg);
		
	}
}
