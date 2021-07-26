package b5622_다이얼;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String[][] arr = { { "A", "B", "C" }, { "D", "E", "F" }, { "G", "H", "I" }, { "J", "K", "L" },
				{ "M", "N", "O" }, { "P", "Q", "R", "S" }, { "T", "U", "V" }, { "W", "X", "Y", "Z" } };
		int sum=0;
		
		for (int i = 0; i < s.length(); i++) {
			
			for(int j=0;j<arr.length;j++) {
				for(int k=0; k<arr[j].length;k++) {
					if((s.charAt(i)+"").equals(arr[j][k])){
						sum+=(j+3);
					}
				}
			}
		}
		System.out.println(sum);

	}

}
