package b1074_Z;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	static char [][] map;
	
	static String conpress(String s) {
		if(s.equals("0000")) return "0";
		if(s.equals("1111")) return "1";
		
		StringBuilder sb =new StringBuilder();
		sb.append("(").append(s).append(")");
		
		return sb.toString();
	}
	
	static String divideAndConquer(int n, int left_r, int left_c, int right_r, int right_c) {
	
		if(n==2) {
			String ret="";
			for(int r=left_r;r<right_r;r++) {
				for(int c=left_c;c<right_c;c++) {
					ret+=map[r][c];
				}
			}
			return conpress(ret);
		}else {
			StringBuilder sb =new StringBuilder();
			
			//-----------------divide----------------------------------------------
			String s1=divideAndConquer(n/2, left_r, left_c, right_r-n/2, right_c-n/2);//왼위
			String s2=divideAndConquer(n/2, left_r, left_c+n/2, right_r-n/2, right_c);//오위
			String s3=divideAndConquer(n/2, left_r+n/2, left_c, right_r, right_c-n/2);//왼아
			String s4=divideAndConquer(n/2, left_r+n/2, left_c+n/2, right_r, right_c);//오아
			//----------------Conquer--------------------------------------------------
			sb.append(s1).append(s2).append(s3).append(s4);
			
			
			return conpress(sb.toString());
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		
		for(int i=0;i<n;i++)
			map[i]=br.readLine().toCharArray();
		
		String ret=divideAndConquer(n, 0, 0, n, n);
		System.out.println(ret);
		
	}
}
