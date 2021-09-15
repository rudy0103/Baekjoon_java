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

		ArrayDeque<int[]> q = new ArrayDeque<>();

		do {
			q.add(new int[] { 0, 0 });
			visited[0][0]=true;
			int cnt=0;
			while (!q.isEmpty()) {
				int [] now=q.poll();
				int r=now[0];
				int c=now[1];
				
				for(int i=0;i<4;i++) {
					int rr=r+dr[i];
					int cc=c+dc[i];
					
					if(rr>=0&&rr<H&&cc>=0&&cc<W) {
						if(visited[rr][cc]) continue;
						if(map[rr][cc]==1) {
							cnt++;
							visited[rr][cc]=true;
							map[rr][cc]=0;
						}else {
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
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++)
					visited[i][j]=false;
			}
			
		} while (true);

	}

}
