package b2920_음계;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] inp=br.readLine().split(" ");
		String res=String.join("", inp);
		if(res.equals("12345678")) System.out.println("ascending");
		else if(res.equals("87654321")) System.out.println("descending");
		else System.out.println("mixed");
	}
}
