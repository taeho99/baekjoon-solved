import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static int MAP_SIZE, ELEMENT_COUNT, SELECT_COUNT, minResult;
    static int[][] map;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    static ArrayList<Core> coreList;
    static Core[] selectList;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        for(int tc=1; tc<=T; tc++) {
            sb.append('#').append(tc).append(' ');
            MAP_SIZE = Integer.parseInt(br.readLine().trim());
            map = new int[MAP_SIZE][MAP_SIZE];
            coreList = new ArrayList<>();
            minResult = Integer.MAX_VALUE;

            for(int row=0; row<MAP_SIZE; row++) {
                st = new StringTokenizer(br.readLine().trim());
                for(int col=0; col<MAP_SIZE; col++) {
                    if(st.nextToken().equals("1")) {
                        map[row][col] = 1;
                        if(row == 0 || col == 0 || row == MAP_SIZE-1 || col == MAP_SIZE-1) continue;
                        coreList.add(new Core(row, col));
                    }
                }
            }
            ELEMENT_COUNT = coreList.size();
            for(SELECT_COUNT=ELEMENT_COUNT; SELECT_COUNT >= 0; SELECT_COUNT--) {
                selectList = new Core[SELECT_COUNT];
                combination(0, 0);
                if(minResult < Integer.MAX_VALUE) break;
            }

            sb.append(minResult).append('\n');
        }
        System.out.print(sb);
    }

    private static void combination(int elementIdx, int selectIdx) {
        if(selectIdx == SELECT_COUNT) {
            dfs(0, 0);
            return;
        }

        if(elementIdx == ELEMENT_COUNT) {
            return;
        }

        selectList[selectIdx] = coreList.get(elementIdx);
        combination(elementIdx + 1, selectIdx + 1);

        selectList[selectIdx] = null;
        combination(elementIdx + 1, selectIdx);
    }

    private static void dfs(int selectIdx, int wireLength) {
        if(selectIdx == SELECT_COUNT) {
            minResult = Math.min(minResult, wireLength);
            return;
        }

        for(int idx=0; idx<4; idx++) {
            int row = selectList[selectIdx].row;
            int col = selectList[selectIdx].col;
            int nowWireLength = 0;

            boolean success = false;
            while(true) {
                row = row + dRow[idx];
                col = col + dCol[idx];
                if(row < 0 || row >= MAP_SIZE || col < 0 || col >= MAP_SIZE) {
                    success = true;
                    break;
                }
                if(map[row][col] != 0) break;
                map[row][col] = 2;
                nowWireLength++;
            }
            if(success) {
                dfs(selectIdx + 1, wireLength + nowWireLength);
            }
            while(true) {
                row = row - dRow[idx];
                col = col - dCol[idx];
                if(row == selectList[selectIdx].row && col == selectList[selectIdx].col) {
                    break;
                }
                map[row][col] = 0;
            }
        }
    }

    static class Core {
        int row, col;

        public Core(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}