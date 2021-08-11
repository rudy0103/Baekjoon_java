package b2564_경비원;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int start_r, start_c;
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<int[]> q = new LinkedList<int[]>();
		String[] inp = br.readLine().split(" ");
		int col = Integer.parseInt(inp[0]);
		int row = Integer.parseInt(inp[1]);
		
		int[][] arr = new int[row + 1][col + 1];
		boolean[][] visited = new boolean[row + 1][col + 1];
		int n = Integer.parseInt(br.readLine());

		int[][] storeLocation = new int[n][2];

		for (int i = 0; i < n + 1; i++) {
			inp = br.readLine().split(" ");
			int dir = Integer.parseInt(inp[0]);
			int far = Integer.parseInt(inp[1]);

			if (i == n) {
				if (dir == 1) {
					start_r = 0;
					start_c = far;
				} else if (dir == 2) {
					start_r = row;
					start_c = far;
				} else if (dir == 3) {
					start_r = far;
					start_c = 0;
				} else if (dir == 4) {
					start_r = far;
					start_c = col;
				}
			} else {
				if (dir == 1) {
					storeLocation[i][0] = 0;
					storeLocation[i][1] = far;
				} else if (dir == 2) {
					storeLocation[i][0] = row;
					storeLocation[i][1] = far;
				} else if (dir == 3) {
					storeLocation[i][0] = far;
					storeLocation[i][1] = 0;
				} else if (dir == 4) {
					storeLocation[i][0] = far;
					storeLocation[i][1] = col;
				}
			}

			
		}

		for (int i = 0; i <= col; i++)
			arr[0][i] = 1;
		for (int i = 0; i <= col; i++)
			arr[row][i] = 1;
		for (int i = 0; i <= row; i++)
			arr[i][0] = 1;
		for (int i = 0; i <= row; i++)
			arr[i][col] = 1;
		
		
		arr[start_r][start_c]=0;
		q.add(new int[] { start_r, start_c });
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int r=now[0];
			int c=now[1];
			visited[r][c]=true;
			for(int i=0;i<4;i++) {
				int next_r=r+dr[i];
				int next_c=c+dc[i];
				if(next_r>=0&&next_r<=row&&next_c>=0&&next_c<=col) {
					if(!visited[next_r][next_c]&&arr[next_r][next_c]==1) {
						arr[next_r][next_c]+=arr[r][c];
						q.add(new int[] {next_r,next_c});
					}else if(arr[next_r][next_c]>1) {
						arr[next_r][next_c]=Math.min(arr[r][c]+1, arr[next_r][next_c]);
					}
				}
			}
		}
		int sum=0;
		
		for(int i=0;i<n;i++) {
			sum+=arr[storeLocation[i][0]][storeLocation[i][1]];
		}
		System.out.println(sum);		
	}
}
