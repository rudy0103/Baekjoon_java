package b2961_도영이가만든맛있는음식;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int n,min;
	static boolean[] isSelected;
	static int[][] arr;
	
	static void makeSubSet(int cnt) {
		if(cnt==n) {
			int S=1;
			int B=0;
			for(int i=0;i<isSelected.length;i++) {
				if(isSelected[i]) {
					S*=arr[i][0];
					B+=arr[i][1];
				}
			}
			if(S!=0&&B!=0)
				if(Math.abs(S-B)<min) min=Math.abs(S-B);
			
		}else {
			isSelected[cnt]=true;
			makeSubSet(cnt+1);
			isSelected[cnt]=false;
			makeSubSet(cnt+1);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n=Integer.parseInt(br.readLine());
		isSelected=new boolean[n];
		arr = new int[n][2];
		min=Integer.MAX_VALUE;
		String [] inp;
		for(int i=0;i<n;i++) {
			inp=br.readLine().split(" ");
			arr[i][0]=Integer.parseInt(inp[0]);
			arr[i][1]=Integer.parseInt(inp[1]);
		}
		
		makeSubSet(0);
		bw.write(min+"");
		bw.close();
	}
}
