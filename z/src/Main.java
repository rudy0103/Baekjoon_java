
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N; // 원소 개수
	static int[] parents; // 부모원소관리 (트리처럼사용)

	private static void make() {
		// 모든 원소를 자신을 대표자로 만듦
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	private static int find(int a) {
		if (a == parents[a])
			return a; // 자신이 대표자일 때는 자신을 리턴
		return parents[a] = find(parents[a]); // 자신이 속한 집합의 대표쟈를 자신의 부모로 : path compression
	}

	// 두 원소를 하나의 집합으로 합치기(대표자를 이용해 합침)
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		parents[bRoot] = aRoot; // b의 부모를 a로 삼다
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 1~N
			int M = Integer.parseInt(st.nextToken()); // 연산
			parents = new int[N + 1];

			// 0 a b의 형태로 입력 --> a가 포함되어 있는 집합과, b가 포함되어 있는 집합을 합친다는 의미
			// 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은 1 a b의 형태로 입력
			// a와 b는 n 이하의 자연수이며 같을 수도 있다.
			// 1로 시작하는 입력에 대해서 같은 집합에 속해있다면 1을, 아니면 0을 순서대로 한줄에 연속하여 출력한다.

			make(); // 원소 집합 만들기

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				int find_union = Integer.parseInt(st.nextToken()); // 0이면 union, 1이면 find
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (find_union == 0) {
					union(a, b);	//a집합, b집합 합침
				}
				else if (find_union == 1) {

					if (find(a) == find(b)) {
						sb.append("1");		//같은 집합이면 1출력
					} else
						sb.append("0");	////다른 집합이면 0출력
				}
			}

			bw.append(sb);
			bw.flush();
		}

		bw.close();
	}

}