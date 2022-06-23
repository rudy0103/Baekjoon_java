package b15729_방탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		boolean [] arr= new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) if(st.nextToken().equals("1")) arr[i]=true;
		
		
		boolean [] origin=new boolean[N];
		
		int cnt=0;
		
		for(int i=0;i<N;i++) {
			
			if(origin[i]!=arr[i]) {
				arr[i]=!arr[i];
				if(i+1<N) arr[i+1]=!arr[i+1];
				if(i+2<N) arr[i+2]=!arr[i+2];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
