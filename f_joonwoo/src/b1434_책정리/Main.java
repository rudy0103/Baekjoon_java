package b1434_책정리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Box{
		int weight;

		public Box(int weight) {
			super();
			this.weight = weight;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		

		int boxWeight=0;
		int bookWeight=0;
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) boxWeight+=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine()," ");
		for(int i=0;i<M;i++) bookWeight+=Integer.parseInt(st.nextToken());
		
	
		System.out.println(boxWeight-bookWeight);
	}

}
