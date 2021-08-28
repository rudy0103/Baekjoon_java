import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N=Integer.parseInt(br.readLine());
		
		int [][] matrix= new int[N][N];
		int [] row_parity=new int[N];
		int [] col_paruty=new int[N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				matrix[i][j]=Integer.parseInt(st.nextToken());
				if(matrix[i][j]==1) {
					row_parity[i]++;
					col_paruty[j]++;
				}
			}
		}
		
		int rowOddCount=0;
		int colOddCount=0;
		
		for(int i=0;i<N;i++) {
			if(row_parity[i]%2!=0) rowOddCount++;
			if(col_paruty[i]%2!=0) colOddCount++;
		}
		
		if(rowOddCount==0&&colOddCount==0) {
			System.out.println("OK");
		}else if(rowOddCount==1&&colOddCount==1){
			int row=-1;
			int col=-1;
			for(int i=0;i<N;i++) {
				if(row_parity[i]%2!=0) row=i;
				if(col_paruty[i]%2!=0) col=i;
			}
			System.out.printf("Change bit (%d,%d)\n",row+1,col+1);
		}else System.out.println("Corrupt");
	}
}