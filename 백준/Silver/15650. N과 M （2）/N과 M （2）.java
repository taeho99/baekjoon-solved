import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visited = new boolean[n];
        dfs(n, m, 0, 0);
        System.out.print(sb);
    }

    private static void dfs(int n, int m, int depth, int at) {
        if(depth == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append('\n');
            return;
        }

        for(int i=at; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i+1;
                dfs(n, m, depth+1, i+1);
                visited[i] = false;
            }
        }
    }
}
