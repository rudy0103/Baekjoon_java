package b7576_토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inp = br.readLine().split(" ");
		StringTokenizer st =null;
		Queue<int []> q = new LinkedList<>();
		int M=Integer.parseInt(inp[0]);
		int N=Integer.parseInt(inp[1]);
		int [][]map=new int[N][M];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int j=0;
			while(st.hasMoreTokens()) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) q.add(new int[] {i,j});
				j++;
			}
		}
		int [] dr= {-1,1,0,0};
		int [] dc= {0,0,-1,1};
		while (!q.isEmpty()) {
			int[]tmp=q.poll();
			for(int d=0;d<4;d++) {
				int rr=tmp[0]+dr[d];
				int cc=tmp[1]+dc[d];
				if(rr>=0&&rr<N&&cc>=0&&cc<M&&map[rr][cc]==0) {
					map[rr][cc]=map[tmp[0]][tmp[1]]+1;
					q.add(new int[] {rr,cc});
				}
			}
		}
		int min=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					System.out.println(-1);
					return;
				}else if(map[i][j]>min) min=map[i][j];
			}
		}
		if(min==1) System.out.println(0);
		else System.out.println(min-1);
	}
}
