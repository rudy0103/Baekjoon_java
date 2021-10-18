package b20057_마법사상어와토네이도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int sand=0;
	static int step=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		
		int N=Integer.parseInt(br.readLine());
		int[][] map=new int[N][N];
		
		sand=0;
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int d=0;
		
		while(step<=N) {
			int cnt=0;
			
			
			if(cnt==2) {
				step++;
				d=change(d);
			}
		
		}
		
		System.out.println(sand);
		
	}

	private static int change(int d) {
		// TODO Auto-generated method stub
		return 0;
	}

}
