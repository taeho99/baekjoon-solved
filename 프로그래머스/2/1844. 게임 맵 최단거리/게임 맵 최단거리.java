import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        queue.add(new Point(0, 0));
        visited[0][0] = true;
        while(!queue.isEmpty()) {
            Point poll = queue.poll();
            int y = poll.y;
            int x = poll.x;
            if(y == (maps.length - 1) && x == (maps[0].length - 1))
                return maps[y][x];

            for(int i=0; i<4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || ny >= maps.length || nx < 0 || nx >= maps[0].length) continue;
                if(!visited[ny][nx] && maps[ny][nx] >= 1) {
                    queue.add(new Point(ny, nx));
                    visited[ny][nx] = true;
                    maps[ny][nx] = maps[y][x] + 1;
                }
            }
        }
        return -1;
    }
    class Point {
        int y, x;
        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}