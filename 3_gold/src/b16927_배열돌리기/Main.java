package b16927_배열돌리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M,R;
	//우하좌상
	static int []dr= {0,1,0,-1};
	static int []dc= {1,0,-1,0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		
		
		int[][] arr = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) arr[i][j]=Integer.parseInt(st.nextToken());		
		}
		
		int r=N;
		int c=M;
		
		int start=0;
		while(r!=0&&c!=0) {
			solve(arr,r,c,start);
			r-=2;
			c-=2;
			start++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());

		
	}
	
    private static void solve(int[][] arr, int r, int c,int start) {
    	
    	int cycle=r*2+c*2-4;
    	int times=R%cycle;
    	
    	for(int i=0;i<times;i++) {
    		turnArr(arr,start);
    	}
    	
    	
	}

	private static void turnArr(int[][] arr, int start) {
		
		int first=arr[start][start];
		
		int beforeR=start;
		int beforeC=start;
		
		int nextR=start;
		int nextC=start+1;
		int d=0;
		
		
		while(d<4) {
			arr[beforeR][beforeC]=arr[nextR][nextC];
			beforeR=nextR;
			beforeC=nextC;
			
			int nr=nextR+dr[d];
			int nc=nextC+dc[d];
			
			if(nr>=start&&nr<N-start&&nc>=start&&nc<M-start) {
				nextR=nr;
				nextC=nc;
			}else {
				d++;
				if(d>=4) break;
				nextR+=dr[d];
				nextC+=dc[d];
			}
		}
		arr[start+1][start]=first;
		
	}
}
