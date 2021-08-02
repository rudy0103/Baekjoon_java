package b7568_덩치;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] arr = new int[n][2];
		int [] ranking =new int[n];
		for(int i =0;i<n;i++) {
			sc.nextLine();
			arr[i][0]=sc.nextInt();
			arr[i][1]=sc.nextInt();
			ranking[i]=1;
		}
		
		for(int i=0; i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][0]>arr[j][0] && arr[i][1]>arr[j][1]) {
					ranking[j]++;
				}
			}
		}
		for(int r:ranking) {
			System.out.print(r+" ");
		}
	}
}
