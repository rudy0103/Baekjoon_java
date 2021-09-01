import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int sec = Integer.MAX_VALUE;
	static int height = Integer.MIN_VALUE;

	public static void getMinSecMaxHeight(int[][] map, int s,int h) {
		if (s > sec)
			return;

		if (s == sec) {
			if (height < h)
				height = h;
		} else {
			sec = s;
			height = h;
		}

	}

	public static void find(int[][]map,int h) {
		int s=0;
		
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				if(h-map[i][j]<0) {
					s+=(map[i][j]-h)*2;
				}else s+=(h-map[i][j]);
			}
		}
		getMinSecMaxHeight(map, s, h);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String[] inp = br.readLine().split(" ");
		int N = Integer.parseInt(inp[0]);
		int M = Integer.parseInt(inp[1]);
		int B = Integer.parseInt(inp[2]);
		int total = 0;
		int[][] map = new int[N][M];
		int size = N * M;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				total += map[i][j];
			}
		}
		B+=total;
		
		for(int i=0;i<=256;i++) {
			if(i*size<=B)
				find(map, i);
			else break;
		}
		
		System.out.println(sec+" "+height);
	}
}