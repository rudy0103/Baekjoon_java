package b4485_녹색옷입은애가젤다지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int N=Integer.parseInt(br.readLine());
		int [] dr= {-1,1,0,0};
		int [] dc= {0,0,-1,1};

		int tc=1;
		while(N!=0) {
			int [][]map=new int[N][N];
			int [][]cost = new int[N][N];
			
			for(int i=0;i<N;i++) {
				st= new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					cost[i][j]=123456789;
				}
			}
			cost[0][0]=map[0][0];
			
			ArrayDeque<int []> q= new ArrayDeque<>();
			q.add(new int[] {0,0});
			
			while(!q.isEmpty()) {
				
				int[] tmp=q.poll();
				int r= tmp[0];
				int c= tmp[1];
				for(int i=0;i<4;i++) {
					int rr =r+dr[i];
					int cc =c+dc[i];
					
					if(rr>=0&&rr<N&&cc>=0&&cc<N) {
						if(cost[rr][cc]>map[rr][cc]+cost[r][c]) {
							q.add(new int[] {rr,cc});
							cost[rr][cc]=map[rr][cc]+cost[r][c];
						}
					}
				}
				
			}
			sb.append("Problem "+tc+": "+cost[N-1][N-1]).append("\n");
			tc++;
			N=Integer.parseInt(br.readLine());
			
		}
		System.out.println(sb.toString());
	}
}
