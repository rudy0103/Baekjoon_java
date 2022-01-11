package b2290_LCDTest;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int s = sc.nextInt();
		String num = sc.next();
		int[][] garo = { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 1, 1 }, { 1, 1, 1 }, { 0, 1, 0 }, { 1, 1, 1 }, { 1, 1, 1 },
				{ 1, 0, 0 }, { 1, 1, 1 }, { 1, 1, 1 } };
		int[][][] sero = {
				{ { 1, 1 }, { 0, 1 }, { 0, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, 0 }, { 0, 1 }, { 1, 1 }, { 1, 1 } },
				{ { 1, 1 }, { 0, 1 }, { 1, 0 }, { 0, 1 }, { 0, 1 }, { 0, 1 }, { 1, 1 }, { 0, 1 }, { 1, 1 },
						{ 0, 1 } } };

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < num.length(); j++) {
				lcd(num.charAt(j)-'0', i, s, sb,garo,sero);
				sb.append(" ");
			}
			if(i%2==1) {
				sb.append("\n");
				String tmp=sb.substring(sb.length()-((s+2)*num.length()+num.length())-1, sb.length());
//				System.out.println(tmp);
//				System.out.println(tmp.length());
				for(int k=0;k<s-1;k++) {
					sb.append(tmp);
				}
			}else
				sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	private static void lcd(int num, int i, int s, StringBuilder sb, int[][] garo, int[][][] sero) {
		
		if(i%2==0) {//가로
			int k=i/2;
			String tmp=" ";
			for(int y=0;y<s;y++) {
				if(garo[num][k]!=1) tmp+=" ";
				else tmp+="-";
			}
			tmp+=" ";
			sb.append(tmp);
		}else {
			if(i==1) i=0;
			else i=1;
			String tmp="";
			if(sero[i][num][0]==1) tmp+="|"; 
			else tmp+=" ";
			
			for(int y=0;y<s;y++) tmp+=" ";
			
			if(sero[i][num][1]==1) tmp+="|"; 
			else tmp+=" ";
			sb.append(tmp);
		}
	}


}
