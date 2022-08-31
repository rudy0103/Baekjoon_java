package b3020_개똥벌레;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int minCnt = N+10;
		int cnt = H+10;

		// 높이가 H --> H개의 구간 K번째 구간은 K-1과 K 사이 구간
		// 홀수 석순, 짝수 종유석

		int[] up = new int[N / 2];
		int[] down = new int[N / 2];

		for (int i = 0; i < N; i++) {
			if (i % 2 == 0) {
				up[i / 2] = Integer.parseInt(br.readLine());
			} else {
				down[i / 2] = Integer.parseInt(br.readLine());
			}
		}

		Arrays.sort(up);
		Arrays.sort(down);
		int len = N / 2;

		for (int h = 1; h <= H; h++) {
			int tmpCnt = 0;

			int upIdx = binarySearch(up, h);
			int downIdx = binarySearch(down, H + 1 - h);

			tmpCnt += addCnt(upIdx, len);
			tmpCnt += addCnt(downIdx, len);
			
			if(tmpCnt<minCnt) {
				minCnt=tmpCnt;
				cnt=1;
			}else if(tmpCnt==minCnt) {
				cnt++;
			}

		}

		System.out.println(minCnt + " " + cnt);

	}

	private static int addCnt(int idx, int len) {
		int tmpCnt = 0;
		if (idx >= 0) {
			tmpCnt += (len - idx);
		} else {
			idx = (idx * -1)-1;
			tmpCnt += (len - idx);
		}
		return tmpCnt;
	}

	private static int binarySearch(int[] arr, int h) {

		int left = 0;
		int right = arr.length - 1;
		int pos = -1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid] > h) {
				right = mid - 1;
			} else if (arr[mid] < h) {
				left = mid + 1;
			} else {
				right = mid - 1;
				pos = mid;
			}

		}

		if (pos != -1)
			return pos;
		else
			return left * -1 - 1;
	}

}
