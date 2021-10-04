package b13977_이항계수와쿼리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long p = 1000000007;
	static long [] fac;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		fac=new long[4000001];
		fac[1]=1;
		for(int i=2;i<=4000000;i++) {
			fac[i]=fac[i-1]*i;
			fac[i]%=p;
		}
		
		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine()," ");
			long res = nCr(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			sb.append(res).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static long nCr(int n, int k) {
		if (k == 0 || n==k)
			return 1;
		if (k == 1)
			return n;

		return fac[n] * (power(fac[n - k], p - 2)) % p * (power(fac[k], p - 2)) % p;
	}

	private static long power(long x, long y) {
		long res = 1L;

		while (y > 0) {
			if (y % 2 == 1)
				res = (res * x) % p;
			y = y >> 1;
			x = (x * x) % p;
		}

		return res;
	}


}
