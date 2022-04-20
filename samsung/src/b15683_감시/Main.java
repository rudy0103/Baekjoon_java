package b15683_감시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//22:40 ~ 23:18

public class Main {
	
	static int [] dr= {0,-1,1,0,0};
	static int [] dc= {0,0,0,-1,1};
	static int D,R,C;
	static int minArea=Integer.MAX_VALUE;
	
	static class CCTV{
		int type;
		int r;
		int c;
		int[][] dir;
		public CCTV(int type, int r, int c, int[][] d) {
			this.type = type;
			this.r=r;
			this.c=c;
			this.dir = d;
		}
		
		public void watch(int d, int [][] map) {
			
			int nr=r+dr[d];
			int nc=c+dc[d];
			while(nr<R&&nr>=0&&nc<C&&nc>=0&&map[nr][nc]!=6) {
				if(map[nr][nc]<=0)
					map[nr][nc]--;
				nr+=dr[d];
				nc+=dc[d];
			}
			
		}
		
	public void erase(int d, int [][] map) {
			
			int nr=r+dr[d];
			int nc=c+dc[d];
			while(nr<R&&nr>=0&&nc<C&&nc>=0&&map[nr][nc]!=6) {
				if(map[nr][nc]<=-1)
					map[nr][nc]++;
				nr+=dr[d];
				nc+=dc[d];
			}
			
		}

	public void f(int n,int[][] map) {
		
		int[] tmp=this.dir[n];
		
		for(int i=0;i<tmp.length;i++) {
			this.watch(tmp[i], map);
		}
		
		
	}

	public void undo(int n, int[][] map) {
		int[] tmp=this.dir[n];
		
		for(int i=0;i<tmp.length;i++) {
			this.erase(tmp[i], map);
		}
		
	}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		R=N;
		C=M;
		
		int [][]office = new int[N][M];
		
		ArrayList<CCTV> cctv = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				office[i][j]=Integer.parseInt(st.nextToken());
				if(office[i][j]==0||office[i][j]==6) continue;
				if(office[i][j]==1) {
					int[][] dir= {{1},{2},{3},{4}};
					CCTV cc = new CCTV(office[i][j],i,j, dir);
					cctv.add(cc);
				}else if(office[i][j]==2) {
					int[][] dir= {{1,2},{3,4}};
					CCTV cc = new CCTV(office[i][j],i,j, dir);
					cctv.add(cc);
				}else if(office[i][j]==3) {
					int[][] dir= {{1,4},{4,2},{2,3},{3,1}};
					CCTV cc = new CCTV(office[i][j],i,j, dir);
					cctv.add(cc);
				}else if(office[i][j]==4) {
					int[][] dir= {{2,3,4},{1,3,4},{1,2,4},{1,2,3}};
					CCTV cc = new CCTV(office[i][j],i,j, dir);
					cctv.add(cc);
				}else {
					int[][] dir= {{1,2,3,4}};
					CCTV cc = new CCTV(office[i][j],i,j, dir);
					cctv.add(cc);
				}
			}
		}
		
		D=cctv.size();
		
		dfs(0,office,cctv);
		
		System.out.println(minArea);
		
	}

	private static void dfs(int d,int[][] office,ArrayList<CCTV> cctv) {
		
		if(d==D) {

			minArea=Math.min(minArea, getArea(office));
			return ;
		}
		
		CCTV cc=cctv.get(d);
		
		for(int i=0;i<cc.dir.length;i++) {
			cc.f(i,office);
			dfs(d+1,office,cctv);
			cc.undo(i,office);
		}
		
		
	}

	private static int getArea(int[][] office) {
		int cnt=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(office[i][j]==0) cnt++;
			}
			
		}
		
		return cnt;
	}

}
