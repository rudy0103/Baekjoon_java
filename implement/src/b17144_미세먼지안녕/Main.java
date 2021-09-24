package b17144_미세먼지안녕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int [] dr= {-1,1,0,0};
	public static int [] dc= {0,0,-1,1};
	
	//위 오른쪽 아래 왼쪽
	public static int [] dru= {-1,0,1,0};
	public static int [] dcu= {0,1,0,-1};
	
	//아래 오른쪽 위 왼쪽
	public static int [] drd= {1,0,-1,0};
	public static int [] dcd= {0,1,0,-1};
	
	static ArrayDeque<int []> q = new ArrayDeque<>();
	
	static int R,C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String [] inp = br.readLine().split(" ");
		R=Integer.parseInt(inp[0]);
		C=Integer.parseInt(inp[1]);
		int T=Integer.parseInt(inp[2]);
		
		int [] airCleaner=new int[2];
		
		int [][]map=new int[R][C];
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<C;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==-1&&airCleaner[0]==0) airCleaner[0]=i;
				else if(map[i][j]==-1&&airCleaner[0]!=0) airCleaner[1]=i;
			}
		}
		
		while(T-->0) {
			spread(map,airCleaner);
			move(map,airCleaner);
		}
		
		int total=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]>0) total+=map[i][j];
			}
		}
		System.out.println(total);
		
	}
	
	private static void spread(int[][] map, int[] airCleaner) {
		
		
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				if(map[r][c]<5) continue;
				q.add(new int[] {r,c,map[r][c]});
			}
		}
		
		while(!q.isEmpty()) {
			int[] tmp=q.poll();
			int dust=tmp[2]/5;
			
			for(int i=0;i<4;i++) {
				int rr= tmp[0]+dr[i];
				int cc= tmp[1]+dc[i];
				
				if(rr>=0&&rr<R&&cc>=0&cc<C&&map[rr][cc]!=-1) {
					map[rr][cc]+=dust;
					map[tmp[0]][tmp[1]]-=dust;
				}
				
			}
			
		}
		
	}

	private static void move(int[][] map, int[] airCleaner) {
		
		int dir=0;
		//위쪽
		int startR=airCleaner[0];
		int startC=0;
		
		while(dir<=3) {
			if( startR+dru[dir]<=airCleaner[0]&&startR+dru[dir]>=0&&startC+dcu[dir]>=0&&startC+dcu[dir]<C) {
				map[startR][startC]=map[startR+dru[dir]][startC+dcu[dir]];
				startR+=dru[dir];
				startC+=dcu[dir];
			}else dir++;
		}
		
		map[airCleaner[0]][0]=-1;
		map[airCleaner[0]][1]=0;
		
		
		//아래쪽
		dir=0;
		startR=airCleaner[1];
		startC=0;
		
		while(dir<=3) {
			if( startR+drd[dir]<R&&startR+drd[dir]>=airCleaner[1]&&startC+dcd[dir]>=0&&startC+dcd[dir]<C) {
				map[startR][startC]=map[startR+drd[dir]][startC+dcd[dir]];
				startR+=drd[dir];
				startC+=dcd[dir];
			}else dir++;
			
		}
		map[airCleaner[1]][0]=-1;
		map[airCleaner[1]][1]=0;
		
	}

}
