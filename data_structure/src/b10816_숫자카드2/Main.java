package b10816_숫자카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map=new HashMap<>();
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int N=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		String key=null;
		for(int i=0;i<N;i++) {
			key=st.nextToken();
			if(map.containsKey(key)){
				Integer value = map.get(key);
				map.put(key, ++value);
			}else map.put(key, 1);
		}
		
		int M=Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			key=st.nextToken();
			if(map.containsKey(key)) {
				sb.append(map.get(key)).append(" ");
			}else sb.append("0 ");
		}
		
		System.out.println(sb.toString());
	}
}
