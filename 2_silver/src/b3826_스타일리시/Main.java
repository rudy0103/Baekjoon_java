package b3826_스타일리시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int[][] originCnt;
	public static int[][] newOneCnt;
	public static int[] intent;
	public static int[] newOneIntent;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int p=Integer.parseInt(st.nextToken());
		int q=Integer.parseInt(st.nextToken());
		
		
		while(p!=0&&q!=0) {
			
			String[] origin=new String[p];
			String[] newOne=new String[q];
			
			for(int i=0;i<p;i++) origin[i]=br.readLine();
			for(int i=0;i<q;i++) newOne[i]=br.readLine();
			
			originCnt=new int[origin.length][3];
			newOneCnt=new int[newOne.length][3];
			intent=new int[origin.length];
			newOneIntent=new int[newOne.length];
			
			for(int i=0;i<origin.length;i++) {
				intent[i]=checkIntent(origin[i]);
			}
			
			count(origin,originCnt);
			count(newOne,newOneCnt);
			
			
			for(int r=1;r<=20;r++) {
				for(int c=1;c<=20;c++) {
					for(int s=1;s<=20;s++) {
						f(r,c,s);
					}
				}
			}
			
			for(int i=0;i<newOneIntent.length;i++) sb.append(newOneIntent[i]+" ");
			sb.append("\n");
			
			/////////////////////////////////////////////
			
			
			st = new StringTokenizer(br.readLine());
			
			p=Integer.parseInt(st.nextToken());
			q=Integer.parseInt(st.nextToken());
			
		}
		System.out.println(sb.toString());
		
		
	}
	

	private static void f(int r, int c, int s) {
		
		
		if(checkTrue(r,c,s)) {
			for(int i=1;i<newOneIntent.length;i++) {
				int intent=getIntent(r,c,s,newOneCnt[i-1]);
				if(newOneIntent[i]==0) {
					newOneIntent[i]=intent;
				}else {
					if(newOneIntent[i]!=intent) {
						newOneIntent[i]=-1;
					}
				}
					
			}
			
		}
		
	}


	private static boolean checkTrue(int r, int c, int s) {
		for(int i=1;i<intent.length;i++) {
			int tent=getIntent(r,c,s,originCnt[i-1]);
			if(intent[i]!=tent) {
				return false;
			}
		}
//		System.out.println(r+" "+c+" "+s);
		return true;
	}


	private static int getIntent(int r, int c, int s, int[] cnt) {
		
		return r*cnt[0]+c*cnt[1]+s*cnt[2];
	}


	public static void count(String[] origin,int[][] cnt) {

		for(int i=0;i<origin.length;i++) {
			for(int k=0;k<3;k++) {
				if(i>0)
					cnt[i][k]=cnt[i-1][k];
			}
			for(int j=0;j<origin[i].length();j++) {
				char ch=origin[i].charAt(j);
				if(ch=='(') {
					cnt[i][0]++;
				}else if(ch==')') {
					cnt[i][0]--;
				}else if(ch=='{') {
					cnt[i][1]++;
				}else if(ch=='}') {
					cnt[i][1]--;
				}else if(ch=='[') {
					cnt[i][2]++;
				}else if(ch==']') {
					cnt[i][2]--;
				}
			}
			
		}
		

	}
	


	public static int checkIntent(String s) {
		int cnt=0;
		
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='.') cnt++;
			else break;
		}
		
		
		return cnt;
	}
	

}
