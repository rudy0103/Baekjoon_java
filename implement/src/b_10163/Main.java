package b_10163;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main{
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		int [][] arr=new int[1001][1001];
		int [] area=new int[N];
		for(int i=1;i<=N;i++) {
			int [] inp=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for(int r=inp[0];r<inp[0]+inp[2];r++) {
				for(int c=inp[1];c<inp[1]+inp[3];c++) {
					arr[r][c]=i;
				}
			}
		}
		
		for(int r=0;r<1001;r++) {
			for(int c=0;c<1001;c++) {
				if(arr[r][c]!=0) area[arr[r][c]-1]++;
			}
		}
		
		for(int n:area) {
			bw.write(n+"\n");
		}
		bw.close();
	}
}