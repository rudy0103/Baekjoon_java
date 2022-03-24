package b1271_엄청난부자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String n=st.nextToken();
		String m=st.nextToken();
		
		BigInteger N=new BigInteger(n); 
		BigInteger M=new BigInteger(m); 
		
		BigInteger K=N.divide(M);
		BigInteger L=N.subtract(M.multiply(K));
		System.out.print(K.toString()+" "+L.toString());
	}

}
