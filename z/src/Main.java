
public class Main {

	
	public static void main(String[] args) {
		

	
		
	}

	private static void printMap(int[][] map) {
		int R = map.length;
		int C = map[0].length;
		System.out.println("@@@@@@@@@@@@@@@@@@");
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
