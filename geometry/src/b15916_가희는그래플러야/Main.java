package b15916_가희는그래플러야;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double[] arr = new double[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			arr[i] = Double.parseDouble(st.nextToken());

		double K = Double.parseDouble(br.readLine());

		boolean flag = false;
		if (N == 1) {
			if (K == arr[1])
				flag = true;
		} else {
			
			for (int i = 2; i <= N; i++) {
				
				double a = arr[i-1]/(i-1);
				double b = arr[i]/i;
				
				if(K>=Math.min(a, b)&&K<=Math.max(a, b)) {
					flag=true;
					break;
				}
			}
		}

		if (flag)
			System.out.println("T");
		else
			System.out.println("F");

	}

}
