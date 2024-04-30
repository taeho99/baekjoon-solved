import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int[] dy = {0, 0, -1, 1};
    static final int[] dx = {-1, 1, 0, 0};
    static int[][] arr;
    static int maxSafeZone = Integer.MIN_VALUE;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.print(maxSafeZone);
    }

    private static void dfs(int depth) {
        if(depth == 3) {
            bfs();
            return;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(depth+1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        int size = n*m;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] == 2) {
                    queue.add(new Node(i, j));
                    visited[i][j] = true;
                    size--;
                } else if (arr[i][j] == 1) {
                    size--;
                }
            }
        }

        while(!queue.isEmpty()) {
            Node poll = queue.poll();
            for(int i=0; i<4; i++) {
                int ny = poll.y + dy[i];
                int nx = poll.x + dx[i];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(!visited[ny][nx] && arr[ny][nx] == 0) {
                    queue.add(new Node(ny, nx));
                    visited[ny][nx] = true;
                    size--;
                }
            }
        }
        maxSafeZone = Math.max(size, maxSafeZone);
    }

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}