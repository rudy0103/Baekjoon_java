package b1620_나는야포켓몬마스터이다솜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		HashMap<Integer,String> map2 = new HashMap< Integer,String>();
		String [] inp=br.readLine().split(" ");
		int N = Integer.parseInt(inp[0]);
		int M = Integer.parseInt(inp[1]);
		
		
		for(int i=1;i<=N;i++) {
			String pk=br.readLine();
			map.put(pk, i);
			map2.put(i, pk);
		}
		
		for(int i=0;i<M;i++) {
			String s=br.readLine();
			if(map.containsKey(s)) {
				sb.append(map.get(s)).append("\n");
			}else {
				sb.append(map2.get(Integer.parseInt(s))).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}
