package b10026_적록색약;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
	
	static int [] dr = {-1,1,0,0};
	static int [] dc= {0,0,-1,1};
	
	public static int findSection(String c, char[][] arr, boolean[][] visited) {
		for(int i=0;i<visited.length;i++)
			Arrays.fill(visited[i], false);
		
		int cnt=0;
		
		ArrayDeque<int []> q = new ArrayDeque<>();
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(c.indexOf(arr[i][j])!=-1&&visited[i][j]==false) {
					q.add(new int[] {i,j});
					visited[i][j]=true;
					cnt++;
					while (!q.isEmpty()) {
						int [] tmp=q.poll();
						for(int d=0;d<4;d++) {
							int rr= tmp[0]+dr[d];
							int cc= tmp[1]+dc[d];
							if(rr>=0&&rr<arr.length&&cc>=0&&cc<arr.length&&!visited[rr][cc]) {
								if(c.indexOf(arr[rr][cc])!=-1) {
									visited[rr][cc]=true;
									q.add(new int[] {rr,cc});
								}
							}
							
						}
					}
					
				}
			}
		}
		
		
		
		return cnt;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		char[][] arr=new char[N][N];
		boolean [][] visited=new boolean[N][N];
		for(int i=0;i<N;i++) {
			arr[i]=br.readLine().toCharArray();
		}
		int RGB=0;
		int RB=0;
		RGB=findSection("R",arr,visited)+findSection("G",arr,visited)+findSection("B",arr,visited);
		RB=findSection("B",arr,visited)+findSection("RG",arr,visited);
		System.out.println(RGB+" "+RB);
	}
}
