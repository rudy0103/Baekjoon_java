package b20327_배열돌리기6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Function {
		int[][] arr;
		int len;

		public Function(int[][] arr, int len) {
			super();
			this.arr = arr;
			this.len = len;
		}

		public void task(int k, int l) {
			int[][] tmp = new int[len][len];
			if (k == 1)
				this.f1(l, tmp);
			if (k == 2)
				this.f2(l, tmp);
			if (k == 3)
				this.f3(l, tmp);
			if (k == 4)
				this.f4(l, tmp);
			if (k == 5)
				this.f5(l, tmp);
			if (k == 6)
				this.f6(l, tmp);
			if (k == 7)
				this.f7(l, tmp);
			if (k == 8)
				this.f8(l, tmp);
		}

		public void f1(int l, int[][] tmp) {
			// 상하
			int subLen = (int) Math.pow(2, l);

			for (int i = 0; i < len; i += subLen) {
				for (int j = 0; j < len; j += subLen) {

					for (int r = 0; r < subLen; r++) {
						for (int c = 0; c < subLen; c++) {
							tmp[i + r][j + c] = arr[i + subLen - r - 1][j + c];
						}
					}

				}
			}

			this.arr = tmp;
		}

		public void f2(int l, int[][] tmp) {
			// 좌우
			int subLen = (int) Math.pow(2, l);

			for (int i = 0; i < len; i += subLen) {
				for (int j = 0; j < len; j += subLen) {

					for (int r = 0; r < subLen; r++) {
						for (int c = 0; c < subLen; c++) {
							tmp[i + r][j + c] = arr[i + r][j + subLen - c - 1];
						}
					}

				}
			}

			this.arr = tmp;
		}

		public void f3(int l, int[][] tmp) {

			// 오른쪽으로 90도
			int subLen = (int) Math.pow(2, l);

			for (int i = 0; i < len; i += subLen) {
				for (int j = 0; j < len; j += subLen) {

					for (int r = 0; r < subLen; r++) {
						for (int c = 0; c < subLen; c++) {
							tmp[i + r][j + c] = arr[i + subLen - c - 1][j + r];
						}
					}

				}
			}

			this.arr = tmp;
		}

		public void f4(int l, int[][] tmp) {
			// 왼쪽으로 90도
			int subLen = (int) Math.pow(2, l);

			for (int i = 0; i < len; i += subLen) {
				for (int j = 0; j < len; j += subLen) {

					for (int r = 0; r < subLen; r++) {
						for (int c = 0; c < subLen; c++) {
							tmp[i + r][j + c] = arr[i + c][j + subLen - r - 1];
						}
					}

				}
			}

			this.arr = tmp;
		}

		public void f5(int l, int[][] tmp) {
			// 상하

			int subLen = (int) Math.pow(2, l);

			for (int i = 0; i < len; i += subLen) {
				for (int j = 0; j < len; j += subLen) {

					int R = i;
					int C = j;

					int oR = len - i - subLen;
					int oC = C;

					for (int r = 0; r < subLen; r++) {
						for (int c = 0; c < subLen; c++) {
							tmp[R + r][C + c] = arr[oR + r][oC + c];
						}
					}

				}
			}

			this.arr = tmp;
		}

		public void f6(int l, int[][] tmp) {

			//좌우

			int subLen = (int) Math.pow(2, l);

			for (int i = 0; i < len; i += subLen) {
				for (int j = 0; j < len; j += subLen) {

					int R = i;
					int C = j;

					int oR = R;
					int oC = len -j -subLen;

					for (int r = 0; r < subLen; r++) {
						for (int c = 0; c < subLen; c++) {
							tmp[R + r][C + c] = arr[oR + r][oC + c];
						}
					}

				}
			}

			this.arr = tmp;
		}

		public void f7(int l, int[][] tmp) {

			//오른쪽으로 90도

			int subLen = (int) Math.pow(2, l);

			for (int i = 0; i < len; i += subLen) {
				for (int j = 0; j < len; j += subLen) {

					int R = i;
					int C = j;
					
					int oR = len-j-subLen;
					int oC = i;

					for (int r = 0; r < subLen; r++) {
						for (int c = 0; c < subLen; c++) {
							tmp[R + r][C + c] = arr[oR + r][oC + c];
						}
					}

				}
			}
			
			
			this.arr = tmp;
		}

		public void f8(int l, int[][] tmp) {

			//왼쪽으로 90도

			int subLen = (int) Math.pow(2, l);

			for (int i = 0; i < len; i += subLen) {
				for (int j = 0; j < len; j += subLen) {

					int R = i;
					int C = j;
					
					int oR = j;
					int oC = len-i-subLen;

					for (int r = 0; r < subLen; r++) {
						for (int c = 0; c < subLen; c++) {
							tmp[R + r][C + c] = arr[oR + r][oC + c];
						}
					}

				}
			}
			
			
			this.arr = tmp;
		}

		public void print() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < len; i++) {
				for (int j = 0; j < len; j++) {
					sb.append(arr[i][j] + " ");
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int len = (int) Math.pow(2, N);
		int[][] arr = new int[len][len];

		for (int i = 0; i < len; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < len; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}

		Function function = new Function(arr, len);

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			if (k <= 4 && l == 0)
				continue;
			function.task(k, l);
		}
		function.print();
	}
}
