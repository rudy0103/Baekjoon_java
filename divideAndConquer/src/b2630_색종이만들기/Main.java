package b2630_색종이만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n,white,blue;
	static int [][]arr;
	
	static void f(int row,int col,int size) {
		
		int sum=0;
		for(int r=row;r<row+size;r++) {
			for(int c=col;c<col+size;c++) {
				sum+=arr[r][c];
			}
		}
		
		if(sum==size*size) {
			blue++;
		}else if(sum==0) white++;
		else {
			int half=size/2;
			f(row,col,half);
			f(row,col+half,half);
			f(row+half,col,half);
			f(row+half,col+half,half);
		}
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		arr=new int[n][n];
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int j=0;
			while (st.hasMoreElements()) {
				arr[i][j++]=Integer.parseInt(st.nextToken());
			}
		}
		
		f(0,0,n);
		System.out.println(white);
		System.out.println(blue);
		
		
	}
}
