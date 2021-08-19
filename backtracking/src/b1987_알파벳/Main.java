package b1987_알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int R,C,max;
	static char[][] map;
	static boolean[][] visited;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	
	public static boolean movable() {
		
		for(int i=0;i<4;i++) {
			
		}
			
		return false;
	}
	
	
	public static void alpha(int step) {
		
		if(movable()==false) {
			
		}
		
		
		
		
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] inp = br.readLine().split(" ");
		R=Integer.parseInt(inp[0]);
		C=Integer.parseInt(inp[1]);
		
		for(int i=0;i<R;i++) map[i]=br.readLine().toCharArray();
		
		alpha(0);
		System.out.println(max);
	}

}
