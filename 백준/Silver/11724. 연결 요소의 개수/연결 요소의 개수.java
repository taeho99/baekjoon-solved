import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++) {
            adj[i] = new ArrayList<>();
            visited[i] = false;
        }

        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        int count = 0;
        for(int i=1; i<=N; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }
        System.out.print(count);
    }

    public static void dfs(int v) {
        visited[v] = true;
        for (int ad : adj[v]) {
            if (!visited[ad])
                dfs(ad);
        }
    }
}
