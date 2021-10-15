package b14503_로봇청소기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int cnt=0;
		
		int[] dr= {-1,0,1,0};
		int[] dc= {0,1,0,-1};
		boolean[][] cleaned=new boolean[N][M];
		int[][] room=new int[N][M];
		
		st=new StringTokenizer(br.readLine()," ");
		ArrayDeque<int []> q = new ArrayDeque<>();
		q.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				room[i][j]=Integer.parseInt(st.nextToken());
				if(room[i][j]==1) cleaned[i][j]=true;
			}
		}
		
		while(!q.isEmpty()) {
			int [] bot=q.poll();
			int r=bot[0];
			int c=bot[1];
			int d=bot[2]; //0->북, 1->동, 2->남, 3->서
			
			if(cleaned[r][c]==false) { //청소를 안한경우 청소하고 cnt증가
				cleaned[r][c]=true;
				cnt++;
			}
			boolean flag=false;
			for(int i=0;i<4;i++) {
				d=changeDir(d);
				int rr=r+dr[d];
				int cc=c+dc[d];
				if(cleaned[rr][cc]==false) {
					flag=true;
					q.add(new int[] {rr,cc,d});
					break;
				}
			}
			
			if(flag) continue;
			r-=dr[d];
			c-=dc[d];
			if(room[r][c]==0) {
				q.add(new int[] {r,c,d});
			}else 
				break;
			
		}
		
		System.out.println(cnt);
	}

	private static int changeDir(int d) {
		if(d==0) return 3;
		return d-1;
	}

}
