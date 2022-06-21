package b1598_정육면체전개도;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	static class Dice {

		int bottom;
		int top;
		int up;
		int down;
		int left;
		int right;
		int r;
		int c;

		public Dice(int bottom, int top, int up, int down, int left, int right, int r, int c) {
			super();
			this.bottom = bottom;
			this.top = top;
			this.up = up;
			this.down = down;
			this.left = left;
			this.right = right;
			this.r = r;
			this.c = c;
		}

		public int getOpposite(int n) {
			if (n == 1)
				return 6;
			if (n == 2)
				return 4;
			if (n == 3)
				return 5;
			if (n == 4)
				return 2;
			if (n == 5)
				return 3;
			if (n == 6)
				return 1;
			return 0;
		}

		public Dice moveRight() {
			int bottom = this.right;
			int right = this.top;
			int top = getOpposite(bottom);
			int left = getOpposite(right);


			return new Dice(bottom, top, this.up, this.down, left, right, r, c+1);

		}

		public Dice moveLeft() {
			int bottom = this.left;
			int left = this.top;
			int right = getOpposite(left);
			int top = getOpposite(bottom);


			return new Dice(bottom, top, this.up, this.down, left, right, r, c-1);

		}

		public Dice moveUp() {
			int bottom = this.up;
			int up = this.top;
			int top = getOpposite(bottom);
			int down = getOpposite(up);

			return new Dice(bottom, top, up, down, this.left, this.right, r-1, c);

		}

		public Dice moveDown() {
			int bottom = this.down;
			int down = this.top;
			int top = getOpposite(bottom);
			int up = getOpposite(down);

			return new Dice(bottom, top, up, down, this.left, this.right, r+1, c);
		}

		public Dice move(int d) {
			if (d == 0)
				return moveUp();
			if (d == 1)
				return moveDown();
			if (d == 2)
				return moveLeft();
			else
				return moveRight();
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < 3; t++) {
			int[][] arr = new int[6][6];
			for (int i = 0; i < 6; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 6; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			if (isTrue(arr)) {
				sb.append("yes\n");
			} else {
				sb.append("no\n");
			}
		}
		System.out.println(sb.toString());

	}

	private static boolean isTrue(int[][] arr) {
		boolean[] checked = new boolean[7];
		boolean[][] visited=new boolean[6][6];
		ArrayDeque<Dice> dq = new ArrayDeque<>();

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (arr[i][j] == 1) {
					dq.add(new Dice(1,6,2,4,3,5,i, j));
					visited[i][j]=true;
					break;
				}
			}
			if(!dq.isEmpty()) break;
		}

		while (!dq.isEmpty()) {
			Dice dice = dq.poll();
			checked[dice.bottom] = true;
			
			for (int d = 0; d < 4; d++) {
				int nr=dice.r+dr[d];
				int nc=dice.c+dc[d];
				
				if(nr<0||nr>=6||nc<0||nc>=6||visited[nr][nc]||arr[nr][nc]==0) continue;
				visited[nr][nc]=true;
				dq.add(dice.move(d));
			}
		}

		for (int i = 1; i <= 6; i++) {
			if (checked[i] == false)
				return false;
		}
		return true;
	}

}
