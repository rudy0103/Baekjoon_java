package b1092_배;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MainB {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;


		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int[] crains = new int[N];

		for (int i = 0; i < N; i++)
			crains[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(crains);//크레인 정렬

		int M = Integer.parseInt(br.readLine());

		int [] freight=new int[M];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < M; i++) {
			freight[i]= Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(freight); //화물을 무게순으로 정렬
		 
		if(freight[M-1]>crains[N-1]) {//가장 무거운 화물이 가장 힘이쌘 크레인보다 크면 완료 할 수 없음
			System.out.println(-1);
		}else {
			
			int [] index=new int[M];//M개의 화물은 자기를 들 수 있는 가장 힘이 약한 크레인의 인덱스를 저장함
		
			
			for(int i=0;i<M;i++) { //인덱스 저장하는 과정
				for(int j=0;j<N;j++) {
					if(crains[j]>=freight[i]) {
						index[i]=j;
						break;
					}
				}
			}
			
			int [] cnt=new int[N];// 각 크레인이 옮긴 화물 수를 저장함
			
			
			//각 크레인이 옮긴 수가 적은 순서대로 인덱스를 반환해줌, 옮긴 수가 같으면 가장 큰 인덱스를 반환함 (뒤에서부터 채우기 위함)
			PriorityQueue<Integer> pq  = new PriorityQueue<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					if(cnt[o1]!=cnt[o2])
						return cnt[o1]-cnt[o2];
					else return o2-o1;
				}
			});
			
			boolean[] visited=new boolean[N];//N개의 크레인의 인덱스가 우선순위큐에 들어갈건데 겹쳐서 들어가지 않게하기 위함
			
			int j=M-1; //가장 무거운 화물부터
			
			while(j>=0) {
				int idx=index[j]; //j번째 화물을 들 수 있는 가장 약한 크레인 인덱스
				for(int i=idx;i<N;i++) {//가장 약한 크레인부터 가장 강한 크레인까지 넣는다
					if(!visited[i]) {//중복되게 넣지 않게
						visited[i]=true;
						pq.add(i);
					}
				}
				
				int putIdx=pq.poll();//자신을 들 수 있는 크레인 중 가장 적게 옮긴 크레인, 횟수가 같으면 가장 쌘 크레인의 인덱스를 가져온다.
				cnt[putIdx]++;//개수를 늘린다.
				pq.add(putIdx);//다시 집어넣는다.
				j--;//다음 화물로
				
			}
			
			int timer=0;
			for(int i=0;i<N;i++) {// 가장 많이 옮긴 컨테이너 만큼 시간이 걸린다.
				timer=Math.max(timer,cnt[i]);
			}
			System.out.println(timer);
			
		}
		
	}
}
