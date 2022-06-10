package b1547_공;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M=Integer.parseInt(br.readLine());
		
		int res=1;
		
		StringTokenizer st = null;
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int X=Integer.parseInt(st.nextToken());
			int Y=Integer.parseInt(st.nextToken());
			if(X==Y) continue;
			if(X==res) res=Y;
			else if(Y==res) res=X;
		}
		
		System.out.println(res);
		
	}

}
