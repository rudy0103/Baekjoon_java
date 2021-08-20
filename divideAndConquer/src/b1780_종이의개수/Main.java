package b1780_종이의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static boolean check(int[][] arr,int size,int row, int col,int [] count) {
		
		int tmp=arr[row][col];
		
		for(int i=row;i<row+size;i++)
			for(int j=col;j<col+size;j++) {
				if(arr[i][j]!=tmp) return false;
			}
		
		if(arr[row][col]==-1) count[0]++;
		else if(arr[row][col]==0) count[1]++;
		else count[2]++;
		
		return true;
	}
	
	public static void divideAndConquer(int[][] arr,int size,int row, int col,int [] count) {
		
		if(check(arr, size, row, col, count)) return;
		
		if(size==1) {
			if(arr[row][col]==-1) count[0]++;
			else if(arr[row][col]==1) count[1]++;
			else count[2]++;
			return;
		}
		
		int length=size/3;
		
		for(int i=0;i<9;i++) {
			int r=i/3;
			int c=i%3;
			divideAndConquer(arr, size/3, row+length*r, col+length*c, count);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		int n=Integer.parseInt(br.readLine());
		int [][] arr =new int[n][n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int idx=0;
			while(st.hasMoreTokens()) {
				arr[i][idx++]=Integer.parseInt(st.nextToken());
			}
		}
		int [] count=new int[3];
		divideAndConquer(arr,n,0,0,count);
		
		for(int a:count) System.out.println(a);
		
	}

}
