package b1019_책페이지;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int page = sc.nextInt();


		LinkedList<Integer> list = new LinkedList<>();
		int totalCnt=getTotalCnt(page);

		for (int i = 1; i < 10; i++) {
			int k = 1;
			int left = page;
			int cur, right;
			int res = 0;

			while (left != 0) {
				left = page / (k * 10);
				cur = (page - (left * k * 10)) / k;
				right = page % k;

				if (cur > i) {
					res += (left + 1) * k;

				} else if (cur == i) {
					res += (left * k) + (right + 1);
				} else {
					res += left * k;
				}

				k = k * 10;
			}
			list.add(res);
		}
		
		int zeroCnt=totalCnt;
		for(int n:list) {
			zeroCnt-=n;
		}
		System.out.print(zeroCnt+" ");
		for(int n:list) {
			System.out.print(n+" ");
		}

	}

	private static int getTotalCnt(int page) {
		int n=page,sum=0;
		int idx=9,digit=1,res=0;
		
		while(sum+idx<n) {
			res+=idx*digit;
			sum+=idx;
			idx*=10;
			digit++;
		}
		
		res+=(n-sum)*digit;
		
		return res;
	}

}
