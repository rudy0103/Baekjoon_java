package b9935_문자열폭발;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] inp = br.readLine().toCharArray();
		char[] boomStr = br.readLine().toCharArray();
		int len = boomStr.length;
		StringBuilder sb = new StringBuilder();
		ArrayDeque<Integer> q = new ArrayDeque<>();

		for (int i = 0; i < inp.length; i++) {
			if (inp[i] == boomStr[0])
				q.add(i);
		}
		int cnt=len;
		while (!q.isEmpty()) {
			int pos = q.pollLast();
			int tmp = 0;
			int i = pos;
			while (tmp < len) {
				if (inp[i] == '@')
					i+=len;
				else if (inp[i] == boomStr[tmp]) {
					i++;
					tmp++;
				} else {
					break;
				}

				if (tmp == len) {
					cnt=len;
					while (cnt > 0) {
						if (inp[pos] != '@') {
							inp[pos] = '@';
							pos++;
							cnt--;
						}else pos+=len;
					}
				}
			}
		}

		for (int i = 0; i < inp.length; i++) {
			if (inp[i] != '@')
				sb.append(inp[i]);
		}
		if(sb.toString().length()!=0) System.out.println(sb.toString());
		else System.out.println("FRULA");
	}
}
