package b21758_꿀따기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] sumToRight=new int[N];
		int[] sumToLeft=new int[N];
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		sumToRight[0]=arr[0];
		for(int i=1;i<N;i++) {
			sumToRight[i]=sumToRight[i-1]+arr[i];
		}
		
		sumToLeft[N-1]=arr[N-1];
		for(int i=N-2;i>=0;i--) {
			sumToLeft[i]=sumToLeft[i+1]+arr[i];
		}
		
		int res=0;
		int tmpSum=sumToRight[N-1]-arr[0];
		for(int j=1;j<N-1;j++) {
			int sum=tmpSum-arr[j]+sumToRight[N-1]-sumToRight[j];
			res=Math.max(res, sum);
		}
		
		
		tmpSum=sumToLeft[0]-arr[N-1];
		for(int j=N-2;j>0;j--) {
			int sum=tmpSum-arr[j]+sumToLeft[0]-sumToLeft[j];
			res=Math.max(res, sum);
		}
		
		for(int j=1;j<N-1;j++) {
			int sum=sumToRight[j]-arr[0]+sumToLeft[j]-arr[N-1];
			res=Math.max(res, sum);
		}
		System.out.println(res);
	}
}
