import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = br.readLine().split(" ");
		Queue<int[]> q = new LinkedList<int[]>();
		int N = Integer.parseInt(inp[0]);
		int M = Integer.parseInt(inp[1]);
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++)
				map[i][j] = input.charAt(j) - '0';
		}

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		map[0][0]=1;
		q.add(new int[] { 0, 0, 1 });
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			if(tmp[0]==N-1&&tmp[1]==M-1) break;
			for (int d = 0; d < 4; d++) {
				int rr = tmp[0] + dr[d];
				int cc = tmp[1] + dc[d];
				if (rr >= 0 && rr < N && cc >= 0 & cc < M) {
					if (map[rr][cc] == 0) {
						map[rr][cc] = map[tmp[0]][tmp[1]] + 1;
						if(rr==N-1&&cc==M-1) break;
						q.add(new int[] { rr, cc, tmp[2] });
					} else if (map[rr][cc] == 1 && tmp[2] == 1) {
						map[rr][cc] = map[tmp[0]][tmp[1]] + 1;
						q.add(new int[] { rr, cc, tmp[2] - 1 });
					}
				}
			}
		}
		if (map[N - 1][M - 1] != 0)
			System.out.println(map[N - 1][M - 1]);
		else
			System.out.println(-1);
	}

}