package b1992_쿼드트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static char [][] map;
	
	static String compress(String s) {
		if(s.equals("0000")) return "0";
		if(s.equals("1111")) return "1";
		
		StringBuilder sb =new StringBuilder();
		sb.append("(").append(s).append(")");
		
		return sb.toString();
	}
	
	static String divideAndConquer(int n, int left_r, int left_c) {
	
		if(n==2) {
			String ret="";
			for(int r=left_r;r<left_r+n;r++) {
				for(int c=left_c;c<left_c+n;c++) {
					ret+=map[r][c];
				}
			}
			return compress(ret);
		}else {
			StringBuilder sb =new StringBuilder();
			
			//divide
			String s1=divideAndConquer(n/2, left_r, left_c);//왼위
			String s2=divideAndConquer(n/2, left_r, left_c+n/2);//오위
			String s3=divideAndConquer(n/2, left_r+n/2, left_c);//왼아
			String s4=divideAndConquer(n/2, left_r+n/2, left_c+n/2);//오아
			//Conquer
			sb.append(s1).append(s2).append(s3).append(s4);
			
			return compress(sb.toString());
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		
		for(int i=0;i<n;i++)
			map[i]=br.readLine().toCharArray();
		
		String ret=divideAndConquer(n, 0, 0);
		System.out.println(ret);
	}
}
