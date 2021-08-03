package b18870_좌표압축;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String [] inp=br.readLine().split(" ");
		
		int [] arr= new int[n];
		int [] res= new int[n];
		int [] copy;
		for(int i =0; i<inp.length;i++) {
			arr[i]=Integer.parseInt(inp[i]);
			res[i]=0;
		}
		
		copy=Arrays.copyOf(arr,arr.length);
		Arrays.sort(copy);
		
		
		int k=0;
		for(int i =0; i<arr.length;i++) {
//			res[i]=copy.
		}
		
		
		bw.flush();
		bw.close();
	}
}