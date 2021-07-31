package b1011_Fly_me_to_the_Alpha_Centauri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String []inp=br.readLine().split(" ");
			int x = Integer.parseInt(inp[0]);
			int y = Integer.parseInt(inp[1]); 
			long start=0L;
			long end=y-x;
			long k=1L;
			
			while((long)(start+k*(k+1))<end) {
				k+=10000;
			}
			
			while(start+k*(k+1)>=end) {
				k/=10;
			}
			
			while(start+k*(k+1)<end) {
				k++;
			}
			
			if(start+k*(k+1)==end) {
				System.out.println(k*2);
			}else{
				if(end<=start+k*(k+1)-k) {
					System.out.println(k*2-1);
				}else{
					System.out.println(k*2);	
				}
			}
		}
	}
}