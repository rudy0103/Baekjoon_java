package b1913_달팽이;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		int M=sc.nextInt();
		
		int [][]map=new int[N][N];
		
		int n=N*N;
		
		
		int d=0;
		int []dr= {1,0,-1,0};
		int []dc= {0,1,0,-1};
		int r=0;
		int c=0;
		int tr=0;
		int tc=0;
		while(n>0) {
			if(map[r][c]==0) {
				map[r][c]=n;
				if(map[r][c]==M) {
					tr=r+1;
					tc=c+1;
				}
				n--;
			}
			
			int nr=r+dr[d];
			int nc=c+dc[d];
			
			if(nr<0||nr>=N||nc<0||nc>=N||map[nr][nc]!=0) {
				d=changeDir(d);
			}else {
				r+=dr[d];
				c+=dc[d];
			}
		}
		printMap(map);
		System.out.println(tr+" "+tc);
		
	}

	private static void printMap(int[][] map) {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map.length;j++) {
				sb.append(map[i][j]+" ");
			}
			sb.append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
		
	}

	private static int changeDir(int d) {
		if(d==3) return 0;
		return ++d;
	}

}
