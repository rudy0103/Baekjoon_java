package b3885_회색영역;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int w=Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		while(n!=0&&w!=0) {
			
			int[] cnt = new int[100/w+1];
			
			for(int i=0;i<n;i++) {
				int v=Integer.parseInt(br.readLine());
				cnt[v/w]++;
			}
			
			int maxSector=0;
			int maxCnt=0;
			for(int i=0;i<cnt.length;i++) {
				if(cnt[i]>0) maxSector=i;
				maxCnt=Math.max(maxCnt, cnt[i]);
			}
						
			double cost=0.01;
			
			
			for(int i=0;i<maxSector;i++) {
				double b=(double)(maxSector-i)/(double)(maxSector);
				double h=((double)cnt[i]/maxCnt);
				cost+=b*h;
			}
			
			
			
			sb.append(cost+"\n");
			
			
			
//			======================================================================
			st = new StringTokenizer(br.readLine());
			
			n=Integer.parseInt(st.nextToken());
			w=Integer.parseInt(st.nextToken());
		}
		System.out.println(sb.toString());
		
	}

}
