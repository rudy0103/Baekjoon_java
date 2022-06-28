package b2954_창영이의일기장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inp = br.readLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < inp.length(); i++) {
			char ch = inp.charAt(i);
			switch (ch) {
			case 'a':
				sb.append(ch);
				i+=2;
				break;
			case 'e':
				sb.append(ch);
				i+=2;
				break;
			case 'i':
				sb.append(ch);
				i+=2;
				break;
			case 'o':
				sb.append(ch);
				i+=2;
				break;
			case 'u':
				sb.append(ch);
				i+=2;
				break;
			default:
				sb.append(ch);
				break;
			}

		}

		System.out.println(sb.toString());

	}

}
