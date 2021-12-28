package b6143_문자열생성2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		char[] str = new char[N];

//		String s = br.readLine();
//		for (int i = 0; i < N; i++) {
//			str[i] = s.charAt(i);
//			System.out.print(str[i]);
//		}
//		System.out.println();

		for (int i = 0; i < N; i++) {
			str[i] = br.readLine().charAt(0);
		}

		int p1 = 0;
		int p2 = N - 1;

		while (p1 != p2) {

			if (str[p1] < str[p2]) {
				sb.append(str[p1]);
				p1++;
			} else if (str[p1] > str[p2]) {
				sb.append(str[p2]);
				p2--;
			} else {
				int tmpPos1 = p1;
				int tmpPos2 = p2;

				while (tmpPos1 < tmpPos2 && str[p1] >= str[tmpPos2-1]) {
					tmpPos2--;
				}
				while (tmpPos1 < tmpPos2 && str[p2] >= str[tmpPos1+1]) {
					tmpPos1++;
				}

				if (tmpPos1 == tmpPos2) {
					for (int i = p1; i <= p2; i++) {
						sb.append(str[i]);
					}

					break;
				} else if (tmpPos1 > tmpPos2) {
					for (int i = p1; i <= p2; i++) {
						sb.append(str[i]);
					}
					break;
				} else {
					if (str[tmpPos1] < str[tmpPos2]) {
						for (int i = p1; i <= tmpPos1; i++) {
							sb.append(str[i]);
						}
						p1 = tmpPos1 + 1;
					} else if (str[tmpPos1] > str[tmpPos2]) {
						for (int i = p2; i >= tmpPos2; i--) {
							sb.append(str[i]);
						}
						p2 = tmpPos2 - 1;
					} else {
						for (int i = p1; i <= tmpPos1; i++) {
							sb.append(str[i]);
						}
						p1 = tmpPos1 + 1;
						
						for (int i = p2; i >= tmpPos2; i--) {
							sb.append(str[i]);
						}
						p2 = tmpPos2 - 1;
					}
				}
			}
		}
		if (p1 == p2)
			sb.append(str[p1]);
		
		StringBuilder res = new StringBuilder();
		
		for(int i=0;i<sb.length();i++) {
			res.append(sb.charAt(i));
			if(i!=0&&i!=sb.length()-1&&(i+1)%80==0) res.append("\n");
		}
		System.out.println(res.toString());

	}
}