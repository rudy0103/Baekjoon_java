package b1248_맞춰봐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static int[] arr,selected;
	static int[][] m;
	static char[][] ans;
	static boolean flag=false;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine())+1;
		arr = new int[N];
		selected=new int[N];
		m=new int[N][N];
		ans=new char[N][N];
		String inp=br.readLine();
		int idx=0;
		
		for(int i=1;i<N;i++) {
			for(int j=i;j<N;j++) {
				ans[i][j]=inp.charAt(idx++);
			}
		}
		
		backtracking(1);
		
	}

	private static void backtracking(int d) {
		if(d==N) {
			for(int i=1;i<N;i++) System.out.print(selected[i]+" ");
			System.exit(0);
			return;
		}
		
		for(int i=-10;i<=10;i++) {
			if(isPromising(d,i)) {
				plus(d,i);
				selected[d]=i;
				backtracking(d+1);
				sub(d,i);
			}
		}
	}

	private static void sub(int d, int n) {
		for(int i=d;i>=1;i--) {
			m[i][d]-=n;
		}
		
	}

	private static void plus(int d, int n) {
		for(int i=d;i>=1;i--) {
			m[i][d]=m[i][d-1]+n;
		}
	}

	private static boolean isPromising(int d, int n) {

		for(int i=d;i>=1;i--) {
			if(m[i][d-1]+n>0&&ans[i][d]!='+') return false;
			else if(m[i][d-1]+n==0&&ans[i][d]!='0') return false;
			else if(m[i][d-1]+n<0&&ans[i][d]!='-') return false;
		}
		
		return true;
	}

}
