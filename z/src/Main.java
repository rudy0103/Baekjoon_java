import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

class Main {
    static int N, M, input[], result[];
    static boolean[] sel;
    static StringBuilder sb = new StringBuilder();
        
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        input = new int[N];
        result = new int[M];
        sel = new boolean[N];
        for(int i = 0; i < N; i++) input[i] = sc.nextInt();
        Arrays.sort(input);
        
        perm(0);
        System.out.println(sb);
    }
    
    static void perm(int idx){
        if(idx == M){
            for(int r : result) sb.append(r+" ");
            sb.append("\n");
            return;
        }
        HashSet<Integer> hash = new HashSet<>();
        for(int i = 0; i < N; i++){
            if(sel[i] || hash.contains(input[i])) continue;
            
            hash.add(input[i]);
            result[idx] = input[i];
            sel[i] = true;
            perm(idx+1);
            sel[i] = false;
        }
    }
}