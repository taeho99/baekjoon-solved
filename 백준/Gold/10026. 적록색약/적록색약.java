import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static char[][] map;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];

        for(int i=0; i<n; i++) {
            String tmp = br.readLine();
            for(int j=0; j<n; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }

        boolean[][] visited = new boolean[n][n];
        int answer_a = bfs(visited);

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if (map[i][j] == 'G')
                    map[i][j] = 'R';
            }
        }
        visited = new boolean[n][n];
        int answer_b = bfs(visited);

        System.out.print(answer_a + " ");
        System.out.print(answer_b);
    }

    private static int bfs(boolean[][] visited) {
        int answer = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if (!visited[i][j]) {
                    Queue<Point> queue = new LinkedList<>();
                    queue.add(new Point(i, j, map[i][j]));
                    visited[i][j] = true;
                    answer++;

                    while(!queue.isEmpty()) {
                        Point poll = queue.poll();
                        int y = poll.y;
                        int x = poll.x;
                        char color = poll.color;

                        for(int k=0; k<4; k++) {
                            int ny = y + dy[k];
                            int nx = x + dx[k];
                            if (ny<0 || ny>=n || nx<0 || nx>=n) continue;
                            if (map[ny][nx] == color && !visited[ny][nx]) {
                                queue.add(new Point(ny, nx, map[ny][nx]));
                                visited[ny][nx] = true;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }

    static class Point {
        int y, x;
        char color;
        public Point(int y, int x, char color) {
            this.y = y;
            this.x = x;
            this.color = color;
        }
    }
}
