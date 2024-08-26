import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  SWEA.1868 파핑파핑지뢰찾기
 *
 *  1. 맵의 크기와 데이터를 입력받는다.
 *      1-1. 지뢰가 있는 곳은 -1, 지뢰가 없으면 0을 입력받는다.
 *  2. 주변에 있는 지뢰의 개수를 계산하여 맵에 넣는다.
 *      2-1. 현재 칸이 지뢰인 경우는 제외한다.
 *  3. 가장 최소 횟수로 클릭하려면 0인 곳 먼저 클릭해야 하므로 방문하지 않았으면서 0인 곳에서 BFS 탐색한다.
 *      3-1. 만약 주변에 지뢰가 있다면 현재 위치의 주변은 탐색하지 않는다.
 *  4. 이제 방문체크를 안했는데 지뢰가 없는 곳을 모두 클릭해준다.
 *  5. 최소 클릭 횟수를 출력한다.
 */
public class Solution {
    static int[][] map;
    static int size;
    static boolean[][] visited;
    static int[] dRow = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dCol = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            sb.append('#').append(tc).append(' ');

            // 1. 맵의 크기와 데이터를 입력받는다.
            size = Integer.parseInt(br.readLine());
            map = new int[size][size];
            for(int row=0; row<size; row++) {
                String tmp = br.readLine();
                for(int col=0; col<size; col++) {
                    char ch = tmp.charAt(col);
                    // 1-1. 지뢰가 있는 곳은 -1, 지뢰가 없으면 0을 입력받는다.
                    map[row][col] = ch == '*' ? -1 : 0;
                }
            }

            // 2. 주변에 있는 지뢰의 개수를 계산하여 맵에 넣는다.
            for(int row=0; row<size; row++) {
                for(int col=0; col<size; col++) {
                    // 2-1. 현재 칸이 지뢰인 경우는 제외한다.
                    if(map[row][col] == -1) continue;
                    map[row][col] = bomb(row, col);
                }
            }

            // 3. 가장 최소 횟수로 클릭하려면 0인 곳 먼저 클릭해야 하므로 방문하지 않았으면서 0인 곳에서 BFS 탐색한다.
            visited = new boolean[size][size];
            int result = 0;
            for(int row=0; row<size; row++) {
                for(int col=0; col<size; col++) {
                    if(visited[row][col] || map[row][col] != 0) continue;
                    bfs(row,col);
                    result++;
                }
            }

            // 4. 이제 방문체크를 안했는데 지뢰가 없는 곳을 모두 클릭해준다.
            for(int row=0; row<size; row++) {
                for(int col=0; col<size; col++) {
                    if(!visited[row][col] && map[row][col] != -1) result++;
                }
            }

            // 5. 최소 클릭 횟수를 출력한다.
            sb.append(result).append('\n');
        }
        System.out.print(sb);
    }

    private static int bomb(int row, int col) {
        int cnt = 0;
        for(int dir=0; dir<8; dir++) {
            int nRow = row + dRow[dir];
            int nCol = col + dCol[dir];

            if(nRow < 0 || nRow >= size || nCol < 0 || nCol >= size || map[nRow][nCol] != -1) continue;
            cnt++;
        }
        return cnt;
    }

    static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col});
        visited[row][col] = true;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            // 3-1. 만약 주변에 지뢰가 있다면 현재 위치의 주변은 탐색하지 않는다.
            if(bomb(poll[0],poll[1]) > 0) continue;

            for(int dir=0; dir<8; dir++) {
                int nRow = poll[0] + dRow[dir];
                int nCol = poll[1] + dCol[dir];

                if(nRow < 0 || nRow >= size || nCol < 0 || nCol >= size) continue;

                if(!visited[nRow][nCol] && map[nRow][nCol] != -1) {
                    queue.add(new int[] {nRow, nCol});
                    visited[nRow][nCol] = true;
                }
            }
        }
    }
}