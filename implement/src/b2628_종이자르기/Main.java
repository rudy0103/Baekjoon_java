package b2628_종이자르기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Paper {
	int[] left_top;
	int[] right_bottom;
	int area;

	public Paper(int[] left_top, int[] right_bottom) {
		super();
		this.left_top = left_top;
		this.right_bottom = right_bottom;
		this.area = (right_bottom[0] - left_top[0]) * (right_bottom[1] - left_top[1]);
	}

}

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] inp = br.readLine().split(" ");
		Queue<Paper> q = new LinkedList<>();

		int N = Integer.parseInt(inp[0]);
		int M = Integer.parseInt(inp[1]);

		Paper origin = new Paper(new int[] { 0, 0 }, new int[] { M, N });
		q.add(origin);
		int cut = Integer.parseInt(br.readLine());
		for (int i = 0; i < cut; i++) {
			inp = br.readLine().split(" ");
			int dir = Integer.parseInt(inp[0]);
			int pos = Integer.parseInt(inp[1]);

			int size = q.size();
			while (size > 0) {
				Paper curr = q.poll();
				size--;
				if (dir == 0) {

					if (pos > curr.left_top[0] && pos < curr.right_bottom[0]) {
						Paper p1 = new Paper(new int[] { curr.left_top[0], curr.left_top[1] },
								new int[] { pos, curr.right_bottom[1] });
						Paper p2 = new Paper(new int[] { pos, curr.left_top[1] },
								new int[] { curr.right_bottom[0], curr.right_bottom[1] });
						q.add(p1);
						q.add(p2);
					} else
						q.add(curr);

				} else {

					if (pos > curr.left_top[1] && pos < curr.right_bottom[1]) {
						Paper p1 = new Paper(new int[] { curr.left_top[0], curr.left_top[1] },
								new int[] { curr.right_bottom[0], pos });
						Paper p2 = new Paper(new int[] { curr.left_top[0], pos },
								new int[] { curr.right_bottom[0], curr.right_bottom[1] });
						q.add(p1);
						q.add(p2);
					} else
						q.add(curr);
				}
			}
		}
		int max=Integer.MIN_VALUE;
		while(!q.isEmpty()) {
			Paper p=q.poll();
			if(p.area>max) max=p.area;
		}
		bw.write(max+"");
		bw.close();

	}
}