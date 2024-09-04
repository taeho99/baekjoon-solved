import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  BOJ.10026 적록색약
 *
 *  1. 맵의 크기와 정보 입력받기
 *  2. 모든 지점에서 BFS 돌면서 같은 구역 갯수 구하기
 *  3. 적록색약은 R==G로 느끼므로 G를 모두 R로 바꾸기
 *  4. 적록색약인 사람이 모든 지점에서 BFS 돌면서 같은 구역 갯수 구하기
 *  5. 출력하기
 */
public class Main {
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static int size;
    static char[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 1. 맵의 크기와 정보 입력받기
        size = Integer.parseInt(br.readLine());
        map = new char[size][size];
        for(int i=0; i<size; i++) {
            String tmp = br.readLine();
            for(int j=0; j<size; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }

        // 2. 모든 지점에서 BFS 돌면서 같은 구역 갯수 구하기
        sb.append(bfs()).append(' ');

        // 3. 적록색약은 R==G로 느끼므로 G를 모두 R로 바꾸기
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if (map[i][j] == 'G')
                    map[i][j] = 'R';
            }
        }

        // 4. 적록색약인 사람이 모든 지점에서 BFS 돌면서 같은 구역 갯수 구하기
        sb.append(bfs());

        // 5. 출력하기
        System.out.print(sb);
    }

    private static int bfs() {
        visited = new boolean[size][size];
        int answer = 0;
        for(int row=0; row<size; row++) {
            for(int col=0; col<size; col++) {
                if(visited[row][col]) continue;
                answer++;

                Queue<Point> queue = new LinkedList<>();
                queue.add(new Point(row, col, map[row][col]));
                visited[row][col] = true;

                while(!queue.isEmpty()) {
                    Point poll = queue.poll();

                    for(int dir=0; dir<4; dir++) {
                        int nRow = poll.row + dRow[dir];
                        int nCol = poll.col + dCol[dir];

                        if (nRow<0 || nRow>=size || nCol<0 || nCol>=size) continue;

                        if (map[nRow][nCol] == poll.color && !visited[nRow][nCol]) {
                            queue.add(new Point(nRow, nCol, map[nRow][nCol]));
                            visited[nRow][nCol] = true;
                        }
                    }
                }
            }
        }
        return answer;
    }

    static class Point {
        int row, col;
        char color;
        public Point(int row, int col, char color) {
            this.row = row;
            this.col = col;
            this.color = color;
        }
    }
}