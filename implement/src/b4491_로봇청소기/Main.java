package b4491_로봇청소기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int startR = -1;
		int startC = -1;
		int cnt = 0;
		char[][] map = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			char[] s = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = s[j];
				if (map[i][j] == 'o') {
					startR = i;
					startC = j;
				} else if (map[i][j] == '*')
					cnt++;
			}
		}
		int[][][] visited = new int[N][M][1000];	

		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[2]-o1[2];
			}
		});
		pq.add(new int[] { startR, startC, 0, 0 });

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		boolean flag=false;
		int min=9999;
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			
			if(now[2]==cnt) {
				flag=true;
				min=Math.min(min,now[3]);
			}

			for (int d = 0; d < 4; d++) {
				int nr=now[0]+dr[d];
				int nc=now[1]+dc[d];
				
				if(nr>=N||nr<0||nc>=M||nc<0) continue;
				if(map[nr][nc]=='x') continue;
				if(map[nr][nc]=='.') {
					if(visited[nr][nc][now[3]]<=now[2]) {
						visited[nr][nc][now[3]]=now[2];
						pq.add(new int[] {nr,nc,now[2],now[3]+1});
					}
				}else {
					if(visited[nr][nc][now[3]]<now[2]+1) {
						visited[nr][nc][now[3]]=now[2]+1;
						pq.add(new int[] {nr,nc,now[2]+1,now[3]+1});
					}
				}
			}

		}
		if(flag==false) System.out.println(-1);
		else System.out.println(min);

	}

}
