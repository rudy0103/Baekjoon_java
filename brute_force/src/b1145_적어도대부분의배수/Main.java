package b1145_적어도대부분의배수;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int []arr=new int[5];
		int min=Integer.MAX_VALUE;
		int max=1;
		
		for(int i=0;i<5;i++) {
			arr[i]=sc.nextInt();
			max*=arr[i];
			min=Math.min(min,arr[i]);
		}
		
		
		for(int i=1;i<=100000000;i++) {
			int cnt=0;
			
			for(int j=0;j<5;j++) {
				if(i%arr[j]==0) cnt++;
			}
			if(cnt>=3) {
				System.out.println(i);
				break;
			}
			
		}
	}

}
