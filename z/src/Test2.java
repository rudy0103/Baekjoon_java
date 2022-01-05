
public class Test2 {

	public static void main(String[] args) {

		for (int i = 0; i < 10000000; i++) {
			long A = (long) (Math.random() * Integer.MAX_VALUE + 1);
			long B = (long) (Math.random() * Integer.MAX_VALUE + 1);
			long C = (long) (Math.random() * Integer.MAX_VALUE + 1);

			if (divideAndConquer(A, B, C) != power(A, B, C)) {
				System.out.println(A);
				System.out.println(B);
				System.out.println(C);
				break;
			}
		}

	}

	private static long power(long a, long b, long c) {
		long res = 1L;

		while (b > 0) {
			if (b % 2 == 1)
				res = (res * a) % c;
			b = b >> 1;
			a = (a * a) % c;
		}

		return res;
	}

	private static long divideAndConquer(long a, long b, long c) {

		if (b == 1)
			return a % c;

		if (b % 2 == 0) {
			long tmp = divideAndConquer(a, b / 2, c);
			long ret = (tmp * tmp) % c;
			return ret;
		} else {
			long tmp = divideAndConquer(a, b / 2, c);
			long ret = (tmp * (tmp * a % c) % c) % c;
			return ret;

		}
	}

}
