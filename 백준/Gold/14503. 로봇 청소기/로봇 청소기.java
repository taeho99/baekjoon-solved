import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int rowSize, colSize, nowRow, nowCol, nowDir;
    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nowRow = Integer.parseInt(st.nextToken());
        nowCol = Integer.parseInt(st.nextToken());
        nowDir = Integer.parseInt(st.nextToken());

        map = new int[rowSize][colSize];
        for(int row=0; row<rowSize; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col=0; col<colSize; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;

        while(true) {
            if (map[nowRow][nowCol] == 0) {
                map[nowRow][nowCol] = 2;
                cnt++;
            }

            boolean isAroundDirty = false;

            for(int dir=nowDir-1; dir>=nowDir-4; dir--) {
                int nDir = (dir + 4) % 4;
                int nRow = nowRow + dRow[nDir];
                int nCol = nowCol + dCol[nDir];

                if (map[nRow][nCol] == 0) {
                    isAroundDirty = true;
                    nowDir = nDir;
                    nowRow = nRow;
                    nowCol = nCol;
                    break;
                }
            }

            if (!isAroundDirty) {
                int nDir = (nowDir + 2) % 4;
                int nRow = nowRow + dRow[nDir];
                int nCol = nowCol + dCol[nDir];

                if (map[nRow][nCol] == 1) break;

                nowRow = nRow;
                nowCol = nCol;
            }
        }
        System.out.println(cnt);
    }
}