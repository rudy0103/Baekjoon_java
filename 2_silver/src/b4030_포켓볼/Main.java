package b4030_포켓볼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		
		HashSet<Integer> square=new HashSet<>();
		HashSet<Integer> tri=new HashSet<>();
		
		int i=1;
		while(i*i<=1000000000) {
			square.add(i*i);
			i++;
		}
		
		int before=0;
		for(int j=0;;j++) {
			if(before+j+1<1000000000) {
				tri.add(before+j+1);
				before+=j;
			}else break;
		}
		
		int t=1;
		while(a!=0) {
			int cnt=0;
			for(Integer num: square) {
				if(num>a&&num<b) {
					if(tri.contains(num)) cnt++;
				}
			}
			
			sb.append("Case "+t+": "+cnt+"\n");
			t++;
			st=new StringTokenizer(br.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
		}
		System.out.println(sb.toString());
	}

}
