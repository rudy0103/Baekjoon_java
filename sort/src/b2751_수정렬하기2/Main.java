package b2751_수정렬하기2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int[2000001];
		for(int i=0;i<n;i++) {
			arr[Integer.parseInt(br.readLine())+1000000]++;
		}
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0; j<arr[i];j++) {
				bw.write(i-1000000+"\n");
			}
		}
		bw.flush();
		bw.close();
		
	}
}