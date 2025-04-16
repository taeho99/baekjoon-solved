import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int rowSize, colSize;
    static int[][] map, result;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        int startRow = 0, startCol = 0;

        map = new int[rowSize][colSize];
        result = new int[rowSize][colSize];

        for(int row=0; row<rowSize; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col=0; col<colSize; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
                if (map[row][col] == 2) {
                    startRow = row;
                    startCol = col;
                } else if (map[row][col] == 1) {
                    result[row][col] = -1;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rowSize][colSize];

        queue.add(new int[] {startRow, startCol, 0});
        visited[startRow][startCol] = true;

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();

            result[poll[0]][poll[1]] = poll[2];

            for(int dir=0; dir<4; dir++) {
                int nRow = poll[0] + dRow[dir];
                int nCol = poll[1] + dCol[dir];

                if (nRow < 0 || nRow >= rowSize || nCol < 0 || nCol >= colSize || visited[nRow][nCol] || map[nRow][nCol] == 0) {
                    continue;
                }

                queue.add(new int[] {nRow, nCol, poll[2] + 1});
                visited[nRow][nCol] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int row=0; row<rowSize; row++) {
            for(int col=0; col<colSize; col++) {
                sb.append(result[row][col]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}