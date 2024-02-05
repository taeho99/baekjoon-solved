import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); //가로
            int n = Integer.parseInt(st.nextToken()); //세로
            int k = Integer.parseInt(st.nextToken());
            int[][] map = new int[n][m];
            int result = 0;
            while(k-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if (map[i][j]==0) continue;
                    LinkedList<Point> queue = new LinkedList<>();
                    queue.add(new Point(i,j));
                    map[i][j]--;
                    while(!queue.isEmpty()) {
                        Point poll = queue.poll();

                        int[] dy = {1, -1, 0, 0};
                        int[] dx = {0, 0, 1, -1};
                        for(int l=0; l<4; l++) {
                            int ny = poll.y + dy[l];
                            int nx = poll.x + dx[l];
                            if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                            if (map[ny][nx] == 1) {
                                queue.add(new Point(ny,nx));
                                map[ny][nx]--;
                            }
                        }
                    }
                    result++;
                }
            }
            System.out.println(result);

        }
    }

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
