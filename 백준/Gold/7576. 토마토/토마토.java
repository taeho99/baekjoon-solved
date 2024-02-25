import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        Queue<Point> queue = new LinkedList<>();
        int answer = 0;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    queue.add(new Point(i, j));
            }
        }

        while(!queue.isEmpty()) {
            Point poll = queue.poll();
            int y = poll.y;
            int x = poll.x;

            for(int i=0; i<4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if (map[ny][nx] == 0) {
                    queue.add(new Point(ny, nx));
                    map[ny][nx] = map[y][x] + 1;
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (map[i][j] == 0) {
                    System.out.print(-1);
                    return;
                }
                if (answer < map[i][j]) answer = map[i][j];
            }
        }
        System.out.print(answer - 1);
    }

    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
