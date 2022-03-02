package b20921_그렇고그런사이;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int[] selected;
	static int[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++)
			arr[i] = i;

		int len=N-1;
		
		int j=-1;
		while (true) {
			int i = N;
			if(K-len>=0) {
				j=i-len;
				swap(i, j, arr);
				K-=len;
				Arrays.sort(arr, j + 1, N + 1);
				len--;
			}else {
				j=i-1;
				while (K > 0 && j >= 1) {
					if (arr[i] < arr[j])
						break;
					K--;
					j--;
				}
				swap(i, j + 1, arr);
				Arrays.sort(arr, j + 2, N + 1);
			}

			
			if (K == 0)
				break;

		}

		for (int i = 1; i <= N; i++)
			sb.append(arr[i]).append(" ");
		System.out.println(sb.toString());

	}

	private static void swap(int i, int j, int[] arr) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

}
