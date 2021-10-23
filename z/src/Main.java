import java.io.IOException;

public class Main {

	static int N, M;
	static int[][] origin;
	static int[][] visited;
	static int[][] copyNamsu;
	static int[][] copySeongkeon;
	static int[][] copyYeijin;

	public static void main(String[] args) throws IOException {
		int maxN=5;
		int maxM=5;
		int tc = 0;
		for (int i = 0; i < 10000; i++) {
			N = (int) (Math.random() * maxN) + 1;
			M = (int) (Math.random() * maxM) + 1;
//			System.out.println(N+" "+M);
			origin = new int[N][N];
			copyNamsu = new int[N][N];
			copySeongkeon = new int[N][N];
			copyYeijin = new int[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					origin[r][c] = (int) (Math.random() * (M + 2)) - 1;
				}
			}
			for (int k = 0; k < N; k++) {
				System.arraycopy(origin[k], 0, copyNamsu[k], 0, N);
				System.arraycopy(origin[k], 0, copySeongkeon[k], 0, N);
				System.arraycopy(origin[k], 0, copyYeijin[k], 0, N);
			}
			Seongkeon sk = new Seongkeon();
			int s = sk.shark(N, M, copyNamsu);

			Namsu namsu = new Namsu();
			int n = namsu.shark(N, M, copySeongkeon);
			
			Yeijin yeijin= new Yeijin();
			int y = yeijin.shark(N, M, copyYeijin);

			if (s != n || s!=y ||n!=y) {
				tc++;
				System.out.println("TestCase: "+tc + "================");
				System.out.println(N + " " + M);
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						System.out.print(origin[r][c]+" ");
					}
					System.out.println();
				}
				System.out.println();
				
				System.out.println("남수 답: "+n);
				System.out.println("성건 답: "+s);
				System.out.println("예진 답: "+y);
				System.out.println("========================");
			}
		}

	}

}
