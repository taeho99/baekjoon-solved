import java.util.Scanner;

public class Main {
    static int n;
    static boolean[] visited;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        n = new Scanner(System.in).nextInt();
        visited = new boolean[n];
        result = new int[n];
        dfs(0);
        System.out.print(sb);
    }

    private static void dfs(int depth) {
        if(depth == n) {
            for (int i : result) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = i+1;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }

}
