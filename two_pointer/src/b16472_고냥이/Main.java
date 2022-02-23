package b16472_고냥이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		
		char[] str=br.readLine().toCharArray();
		
		

		
		int [] cnt=new int[26];
		
		int pos1=0,pos2=0;
		
		pos2=getFirstPos(N,str,cnt);
		
		if(pos2==str.length-1) System.out.println(str.length);
		else {
			int max=pos2+1;
			int maxCnt=N;
			
			pos2++;
			
			while(pos2<str.length) {
				
				if(cnt[str[pos2]-'a']==0) {//현재 문자열 중 하나의 문자가 0이 될때 까지 pos1을 이동
					
					if(maxCnt<N) {
						pos2++;
						max=Math.max(max,pos2-pos1+1);
						continue;
					}
					
					while(cnt[str[pos1]-'a']>1) {
						cnt[str[pos1]-'a']--;
						pos1++;
					}
					
					cnt[str[pos1]-'a']--;
					pos1++;
					
					cnt[str[pos2]-'a']++;
				}else {
					cnt[str[pos2]-'a']++;
					max=Math.max(max,pos2-pos1+1);
				}
				pos2++;
				
			}
			
			
			System.out.println(max);
		}
	}

	private static int getFirstPos(int N, char[] str, int[] cnt) {
		
		if(str.length==1) return 1;
		
		int tmpCnt=1;
		
		cnt[str[0]-'a']=1;
		
		for(int i=1;i<str.length;i++) {
			
			if(cnt[str[i]-'a']==0) {
				tmpCnt++;
				if(tmpCnt>N) return i-1;
				else cnt[str[i]-'a']++;
			}else cnt[str[i]-'a']++;
			
		}
		
		
		return str.length-1;
	}

}
