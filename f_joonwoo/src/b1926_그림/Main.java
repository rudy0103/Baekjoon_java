package b1926_그림;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		boolean [][]map=new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
			int tmp=Integer.parseInt(st.nextToken());
			if(tmp==1) map[i][j]=true;
			}
		}
		
		int cnt=0;
		int area=0;
		
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		boolean[][] visited=new boolean[n][m];
		
		int [] dr= {-1,1,0,0};
		int [] dc= {0,0,-1,1};
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==false||visited[i][j]) continue;
				int a=0;
				cnt++;
				dq.add(new int[]{i,j});
				visited[i][j]=true;
				while(!dq.isEmpty()) {
					int[] curr=dq.poll();
					a++;					
					for(int d=0;d<4;d++) {
						int nr=curr[0]+dr[d];
						int nc=curr[1]+dc[d];
						
						if(nr<0||nr>=n||nc<0||nc>=m||map[nr][nc]==false||visited[nr][nc]) continue;
						visited[nr][nc]=true;
						dq.add(new int[]{nr,nc});
					}
				}
				area=Math.max(area, a);
				
			}
		}
		
		System.out.println(cnt);
		System.out.println(area);
		
		
	}

}
