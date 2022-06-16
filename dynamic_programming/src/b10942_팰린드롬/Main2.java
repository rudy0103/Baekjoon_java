package b10942_팰린드롬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr=new int[N+1];
        for(int i=1;i<=N;i++) arr[i]=Integer.parseInt(st.nextToken());
        
        
        boolean[][] isTrue=new boolean[N+1][N+1];
        
      
        for(int i=1;i<=N;i++) {
        	isTrue[i][i]=true;
        	if(i+1<=N&&arr[i]==arr[i+1]) {
        		isTrue[i][i+1]=true;
        	}
        }
        
        
        for(int i=2;i<N;i++) {
        	for(int j=1;j<=N-i;j++) {
        		if(arr[j]==arr[j+i]&&isTrue[j+1][j+i-1]) {
        			isTrue[j][j+i]=true;
        		}
        	}
        }
        
        
        int M=Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++) {
        	st=new StringTokenizer(br.readLine());
        	int S=Integer.parseInt(st.nextToken());
        	int E=Integer.parseInt(st.nextToken());
        	if(isTrue[S][E]) sb.append("1\n");
        	else sb.append("0\n");
        }
        System.out.println(sb.toString());
 

	}

}
