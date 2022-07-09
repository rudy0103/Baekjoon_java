package b2573_빙산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int [][]map=new int[N][M];
		
		ArrayDeque<int[]> ice = new ArrayDeque<>();
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]!=0) ice.add(new int[] {i,j,map[i][j]});
			}
		}
		
		
		int time=0;
		boolean flag=false;
		
		boolean[][] visited=new boolean[N][M];
		int[] dr= {-1,1,0,0};
		int[] dc= {0,0,-1,1};
		while(!ice.isEmpty()) {
			
			//덩어리 체크
			initVisited(visited);
			int cnt=0;
			int size=ice.size();
			int[] check=ice.peekFirst();
			
			dq.add(check);
			visited[check[0]][check[1]]=true;
			
			while(!dq.isEmpty()) {
				int [] now=dq.poll();
				cnt++;
				
				for(int d=0;d<4;d++) {
					int nr=now[0]+dr[d];
					int nc=now[1]+dc[d];
					
					if(nr<0||nr>=N||nc<0||nc>=M||visited[nr][nc]||map[nr][nc]==0) continue;
					visited[nr][nc]=true;
					dq.add(new int[] {nr,nc});
					
				}
			}
			
			if(size!=cnt) {
				flag=true;
				break;
			}
			time++;
			///얼음 녹이기
			for(int i=0;i<size;i++) {
				int[] now=ice.poll();
				
				int water=0;
				
				for(int d=0;d<4;d++) {
					int nr=now[0]+dr[d];
					int nc=now[1]+dc[d];
					
					if(nr<0||nr>=N||nc<0||nc>=M||visited[nr][nc]||map[nr][nc]!=0) continue;
					water++;
				}
				now[2]-=water;
				ice.add(now);
			}
			
			//
			for(int i=0;i<size;i++) {
				int[] now=ice.poll();
				if(now[2]>0) {
					map[now[0]][now[1]]=now[2];
					ice.add(now);
				}else {
					map[now[0]][now[1]]=0;
				}
			}
			
			
		}
		
	
		
		if(flag) System.out.println(time);
		else System.out.println("0");
		
		
		
		
	}

	private static void initVisited(boolean[][] visited) {
		for(int i=0;i<visited.length;i++) Arrays.fill(visited[i], false);
		
	}

}
