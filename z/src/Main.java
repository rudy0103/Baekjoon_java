import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String answer = "";



        for (int i = 0; i < 10; i++) {
            String start = String.valueOf(i);
            list.add(Long.valueOf(start));
            dfs(i, start);

        }
        list.sort(null);
        if(n >= list.size()) {
            answer = "-1";
        } else {
            answer = String.valueOf(list.get(n));
        }

        System.out.println(answer);
    }

    private static void dfs(int cur, String result) {

        for (int i = 0; i < 10; i++) {
            if (i < cur) {
                Long next = Long.valueOf(result+i);
                list.add(next);
                dfs(i, result+i);
            }
        }


    }
}