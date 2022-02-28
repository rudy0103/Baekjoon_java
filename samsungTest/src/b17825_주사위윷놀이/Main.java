package b17825_주사위윷놀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int max = 0;
	static int[][] before=new int[10][2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] map = new int[4][22];
		int[] dice = new int[10];

		for (int i = 0; i < 10; i++)
			dice[i] = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= 20; i++)
			map[0][i] = 2 * i;

		map[0][21] = -1;
		map[1] = new int[] {10, 13, 16, 19, 25, 30, 35, 40, -1 };
		map[2] = new int[] {20, 22, 24, 25, 30, 35, 40, -1 };
		map[3] = new int[] {30, 28, 27, 26, 25, 30, 35, 40, -1 };

		int[][] horses = new int[4][2];

		playGame(0, map, horses, dice,0);

		System.out.println(max);

	}

	private static void playGame(int d, int[][] map, int[][] horses, int[] dice,int score) {
		
		if (d == 10) {
			if(score>max) max=score;
			return;
		}

		for (int i = 0; i < 4; i++) {

			if(map[horses[i][0]][horses[i][1]]==-1) continue;
			
			before[d][0]=horses[i][0];
			before[d][1]=horses[i][1];
	
			int s=0;
			if(horses[i][0]==0&&map[horses[i][0]][horses[i][1]]%10==0) {
				if(map[horses[i][0]][horses[i][1]]!=40) {
					horses[i][0]=map[horses[i][0]][horses[i][1]]/10;
					horses[i][1]=0;
				}
			}
			
			int next=horses[i][1];
			for(int j=1;j<=dice[d];j++) {
				if(map[horses[i][0]][++next]!=-1) {
					s=map[horses[i][0]][next];
				}else {
					s=0;
					break;
				}
			}
			
			horses[i][1]=next;
			
			boolean possible=true;
			for(int j=0;j<4;j++) {
				if(i==j) continue;
				if(horses[j][0]==horses[i][0]&&horses[j][1]==horses[i][1]) {
					if(map[horses[j][0]][horses[j][1]]!=-1) {
						possible=false;
						break;
					}
				}else if(map[horses[j][0]][horses[j][1]]==map[horses[i][0]][horses[i][1]]) {
					if(map[horses[j][0]][horses[j][1]]==25||map[horses[j][0]][horses[j][1]]==35||map[horses[j][0]][horses[j][1]]==40) {
						possible=false;
						break;
					}else if(horses[j][0]>0&&horses[i][0]>0&&map[horses[j][0]][horses[j][1]]==30) {
						possible=false;
						break;
					}
				}
			}
			if(!possible) {
				horses[i][0]=before[d][0];
				horses[i][1]=before[d][1];
				continue;
			}
			
			playGame(d + 1, map, horses, dice,score+s);

			horses[i][0]=before[d][0];
			horses[i][1]=before[d][1];
		}

	}

}
