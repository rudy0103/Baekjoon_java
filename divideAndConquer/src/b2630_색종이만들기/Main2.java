package b2630_색종이만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	
	
	static int white,blue;
	
	static int [] dr= {0,1,0,1};
	static int [] dc= {0,0,1,1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		divideAndConquer(0,0,N,map);
		
		System.out.println(white);
		System.out.println(blue);
		

	}

	private static void divideAndConquer(int startR, int startC, int len, int[][] map) {
		if(len==1) {
			if(map[startR][startC]==0) white++;
			else blue++;
			return;
		}
		
		int sum=0;
		
		for(int i=startR;i<startR+len;i++) {
			for(int j=startC;j<startC+len;j++) {
				sum+=map[i][j];
			}
		}
		
		if(sum==len*len) {
			blue++;
			return;
		}else if(sum==0) {
			white++;
			return;
		}
		
		for(int i=0;i<4;i++) {
			int l=len/2;
			divideAndConquer(startR+l*dr[i], startC+l*dc[i], l, map);
		}
	}
}
