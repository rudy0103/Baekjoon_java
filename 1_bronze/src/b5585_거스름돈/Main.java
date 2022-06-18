package b5585_거스름돈;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num=1000-sc.nextInt();
		int[] arr = {500,100,50,10,5,1};

		int cnt=0;
		
		int idx=0;
		while(num>0) {
			if(num/arr[idx]>=1) {
				cnt+=num/arr[idx];
				num-=arr[idx]*(num/arr[idx]);
			}
			idx++;
		}
		System.out.println(cnt);
	}
}
