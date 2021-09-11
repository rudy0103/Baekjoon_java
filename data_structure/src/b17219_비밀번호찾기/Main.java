package b17219_비밀번호찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		String [] inp = br.readLine().split(" ");
		int N=Integer.parseInt(inp[0]);
		int M=Integer.parseInt(inp[1]);
		
		HashMap<String, String> hmap = new HashMap<>();
		String site=null;
		String pw = null;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			site=st.nextToken();
			pw=st.nextToken();
			
			hmap.put(site, pw);
		}
		
		for(int i=0;i<M;i++) {
			sb.append(hmap.get(br.readLine())).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
}
