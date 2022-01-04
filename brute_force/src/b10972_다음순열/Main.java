package b10972_다음순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		

		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		if(nextPermutation(N, arr)) {
			for(int n:arr) {
				sb.append(n).append(" ");
			}
			
			System.out.println(sb.toString());
		}else {
			System.out.println(-1);
		}
	}

	private static boolean nextPermutation(int N, int[] numbers) {
		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i])
			--i;
		if (i == 0)
			return false;
		int j = N - 1;
		while (numbers[i - 1] >= numbers[j])
			--j;
		swap(i - 1, j, numbers);
		j = N - 1;
		while (i < j) {
			swap(i++, j--, numbers);
		}
		return true;

	}

	private static void swap(int i, int j, int[] numbers) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}
