import java.util.Scanner;

public class Main {

static int N, color, cnt, Answer;
static int[][] map;

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt(); // 색종이의 장수
    map = new int[20][20]; // 평면

    while (N > 0) {

        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = sc.nextInt();
        }

        for (int j = map.length - 1; j >= 0; j--) {
            for (int k = 0; k < map.length; k++) {
                if (k == arr[0] && j == arr[1]) {
                    map[k][j] = ++color;
                    for (int x = k; x < k + arr[2]; x++) {
                        for (int y = j; y < k + arr[3]; y++) {
                            map[x][y] = color;
                        }
                    }
                }
            }
        }
        N--;
    }
        for (int j = map.length - 1; j >= 0; j--) {
            for (int k = 0; k < map.length; k++) {
                int sum = 0, color = 1;
                if (map[j][k] == color) {
                    sum += color;
                }
                System.out.println(Answer);
            }
        }

    for (int j = map.length - 1; j >= 0; j--) {
        for (int k = 0; k < map.length; k++) {
            System.out.print(map[k][j] + " ");
        }
        System.out.println();
    }
}
}