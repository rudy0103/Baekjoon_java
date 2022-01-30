package b1002_터렛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static class Turet{
		int x;
		int y;
		int r;
		public Turet(int x, int y, int r) {
			super();
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st =null;
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			st=new StringTokenizer(br.readLine()," ");
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			int r1=Integer.parseInt(st.nextToken());
			
			Turet t1 = new Turet(x1,y1,r1);
			
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			int r2=Integer.parseInt(st.nextToken());
			
			Turet t2 = new Turet(x2,y2,r2);
			
			if(x1==x2&&y1==y2&&r1==r2) {//무한대
				sb.append("-1\n");
			}else if(x1==x2&&y1==y2){// 두 터렛 위치는 같은데 반지름이 다른경우
				sb.append("0\n");
			}else {
				double dist=Math.abs(x1-x2)*Math.abs(x1-x2)+Math.abs(y1-y2)*Math.abs(y1-y2);
				dist=Math.sqrt(dist);
				
				Turet big;
				Turet small;
				if(t1.r>=t2.r) {
					big=t1;
					small=t2;
				}else {
					big=t2;
					small=t1;
				}
				
				if(dist==big.r) {
					sb.append("2\n");
				}else if(dist<big.r) {
					
					if(dist+small.r==big.r) {
						sb.append("1\n");
					}else if(dist+small.r>big.r) {
						sb.append("2\n");
					}else {
						sb.append("0\n");
					}
					
				}else {
					if(small.r+big.r==dist) {
						sb.append("1\n");
					}else if(small.r+big.r>dist) {
						sb.append("2\n");
					}else {
						sb.append("0\n");
					}
				}
			}
		}
		System.out.println(sb.toString());
	}
}
