package b10818_최소최대;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()){
			int tmp = Integer.parseInt(st.nextToken());
			if (tmp > max)
				max = tmp;
			if (tmp < min)
				min = tmp;
		}
		System.out.println(min + " " + max);
	}
}
