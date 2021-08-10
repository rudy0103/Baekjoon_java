package b14888_연산자끼워넣기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static int[] arr;
	static int[] op;
	static int[] selectedOp;
	static int n;
	static int max=Integer.MIN_VALUE;
	static int min=Integer.MAX_VALUE;
	
	public static void makePermutation(int cnt) {
		if(cnt==n-1) {
			int tmp=arr[0];
			for(int i=0;i<selectedOp.length;i++) {
				if(selectedOp[i]==0) {
					tmp+=arr[i+1];
				}else if(selectedOp[i]==1) {
					tmp-=arr[i+1];
				}else if(selectedOp[i]==2) {
					tmp*=arr[i+1];
				}else{
					tmp/=arr[i+1];
				}
			}
			min = tmp > min ? min : tmp;
			max = tmp > max ? tmp : max;
		}else {
			for(int i=0;i<op.length;i++) {
				if(op[i]==0) continue;
				op[i]--;
				selectedOp[cnt]=i;
				makePermutation(cnt+1);
				op[i]++;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//n입력 받기
		n = Integer.parseInt(br.readLine());
		
		//수열 입력받기
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		//연산자 입력받기
		op= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		//연산자의 순서를 저장할 배열
		selectedOp=new int[n-1];
		//연산자 순열을 만드는 함수
		makePermutation(0);
		//max,min 출력
		bw.write(max+"\n"+min);
		bw.close();
	}
}
