package b7795_먹을것인가먹힐것인가;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			int cnt=0;
			
			int []A=new int[N];
			int []B=new int[M];
			
			st=new StringTokenizer(br.readLine()," ");
			for(int i=0;i<N;i++) A[i]=Integer.parseInt(st.nextToken());
			
			st=new StringTokenizer(br.readLine()," ");
			for(int i=0;i<M;i++) B[i]=Integer.parseInt(st.nextToken());
			
			
			Arrays.sort(A);
			Arrays.sort(B);
			int len=B.length;
			
			for(int i=0;i<N;i++) {
				int num=A[i];
				
				int idx=Arrays.binarySearch(B, num);
				
				if(idx>=0) {
					while(idx>=1&&B[idx-1]==num) idx--;
					int tmpCnt=idx;
					if(len>0) cnt+=tmpCnt;
				}else {
					
					idx=-idx-1;
					int tmpCnt=idx;
					if(len>0) cnt+=tmpCnt;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}

}
