import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	
	public static int [][] paper=new int[100][100];
	
	
	public static void f(int r, int c) {
		
		for(int rr=r;rr<r+10;rr++) 
			for(int cc=c;cc<c+10;cc++)
				paper[rr][cc]++;
		
	}
	
	public static int getArea() {
		int area=0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(paper[i][j]!=0) area++;
			}
		}
		
		return area;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			String [] inp=br.readLine().split(" ");
			f(Integer.parseInt(inp[0]),Integer.parseInt(inp[1]));
		}
		bw.write(getArea()+"");
		bw.close();
	}
}
