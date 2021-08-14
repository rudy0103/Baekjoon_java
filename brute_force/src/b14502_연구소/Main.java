package b14502_연구소;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, M, R, safeZone;
	static int[][] origin;
	static int[][] wall = new int[3][2];
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static ArrayList<int []> virusList=new ArrayList<>();//매번 바이러스의 위치를 탐색하는 
														//방법은 비효율적임으로 저장해둡니다.
	
	
	static int getSafeZone() {
		int cnt=0;
		int [][] map=new int[N][M];
		Queue<int[]> queue=new LinkedList<int[]>();
		
		
		for(int i=0;i<N;i++) {
			System.arraycopy(origin[i], 0, map[i], 0, M);
		}
		
		for(int i=0;i<wall.length;i++) //3개의 벽 세우기
			map[wall[i][0]][wall[i][1]]=1;
		
		for(int i=0;i<virusList.size();i++) { //초기 상태의 바이러스 위치를 큐에 넣음
			queue.add(new int[] {virusList.get(i)[0],virusList.get(i)[1]});
		}

		while(!queue.isEmpty()) { //일반적인 BFS 탐색
			int[] virus=queue.poll(); //큐에서 바이러스를 빼면서 BFS 탐색을 진행
			for(int i=0;i<4;i++) {
				int rr=virus[0]+dr[i];
				int cc=virus[1]+dc[i];
				if(rr>=0&&rr<N&&cc>=0&&cc<M) {
					if(map[rr][cc]==0) {
						map[rr][cc]=2;
						queue.add(new int[] {rr,cc});
					}
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) cnt++;
			}
		}
		
		return cnt;
	}

	static void makeCombination(int cnt, int start) {
		if (cnt == R) {
			int zone=getSafeZone();
			if(zone>safeZone) safeZone=zone;
		} else {
			for (int i = start; i < N * M; i++) {
				int r = i / M;
				int c = i % M;
				if (origin[r][c] != 0) //만약 벽을 세우려는 곳이 0이 아니면 넘어갑니다
					continue;
				wall[cnt][0] = r;
				wall[cnt][1] = c;
				makeCombination(cnt + 1, i + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] inp = br.readLine().split(" ");
		N = Integer.parseInt(inp[0]);
		M = Integer.parseInt(inp[1]);
		R = 3;
		origin = new int[N][M];

		for (int i = 0; i < N; i++) {
			inp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				origin[i][j] = Integer.parseInt(inp[j]);
				if(origin[i][j]==2) virusList.add(new int[] {i,j}); //바이러스 위치 넣어두기
			}
		}
		makeCombination(0, 0); //3개의 벽을 세우는 조합 구하기
		bw.write(safeZone+"");
		bw.close();
	}
}