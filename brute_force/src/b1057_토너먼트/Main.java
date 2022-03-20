package b1057_토너먼트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int Jimin = Integer.parseInt(st.nextToken());
		int Hansu = Integer.parseInt(st.nextToken());

		int round = 1;
		
		while(true) {
			if(Jimin%2==1&&Hansu==Jimin+1) {
				break;
			}else if(Hansu%2==1&&Jimin==Hansu+1) {
				break;
			}else {
				round++;
				Jimin--;
				Jimin/=2;
				Jimin++;
				
				Hansu--;
				Hansu/=2;
				Hansu++;
			}
		}

		System.out.println(round);

	}

}
