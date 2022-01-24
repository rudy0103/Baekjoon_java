package b16931_겉넓이구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int [][] squares=new int[N][M];
		
		int cnt=0;
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				squares[i][j]=Integer.parseInt(st.nextToken());
				if(squares[i][j]>0) cnt++;
			}
		}
		
		int area=0;
		
		//밑면,윗면
		
		area+=cnt*2;

		
		//옆면 4개
		
		for(int i=0;i<N;i++) {
			int tmp=0;
			for(int j=0;j<M;j++) {
				if(tmp-squares[i][j]<0)
					area-=tmp-squares[i][j];
				tmp=squares[i][j];
			}
			
			tmp=0;
			for(int j=M-1;j>=0;j--) {
				if(tmp-squares[i][j]<0)
					area-=tmp-squares[i][j];
				tmp=squares[i][j];
			}
	
		}
		
		for(int i=0;i<M;i++) {
			int tmp=0;
			for(int j=0;j<N;j++) {
				if(tmp-squares[j][i]<0)
					area-=tmp-squares[j][i];
				tmp=squares[j][i];
			}
			tmp=0;
			for(int j=N-1;j>=0;j--) {
				if(tmp-squares[j][i]<0)
					area-=tmp-squares[j][i];
				tmp=squares[j][i];
			}
	
		}
		

		

		
		System.out.println(area);
	}

}
