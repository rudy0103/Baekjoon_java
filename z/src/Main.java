import java.io.IOException;
import java.util.Scanner;

public class Main {
  
	public static void main(String [] args) throws IOException{
		
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		int d=sc.nextInt();
		
		
		char[] arr=new char[d];
		
		for(int i=0;i<d;i++) arr[i]=(char) (i+'0');
		
		arr[0]='1';
		arr[1]='0';
		long tmp=-1;
	
		do {
			tmp=isBiggerThanN(arr,d);
			
			if(tmp>N) {
				break;
			}
			
		}while(np(arr));
	
		if(tmp>N)
			System.out.println(tmp);
		else System.out.println(-1);
		
	}

	private static boolean np(char[] arr) {
		
		int N=arr.length;
		
		int a=N-2;
		
		while(a>=0&&arr[a]>=arr[a+1]) a--;
		
		if(a==-1) return false;
		
		int t=N-1;
		
		while(arr[a]>=arr[t]) t--;
		
		swap(arr,a,t);
		
		int i=a+1;
		
		int j=N-1;
		
		while(i<=j) swap(arr, i++, j--);
		
		return true;
	}

	private static long isBiggerThanN(char[] arr,int d) {

		String s=String.valueOf(arr);
		return Integer.parseInt(s,d);

	}
	
	static void swap(char[] arr, int x,int y) {
		char tmp=arr[x];
		arr[x]=arr[y];
		arr[y]=tmp;
		
	}
}