import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] result = new int[n][m];
        int startY = 0, startX = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    startY = i;
                    startX = j;
                } else if (map[i][j] == 1) {
                    result[i][j] = -1;
                }
            }
        }

        boolean[][] visited = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(startY, startX));
        visited[startY][startX] = true;
        result[startY][startX] = 0;
        while(!queue.isEmpty()) {
            Point poll = queue.poll();
            for(int i=0; i<4; i++) {
                int ny = poll.y + dy[i];
                int nx = poll.x + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

                if(map[ny][nx] == 1 && !visited[ny][nx]) {
                    queue.add(new Point(ny, nx));
                    visited[ny][nx] = true;
                    result[ny][nx] = result[poll.y][poll.x] + 1;
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
