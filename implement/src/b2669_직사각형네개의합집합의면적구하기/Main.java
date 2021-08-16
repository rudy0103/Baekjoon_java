package b2669_직사각형네개의합집합의면적구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int area = 0;
		boolean[][] arr = new boolean[101][101];
		for (int i = 0; i < 4; i++) {
			String[] inp = br.readLine().split(" ");
			for (int r = Integer.parseInt(inp[0]); r < Integer.parseInt(inp[2]); r++) {
				for (int c = Integer.parseInt(inp[1]); c < Integer.parseInt(inp[3]); c++) {
					arr[r][c] = true;
				}
			}
		}
		
		for(boolean [] ar:arr) {
			for(boolean a:ar) if(a) area++;
		}
		System.out.println(area);
	}

}