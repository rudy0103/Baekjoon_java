package b17143_낚시왕;

import java.io.*;
import java.util.*;


//20:10~21:50
public class Main {

	static int R,C,M;
	static int score;
	
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,1,-1};//상하우좌
	
	static class Shark{
		int r;
		int c;
		int s;
		int d;
		int z;
		boolean dead;
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
			this.dead=false;
		}
		public void move(Shark[][] map) {
			
			int nr=r;
			int nc=c;
			int dir=d;
			for(int i=0;i<s;i++) {
				nr+=dr[dir];
				nc+=dc[dir];
				
				if(nr<0||nr>=R||nc<0||nc>=C) {
					dir=changeDir(dir);
					nr+=(dr[dir]*2);
					nc+=(dc[dir]*2);
				}
			}
		
//			
//			if(nr<0||nr>=R||nc<0||nc>=C) {
//				System.out.println(this.r+" "+this.c+" "+this.s+" "+this.d+" "+this.z);
//				System.out.println(nr+" "+nc+" "+dir);
//			}
//			
			this.r=nr;
			this.c=nc;
			this.d=dir;
			
			if(map[r][c]==null) {
				map[r][c]=this;
			}else if(map[r][c].z>this.z) {
				this.dead=true;
			}else {
				map[r][c].dead=true;
				map[r][c]=this;
			}
			
			
		}
		private int changeDir(int dir) {
			
			if(dir==0) return 1;
			if(dir==1) return 0;
			if(dir==2) return 3;
			if(dir==3) return 2;
			return 0;
		}
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		Shark [][]map=new Shark[R][C];
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				map[i][j]=null;
			}
		}
		
		
		LinkedList<Shark> sharks=new LinkedList<>();
		
		int CRecur=(C-1)*2;
		int RRecur=(R-1)*2;
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken())-1;
			int c=Integer.parseInt(st.nextToken())-1;
			int s=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken())-1;
			int z=Integer.parseInt(st.nextToken());
			if(d==0||d==1) {
				s%=RRecur;
			}else {
				s%=CRecur;
			}
			Shark shark =new Shark(r, c, s, d, z);
			map[r][c]=shark;
			sharks.add(shark);
		}
			
		for(int c=0;c<C;c++) {
//			printMap(map);
			fishingShark(c,map,sharks);
//			printMap(map);
		}
		
		
		
		System.out.println(score);

	}

	private static void printMap(Shark[][] map) {
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]==null) {
					System.out.print("0 ");
					continue;
				};
				System.out.print(map[i][j].z+" ");
			}
			System.out.println();
		}
		System.out.println("@@@@@@@@@@@@@@@@@@@");
		
	}

	private static void fishingShark(int c, Shark[][] map, LinkedList<Shark> sharks) {
		
		for(int r=0;r<R;r++) {
			if(map[r][c]!=null) {
				score+=map[r][c].z;
//				System.out.println("get "+map[r][c].z+"score: "+score);
				map[r][c].dead=true;
				map[r][c]=null;
				break;
			}
		}
		

		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				map[i][j]=null;
			}
		}
		
		
		for(Shark shark:sharks) {
			if(shark.dead==false) {
				shark.move(map);
			}
		}
		
	}

}
