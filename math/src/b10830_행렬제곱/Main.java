package b10830_행렬제곱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][]m;
	static int N;
	static long B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		String [] inp=br.readLine().split(" ");
		N=Integer.parseInt(inp[0]);
		B=Long.parseLong(inp[1]);

		m=new int[N][N];
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				m[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int [][]res=matrix(B);
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(res[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
	private static int[][] multipleMatrix(int[][] a,int[][] b){
		int[][] res = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int tmp=0;
				for(int k=0;k<N;k++) {
					tmp+=(a[i][k]*b[k][j]);
				}
				res[i][j]=tmp%1000;
			}
		}
		
		
		return res;
	}

	private static int[][] matrix(long y) {
		int [][] res= new int[N][N];
		
		for(int i=0;i<N;i++) {
			res[i][i]=1;
		}
		
		while(y>0) {
			if(y%2==1L)
				res=multipleMatrix(res,m);
			y=y>>1;
			m=multipleMatrix(m,m);
		}
		
		return res;
	}

}
