import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  BOJ.2178 미로탐색
 *
 *  1. 미로의 크기와 미로의 정보에 대해 입력받는다.
 *  2. 큐와 방문체크 배열을 이용해 (0,0)부터 BFS 탐색한다.
 *      2-1. 시작 위치의 칸을 큐에 넣고 방문 체크한다.
 *      2-2. 미로의 범위를 벗어났거나 이동할 수 없는 칸, 이미 방문한 칸은 제외한다.
 *      2-3. (이전 위치 값 + 1)을 다음 이동할 칸에 넣어 현재 몇번째 칸인지 미로에 입력한다.
 *  3. 도착 위치에 있는 칸의 값이 이동한 칸의 수이므로 출력한다.
 */
public class Main {
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 미로의 크기와 미로의 정보에 대해 입력받는다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());

        int[][] map = new int[rowSize][colSize];
        for(int row=0; row<rowSize; row++) {
            String tmp = br.readLine();
            for(int col=0; col<colSize; col++) {
                map[row][col] = tmp.charAt(col) - '0';
            }
        }

        // 2. 큐와 방문체크 배열을 이용해 (0,0)부터 BFS 탐색한다.
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[rowSize][colSize];

        // 2-1. 시작 위치의 칸을 큐에 넣고 방문 체크한다.
        queue.add(new int[] {0, 0});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();

            for(int dir=0; dir<4; dir++) {
                int nRow = poll[0] + dRow[dir];
                int nCol = poll[1] + dCol[dir];

                // 2-2. 미로의 범위를 벗어났거나 이동할 수 없는 칸, 이미 방문한 칸은 제외한다.
                if(nRow < 0 || nRow >= rowSize || nCol < 0 || nCol >= colSize || map[nRow][nCol] == 0 || visited[nRow][nCol]) continue;

                queue.add(new int[]{nRow, nCol});
                visited[nRow][nCol] = true;
                // 2-3. (이전 위치 값 + 1)을 다음 이동할 칸에 넣어 현재 몇번째 칸인지 미로에 입력한다.
                map[nRow][nCol] = map[poll[0]][poll[1]] + 1;
            }
        }

        // 3. 도착 위치에 있는 칸의 값이 이동한 칸의 수이므로 출력한다.
        System.out.print(map[rowSize-1][colSize-1]);
    }
}