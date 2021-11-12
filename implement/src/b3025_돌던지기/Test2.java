//백준 geegee님 풀이 (공부용)
package b3025_돌던지기;

import java.io.*;
import java.util.*;

public class Test2 {
	static int rr,cc,n,a[];
	static char map[][]=new char[30000][31];
	static Pair memo[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb=new StringBuilder();
		rr=Integer.parseInt(st.nextToken());
		cc=Integer.parseInt(st.nextToken());
		for(int i=0;i<rr;i++) {
			map[i]=in.readLine().toCharArray();
		}
		
		memo=new Pair [cc];
		
		for(int i=0;i<cc;i++) {
			memo[i]=new Pair();
			memo[i].col[0]=i;
			update(memo[i]);
		}
		n=Integer.parseInt(in.readLine());
		a=new int [n];
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(in.readLine())-1;
		}
		
		for(int i=0;i<n;i++) {
			insert(memo[a[i]]);
			for(int j=0;j<cc;j++) {
				update(memo[j]);
			}
		}
		
		for(int i=0;i<rr;i++) {
			for(int j=0;j<cc;j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}
	static class Pair{
		int r,col[];

		public Pair() {
			super();
			this.r=1;
			this.col=new int [30000];
			
		}
	}
	static void update(Pair p) {
		while(true) {
			int cur=p.col[p.r-1];
			if(p.r>1 && map[p.r-1][cur]!='.') {
				p.r--;
			}
			else if(p.r==rr) break;
			else if(map[p.r][cur]=='X') break;
			else if(map[p.r][cur]=='.') p.col[p.r++]=cur;
			else {
				if(cur>0 && map[p.r][cur-1]=='.' && map[p.r-1][cur-1]=='.') p.col[p.r++]=cur-1;
				else if(cur+1<cc && map[p.r][cur+1]=='.' &&map[p.r-1][cur+1]=='.') p.col[p.r++]=cur+1;
				else break;
			}
			
			
		}
	}
	static void insert(Pair p) {
		map[p.r-1][p.col[p.r-1]]='O';
	}
}