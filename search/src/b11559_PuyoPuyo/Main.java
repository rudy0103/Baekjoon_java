package b11559_PuyoPuyo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] map = new char[12][6];

		for (int i = 0; i < 12; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int cnt = 0;

		int groupCnt[] = new int[12 * 6 + 1];
		int groups[][] = new int[12][6];
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		ArrayDeque<int[]> q = new ArrayDeque<>();

		while (true) {
			int group = 0;
			for (int i = 0; i < 12; i++) {
				Arrays.fill(groups[i], 0);
			}
			Arrays.fill(groupCnt, 0);

			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] != '.'&&groups[i][j]==0) {
						group++;
						q.add(new int[] { i, j });
						while (!q.isEmpty()) {
							int[] curr = q.poll();
							groups[curr[0]][curr[1]] = group;
							for (int d = 0; d < 4; d++) {
								int r = curr[0] + dr[d];
								int c = curr[1] + dc[d];

								if (r >= 0 && r < 12 && c >= 0 && c < 6 && map[r][c] == map[i][j]
										&& groups[r][c] == 0) {

									groups[r][c] = group;
									groupCnt[group]++;
									q.add(new int[] { r, c });
								}
							}
						}
					}
				}
			}

			boolean isBoomed = false;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (groupCnt[groups[i][j]] >= 3) {
						map[i][j] = '.';
						isBoomed = true;
					}
				}
			}
			if (isBoomed == false) {
				break;
			} else {
				cnt++;
				gravity(map);
			}
		}
		System.out.println(cnt);
	}

	private static void gravity(char[][] map) {
		
		for(int i=0;i<6;i++) {
			
			int r=11;
			
			while(r>0) {
				if(map[r][i]!='.') {
					r--;
				}else {
					int pos=r-1;
					
					while(pos>0&&map[pos][i]=='.') {
						pos--;
					}
					if(map[pos][i]!='.') {
						map[r][i]=map[pos][i];
						map[pos][i]='.';
					}
					r--;
				}
			}
		}
	}
}
