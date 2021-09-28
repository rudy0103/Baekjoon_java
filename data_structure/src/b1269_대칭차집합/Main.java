package b1269_대칭차집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String []inp=br.readLine().split(" ");
		
		HashSet<String> set = new HashSet<>();
		
		int A=Integer.parseInt(inp[0]);
		int B=Integer.parseInt(inp[1]);
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<A;i++) {
			set.add(st.nextToken());
		}
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<B;i++) {
			String tmp=st.nextToken();
			if(set.contains(tmp)){
				set.remove(tmp);
			}else {
				set.add(tmp);
			}
		}
		System.out.println(set.size());
	}
}
