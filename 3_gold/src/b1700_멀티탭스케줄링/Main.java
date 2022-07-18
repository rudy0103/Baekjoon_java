package b1700_멀티탭스케줄링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] index;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int[] arr = new int[K];
		index=new int[N];
		for (int i = 0; i < K; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int cnt = getCnt(N, K, arr);

		System.out.println(cnt);

	}

	private static int getCnt(int n, int k, int[] arr) {

		if (n >= k)
			return 0;

		int[] table = new int[n];
		int cnt = 0;
		
		int start =init(n,k,table,arr);

		for (int i = start; i < k; i++) {

			if (isHit(table, arr[i]))
				continue;
			int idx = getIndex(table, arr, i);
			table[idx] = arr[i];
			cnt++;
		}

		return cnt;
	}

	private static int init(int n, int k, int[] table, int[] arr) {
		int idx=0;
		
		for(int i=0;i<k;i++) {
			if(isHit(table, arr[i])) continue;
			if(idx<n)
				table[idx++]=arr[i];
			else return i;
		}
		
		return k; 

	}

	private static int getIndex(int[] table, int[] arr, int start) {
		int idx = 0;
		
		Arrays.fill(index, Integer.MAX_VALUE);
		
		for (int i = 0; i < table.length; i++) {			
			for (int j = start; j < arr.length; j++) {
				if (table[i] == arr[j]) {
					index[i]=j;
					break;
				}
			}
		}
		
		int far=0;
		
		for(int i=0;i<index.length;i++) {
			if(index[i]==Integer.MAX_VALUE) return i;
			if(far<index[i]) {
				far=index[i];
				idx=i;
			}
			
		}
		
		return idx;
	}

	private static boolean isHit(int[] table, int n) {

		for (int i = 0; i < table.length; i++) {
			if (table[i] == n)
				return true;
		}

		return false;
	}

}
