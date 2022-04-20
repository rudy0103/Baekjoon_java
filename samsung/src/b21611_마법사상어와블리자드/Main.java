package b21611_마법사상어와블리자드;


//19:50~
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	
	static class Area{
		int r;
		int c;
		int num;
		public Area(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}
		
		
	}
	
	static class Group{
		int A;
		int B;
		public Group(int a, int b) {
			A = a;
			B = b;
		}
	}
	
	static int[] dr = {0,-1,1,0,0};
	static int[] dc = {0,0,0,-1,1};
	static int SR,SC,N;
	static int ret;
	static int[][]idx;
	static ArrayList<Area> list;
	static ArrayDeque<Group> groupList;
	static ArrayList<int[]> order;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int[][] map=new int[N][N];
		idx=new int[N][N];
		list=new ArrayList<>();
		groupList=new ArrayDeque<>();
		order=new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int d=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			order.add(new int[] {d,s});
		}
	
		
		
		SR=N/2;
		SC=N/2;
		map[N/2][N/2]=9;
		
		
		initState(map);
		
		for(int i=0;i<M;i++) {
			blizard(order.get(i));
		}
		System.out.println(ret);
		
	}

	private static void printList() {
		int L=SR*2+1;
		int [][] map=new int[L][L];
		
		System.out.println("____________________");
		for(Area a: list) {
			map[a.r][a.c]=a.num;
		}
		
		print(map);
		System.out.println("____________________");
		
	}

	private static void blizard(int[] order) {
		
		int r=SR;
		int c=SC;
		int d=order[0];
		int s=order[1];
		
		
		while(s-->0) { //블리자드 마법
			r+=dr[d];
			c+=dc[d];
			
			if(r<0||r>=N||c<0||c>=N) break;
			int loc=idx[r][c];
			list.get(loc).num=0;
		}
		
		move();//이동
		while(true) { // 폭발
			if(boom()==false) break;
			move();//이동
		}
		//구슬 변화
		change();
		
	}

	private static void change() {
		
		
		for(int i=1;i<list.size();i++) {
			if(list.get(i).num==0) break;
			if(groupList.isEmpty()) groupList.add(new Group(1,list.get(i).num));
			else {
				if(groupList.peekLast().B==list.get(i).num) {
					groupList.peekLast().A++;
				}else {
					groupList.add(new Group(1,list.get(i).num));
				}
			}
			list.get(i).num=0;
		}
		
		int i=1;
		
		while(!groupList.isEmpty()&&i<list.size()) {
			Group tmp=groupList.pollFirst();
			list.get(i++).num=tmp.A;
			if(i>=list.size()) break;
			list.get(i++).num=tmp.B;
		}
		
		groupList.clear();
		
	}

	private static boolean boom() {
		
		int tmpRet=ret;
		Stack<Area> st = new Stack<>();

		
		for(int i=1;i<list.size();i++) {
			if(list.get(i).num==0) break;
			if(st.isEmpty()) st.add(list.get(i));
			else {
				if(list.get(i).num==st.peek().num) {
					st.add(list.get(i));
				}else {
					if(st.size()>=4) {
						while(!st.isEmpty()) {
							int tmp=st.peek().num;
							ret+=tmp;
							st.pop().num=0;
						}
					}
					
					st.clear();
					st.add(list.get(i));
				}
			}
			
		}
		
		if(st.size()>=4) {
			while(!st.isEmpty()) {
				int tmp=st.peek().num;
				ret+=tmp;
				st.pop().num=0;
			}
		}
		
		if(ret==tmpRet) return false;
		else return true;
	}

	private static void move() {
		
		
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		
		for(Area a : list) {
			if(a.num>0) {
				dq.add(a.num);
				a.num=0;
			}
		}
		
		int i=1;
		
		while(!dq.isEmpty()) {
			int n=dq.poll();
			list.get(i++).num=n;
		}
		
		
	}

	private static void initState(int[][] map) {
		int L=map.length;
		
		int []dr= {0,1,0,-1};
		int []dc= {1,0,-1,0};
		//우하좌상 
		
		int cnt=0;
		
		int r=0;
		int c=0;
		int d=0;
		
		Stack<int[]> st = new Stack<>();
		
		boolean[][] visited=new boolean[L][L];
		
		while(cnt<L*L) {
			
			st.add(new int[] {r,c,map[r][c]});
			visited[r][c]=true;
			cnt++;
			int nr=r+dr[d];
			int nc=c+dc[d];
			
			if(nr<0||nr>=L||nc<0||nc>=L||visited[nr][nc]) {
				d=changeDir(d);
			}
			r+=dr[d];
			c+=dc[d];
		}
		
		
		while(!st.isEmpty()) {
			int[] tmp=st.pop();
			list.add(new Area(tmp[0], tmp[1], tmp[2]));
		}
		
		int i=0;
		for(Area a:list) {
			idx[a.r][a.c]=i++;
		}
//		print(idx);
		list.get(0).num=-1;
		
	}

	private static int changeDir(int d) {
	
		if(d==3) return 0;
		else return d+1;
	}

	private static void print(int[][] map) {
		int N=map.length;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
