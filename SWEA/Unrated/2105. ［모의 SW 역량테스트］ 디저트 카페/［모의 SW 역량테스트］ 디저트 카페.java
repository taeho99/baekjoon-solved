import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  SWEA.2105 디저트카페
 *
 *  1. 맵의 크기와 디저트 종류를 입력받는다.
 *  2. 디저트 카페 투어가 가능한 지점에서만 투어를 시작한다.
 *      2-1. 이미 맛본 디저트 종류를 기록할 boolean 배열을 초기화한다.
 *      2-2. 시작 지점을 미리 저장해준다. (startRow, startCol)
 *      2-3. 예제처럼 반시계 방향으로 디저트 투어를 한다. (dir: 0부터 시작)
 *  3. 반시계 방향으로 디저트 투어를 한다.
 *      3-1. 다음 위치가 배열 범위를 벗어나면 제외
 *      3-2. 이전 위치로 되돌아간 경우 제외
 *      3-3. 이미 맛본 디저트 종류면은 제외
 *      3-4. 시작지점으로 되돌아 왔으면 result값 갱신!
 *      3-5. 현재 위치의 디저트를 먹었다 표시하고 다음 디저트 카페 투어 시작
 *      3-6. 현재 위치의 디저트 먹었다 표시 원상복귀
 *  4. 가장 많이 먹은 디저트 종류 수를 출력한다.
 */
public class Solution {
    static int size, result, startRow, startCol;
    static int[][] map;
    static boolean[] isEat;
    static int[] dRow = {1, 1, -1, -1}; // 오른아래, 왼아래, 왼위, 오른위
    static int[] dCol = {1, -1, -1, 1};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<=T; tc++) {
            sb.append('#').append(tc).append(' ');

            // 1. 맵의 크기와 디저트 종류를 입력받는다.
            size = Integer.parseInt(br.readLine().trim());
            map = new int[size][size];

            for(int row=0; row<size; row++) {
                st = new StringTokenizer(br.readLine().trim());
                for(int col=0; col<size; col++) {
                    map[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            // 2. 디저트 카페 투어가 가능한 지점에서만 투어를 시작한다.
            result = -1;
            for(int row=0; row<size-2; row++) {
                for(int col=1; col<size-1; col++) {
                    // 2-1. 이미 맛본 디저트 종류를 기록할 boolean 배열을 초기화한다.
                    isEat = new boolean[101];
                    // 2-2. 시작 지점을 미리 저장해준다. (startRow, startCol)
                    startRow = row; startCol = col;
                    // 2-3. 예제처럼 반시계 방향으로 디저트 투어를 한다. (dir: 0부터 시작)
                    dfs(row, col,  -1, -1, 0, 0);
                }
            }

            // 4. 가장 많이 먹은 디저트 종류 수를 출력한다.
            sb.append(result).append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int row, int col, int prevRow, int prevCol, int dir, int depth) {
        // 3. 반시계 방향으로 디저트 투어를 한다.
        for(int d=dir; d<4; d++) {
            int nRow = row + dRow[d];
            int nCol = col + dCol[d];

            // 3-1. 다음 위치가 배열 범위를 벗어나면 제외
            if(nRow < 0 || nRow >= size || nCol < 0 || nCol >= size) continue;
            // 3-2. 이전 위치로 되돌아간 경우 제외
            if(nRow == prevRow && nCol == prevCol) continue;
            // 3-3. 이미 맛본 디저트 종류면은 제외
            if(isEat[map[nRow][nCol]]) continue;

            // 3-4. 시작지점으로 되돌아 왔으면 result값 갱신!
            if(nRow == startRow && nCol == startCol) {
                result = Math.max(result, depth + 1);
                return;
            }

            // 3-5. 현재 위치의 디저트를 먹었다 표시하고 다음 디저트 카페 투어 시작
            isEat[map[nRow][nCol]] = true;
            dfs(nRow, nCol, row, col, d, depth + 1);
            // 3-6. 현재 위치의 디저트 먹었다 표시 원상복귀
            isEat[map[nRow][nCol]] = false;
        }
    }
}