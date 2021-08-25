package b16236_아기상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class BabyShark {
	int r;
	int c;
	int ate;
	int size;
	int N;
	int[][] map;
	int time;
	int []dr;
	int []dc;
	boolean [][]visited;

	public BabyShark(int r, int c, int[][] map,boolean [][]visited) {
		super();
		this.r = r;
		this.c = c;
		this.size = 2;
		this.map = map;
		this.N=map.length;
		this.dr=new int[]{-1,0,0,1};//상좌우하
		this.dc=new int[] {0,-1,1,0};
		this.visited=visited;
	}

	public void eatFish(int r, int c,int move) {
		ate++;
		if (ate == size) {
			size++;
			ate = 0;
		}
		map[this.r][this.c]=0;
		this.r = r;
		this.c = c;
		this.time+=move;
		map[r][c] = 9;
	}
	
	public boolean searchAndEat(PriorityQueue<int[]> pq) {
		
		pq.add(new int[] {this.r,this.c,0});
		visited[r][c]=true;
		
		while (!pq.isEmpty()) {
			int[] curr=pq.poll();
			
			if(map[curr[0]][curr[1]]!=0&&map[curr[0]][curr[1]]<this.size&&map[curr[0]][curr[1]]!=9) {
				eatFish(curr[0], curr[1], curr[2]);
				return true;
			}
			for(int i=0;i<4;i++) {
				int rr=curr[0]+dr[i];
				int cc=curr[1]+dc[i];
				if(rr>=0&&rr<N&&cc>=0&&cc<N&&map[rr][cc]<=this.size&&visited[rr][cc]!=true) {
					pq.add(new int[] {rr,cc,curr[2]+1});
					visited[rr][cc]=true;
				}
			}
		}
		return false;
	}

}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		boolean [][] visited=new boolean[N][N];
		BabyShark baby = null;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9)
					baby = new BabyShark(i, j,map,visited);
			}
		}

		PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int []>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[2]!=o2[2]) return o1[2]-o2[2];
				if(o1[0]!=o2[0]) return o1[0]-o2[0];
				return o1[1]-o2[1];
			}
		});
		
		while(true) {
			if(!baby.searchAndEat(pq))
				break;
			for(int i=0;i<N;i++) Arrays.fill(visited[i],false);
			pq.clear();
		}
		System.out.println(baby.time);

	}
}
