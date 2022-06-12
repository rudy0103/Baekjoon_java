package b1550_16진수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		String hexa=br.readLine();
		
		int res=Integer.parseInt(hexa, 16);
		System.out.println(res);

	}

}
