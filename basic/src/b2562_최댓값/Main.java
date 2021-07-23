package b2562_최댓값;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int [] arr= new int[9];
		int idx=-1;
		int max=Integer.MIN_VALUE;
		for(int i=0;i<9;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			if(arr[i]>max) {
				idx=i;
				max=arr[i];
			}
		}
		bw.write(max+"\n");
		bw.write(idx+1+"\n");
		bw.flush();
		bw.close();
	}

}
