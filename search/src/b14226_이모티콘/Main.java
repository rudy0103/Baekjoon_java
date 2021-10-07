package b14226_이모티콘;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();

		ArrayDeque<int[]> q = new ArrayDeque<>();

		boolean[][] visited = new boolean[1001][1001];

		q.add(new int[] { 1, 0, 0 });// 화면 이모티콘 개수, 클립보드 이모티콘 개수,초

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			if (curr[0] == S) {
				System.out.println(curr[2]);
				break;
			}

			// 1.화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장
			if (curr[0] < 1001 && curr[1] < 1001&&!visited[curr[0]][curr[0]] ) {
				q.add(new int[] { curr[0], curr[0], curr[2] + 1 });
				visited[curr[0]][curr[0]] = true;
			}
			// 2.클립보드에 있는 모든 이모티콘을 화면에 붙여넣기
			if (curr[0]+ curr[1] < 1001&&!visited[curr[0] + curr[1]][curr[1]] ) {
				q.add(new int[] { curr[0] + curr[1], curr[1], curr[2] + 1 });
				visited[curr[0] + curr[1]][curr[1]] = true;
			}
			// 3.화면에 있는 이모티콘 중 하나를 삭제한다.
			if (curr[0] >= 1&&!visited[curr[0]-1][curr[1]] ) {
				q.add(new int[] { curr[0] - 1, curr[1], curr[2] + 1 });
				visited[curr[0] - 1][curr[1]] = true;
			}

		}

	}

}
