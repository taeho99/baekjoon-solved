import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *  SWEA.1767 프로세서연결하기
 *
 *  1. 맵의 크기와 프로세서의 위치를 입력받는다.
 *      1-1. coreList에 프로세서를 저장한다. 단, 맵의 테두리에 붙어있는 프로세서는 이미 연결되었으므로 제외.
 *  2. 최대한 많은 코어를 연결해야 하므로 모든 코어를 선택 후 전선의 길이를 구해보고, 연결할 수 없으면 코어를 1개씩 줄이면서 전선의 길이를 구해본다.
 *      2-1. 만약, 현재 선택된 코어들로 전선 연결이 가능하다면, 더 이상 확인하지 않고 중단한다.
 *  3. 코어 ELEMENT_COUNT개 중, SELECT_COUNT개 선택
 *      3-1. [기저조건] 코어가 SELECT_COUNT개 만큼 선택이 완료되었으면, 현재 선택된 코어들로 connect() 메서드에서 전선이 연결이 가능한지 확인해본다.
 *  4. 선택된 각 코어들로 전선을 연결
 *      4-1. [기저조건] 모든 코어들의 전선 연결 여부를 확인했으면 minResult 값을 갱신하고 종료한다.
 *      4-2. 상,하,좌,우 4방향으로 현재 코어에 전선을 연결해본다.
 *      4-3. 전선의 길이를 1씩 증가
 *          4-3-1. 전선이 맵 테두리에 닿았으면 연결 성공이므로 break
 *          4-3-2. 전선을 설치할 위치에 다른 코어가 있거나 전선이 있으면 break
 *          4-3-3. 전선을 설치한 위치에는 맵에 2라고 표시하기
 *          4-3-4. 전선의 길이 +1 하여 현재 전선길이 갱신해주기
 *      4-4. 만약 코어에 전선 연결이 성공했으면 다음 코어에 전선을 연결하러 떠나기
 *      4-5. 연결한 전선 복구해주기(다른 방향도 확인해봐야 하므로)
 *          4-5-1. 복구하다가 현재 코어의 위치까지 오면 break
 *  5. 전선 길이의 합이 갱신되었다면 정답이므로 출력한다.
 */
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

            // 1. 맵의 크기와 프로세서의 위치를 입력받는다.
            MAP_SIZE = Integer.parseInt(br.readLine().trim());
            map = new int[MAP_SIZE][MAP_SIZE];
            coreList = new ArrayList<>();
            minResult = Integer.MAX_VALUE;

            for(int row=0; row<MAP_SIZE; row++) {
                st = new StringTokenizer(br.readLine().trim());
                for(int col=0; col<MAP_SIZE; col++) {
                    if(st.nextToken().equals("1")) {
                        // 1-1. coreList에 프로세서를 저장한다. 단, 맵의 테두리에 붙어있는 프로세서는 이미 연결되었으므로 제외.
                        map[row][col] = 1;
                        if(row == 0 || col == 0 || row == MAP_SIZE-1 || col == MAP_SIZE-1) continue;
                        coreList.add(new Core(row, col));
                    }
                }
            }

            ELEMENT_COUNT = coreList.size();
            // 2. 최대한 많은 코어를 연결해야 하므로 모든 코어를 선택 후 전선의 길이를 구해보고, 연결할 수 없으면 코어를 1개씩 줄이면서 전선의 길이를 구해본다.
            for(SELECT_COUNT=ELEMENT_COUNT; SELECT_COUNT >= 0; SELECT_COUNT--) {
                selectList = new Core[SELECT_COUNT];
                combination(0, 0);
                // 2-1. 만약, 현재 선택된 코어들로 전선 연결이 가능하다면, 더 이상 확인하지 않고 중단한다.
                if(minResult < Integer.MAX_VALUE) break;
            }

            // 5. 전선 길이의 합이 갱신되었다면 정답이므로 출력한다.
            sb.append(minResult).append('\n');
        }
        System.out.print(sb);
    }

    // 3. 코어 ELEMENT_COUNT개 중, SELECT_COUNT개 선택
    private static void combination(int elementIdx, int selectIdx) {
        // 3-1. [기저조건] 코어가 SELECT_COUNT개 만큼 선택이 완료되었으면, 현재 선택된 코어들로 connect() 메서드에서 전선이 연결이 가능한지 확인해본다.
        if(selectIdx == SELECT_COUNT) {
            connect(0, 0);
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

    // 4. 선택된 각 코어들로 전선을 연결
    private static void connect(int selectIdx, int wireLength) {
        // 4-1. [기저조건] 모든 코어들의 전선 연결 여부를 확인했으면 minResult 값을 갱신하고 종료한다.
        if(selectIdx == SELECT_COUNT) {
            minResult = Math.min(minResult, wireLength);
            return;
        }

        // 4-2. 상,하,좌,우 4방향으로 현재 코어에 전선을 연결해본다.
        for(int idx=0; idx<4; idx++) {
            int row = selectList[selectIdx].row;
            int col = selectList[selectIdx].col;
            int nowWireLength = 0;

            boolean success = false;
            // 4-3. 전선의 길이를 1씩 증가
            while(true) {
                row = row + dRow[idx];
                col = col + dCol[idx];
                // 4-3-1. 전선이 맵 테두리에 닿았으면 연결 성공이므로 break
                if(row < 0 || row >= MAP_SIZE || col < 0 || col >= MAP_SIZE) {
                    success = true;
                    break;
                }
                // 4-3-2. 전선을 설치할 위치에 다른 코어가 있거나 전선이 있으면 break
                if(map[row][col] != 0) break;
                // 4-3-3. 전선을 설치한 위치에는 맵에 2라고 표시하기
                map[row][col] = 2;
                // 4-3-4. 전선의 길이 +1 하여 현재 전선길이 갱신해주기
                nowWireLength++;
            }

            // 4-4. 만약 코어에 전선 연결이 성공했으면 다음 코어에 전선을 연결하러 떠나기
            if(success) {
                connect(selectIdx + 1, wireLength + nowWireLength);
            }

            // 4-5. 연결한 전선 복구해주기(다른 방향도 확인해봐야 하므로)
            while(true) {
                row = row - dRow[idx];
                col = col - dCol[idx];
                // 4-5-1. 복구하다가 현재 코어의 위치까지 오면 break
                if(row == selectList[selectIdx].row && col == selectList[selectIdx].col) break;
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