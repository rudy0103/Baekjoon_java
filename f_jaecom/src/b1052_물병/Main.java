package b1052_물병;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<>();
		int t = 1;
		while (t <= 10000000*2) {
			list.add(t);
			t *= 2;
		}

		while (K > 1) {
			for (int i = list.size() - 1; i >= 0; i--) {
				if (list.get(i) <= N) {
					N -= list.get(i);
					break;
				}
			}
			K--;
		}
		if (N == 0) {
			System.out.println("0");
		} else {
			int idx = -1;
			for (int i = 0; i < list.size(); i++) {
				if (N <= list.get(i)) {
					idx = i;
					break;
				}
			}
			System.out.println(list.get(idx) - N);

		}

	}

}
