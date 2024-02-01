import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] miro = new int[n][m];

        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                miro[i][j] = str.charAt(j) - '0';
            }
        }

        boolean[][] visited = new boolean[n][m];
        LinkedList<Point> queue = new LinkedList<>();

        visited[0][0] = true;
        queue.add(new Point(0, 0));

        while(queue.size() != 0) {
            Point poll = queue.poll();
            int y = poll.y;
            int x = poll.x;
            int[] dy = {1, -1, 0, 0};
            int[] dx = {0, 0, 1, -1};

            for(int i=0; i<4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m)
                    continue;
                if (miro[ny][nx] > 0 && !visited[ny][nx]) {
                    queue.add(new Point(ny, nx));
                    visited[ny][nx] = true;
                    miro[ny][nx] = miro[y][x] + 1;
                }
            }
        }
        System.out.println(miro[n-1][m-1]);
    }
}

class Point {
    int y;
    int x;

    Point(int y, int x) {
        this.x = x;
        this.y = y;
    }
}