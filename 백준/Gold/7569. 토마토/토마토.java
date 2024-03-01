import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dz = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dx = {0, 0, 0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int xSize = Integer.parseInt(st.nextToken());
        int ySize = Integer.parseInt(st.nextToken());
        int zSize = Integer.parseInt(st.nextToken());
        int[][][] map = new int[zSize][ySize][xSize];
        Queue<Point> queue = new LinkedList<>();
        int answer = 0;

        for(int i=0; i<zSize; i++) {
            for(int j=0; j<ySize; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<xSize; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1) {
                        queue.add(new Point(i, j, k));
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            int z = poll.z;
            int y = poll.y;
            int x = poll.x;

            for(int i=0; i<6; i++) {
                int nz = z + dz[i];
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (nz < 0 || nz >= zSize || ny < 0 || ny >= ySize || nx < 0 || nx >= xSize) continue;
                if (map[nz][ny][nx] == 0) {
                    queue.add(new Point(nz, ny, nx));
                    map[nz][ny][nx] = map[z][y][x] + 1;
                }
            }
        }

        for(int i=0; i<zSize; i++) {
            for(int j=0; j<ySize; j++) {
                for(int k=0; k<xSize; k++) {
                    if (map[i][j][k] == 0) {
                        System.out.print(-1);
                        return;
                    }
                    if (map[i][j][k] > answer) {
                        answer = map[i][j][k];
                    }
                }
            }
        }
        System.out.print(answer - 1);
    }

    static class Point {
        int z, y, x;

        public Point(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }
}
