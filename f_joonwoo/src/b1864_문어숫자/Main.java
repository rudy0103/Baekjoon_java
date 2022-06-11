package b1864_문어숫자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inp=br.readLine();
		StringBuilder sb = new StringBuilder();
		HashMap<Character,Integer> hmap=new HashMap<>();
		hmap.put('-', 0);
		hmap.put('\\', 1);
		hmap.put('(', 2);
		hmap.put('@', 3);
		hmap.put('?', 4);
		hmap.put('>', 5);
		hmap.put('&', 6);
		hmap.put('%', 7);
		hmap.put('/', -1);
		
		while(inp.equals("#")==false) {
			
			int len=inp.length();
			int num=0;
			for(int i=0;i<inp.length();i++) {
		
				num+=(hmap.get(inp.charAt(i))*Math.pow(8, len-i-1));
			}
			
			sb.append(num+"\n");
			
			
			inp=br.readLine();
		}
		
		System.out.println(sb.toString());
	}

}
