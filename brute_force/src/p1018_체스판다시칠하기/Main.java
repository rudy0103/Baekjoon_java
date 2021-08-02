package p1018_체스판다시칠하기;

import java.util.Scanner;

public class Main {
	
	public static int min=Integer.MAX_VALUE;
	public static char [][] arr;
	
	public static void get_min(int r, int c) {
		
		char left_top;
		
		int cnt=0;
		left_top='W';
		for(int i=r; i<r+8;i++) {
			for(int j=c;j<c+8;j++) {
				if(i%2==0&&j%2==0) {
					if(arr[i][j]!=left_top) cnt++;
				}
				else if(i%2==1&&j%2==1) {
					if(arr[i][j]!=left_top) cnt++;
				}
				else if(i%2==0&&j%2==1) {
					if(arr[i][j]==left_top) cnt++;
				}else {
					if(arr[i][j]==left_top) cnt++;
				}
			}
		}
		if(cnt<min) {
			min=cnt;
		}
		cnt=0;
		left_top='B';
		for(int i=r; i<r+8;i++) {
			for(int j=c;j<c+8;j++) {
				if(i%2==0&&j%2==0) {
					if(arr[i][j]!=left_top) cnt++;
				}
				else if(i%2==1&&j%2==1) {
					if(arr[i][j]!=left_top) cnt++;
				}
				else if(i%2==0&&j%2==1) {
					if(arr[i][j]==left_top) cnt++;
				}else {
					if(arr[i][j]==left_top) cnt++;
				}
			}
		}
		if(cnt<min) {
			min=cnt;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		arr=new char[n][m];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.next().toCharArray();
		}
		
		for(int i=0; i<n-7;i++) {
			for(int j=0;j<m-7;j++) {
				get_min(i,j);
			}
		}
		System.out.println(min);
	}
}
