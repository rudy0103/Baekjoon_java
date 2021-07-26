package b4344_평균은넘겠지;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		for(int i=0; i<T;i++) {
			int N=sc.nextInt();
			int sum=0;
			double avg=0;
			int [] arr = new int[N];
			
			for(int j=0;j<N;j++) {
				int tmp=sc.nextInt();
				arr[j]=tmp;
				sum+=tmp;
			}
			avg=(double)sum/N;
			int cnt=0;
			for(int j=0;j<arr.length;j++) {
				if((double)arr[j]>avg) {
					cnt++;
				}
			}
			double percent=Math.round(((double)cnt/N)*100000)/1000.0;
			System.out.printf("%.3f%%\n",percent);
			
		}
	}
}
