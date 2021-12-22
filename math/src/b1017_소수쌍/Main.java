package b1017_소수쌍;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isPrime(int num) {
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

}
