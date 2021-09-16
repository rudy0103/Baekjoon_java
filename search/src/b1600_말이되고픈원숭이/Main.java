package b1600_말이되고픈원숭이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int k = Integer.parseInt(br.readLine());
		String[] inp = br.readLine().split(" ");
		int W = Integer.parseInt(inp[0]);
		int H = Integer.parseInt(inp[1]);

		int[][] map = new int[H][W];
		boolean[][][] visited = new boolean[H][W][k+1]; // 방문 이때 말로 이동할 수 있는 횟수로 동일하게 방문 못하게
														// 0~k까지의 횟수로 방문햇는지를 true false하는 것

		int[] dr = { -1, 1, 0, 0 }; // 상하좌우
		int[] dc = { 0, 0, -1, 1 }; //
		int[] dhr = { -2, -1, 1, 2, 2, 1, -1, -2 }; // 나이트 방식으로 움직이는 것
		int[] dhc = { 1, 2, 2, 1, -1, -2, -2, -1 };

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		q.add(new int[] { 0, 0, k, 0 });
		
		for (int i = 0; i < k+1; i++) { //0,0은 어떤 경우로도 재방문 하지 않게 true로 초기화
			visited[0][0][i] = true;
		}
		
		boolean flag = false;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int r = now[0];
			int c = now[1];
			int horse = now[2]; //말로 이동 할 수 있는 횟수 0~k
			int move = now[3]; //이동했던 횟수

			if (r == H - 1 && c == W - 1) {
				System.out.println(move);
				flag = true;
				break;
			}

			if (horse > 0) { // 말로 이동할 수 있을 때
				for (int i = 0; i < 8; i++) {
					int rr = r + dhr[i];
					int cc = c + dhc[i];
					if (rr >= 0 && rr < H && cc >= 0 && cc < W) {
						if (map[rr][cc] == 1 || visited[rr][cc][horse - 1])//벽이거나 horse-1로 이미 방문했을경우 pass
							continue;
						visited[rr][cc][horse - 1] = true; //미방문시 방문처리
						q.add(new int[] { rr, cc, horse - 1, move + 1 });// 이동횟수 증가, 말로 이동할 수 있는 횟수 감소
					}
				}
			}

			for (int i = 0; i < 4; i++) { //상하좌우로 한칸씩 이동할 수 있을 때
				int rr = r + dr[i];
				int cc = c + dc[i];
				if (rr >= 0 && rr < H && cc >= 0 && cc < W) {
					if (map[rr][cc] == 1 || visited[rr][cc][horse])// 벽이거나 방문했던곳이거나
						continue;
					visited[rr][cc][horse] = true; //방문처리
					q.add(new int[] { rr, cc, horse, move + 1 }); //이동횟수 증가
				}
			}
		}
		if (flag == false) //만약 가지 못하였을 경우 flag는 false 그대로 ==> -1출력
			System.out.println(-1);
	}
}
