package b1152_단어의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt=0;
		while(st.hasMoreTokens()) {
			cnt++;
			st.nextToken();
		}
		System.out.println(cnt);

	}
}
