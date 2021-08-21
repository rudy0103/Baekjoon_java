package b2667_단지번호붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> res = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		int N=Integer.parseInt(br.readLine());
		int[][]map=new int[N][N];
		boolean[][] visited=new boolean[N][N];
		int[] dr= {-1,1,0,0};
		int[] dc= {0,0,-1,1};
		
		for(int i=0;i<N;i++) {
			String inp=br.readLine();
			for(int j=0;j<N;j++) map[i][j]=inp.charAt(j)-'0';
		}
		int cnt=0;
		Queue<int []> q = new LinkedList<int[]>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1&&!visited[i][j]) {
					q.add(new int[] {i,j});
					visited[i][j]=true;
					while (!q.isEmpty()) {
						int[] tmp=q.poll();
						cnt++;
						for(int d=0;d<4;d++) {
							int rr=tmp[0]+dr[d];
							int cc=tmp[1]+dc[d];
							if(rr>=0&&rr<N&&cc>=0&&cc<N&&map[rr][cc]==1&&!visited[rr][cc]) {
								visited[rr][cc]=true;
								q.add(new int[]{rr,cc});
							}
						}
					}
					res.add(cnt);
				}else cnt=0;
			}
		}
		sb.append(res.size()).append("\n");
		Collections.sort(res);
		for(int n:res) {
			sb.append(n).append("\n");
		}
		System.out.println(sb.toString());
	}
}
