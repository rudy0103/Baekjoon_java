package b3025_돌던지기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;


public class Test2 {

	static char[][] map;
	static int R, C,N;

	static void printMap() {
		for (char[] arr : map) {
			for (char c : arr)
				System.out.print(c);
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<int []> queue=new LinkedList<>();//화산탄을 넣을 덱
		// R,C 입력값 받기
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		// map 입력값 받기
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
//		printMap();
		//화산탄 개수 
		N=Integer.parseInt(br.readLine());
		//화산탄 입력받아 큐에 넣기
		while (N-->0) queue.add(new int[] {0,Integer.parseInt(br.readLine())-1});
		
		while (!queue.isEmpty()) {
			int [] tan=queue.poll();//맨 앞의 화산탄을 꺼냄
			int r=tan[0]; //행
			int c=tan[1]; //열
			while(r+1<R&&map[r+1][c]=='.') //아래 행이 유효범위고 '.'이면 내려감
				r++;
			if(r==R-1&&map[r][c]=='.'||map[r+1][c]=='X') { //만약 마지막 행이고'.'이거나 다음행이 'X'이면 굳음
				map[r][c]='O';
			}else if(map[r+1][c]=='O') {//만약 화산탄이 굳어있다면
				if(c-1>=0 && map[r][c-1]=='.'&&map[r+1][c-1]=='.') {//왼쪽이 비고 왼쪽아래도 비면
					queue.addFirst(new int[] {r,c-1});//다시 큐의 처음으로 넣음
				}
				else if(c+1<C&&map[r][c+1]=='.'&&map[r+1][c+1]=='.') {//오른쪽이 비고 오른쪽 아래도 비면
					queue.addFirst(new int[] {r,c+1});//다시 큐의 처음으로 넣음
				}else {
					map[r][c]='O';//왼쪽도 안되고 오른쪽도 안되면 굳음
				}
			}
		}
		printMap();//결과 출력
	}
}
