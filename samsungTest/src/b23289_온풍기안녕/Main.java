package b23289_온풍기안녕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int R, C, K, choco;
	static int[][] map;
	static int[][] temperature;
	static boolean[][] visited;
	static boolean[][][] blocked;
	// 오른,왼,위,아래
	static int dr[] = { 0, 0, -1, 1 };
	static int dc[] = { 1, -1, 0, 0 };
	static int dir[][]= {{2,3},{2,3},{0,1},{0,1}};

	static class Heater {
	
		int r;
		int c;
		int d;

		public Heater(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}

		public void heat() {
			this.init();
			
			ArrayDeque<int[]> dq=new ArrayDeque<>();
			dq.add(new int[] {r+dr[d],c+dc[d],5});
			visited[r][c]=true;
			temperature[r+dr[d]][c+dc[d]]=5;
			
			while(!dq.isEmpty()) {
				
				int [] curr=dq.poll();
				if(curr[2]==1) break;
				
				// 일직선				
				spread1(curr,dq);
				//대각선 1.
				spread2(curr,dq,0);				
				//대각선 2.
				spread2(curr,dq,1);
				
			}
			
			this.addTemper();
			

		}

		private void spread2(int[] curr, ArrayDeque<int[]> dq,int k) {
			
			int nd=dir[d][k];
			int nr=curr[0]+dr[nd];
			int nc=curr[1]+dc[nd];
			if(nr<0||nr>=R||nc<0||nc>=C||visited[nr][nc]) return;
			if(blocked[curr[0]][curr[1]][nd]) return;
			
			
			int nnr=nr+dr[d];
			int nnc=nc+dc[d];
			if(nnr<0||nnr>=R||nnc<0||nnc>=C||visited[nnr][nnc]) return;
			if(blocked[nr][nc][d]) return;
			visited[nnr][nnc]=true;
			temperature[nnr][nnc]=curr[2]-1;
			dq.add(new int[] {nnr,nnc,curr[2]-1});
			
		}

		private void spread1(int[] curr, ArrayDeque<int[]> dq) {
			int nr=curr[0]+dr[d];
			int nc=curr[1]+dc[d];
		
			if(nr<0||nr>=R||nc<0||nc>=C||visited[nr][nc]) return;
			if(blocked[curr[0]][curr[1]][d]) return;
			
			visited[nr][nc]=true;
			temperature[nr][nc]=curr[2]-1;
			dq.add(new int[] {nr,nc,curr[2]-1});
			
		}

		public void init() {
			for (int i = 0; i < R; i++) {
				Arrays.fill(temperature[i], 0);
				Arrays.fill(visited[i], false);
			}
		}
		
		public void addTemper() {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					map[i][j]+=temperature[i][j];
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); /// 온도 1~1000

		map = new int[R][C];
		temperature = new int[R][C];
		visited = new boolean[R][C];
		blocked = new boolean[R][C][4];
		ArrayList<Heater> heater = new ArrayList<>();
		ArrayList<int[]> inspectArea = new ArrayList<>(); // 5

		// info
//		0: 빈 칸
//		1: 방향이 오른쪽인 온풍기가 있음
//		2: 방향이 왼쪽인 온풍기가 있음
//		3: 방향이 위인 온풍기가 있음
//		4: 방향이 아래인 온풍기가 있음
//		5: 온도를 조사해야 하는 칸

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				int info = Integer.parseInt(st.nextToken());
				if (info == 0)
					continue;
				else if (info == 5)
					inspectArea.add(new int[] { i, j });
				else {
					heater.add(new Heater(i, j, --info));// 히터는 방향 정보도 같이 들어간다.
				}
			}
		}

		int wallCnt = Integer.parseInt(br.readLine());

		for (int i = 0; i < wallCnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int t = Integer.parseInt(st.nextToken());

			// 0오른
			// 1 왼
			// 2 위
			// 3 아래

			// t==0 (x,y),(x-1,y)사이에 벽
			if (t == 0) {
				blocked[x][y][2] = true;// 위쪽 막힘
				if (x - 1 >= 0)
					blocked[x - 1][y][3] = true;// 아래 방향 막힘
			} else {
				// t==1 (x,y),(x,y+1)사이에 벽
				blocked[x][y][0] = true;// 오른쪽 막힘
				if (y + 1 < C)
					blocked[x][y + 1][1] = true;// 왼쪽 막힘
			}
		}

		while (true) {

//			1.집에 있는 모든 온풍기에서 바람이 한 번 나옴
			for(Heater h:heater) {
				h.heat();
			}
			
//			2.온도가 조절됨
			
			controllTemper();
			
//			3.온도가 1 이상인 가장 바깥쪽 칸의 온도가 1씩 감소
			
			downSideTemper();
			
//			4.초콜릿을 하나 먹는다.
			
			choco++;
			if(choco>100) break;
//			5.조사하는 모든 칸의 온도가 K 이상이 되었는지 검사. 모든 칸의 온도가 K이상이면 테스트를 중단하고, 아니면 1부터 다시 시작한다.
			if(isSatisfied(inspectArea)) break;
		}
		
//		printMap(map);

		System.out.println(choco);

	}

	private static void downSideTemper() {
		
		for(int i=0;i<C;i++) {
			if(map[0][i]>=1) map[0][i]--;
			if(map[R-1][i]>=1) map[R-1][i]--;
		}
		for(int i=1;i<R-1;i++) {
			if(map[i][0]>=1) map[i][0]--;
			if(map[i][C-1]>=1) map[i][C-1]--;
		}
		
		
	}

	private static void controllTemper() {
		
		int [][]tmpTemper=new int[R][C];
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {				
				for(int d=0;d<4;d++) {
					int nr=i+dr[d];
					int nc=j+dc[d];
					
					if(nr<0||nr>=R||nc<0||nc>=C||map[i][j]<=map[nr][nc]||blocked[i][j][d]) continue;
					
					int tmp=(map[i][j]-map[nr][nc])/4;
					tmpTemper[nr][nc]+=tmp;
					tmpTemper[i][j]-=tmp;
				}
			}
		}
		
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				map[i][j]+=tmpTemper[i][j];
			}
		}
		
		
	}

	// 조사하는 칸의 온도가 모두 K이상인가?
	private static boolean isSatisfied(ArrayList<int[]> inspectArea) {

		for (int[] area : inspectArea) {
			if (map[area[0]][area[1]] < K)
				return false;
		}
		return true;
	}

	public static void printMap(int[][] map) {

		int R=map.length;
		int C=map[0].length;
		System.out.println(" print start");
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(" print end\n");

	}
	

}
