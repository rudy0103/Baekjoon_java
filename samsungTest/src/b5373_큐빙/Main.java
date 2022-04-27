package b5373_큐빙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static class Cube {

		HashMap<Character, Area> hmap = new HashMap<>();

		public Cube() {

			Area up = new Area('w', 'U');
			Area down = new Area('y', 'D');
			Area front = new Area('r', 'F');
			Area back = new Area('o', 'B');
			Area left = new Area('g', 'L');
			Area right = new Area('b', 'R');
//
//			up.setAdj(new String[] { "F1", "B1", "L1", "R1" });
//			down.setAdj(new String[] { 'F', 'B', 'L', 'R' });
//			front.setAdj(new String[] { 'U', 'D', 'L', 'R' });
//			back.setAdj(new String[] { 'U1', 'D3', 'L', 'R' });
//			left.setAdj(new String[] { 'U', 'D', 'F', 'B' });
//			right.setAdj(new String[] { 'U', 'D', 'F', 'B' });
			hmap.put('U', up);
			hmap.put('D', down);
			hmap.put('F', front);
			hmap.put('B', back);
			hmap.put('L', left);
			hmap.put('R', right);
		}

	}

	static class Area {

		char[][] color;
		String[] adj;

		char name;

		public Area(char c, char name) {
			this.name = name;
			this.adj = new String[4];// 동남서북
			color = new char[3][3];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					color[i][j] = c;
				}
			}
		}

		public void setAdj(String[] adj) {
			this.adj = adj;
		}

		public void turnClock() {
			char[][] tmp = new char[3][3];

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					tmp[j][2 - i] = color[i][j];
				}
			}
			this.color = tmp;
		}

		public void turnCountClock() {
			char[][] tmp = new char[3][3];

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					tmp[2 - j][i] = color[i][j];
				}
			}
		}
	}

	// 어떤 면을 바라보고 시계방향, 반시계 방향으로 돌릴때 반대편의 면은 영향을 안받지만 인접한 4개의 면은 바뀐다.

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			Cube cube = new Cube();
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				String cmd = st.nextToken();
				excuteCmd(cmd, cube);
			}
			Area up = cube.hmap.get('U');
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					sb.append(up.color[r][c]);
				}
				if (r != 2)
					sb.append("\n");
			}
		}

		System.out.println(sb.toString());
	}

	private static void excuteCmd(String cmd, Cube cube) {
		
		Area A=cube.hmap.get(cmd.charAt(0));
		char d=cmd.charAt(1);
		
		
		if(d=='+') {
			A.turnClock();
			String []adj=A.adj;
			
			
		}else {
			A.turnCountClock();
		}
		
	}

}
