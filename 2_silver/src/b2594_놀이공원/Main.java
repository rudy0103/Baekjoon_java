package b2594_놀이공원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int max=0;
		

		//10:00 ~ 22:00 -> 600 ~ 60*22
		boolean []times=new boolean[60*24];
		Arrays.fill(times,true);
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String start = st.nextToken();
			String end = st.nextToken();
			int s=getTime(start);
			int e=getTime(end);
			
			for(int t=s-10;t<e+10;t++) {
				times[t]=false;
			}
		}
		
		int time=0;
		
		for(int t=600;t<60*22;t++) {
			if(times[t]) {
				time++;
			}else {
				max=Math.max(max, time);
				time=0;
			}
		}
		max=Math.max(max, time);
		
		System.out.println(max);
		
	}

	private static int getTime(String start) {
		
		int h=Integer.parseInt(start.substring(0,2));
		int m=Integer.parseInt(start.substring(2));
		
		return 60*h+m;
	}

}
