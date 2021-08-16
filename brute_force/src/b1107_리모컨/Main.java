package b1107_리모컨;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

	static int ch, n, arr, m, r;
	static int[] selected;
	static int[] numbers;
	static int min = Integer.MAX_VALUE;

	static void makePermutation(int cnt, int k) {
		if (cnt == k) {
			StringBuilder sb=new StringBuilder();
			for (int a : selected)
				sb.append(a);
			int num = Integer.parseInt(sb.toString());
			int press = Math.abs(ch - num) + k;
			if (press < min)
				min = press;
			return;
		}
		for (int i = 0; i < m; i++) {
			selected[cnt] = numbers[i];
			makePermutation(cnt + 1, k);
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		ch = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		m = 10 - n;
		int arr[] = new int[10];
		numbers = new int[m];
		r = (ch + "").length();

		if (n > 0) {
			String[] inp = br.readLine().split(" ");

			for (int i = 0; i < n; i++)
				arr[Integer.parseInt(inp[i])] = -1;

			int idx = 0;
			for (int i = 0; i < 10; i++)
				if (arr[i] == 0)
					numbers[idx++] = i;
		}else {
			for (int i = 0; i < 10; i++)
					numbers[i] = i;
		}
		if (r < 6) {
			selected = new int[r];
			makePermutation(0, r);
			selected = new int[r + 1];
			makePermutation(0, r + 1);
			if (r >= 2) {
				selected = new int[r - 1];
				makePermutation(0, r - 1);
			}
		} else if (r == 6) {
			selected = new int[r];
			makePermutation(0, r);
			selected = new int[r - 1];
			makePermutation(0, r - 1);
		}

		min = min < Math.abs(ch - 100) ? min : Math.abs(ch - 100);

		bw.write(min + "");
		bw.close();
	}
}