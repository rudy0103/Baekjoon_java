import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static int cntZero(String n) {
		int cnt = 0;

		for (int i = (n.length() - 1); i >= 0; i--) {
			if (n.charAt(i) == '0')
				cnt++;
			else
				break;
		}
		return cnt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n == 0)
			System.out.println(0);
		else {
			BigInteger num = new BigInteger("1");
			for (int i = 1; i <= n; i++) {
				num = num.multiply(new BigInteger(Integer.toString(i)));
			}
			System.out.println(cntZero(num.toString()));
		}
	}
}
