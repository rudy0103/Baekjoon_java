package b9184_신나는함수실행;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int a,b,c;
		do {
			String [] inp=br.readLine().split(" ");
			a=Integer.parseInt(inp[0]);
			b=Integer.parseInt(inp[1]);
			c=Integer.parseInt(inp[2]);
			if(a==-1&&b==-1&&c==-1) break;
			bw.write("w("+a+", "+b+", "+c+") = "+w(a,b,c)+"\n");
		}while(true);
		bw.close();
	}
	
	static int [][][] dy=new int[21][21][21];
	
	static int w(int a, int b, int c) {
			
		if(a<=0 || b<=0||c<=0) {
			return 1;
		}else if(a>20 || b>20 ||c>20) {
			if(dy[20][20][20]!=0) return dy[20][20][20];
			dy[20][20][20]=w(20,20,20);
			return dy[20][20][20];
		}else if(a<b && b<c) {
			if(dy[a][b][c]!=0) return dy[a][b][c];
			dy[a][b][c]=w(a,b,c-1) + w(a,b-1,c-1) -w(a,b-1,c);
			return w(a,b,c-1) + w(a,b-1,c-1) -w(a,b-1,c);
		}else {
			if(dy[a][b][c]!=0) return dy[a][b][c];
			dy[a][b][c]=w(a-1,b,c) +w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
			return dy[a][b][c];
		}
	}
}
