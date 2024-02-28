import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] map = new int[n][n];
        int max = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > max) {
                    max = map[i][j];
                }
            }
        }

        int[] result = new int[max+1];

        for(int i=0; i<=max; i++) {
            boolean[][] visited = new boolean[n][n];
            for(int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    Queue<Point> queue = new LinkedList<>();
                    if (map[j][k] > i && !visited[j][k]) {
                        queue.add(new Point(j, k));
                        visited[j][k] = true;
                        result[i]++;

                        while (!queue.isEmpty()) {
                            Point poll = queue.poll();
                            int y = poll.y;
                            int x = poll.x;

                            for (int a = 0; a < 4; a++) {
                                int ny = y + dy[a];
                                int nx = x + dx[a];

                                if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                                if (map[ny][nx] > i && !visited[ny][nx]) {
                                    queue.add(new Point(ny, nx));
                                    visited[ny][nx] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        int answer = Arrays.stream(result).max().getAsInt();
        System.out.println(answer);
    }
    static class Point {
        int y, x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}