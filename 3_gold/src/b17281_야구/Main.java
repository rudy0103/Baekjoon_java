package b17281_야구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int max=0;
	static int cnt=0;
	static int [] selected;
	static boolean [] visited;
	static int[][] arr;
	static int N;

	public static void main(String[] args) throws  IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		arr = new int[N+1][10];
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=9;j++) arr[i][j]=Integer.parseInt(st.nextToken());
		}
		selected=new int[10];
		visited=new boolean[10];
		
		selected[4]=1;
		visited[1]=true;
		
		permutation(1,9);
		System.out.println(max);
	}

	private static void permutation(int d, int end) {

		if(d>end) {
			max=Math.max(max, playGame());
			return;
		}
		
		if(d==4) {
			permutation(d+1, end);
			return;
		}
		
		for(int i=1;i<=9;i++) {
			if(visited[i]) continue;
			visited[i]=true;
			selected[d]=i;
			permutation(d+1, end);
			visited[i]=false;
		}
		
	}

	private static int playGame() {
		int score=0;
		
		
		int nextPlayerIndex=1;
		int out=0;
		boolean [] groundPlayer=new boolean[4];
		
		for(int i=1;i<=N;i++) {
			Arrays.fill(groundPlayer, false);
			while(out<3) {
				int hit=arr[i][selected[nextPlayerIndex++]];
				groundPlayer[0]=true;
				if(hit==0) {// 아웃
					out++;
				}else {
					score+=go(hit,groundPlayer);
				}
				
				if(nextPlayerIndex>9) nextPlayerIndex=1;
			}
			out=0;
		}
		
		
		return score;
	}

	private static int go(int hit, boolean[] groundPlayer) {
		int score=0;
		
		for(int i=3;i>=0;i--) {
			if(groundPlayer[i]) {
				if(i+hit>3) {
					score++;
					groundPlayer[i]=false;
				}else {
					groundPlayer[i]=false;
					groundPlayer[i+hit]=true;
				}
			}
		}
		
		return score;
	}

}
