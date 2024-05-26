import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, result = 0;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                visited[i][j] = true;
                dfs(i, j, arr[i][j], 1);
                visited[i][j] = false;
            }
        }
        System.out.println(result);
    }

    private static void dfs(int y, int x, int sum, int depth) {
        if(depth == 4) {
            result = Math.max(result, sum);
            return;
        }

        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny<0 || ny>=n || nx<0 || nx>=m) continue;

            if(!visited[ny][nx]) {
                if(depth == 2) {
                    visited[ny][nx] = true;
                    dfs(y, x, sum+arr[ny][nx], depth + 1);
                    visited[ny][nx] = false;
                }
                visited[ny][nx] = true;
                dfs(ny, nx, sum+arr[ny][nx], depth + 1);
                visited[ny][nx] = false;
            }
        }
    }
}
