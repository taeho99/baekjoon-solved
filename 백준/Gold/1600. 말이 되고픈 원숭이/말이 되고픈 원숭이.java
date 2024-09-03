import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *    BOJ.1600 말이되고픈원숭이 
 *
 */
public class Main {
    static int rowSize, colSize, horseCnt;
    static int[][] map;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static int[] hRow = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] hCol = {-2, -1, 1, 2, -2, -1, 1, 2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        horseCnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        colSize = Integer.parseInt(st.nextToken());
        rowSize = Integer.parseInt(st.nextToken());

        map = new int[rowSize][colSize];
        for(int row=0; row<rowSize; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col=0; col<colSize; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }
    static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[horseCnt+1][rowSize][colSize];

        queue.add(new int[] {0, 0, 0, 0}); //row, col, 말움직임 cnt, 원숭이 움직임 cnt
        visited[0][0][0] = true;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int row = poll[0];
            int col = poll[1];
            int horseMoveCnt = poll[2];
            int monkeyMoveCnt = poll[3];
//            System.out.println(row + " " + col + " : " + horseMoveCnt + " " + monkeyMoveCnt);

            if(row == rowSize-1 && col == colSize-1) {
                return horseMoveCnt + monkeyMoveCnt;
            }


            // 원숭이로 움직이기
            for(int dir=0; dir<4; dir++) {
                int nRow = row + dRow[dir];
                int nCol = col + dCol[dir];

                if(nRow < 0 || nRow >= rowSize || nCol < 0 || nCol >= colSize || visited[horseMoveCnt][nRow][nCol] || map[nRow][nCol] == 1) continue;

                queue.add(new int[] {nRow, nCol, horseMoveCnt, monkeyMoveCnt + 1});
                visited[horseMoveCnt][nRow][nCol] = true;
            }

            // 말로 움직이기
            if(horseMoveCnt < horseCnt) {
                for(int dir=0; dir<8; dir++) {
                    int nRow = row + hRow[dir];
                    int nCol = col + hCol[dir];

                    if(nRow < 0 || nRow >= rowSize || nCol < 0 || nCol >= colSize || visited[horseMoveCnt + 1][nRow][nCol] ||  map[nRow][nCol] == 1) continue;

                    queue.add(new int[] {nRow, nCol, horseMoveCnt + 1, monkeyMoveCnt});
                    visited[horseMoveCnt + 1][nRow][nCol] = true;
                }
            }
        }

        return -1;
    }
}