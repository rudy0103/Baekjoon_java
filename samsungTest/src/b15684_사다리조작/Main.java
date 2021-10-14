package b15684_사다리조작;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] ladder;
	static int N,M,H;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		H=Integer.parseInt(st.nextToken());
		
		ladder= new int[H+2][N+1];
		
		for(int i=1;i<=N;i++) {
			
		}
	}

}
