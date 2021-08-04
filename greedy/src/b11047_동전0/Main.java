package b11047_동전0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String [] inp=br.readLine().split(" ");
		
		int N=Integer.parseInt(inp[0]);
		int K=Integer.parseInt(inp[1]);
		int [] coin = new int[N];
		
		for(int i=0;i<coin.length;i++)
			coin[i]=Integer.parseInt(br.readLine());
		
		int cnt=0;
		for(int i=coin.length-1;i>=0;i--){
			if(K/coin[i]>=1) {
				cnt+=(K/coin[i]);
				K-=coin[i]*(K/coin[i]);
			}
		}
		System.out.println(cnt);
	}
}
