package sk3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;


public class Main {

	static int ans;

	public static void main(String[] args) {
//		
//		int[][] a = {{1,2},{2,3}};
//		int[][] b = {{1,3},{3,2}};
		
		
		int[][] a = { { 3, 4 }, { 7, 2 }, { 5, 4 }, { 2, 3 }, { 6, 5 }, { 1, 2 } };
//		int[][] b = { { 2, 1 }, { 3, 6 }, { 1, 4 }, { 1, 5 }, { 7, 1 }, { 3, 2 } };
		int[][] b = { { 1, 5 }, { 5, 6 }, { 1, 2 }, { 2, 4 }, { 2, 7 }, { 2, 3 } };
		int m = 0;

		solution(a, b, m);

		System.out.println(ans);
	}

	public static int solution(int[][] a, int[][] b, int m) {

		int len = a.length;
		ans = len;
		sort(a);
		sort(b);
		getMin(a, b);
		func(a, b, 0, m);

		return ans;
	}

	private static void func(int[][] a, int[][] b, int depth, int m) {
		if(m==0) {
			getMin(a, b);
			System.out.println(Arrays.deepToString(a));
			System.out.println(Arrays.deepToString(b));
			return;
		}
		if (depth >= m) {

			return;
		}
		

		int len=a.length+1;
		for (int i = 1; i < len; i++) {
			for (int j = i + 1; j <= len; j++) {
				int[][] tmp=swap(b, i, j);
				sort(tmp);
				getMin(a, tmp);
				func(a, tmp, depth + 1, m);
			}
		}
	}

	private static int[][] swap(int[][] b, int target, int target2) {
		
		int [][]ret=new int[b.length][2];
		copy(ret,b);
		
		int len = b.length;
		for (int i = 0; i < len; i++) {

			if (ret[i][0] == target)
				ret[i][0] = target2;
			else if (ret[i][0] == target2)
				ret[i][0] = target;

			if (ret[i][1] == target)
				ret[i][1] = target2;
			else if (ret[i][1] == target2)
				ret[i][1] = target;

		}
		return ret;

	}
	
	

	private static void copy(int[][] tmp, int[][] b) {
		
		for(int i=0;i<b.length;i++) {
			for(int j=0;j<2;j++) tmp[i][j]=b[i][j];
		}
		
	}

	private static void getMin(int[][] a, int[][] b) {
		int len = a.length;
		sort(b);
		
		int cnt = 0;
		for (int i = 0; i < len; i++) {
			boolean find=false;
			for(int j=0;j<len;j++) {
				if (a[i][0] == b[j][0] && a[i][1] == b[j][1])
					find=true;
			}
			if(find==false) cnt++;
		}
		ans = Math.min(ans, cnt);
	}

	static void sort(int[][] arr) {

		int len = arr.length;
		for (int i = 0; i < len; i++) {
			int[] tmp = new int[2];
			tmp[0] = Math.min(arr[i][0], arr[i][1]);
			tmp[1] = Math.max(arr[i][0], arr[i][1]);
			arr[i] = tmp;
		}

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o1[0] - o2[0];
				}
			}
		});

	}

}
