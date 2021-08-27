package b16236_아기상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class BabyShark {
	int r;  // 아기 상어의 행 위치
	int c;	// 아기 상어의 열 위치
	int ate; // 먹은 물고기 수 (몸집 커지면 0으로 바뀜)
	int size; // 사이즈
	int N; // N x N
 	int[][] map;
	int time; // 걸린 시간
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

	public void eatFish(int r, int c,int move) {//물고기 먹기
		ate++;
		if (ate == size) {
			size++;
			ate = 0;
		}
		map[this.r][this.c]=0; //원래 위치는 0
		this.r = r;
		this.c = c;
		this.time+=move;
		map[r][c] = 9; // 물고기 위치로 상어가 이동
	}
	
	public boolean search(PriorityQueue<int[]> pq) {
		
		pq.add(new int[] {this.r,this.c,0}); //현재 상어의 위치를 기준으로 탐색하기 위해 0-> 시간
		visited[r][c]=true;
		
		while (!pq.isEmpty()) {
			int[] curr=pq.poll();//큐에 넣은 물고기를 뺌
			
			if(map[curr[0]][curr[1]]!=0&&map[curr[0]][curr[1]]<this.size&&map[curr[0]][curr[1]]!=9) {
				eatFish(curr[0], curr[1], curr[2]);//조건을 만족하면 물고기를 먹음
				return true; //물고기를 먹었으면 true 반환
			}
			for(int i=0;i<4;i++) { //4방향으로 탐색하여 물고기를 우선순위 큐에 넣음
				int rr=curr[0]+dr[i];
				int cc=curr[1]+dc[i];
				if(rr>=0&&rr<N&&cc>=0&&cc<N&&map[rr][cc]<=this.size&&visited[rr][cc]!=true) {
					pq.add(new int[] {rr,cc,curr[2]+1});
					visited[rr][cc]=true;
				}
			}
		}
		return false; // 물고기를 찾지 못했을 때 false 반환;
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
				if(o1[2]!=o2[2]) return o1[2]-o2[2]; //거리 오름차순
				if(o1[0]!=o2[0]) return o1[0]-o2[0]; // 행 오름차순
				return o1[1]-o2[1]; //열 오름차순
			}
		});
		
		while(true) {
			if(!baby.search(pq))
				break;
			for(int i=0;i<N;i++) Arrays.fill(visited[i],false);//visited를 초기화 해줘야함
			pq.clear();// 우선순위의 큐를 비워줌
		}
		System.out.println(baby.time); // 상어의 time 변수를 출력

	}
}
