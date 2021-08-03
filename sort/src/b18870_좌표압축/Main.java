package b18870_좌표압축;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;


public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String [] inp=br.readLine().split(" ");
		
		int [][] arr= new int[n][2];
		int [] res= new int[n];

		for(int i =0; i<inp.length;i++) {
			arr[i][0]=Integer.parseInt(inp[i]);
			arr[i][1]=i;
			res[i]=0;
		}
		
		Arrays.sort(arr,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) return o1[1]-o2[1];
				else return o1[0]-o2[0];
			}
		});
		
		int cnt=0;
		res[0]=0;
		for(int i=1; i<arr.length;i++) {
			if(arr[i-1][0]!=arr[i][0]) cnt++;
			res[arr[i][1]]=cnt;
		}
		for(int num:res) {
			bw.write(num+" ");
		}
		
		bw.flush();
		bw.close();
	}
}