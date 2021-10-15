package b1520_내리막길;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int cnt = 0, N, M;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void goingDown(int[][] map, int r, int c, int[][] dp) {

		if (dp[r][c] > 0) { //r,c dp 테이블이 0보다 크면  그 값을 더한다.
			cnt += dp[r][c];
			return;
		}

		for (int i = 0; i < 4; i++) {
			int tmp = cnt; // 내리막길 가기 전 cnt를 저장함
			int rr = r + dr[i];
			int cc = c + dc[i];
			if (rr >= 0 && rr < N && cc >= 0 && cc < M) {
				if (map[rr][cc] < map[r][c] && dp[rr][cc] != -1) {
					goingDown(map, rr, cc, dp);
					if (tmp != cnt) {
						dp[r][c]+=dp[rr][cc];
					} 
				}
			}
		}
		if(dp[r][c]==0) dp[r][c]=-1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());// 세로
		M = Integer.parseInt(st.nextToken());// 가로

		int[][] map = new int[N][M];
		int[][] dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[N-1][M-1]=1; //도착점은 1로 해놔야함 
		goingDown(map, 0, 0, dp);
		System.out.println(cnt);
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.println();
			}
		}

	}
}
