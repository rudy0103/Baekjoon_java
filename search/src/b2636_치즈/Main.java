package b2636_치즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static int time = 0;
	static int totalCnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String[] inp = br.readLine().split(" ");
		int H = Integer.parseInt(inp[0]);
		int W = Integer.parseInt(inp[1]);

		int[][] map = new int[H][W];
		
		boolean [][]visited =new boolean[H][W];
		
		int [] dr= {-1,1,0,0};
		int [] dc= {0,0,-1,1};

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					totalCnt++;
			}
		}

		ArrayDeque<int[]> q = new ArrayDeque<>();//공기를 넣는 큐

		do {
			q.add(new int[] { 0, 0 }); //0,0은
			visited[0][0]=true;
			int cnt=0;
			while (!q.isEmpty()) {
				int [] now=q.poll();
				int r=now[0];
				int c=now[1];
				
				for(int i=0;i<4;i++) {//사방탐색
					int rr=r+dr[i];
					int cc=c+dc[i];
					
					if(rr>=0&&rr<H&&cc>=0&&cc<W) {
						if(visited[rr][cc]) continue;
						if(map[rr][cc]==1) { //치즈면
							cnt++;// 카운트 증가
							visited[rr][cc]=true; //방문처리
							map[rr][cc]=0; //0으로 바꿈
						}else { //공기면
							q.add(new int[] {rr,cc});
							visited[rr][cc]=true;
						}
					}
				}
			}
			time++;
			if(totalCnt-cnt==0) {
				System.out.println(time);
				System.out.println(totalCnt);
				break;
			}else totalCnt-=cnt;
			
			for(int i=0;i<H;i++) { //방문 처리 초기화
				for(int j=0;j<W;j++)
					visited[i][j]=false;
			}
			
		} while (true);

	}
}
