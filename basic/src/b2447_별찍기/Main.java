package b2447_별찍기;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	
	public static char[][] arr;

	public static void func(int n, int r, int c) {
		int size=n/3;
		if (n > 3) {
				for (int i = r+size; i < r+size*2; i++) {
					for (int j = c+size; j < c+size*2; j++) {
						arr[i][j] = ' ';
					}
				}
				
			for(int i=0; i<3;i++) {
				for(int j=0;j<3;j++) {
					func(n/3,r+size*i,c+size*j);
				}
			}
		}else {
			arr[r+1][c+1]=' ';
		}
	}

	public static void main(String[] args) throws InterruptedException, IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = sc.nextInt();
		arr = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = '*';
			}
		}
		func(n,0,0);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				bw.write((arr[i][j]));
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}