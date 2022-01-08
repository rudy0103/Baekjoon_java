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

	// 다음 큰 순열이 있으면 return true else return false;
	private static boolean nextPermutation(int len,int[] arr) {

		int i = len-1;

		
		// step1. 뒤쪽부터 접근하면서 arr[i-1]이 arr[i]보다 크거나 같으면 i를 줄여간다.
		while (i > 0 && arr[i - 1] >= arr[i]) {
			--i;
		}
		
		//내림차순으로 순열이 정렬되어 있다는 의미--> 다음 순열은 없다.
		if(i==0) return false;
		
		//step2. arr[i-1]값과 교환할 큰 값 찾기
		int j=len-1;
		
		
		// i번 쨰 값은 arr[i-1]보다 크다 따라서 j는 무조건 범위 안에서 멈추게된다.
		while(arr[i-1]>=arr[j]) j--;
		
		
		// step 3, i-1위치값과 j위치 값 교환
		swap(arr,i-1,j);
		
		// i부터 맨 뒤까지 오름차순 정렬
		
		int k=len-1;
		
		while(i<k) {
			swap(arr, i++, k--);
		}
		return true;
	}
	
	static void swap(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

}
