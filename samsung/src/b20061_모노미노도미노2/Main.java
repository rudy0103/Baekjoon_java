package b20061_모노미노도미노2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] green=new int[6][4];
		int [][] blue=new int[6][4];
		int score=0;
		int cnt=0;
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(t==1) { //한개
				
				score+=type1(0,y,green);
				score+=type1(0,3-x,blue);
				
				
			}else if(t==2) {//가로(x,y),(x,y+1)
				
				score+=type2(0,y,green);
				score+=type3(0,3-x,blue);
				
				
			}else{//세로(x,y),(x+1,y)
				
				score+=type3(0,y,green);
				score+=type2(0,3-(x+1),blue);
				
			}
		}
		
		cnt+=getCnt(green);
		cnt+=getCnt(blue);
		System.out.println(score);
		System.out.println(cnt);

	}

	private static int type1(int x, int y, int[][] map) {
		

		int dx=down(x,y,map);
		
		map[dx][y]=1;
		
		
		return getScore(map);
	}
	

	private static int getScore(int[][] map) {
		
		int score=0;
		int rIdx=10;
		for(int r=2;r<6;r++) {
			int tmp=0;
			for(int c=0;c<4;c++) {
				tmp+=map[r][c];
			}
			if(tmp==4) {
				score++;
				rIdx=Math.min(rIdx, r);
				for(int c=0;c<4;c++) {
					map[r][c]=0;
				}
			}
		}
		
		if(rIdx!=10) {
			for(int r=rIdx-1;r>=0;r--) {
				for(int c=0;c<4;c++) {
					map[r+score][c]=map[r][c];
					map[r][c]=0;
				}
			}
		}
		
		
		int isTrue=0;
		for(int r=0;r<2;r++) {
			for(int c=0;c<4;c++) {
				if(map[r][c]==1) {
					isTrue++;
					break;
				}
			}	
		}
		if(isTrue>0) {
			for(int r=5;r>5-isTrue;r--) {
				for(int c=0;c<4;c++) {
					map[r][c]=0;
				}
			}
			
			for(int r=5-isTrue;r>=0;r--) {
				for(int c=0;c<4;c++) {
					map[r+isTrue][c]=map[r][c];
					map[r][c]=0;
				}
			}
		}
	
		return score;
	}

	private static int down(int x, int y, int[][] map) {
		
		int sx=x;
		
		while(true) {
			if(sx==5||map[sx+1][y]==1) {
				break;
			}else sx++;
		}
		
		return sx;
	}

	private static int type2(int x, int y, int[][] map) { //가로

		int dx=0;
		
		dx=down(x, y, map);
		dx=Math.min(dx, down(x, y+1, map));
		
		map[dx][y]=1;
		map[dx][y+1]=1;
		
		return getScore(map);
	}

	
	private static int type3(int x, int y, int[][] map) {//세로

		int dx=down(1,y,map);
		
		map[dx][y]=1;
		map[dx-1][y]=1;
		
		
		return getScore(map);
	}

	private static int getCnt(int[][] map) {
		int cnt=0;
		for(int r=2;r<6;r++){
			for(int c=0;c<4;c++) {
				if(map[r][c]==1) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
}
