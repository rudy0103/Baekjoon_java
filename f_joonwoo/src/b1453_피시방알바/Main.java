package b1453_피시방알바;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		boolean [] arr=new boolean[101];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int cnt=0;
		for(int i=0;i<N;i++) {
			int n=Integer.parseInt(st.nextToken());
			if(arr[n]) cnt++;
			else arr[n]=true;
		}
		System.out.println(cnt);

	}

}
