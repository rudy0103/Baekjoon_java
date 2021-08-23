import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = br.readLine().split(" ");
		int su = Integer.parseInt(inp[0]);
		int bro = Integer.parseInt(inp[1]);
		ArrayDeque<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] { su, 0 });
		int time = -1;
		int count = 0;
		boolean[] visited = new boolean[100001];
		boolean flag = false;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			visited[tmp[0]] = true;
			if (tmp[0] == bro) {
				if (flag == false) {
					time = tmp[1];
					flag = true;
				}
				if (tmp[1] == time)
					count++;
				else
					break;
			}
			if (!flag) {
				if (tmp[0] < bro) {
					if (tmp[0] * 2 <= 100000 && !visited[tmp[0] * 2]) {
						q.add(new int[] { tmp[0] * 2, tmp[1] + 1 });
					}
					if (tmp[0] + 1 <= 100000 && !visited[tmp[0] + 1]) {
						q.add(new int[] { tmp[0] + 1, tmp[1] + 1 });
					}
					if (tmp[0] - 1 >= 0 && !visited[tmp[0] - 1]) {
						q.add(new int[] { tmp[0] - 1, tmp[1] + 1 });
					}
				} else {
					if (tmp[0] - 1 >= 0 && !visited[tmp[0] - 1]) {
						q.add(new int[] { tmp[0] - 1, tmp[1] + 1 });
					}
				}
			}
		}

		System.out.println(time);
		System.out.println(count);
	}
}
