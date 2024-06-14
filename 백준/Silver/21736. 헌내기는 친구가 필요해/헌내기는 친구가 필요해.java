import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, result = 0;
    static char[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m];
        Point start = null;

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            for(int j=0; j<m; j++) {
                char c = s.charAt(j);
                if(c == 'I') start = new Point(i, j);
                map[i][j] = c;
            }
        }

        bfs(start);
        System.out.println(result == 0 ? "TT" : result);
    }

    private static void bfs(Point start) {
        Queue<Point> queue = new LinkedList<>();

        queue.add(start);
        visited[start.y][start.x] = true;
        while(!queue.isEmpty()) {
            Point poll = queue.poll();

            for(int i=0; i<4; i++) {
                int ny = poll.y + dy[i];
                int nx = poll.x + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(!visited[ny][nx] && map[ny][nx] != 'X') {
                    if(map[ny][nx] == 'P') result++;
                    queue.add(new Point(ny, nx));
                    visited[ny][nx] = true;
                }
            }
        }
    }

    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
