import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] diff = {-1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;

            int[][] map = new int[h][w];
            boolean[][] visited = new boolean[h][w];
            int answer = 0;

            for(int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    Queue<Point> queue = new LinkedList<>();
                    if (map[i][j] == 1 && !visited[i][j]) {
                        answer++;
                        queue.add(new Point(i,j));
                        visited[i][j] = true;

                        while(!queue.isEmpty()) {
                            Point poll = queue.poll();
                            int y = poll.y;
                            int x = poll.x;

                            for(int a=0; a<3; a++) {
                                for(int b=0; b<3; b++) {
                                    int ny = y + diff[a];
                                    int nx = x + diff[b];

                                    if(ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
                                    if (map[ny][nx] == 1 && !visited[ny][nx]) {
                                        queue.add(new Point(ny, nx));
                                        visited[ny][nx] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(answer);
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
