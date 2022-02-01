package b1032_명령프롬프트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		char[] res=br.readLine().toCharArray();
		int len=res.length;
		
		for(int i=0;i<N-1;i++) {
			char[] next=br.readLine().toCharArray();
			
			for(int j=0;j<len;j++) {
				if(res[j]!=next[j]) res[j]='?';
			}
		}
		
		System.out.println(res);
		
		
	}

}
