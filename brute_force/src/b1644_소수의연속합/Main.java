package b1644_소수의연속합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws  IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		ArrayList<Integer> prime=new ArrayList<>();
		
		boolean[] isPrime = new boolean[4000001];
		for(int i=2;i<isPrime.length;i++) {
			isPrime[i]=true;
		}
		
		for(int i=2;i*i<=N;i++) {
			if(isPrime[i]==false) continue;
			for(int j=i*i;j<=N;j+=i) {
				isPrime[j]=false;
			}
		}
		
		for(int i=0;i<=N;i++) {
			if(isPrime[i]) prime.add(i);
		}
		
		long [] preSum=new long[prime.size()+1];
		
		for(int i=1;i<=prime.size();i++) {
			preSum[i]=preSum[i-1]+prime.get(i-1);
		}
		
		
		int cnt=0;
		
		for(int i=1;i<=prime.size();i++) {
			for(int j=i;j<=prime.size();j++) {
				if(preSum[j]-preSum[i-1]==N) cnt++;
				if(preSum[j]-preSum[i-1]>N) break;
			}
		}
		
		System.out.println(cnt);
		
		
	}


}
