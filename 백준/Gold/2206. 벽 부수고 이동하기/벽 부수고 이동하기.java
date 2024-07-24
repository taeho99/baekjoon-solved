import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static class Point {
        int y, x, count;
        boolean isDestroy;

        public Point(int y, int x, int count, boolean isDestroy) {
            this.y = y;
            this.x = x;
            this.count = count;
            this.isDestroy = isDestroy;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            String in = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = in.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(0, 0, 1, false));
        visited[0][0][0] = true; // 0: 벽을 부수지 않은 상태 , 1: 벽을 부순 상태

        while (!queue.isEmpty()) {
            Point poll = queue.poll();

            if (poll.y == n - 1 && poll.x == m - 1) return poll.count;

            for (int i = 0; i < 4; i++) {
                int ny = poll.y + dy[i];
                int nx = poll.x + dx[i];

                if (ny >= n || ny < 0 || nx >= m || nx < 0) continue;

                //벽을 부순 적이 있다면,
                if (poll.isDestroy) {
                    if (map[ny][nx] == 0 && !visited[ny][nx][1]) {
                        visited[ny][nx][1] = true;
                        queue.add(new Point(ny, nx, poll.count + 1, true));
                    }
                } else { //벽을 부순 적이 없다면,
                    //벽이라면 벽을 부수고 이동한다.
                    if (map[ny][nx] == 1 && !visited[ny][nx][1]) {
                        visited[ny][nx][1] = true;
                        queue.add(new Point(ny, nx, poll.count + 1, true));
                    } else if (map[ny][nx] == 0 && !visited[ny][nx][0]) {
                        visited[ny][nx][0] = true;
                        queue.add(new Point(ny, nx, poll.count + 1, false));
                    }
                }
            }
        }
        return -1;

    }
}
