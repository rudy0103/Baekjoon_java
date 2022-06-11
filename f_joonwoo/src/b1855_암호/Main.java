package b1855_암호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K=Integer.parseInt(br.readLine());
		String inp=br.readLine();
		int len=inp.length();
		char[][]map=new char[len/K][K];
		
		for(int i=0;i<len;i++) {
			int r=i/K;
			int c=i%K;
			
			if(r%2==0) {
				map[r][c]=inp.charAt(i);
			}else {
				map[r][K-c-1]=inp.charAt(i);
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int c=0;c<K;c++) {
			for(int r=0;r<len/K;r++) {
				sb.append(map[r][c]);
			}
		}
		System.out.println(sb.toString());
		
	}

}
