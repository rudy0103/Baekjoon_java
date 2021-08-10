package b1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] inp = br.readLine().split(" ");
		int n = Integer.parseInt(inp[0]);
		int k = Integer.parseInt(inp[1]);
		
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=1;i<=n;i++)
			list.add(i);
		
		int cnt=0;
		int idx=k-1;
		StringBuilder sb = new StringBuilder();
		sb.append("<");

		while(cnt<n) {
			while (idx<list.size()) {
				sb.append(list.get(idx)+", ");
				list.remove(idx);
				idx+=(k-1);
				cnt++;
			}
			if(idx>=list.size()) idx-=list.size();
		}
		
		sb.setLength(sb.length() - 2);
		sb.append(">");
		bw.write(sb.toString());
		bw.close();
	}
}