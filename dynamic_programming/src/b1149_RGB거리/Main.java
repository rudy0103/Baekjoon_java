package b1149_RGB거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N=Integer.parseInt(br.readLine());
		int [][] arr= new int[N+1][3];
		
		int [][] D=new int[N+1][3];
		
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
			arr[i][2]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++) {
			D[i][0]=Math.min(D[i-1][1]+arr[i][0], D[i-1][2]+arr[i][0]);
			D[i][1]=Math.min(D[i-1][0]+arr[i][1], D[i-1][2]+arr[i][1]);
			D[i][2]=Math.min(D[i-1][0]+arr[i][2], D[i-1][1]+arr[i][2]);
		}
		
		System.out.println(Math.min(Math.min(D[N][0], D[N][1]),D[N][2]));
		
				
	}

}
