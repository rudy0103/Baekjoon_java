package b2503_숫자야구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int cnt=0;
	static int [] selected=new int[3];
	static boolean [] visited=new boolean[10];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N=Integer.parseInt(br.readLine());
		
		int[][] arr =new int[N][3];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
			arr[i][2]=Integer.parseInt(st.nextToken());
		}
		
		
		playGame(0,arr);
		
		
		System.out.println(cnt);
		
	}

	private static void playGame(int d, int[][] arr) {
		
		if(d==3) {
			
			if(isPossible(arr)) {
				cnt++;
			}
			
			return;
		}
		
		for(int i=1;i<=9;i++) {
			
			if(visited[i]) continue;
			visited[i]=true;
			selected[d]=i;
			playGame(d+1, arr);
			visited[i]=false;
			
		}
		
		
	}

	private static boolean isPossible(int[][] arr) {

		for(int i=0;i<arr.length;i++) {
			int strike=0;
			int ball=0;
			
			char[]tmp=Integer.toString(arr[i][0]).toCharArray();
			
			for(int j=0;j<3;j++) {
				
				for(int k=0;k<3;k++) {
					if((tmp[j]-'0')==selected[k]&&j==k) {
						strike++;
					}else if((tmp[j]-'0')==selected[k]) ball++;
					
				}
			}
			
			if(strike!=arr[i][1]||ball!=arr[i][2]) return false;
			
		}
		
		
		return true;
	}

}
