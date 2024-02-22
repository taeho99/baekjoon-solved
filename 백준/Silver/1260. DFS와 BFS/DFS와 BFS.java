import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] adj;
    static boolean[] visited_dfs;
    static boolean[] visited_bfs;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        adj = new int[N+1][N+1];
        visited_dfs = new boolean[N+1];
        visited_bfs = new boolean[N+1];
        for(int i=1; i<=N; i++) {
            visited_dfs[i] = false;
            visited_bfs[i] = false;
            for(int j=1; j<=N; j++) {
                adj[i][j] = 0;
            }
        }

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u][v] = 1;
            adj[v][u] = 1;
        }
        dfs(S);
        sb.append('\n');
        bfs(S);
        System.out.print(sb);
    }

    private static void dfs(int s) {
        visited_dfs[s] = true;
        sb.append(s).append(' ');
        for(int i=1; i<adj.length; i++) {
            if (adj[s][i] == 1 && !visited_dfs[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int s) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited_bfs[s] = true;
        sb.append(s).append(' ');

        while(!queue.isEmpty()) {
            Integer poll = queue.poll();
            for(int i=1; i<adj.length; i++) {
                if(adj[poll][i] == 1 && !visited_bfs[i]) {
                    visited_bfs[i] = true;
                    sb.append(i).append(' ');
                    queue.add(i);
                }
            }
        }
    }
}
