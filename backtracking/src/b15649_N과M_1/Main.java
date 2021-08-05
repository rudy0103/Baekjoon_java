package b15649_N과M_1; //순열

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;



public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	static int n,m;
	static boolean [] isSelected;
	static int [] arr;

	static void permutation(int cnt) throws IOException {
		if(cnt==m) {
			for(int num:arr) {
				bw.write(num+" ");
			}
			bw.write("\n");
		}else {
			for(int i=1;i<=n;i++) {
				if(isSelected[i]) continue;
				isSelected[i]=true;
				arr[cnt]=i;
				permutation(cnt+1);
				isSelected[i]=false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		
		String []inp=br.readLine().split(" ");
		n=Integer.parseInt(inp[0]);
		m=Integer.parseInt(inp[1]);
		isSelected = new boolean[n+1];
		arr = new int[m];
		for(int i=0; i<isSelected.length;i++)
			isSelected[i]=false;
		
		permutation(0);
		bw.flush();
		bw.close();
	}
}