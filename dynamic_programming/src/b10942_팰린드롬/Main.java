package b10942_팰린드롬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr=new int[N+1];
        for(int i=1;i<=N;i++) arr[i]=Integer.parseInt(st.nextToken());
        
        
        boolean[][] isTrue=new boolean[N+1][N+1];
        
        
        for(int i=1;i<=N;i++) {
        	for(int j=i;j<=N;j++) {
        		int left=i;
        		int right=j;
        		boolean flag=true;
        		while(right>=left) {
        			if(arr[left++]!=arr[right--]) {
        				flag=false;
        				break;
        			}
        		}
        		isTrue[i][j]=flag;
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
