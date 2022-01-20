package b5676_음주코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String inp = "";
		while ((inp = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(inp, " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int arr[] = new int[N];

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if (arr[i] > 0)
					arr[i] = 1;
				else if (arr[i] < 0)
					arr[i] = -1;
			}

			int[] segmentTree = new int[4 * N];

			makeTree(segmentTree, arr, 1, 0, N - 1);

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				char command = st.nextToken().charAt(0);
				if (command == 'C') {// 변경
					int I = Integer.parseInt(st.nextToken()) - 1;
					int V = Integer.parseInt(st.nextToken());
					if (V > 0)
						V = 1;
					else if (V < 0)
						V = -1;
					update(segmentTree, V, I, 1, 0, N - 1);

				} else {// 곱셈

					int I = Integer.parseInt(st.nextToken()) - 1;
					int J = Integer.parseInt(st.nextToken()) - 1;

					int res = multiply(segmentTree, I, J, 1, 0, N - 1);

					if (res == 0)
						sb.append("0");
					else if (res > 0)
						sb.append("+");
					else
						sb.append("-");
				}

			}
			sb.append("\n");

		}
		System.out.println(sb.toString());

	}

	private static int multiply(int[] segmentTree, int left, int right, int node, int nodeLeft, int nodeRight) {

		if (left > nodeRight || right < nodeLeft)
			return 1;

		if (left <= nodeLeft && nodeRight <= right) {

			return segmentTree[node];
		}

		int mid = (nodeLeft + nodeRight) / 2;
		int leftVal = multiply(segmentTree, left, right, node * 2, nodeLeft, mid);
		int rightVal = multiply(segmentTree, left, right, node * 2 + 1, mid + 1, nodeRight);

		return leftVal * rightVal;
	}

	private static int update(int[] segmentTree, int value, int index, int node, int nodeLeft, int nodeRight) {

		if (index < nodeLeft || index > nodeRight)
			return -9;

		if (nodeLeft == nodeRight) {
			return segmentTree[node]=value;

		}

		int mid = (nodeLeft + nodeRight) / 2;
		int leftVal = update(segmentTree, value, index, node * 2, nodeLeft, mid);
		if(leftVal==-9) leftVal=segmentTree[node*2];
		
		int rightVal = update(segmentTree, value, index, node * 2 + 1, mid + 1, nodeRight);
		if(rightVal==-9) rightVal=segmentTree[node*2+1];

	
		return segmentTree[node] = (leftVal * rightVal);
	}

	private static int makeTree(int[] segmentTree, int[] arr, int node, int left, int right) {

		if (left == right) {
			return segmentTree[node] = arr[left];
		}

		int mid = (left + right) / 2;

		int leftVal = makeTree(segmentTree, arr, node * 2, left, mid);
		int rightVal = makeTree(segmentTree, arr, node * 2 + 1, mid + 1, right);

		return segmentTree[node] = leftVal * rightVal;
	}

}
