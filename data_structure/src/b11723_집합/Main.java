package b11723_집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashSet<Integer> set = new HashSet<Integer>();
		int N = Integer.parseInt(br.readLine());
		String[] inp = null;
		for (int i = 0; i < N; i++) {
			inp = br.readLine().split(" ");
			if (inp[0].equals("add")) {
				set.add(Integer.parseInt(inp[1]));
			} else if (inp[0].equals("remove")) {
				set.remove(Integer.parseInt(inp[1]));
			} else if (inp[0].equals("check")) {
				if(set.contains(Integer.parseInt(inp[1]))) {
					sb.append("1\n");
				}else sb.append("0\n");
			}
			else if (inp[0].equals("toggle")) {
				if(set.contains(Integer.parseInt(inp[1]))) {
					set.remove(Integer.parseInt(inp[1]));
				}else set.add(Integer.parseInt(inp[1]));
			}else if(inp[0].equals("all")) {
				for(int j=1;j<=20;j++) set.add(j);
			}else if(inp[0].equals("empty")) set.clear();
		}
		System.out.println(sb.toString());

	}

}
