package b2309_일곱난쟁이;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int [] res=new int[7];
	static void bruteForce(int[] arr, int[] selected, int cnt, int start, int sum) throws IOException {
		if (cnt == 7) {
			if (sum == 100) {
				for(int i=0;i<res.length;i++) {
					res[i]=selected[i];
				}
			}
		} else {
			for (int i = start; i < arr.length; i++) {
				selected[cnt] = arr[i];
				bruteForce(arr, selected, cnt + 1, i + 1, sum + arr[i]);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] arr = new int[9];
		int[] selected = new int[7];
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		bruteForce(arr, selected, 0, 0, 0);
		Arrays.sort(res);
		for (int n : res) {
			bw.write(n + "\n");
		}
		bw.close();
	}
}
