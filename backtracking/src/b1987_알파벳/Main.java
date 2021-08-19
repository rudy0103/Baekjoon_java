package b1987_알파벳;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int R,C,max;
	static char[][] map;
	static boolean[] canMove;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	
	public static void alpha(int row,int col,int step) {
		
		if(step>max) max=step;
		
		for(int i=0;i<4;i++) {
			int rr=row+dr[i];
			int cc=col+dc[i];
			if(rr>=0&&rr<R&&cc>=0&&cc<C&&!canMove[map[rr][cc]-'A']) {
				canMove[map[rr][cc]-'A']=true;
				alpha(rr, cc, step+1);
				canMove[map[rr][cc]-'A']=false;
			}
		}
	};
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] inp = br.readLine().split(" ");
		R=Integer.parseInt(inp[0]);
		C=Integer.parseInt(inp[1]);
		canMove=new boolean[26];
		map=new char[R][C];
		for(int i=0;i<R;i++) map[i]=br.readLine().toCharArray();
		canMove[map[0][0]-'A']=true;
		alpha(0,0,1);
		System.out.println(max);
	}
}
