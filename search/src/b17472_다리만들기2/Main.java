package b17472_다리만들기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Main {
	
	public static int cnt=0;
	public static int N,M;
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	public static void init(int[][]map) {
		
		ArrayDeque<int []> q= new ArrayDeque<>();
		boolean [][] visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0||visited[i][j]) continue;
				if(!visited[i][j]) cnt++;
				visited[i][j]=true;
				map[i][j]=cnt;
				q.add(new int[] {i,j});
				while(!q.isEmpty()) {
					int [] tmp= q.poll();
					int r = tmp[0];
					int c = tmp[1];
					
					for(int d=0;d<4;d++) {
						int rr=r+dr[d];
						int cc=c+dc[d];
						
						if(rr>=0&&rr<N&&cc>=0&&cc<M) {
							if(map[rr][cc]==1&&!visited[rr][cc]) {
								visited[rr][cc]=true;
								map[rr][cc]=cnt;
								q.add(new int[] {rr,cc});
							}
						}
					}
				}
			}
		}
		
	}
	
	public static void makeSet(int [] rep) {
		for(int i=0;i<rep.length;i++) {
			rep[i]=i;
		}
	}
	
	public static int findSet(int a, int[]rep) {
		if(a==rep[a]) return a;
		return rep[a]=findSet(rep[a], rep);
	}
	
	
	public static boolean unionSet(int a, int b, int [] rep) {
		int A =findSet(a, rep);
		int B= findSet(b, rep);
		if(A==B) return false;
		rep[A]=B;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] inp =br.readLine().split(" ");
		StringTokenizer st = null;
		N=Integer.parseInt(inp[0]);
		M=Integer.parseInt(inp[1]);
		
		int [][]map = new int[N][M];
		
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		init(map);
		int [] rep=new int[cnt+1];
		makeSet(rep);
		
		PriorityQueue<int[]> q=new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		}); //다리 정보 넣을 우선순위 큐
		getBridge(q,map);
		
		int totalDistance=0;
		
		while(!q.isEmpty()) {
			int[] tmp=q.poll();
			int a=tmp[0];
			int b=tmp[1];
			int dis=tmp[2];
			
			if(unionSet(a, b, rep)) {
				totalDistance+=dis;
			}
		}
		
		int tmp=findSet(1, rep);
		boolean flag=true;
		for(int i=2;i<=cnt;i++) {
			if(tmp!=findSet(i, rep)) {
				flag=false;
				break;
			}
		}
		if(flag) System.out.println(totalDistance);
		else System.out.println(-1);
		
		
	}

	private static void getBridge(PriorityQueue<int[]> q, int[][] map) {
		
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				if(map[i][j]==0) continue;
				int r=i;
				int c=j;
				for(int d=0;d<4;d++) {
					int rr= r+dr[d];
					int cc= c+dc[d];
					boolean flag=false;
					if(rr>=0&&rr<N&&cc>=0&&cc<M&&map[rr][cc]==0) {
						while(rr>=0&&rr<N&&cc>=0&&cc<M&&map[rr][cc]!=map[r][c]) {
							if(map[rr][cc]!=0&&map[rr][cc]!=map[r][c]) {
								flag=true;
								break;
							}
							rr+=dr[d];
							cc+=dc[d];
						}
					}
					if(flag) {
						int dis=getDistance(r,c,rr,cc);
						if(dis>2) q.add(new int[] {map[r][c],map[rr][cc],dis-1});
					}
				}
			}
		}
		
	}

	private static int getDistance(int r, int c, int rr, int cc) {
		return Math.abs(r-rr)+Math.abs(c-cc);
	}

}
