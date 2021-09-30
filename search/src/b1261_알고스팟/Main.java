package b1261_알고스팟;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		
		int [][]map=new int[N][M];
		boolean [][] visited=new boolean[N][M];
		int[] dr = {-1,1,0,0,};
		int[] dc = {0,0,-1,1};
		
		for(int i=0;i<N;i++) {
			char[] ch=br.readLine().toCharArray();
			for(int j=0;j<M;j++) {
				map[i][j]=ch[j]-'0';
			}
		}
		
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		pq.add(new int[] {0,0,0});
		visited[0][0]=true;
		
		while(!pq.isEmpty()) {
			int [] cur=pq.poll();
			int r=cur[0];
			int c=cur[1];
			int broken=cur[2];
			if(r==N-1&&c==M-1) {
				System.out.println(broken);
				break;
			}
			
			for(int d=0;d<4;d++) {
				int rr=r+dr[d];
				int cc=c+dc[d];
				if(rr>=0&&rr<N&&cc>=0&&cc<M&&visited[rr][cc]==false) {
					visited[rr][cc]=true;
					pq.add(new int[] {rr,cc,broken+map[rr][cc]});
				}
			}
		}
		
		
		
	}

}
