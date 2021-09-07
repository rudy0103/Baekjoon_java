package b16439_치킨치킨치킨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int max=0;
	static int[] selected=new int[3];
	
	static int getSatisfaction(int k,int[] selected,int[][]chiken) {
		int s=-1;
		
		for(int i=0;i<selected.length;i++) {
			if(chiken[k][selected[i]]>s) s=chiken[k][selected[i]];
		}
		return s;
	}
	static void getMax(int depth, int[][]chiken,int start) {
		if(depth==3) {
			int sum=0;
			for(int i=0;i<chiken.length;i++) {
				sum+=getSatisfaction(i, selected, chiken);
			}
			if(sum>max) max=sum;
			return;
		}
		
		for(int i=start;i<chiken[0].length;i++) {
			selected[depth]=i;
			getMax(depth+1, chiken, i+1);
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String[] inp=br.readLine().split(" ");
		int N=Integer.parseInt(inp[0]);
		int M=Integer.parseInt(inp[1]);
		int [][]chiken= new int[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				chiken[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		getMax(0,chiken,0);
		System.out.println(max);
		
	}

}
