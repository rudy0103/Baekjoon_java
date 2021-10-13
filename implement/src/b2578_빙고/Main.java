package b2578_빙고;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static int[][] arr;

	
	public static boolean isBingo(int num) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == num)
					arr[i][j] = -1;
			}
		}

		int cnt = 0;

		for (int r = 0; r < 5; r++) {
			if (arr[r][0] == -1) {
				int sum = 0;
				for (int c = 0; c < 5; c++)
					sum += arr[r][c];
				if (sum == -5) {
					cnt++;
					if (cnt >= 3)
						return true;
				}
			}
		}

		for (int c = 0; c < 5; c++) {
			if (arr[0][c] == -1) {
				int sum = 0;
				for (int r = 0; r < 5; r++)
					sum += arr[r][c];
				if (sum == -5) {
					cnt++;
					if (cnt >= 3)
						return true;
				}
			}
		}
		if (arr[0][0] == -1) {
			int sum=0;
			for (int i = 0; i < 5; i++) {
				sum+=arr[i][i];
			}
			if(sum==-5) cnt++;
			if(cnt>=3) return true;
		}
		
		if(arr[0][4]==-1) {
			int sum=0;
			for(int i=0; i<5;i++) {
				sum+=arr[i][4-i];
			}
			if(sum==-5) cnt++;
			if(cnt>=3) return true;
		}

			return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<Integer> q = new LinkedList<Integer>();
		
		int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 }; // 좌상부터 시계방향
	    int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };
		
		arr = new int[5][5];
		for (int i = 0; i < 5; i++) {
			String[] inp = br.readLine().split(" ");
			for (int j = 0; j < inp.length; j++) {
				arr[i][j] = Integer.parseInt(inp[j]);
			}
		}

		for (int i = 0; i < 5; i++) {
			String[] inp = br.readLine().split(" ");
			for (int j = 0; j < inp.length; j++) {
				q.add(Integer.parseInt(inp[j]));
			}
		}

		int cnt = 0;
		while (!q.isEmpty()) {
			cnt++;
			if (isBingo(q.poll())) {
				break;
			}
		}
		bw.write(cnt + "");
		bw.close();
	}
}
