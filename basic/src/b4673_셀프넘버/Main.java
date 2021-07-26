package b4673_셀프넘버;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

	static public void d(int n) {
		if (n <= 10000) {
			int m = 10000;
			int ret = n;
			String s = Integer.toString(n);
			for (int i = 0; i < s.length(); i++) {
				ret += Integer.parseInt(s.charAt(i) + "");
			}
			if (ret <= 10000) {
				arr[ret] = 1;
				d(ret);
			}
		}
	}

	static int[] arr = new int[10001];

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 1; i <= 10000; i++) {
			d(i);
		}
		for (int i = 1; i <= 10000; i++) {
			if (arr[i] == 0) {
				bw.write(i+"\n");
			}
		}
		bw.flush();
		bw.close();

	}

}
