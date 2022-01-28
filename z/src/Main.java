import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		int[] tree = new int[4000004];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			String A = st.nextToken();
			if (A.charAt(0) == '1') {// B는 꺼낼 사탕의 순위
				int B = Integer.parseInt(st.nextToken());
				int tmp = find(tree,B,1,1,1000000,0);
				sb.append(tmp+"\n");
				update(tree, tmp, -1, 1, 1, 1000000);

			} else {//

				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());

				update(tree, B, C, 1, 1, 1000000);
			}

		}
		System.out.println(sb.toString());
	}



	private static int find(int[] tree, int b, int node, int left, int right, int cnt) {

		
		if(left==right) return left; //더이상 쪼개질 수 없을 때
		
		
		int mid=(left+right)/2;
		
		int leftNode=node*2;
		
		if(b<=tree[leftNode]+cnt) {
			return find(tree, b, node*2, left, mid, cnt);
		}else {
			return find(tree, b, node*2+1, mid+1, right, cnt+tree[leftNode]);
		}
		
		
	}



	private static void update(int[] tree, int index, int val, int node, int left, int right) {

		if (index < left | index > right)
			return;

		if (left == right) {
			tree[node] += val;
			return ;
		}

		int mid = (left + right) / 2;

		if (index <= mid) {
			update(tree, index, val, node * 2, left, mid);
		} else {
			update(tree, index, val, node * 2 + 1, mid + 1, right);
		}

		tree[node] = tree[node * 2] + tree[node * 2 + 1];

	}

}