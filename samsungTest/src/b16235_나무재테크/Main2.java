package b16235_나무재테크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
	public static class Tree{
		int age;
		Tree link;	
		
		public Tree(int age, Tree link) {
			super();
			this.age = age;
			this.link = link;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		//추가 영양,죽어서 영양분이 된 나무, 현재 영양, 나무 정보
		int[][] A = new int[N+1][N+1];
		int[][] addA = new int[N+1][N+1];
		int[][] map = new int[N+1][N+1];
		Tree[][] tree = new Tree[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		} 
		//나무 정보 입력
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			tree[y][x] = new Tree(z, tree[y][x]);
		}
		
		while(K-->0) {
			//봄
			for(int y=1; y<=N; y++) {
				for(int x=1; x<=N; x++) {
					if(tree[y][x]==null) continue;
					//현재 위치에 있는 나무 성장 or dead
					for(Tree curr = tree[y][x]; curr!=null; curr=curr.link) {
						//나이만큼 양분이 있으면 양분먹고 나이 1 성장
						if(curr.age<=map[y][x]) {
							map[y][x] -= curr.age;
							curr.age++;
						}else {
							//죽으면 양분 추가해주고 나이를 0으로
							addA[y][x] += curr.age/2;
							curr.age = 0;
						}
					}
				}
			}
			
			//여름
			// 죽은 나무 양분으로 추가
			for(int y=1; y<=N; y++) {
				for(int x=1; x<=N; x++) {
					map[y][x] += addA[y][x];
					addA[y][x] = 0;
					//죽은 나무 제거
                    if(tree[y][x]==null) continue;
                    
					if(tree[y][x].age ==0) {
						tree[y][x] = null;
						continue;
					}else {
						for(Tree curr = tree[y][x]; curr!=null; curr=curr.link) {
							if(curr.link!=null && curr.link.age==0) {
								curr.link = null;
								break;
							}	
						}
					}
					
				}
			}
			
			//가을
			//나이가 5의 배수인 나무의 번식
			int[] my = {-1,-1,-1,0,0,1,1,1};
			int[] mx = {-1,0,1,-1,1,-1,0,1};
			
			for(int y=1; y<=N; y++) {
				for(int x=1; x<=N; x++) {
					if(tree[y][x]==null) continue;
					
					for(Tree curr = tree[y][x]; curr!=null; curr=curr.link) {
						if(curr.age%5 !=0) continue;
						
						for(int i=0; i<8; i++) {
							int ny = y+my[i];
							int nx = x+mx[i];
							
							if(ny<1 || ny>N || nx<1 || nx>N) continue;

							tree[ny][nx] = new Tree(1, tree[ny][nx]);
						}
					}
				}
			}
			
			//겨울
			//땅에 양분 추가
			for(int y=1; y<=N; y++) {
				for(int x=1; x<=N; x++) {
					map[y][x] += A[y][x];
				}
			}
		}
		
		//나무의 수 세기
		int result = 0;
		
		for(int y=1; y<=N; y++) {
			for(int x=1; x<=N; x++) {
				if(tree[y][x]==null) continue;
				
				for(Tree curr = tree[y][x]; curr!=null; curr=curr.link) {
					result++;
				}
			}
		}
		
		System.out.println(result);
	}
}
