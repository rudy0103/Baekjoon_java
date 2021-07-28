package b2869_달팽이는올라가고싶다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] arr=br.readLine().split(" ");
		int A=Integer.parseInt(arr[0]);
		int B=Integer.parseInt(arr[1]);
		int V=Integer.parseInt(arr[2]);

		int day = 1;
		V -= A;
		if (V % (A - B) == 0) {
			day += V / (A - B);
		} else {
			day += V / (A - B) + 1;
		}
		System.out.println(day);

	}
}
