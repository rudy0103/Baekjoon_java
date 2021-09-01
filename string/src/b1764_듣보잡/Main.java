package b1764_듣보잡;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<String, Integer> hMap=new HashMap<>();
		String [] inp = br.readLine().split(" ");
		int N=Integer.parseInt(inp[0]);
		int M=Integer.parseInt(inp[1]);
		
		int cnt=0;
		ArrayList<String> list = new ArrayList<>();
		for(int i=0;i<N+M;i++) {
			String tmp=br.readLine();
			if(hMap.containsKey(tmp)) {
				int v=hMap.get(tmp);
				hMap.replace(tmp, ++v);
				cnt++;
				list.add(tmp);
			}else {
				hMap.put(tmp, 1);
			}
		}
		Collections.sort(list);
		
		sb.append(cnt).append("\n");
		for(String s:list) {
			sb.append(s).append("\n");
		}
		System.out.println(sb.toString());
	}
}
