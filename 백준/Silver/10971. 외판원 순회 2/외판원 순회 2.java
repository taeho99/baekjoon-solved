import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, start, result = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            start = i;
            dfs(i, 0, 0);
        }
        System.out.println(result);
    }

    private static void dfs(int now, int sum, int depth) {
        if(depth == n - 1) {
            sum += map[now][start];
            if(map[now][start] != 0)
                result = Math.min(sum, result);
            return;
        }
        for(int i=0; i<n; i++) {
            if(!visited[i] && map[now][i] != 0) {
                visited[i] = true;
                dfs(i, sum + map[now][i], depth + 1);
                visited[i] = false;
            }
        }
    }
}
