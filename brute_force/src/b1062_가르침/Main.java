package b1062_가르침;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

import jdk.nashorn.internal.ir.SetSplitState;

public class Main {

	static int maxCnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		teach(N, K, br);
		System.out.println(maxCnt);
	}

	private static void teach(int n, int k, BufferedReader br) throws IOException {
		if (k < 5)
			return;

		HashSet<String> set = new HashSet<>();
		
		boolean[][]words=new boolean[n][26];
		
		boolean[]teached=new boolean[26];
		
		teached['a'-'a']=true;
		teached['n'-'a']=true;
		teached['t'-'a']=true;
		teached['i'-'a']=true;
		teached['c'-'a']=true;
		
		
		for (int i = 0; i < n; i++) {
			char[] word=br.readLine().toCharArray();
			for(int j=0;j<word.length;j++) {
				words[i][word[j]-'a']=true;
			}
		}
		
		subSet(0,0,k-5,words,teached);

	}

	private static void subSet(int l,int d, int D,  boolean[][] words, boolean[] teached) {
		
		if(d==D) {
			int cnt=0;
			
			for(int i=0;i<words.length;i++) {
				boolean flag=true;
				for(int j=0;j<26;j++) {
					if(!teached[j]&&words[i][j]) {
						flag=false;
						break;
					}
				}
				if(flag) cnt++;
			}
			if(cnt>maxCnt) maxCnt=cnt;
			
			return;
		}
		
		if(teached[l]) return;
		
		teached[l]=true;
		subSet(l+1, d+1, D, words, teached);
		teached[l]=false;
		subSet(l+1, d, D, words, teached);
	}
}
