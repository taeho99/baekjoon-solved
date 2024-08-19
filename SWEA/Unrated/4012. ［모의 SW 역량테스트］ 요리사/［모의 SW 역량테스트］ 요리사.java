import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA.4012 요리사
 *
 * 1. 재료의 개수(ELEMENT_COUNT)를 입력받고 각 요리당 재료 선택 개수(SELECT_COUNT)를 초기화한다.
 * 2. 각 재료간 발생하는 시너지를 입력으로 받는다.
 * 3. ELEMENT_COUNT개의 재료 중 SELECT_COUNT개의 재료로 요리를 만들 수 있는 조합을 탐색한다.
 *      3-0. [기저조건] SELECT_COUNT개의 재료가 선택되면 두 요리의 시너지 맛의 차이를 구해 minDiff를 갱신한다.
 *      3-1. 첫 번째 요리에 해당하는 재료를 true로 표시한다.
 *      3-2. 두 번째 요리에 해당하는 재료를 false로 표시한다.
 * 4. 한 요리에 들어가는 재료의 시너지 합을 구한다.
 *      4-1. 현재 요리에서 선택된 재료가 아니면 continue 한다.
 *      4-2. 시너지 테이블에서 대각선 데이터는 나와 나의 시너지를 나타내므로 continue 한다.
 *      4-3. 같은 요리에 선택된 재료면 시너지 합에 두 재료의 시너지를 더해준다.
 * 5. 4번과 같은 방식으로 두 번째 요리의 시너지 합도 구해준다.
 * 6. 재료의 조합에 따라 갱신된 두 요리의 맛의 차이의 최솟값을 출력한다.
 */
public class Solution {
    static int ELEMENT_COUNT, SELECT_COUNT, minDiff;
    static boolean[] selectIngredient;
    static int[][] synergy;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            sb.append('#').append(tc).append(' ');

            // 1. 재료의 개수(ELEMENT_COUNT)를 입력받고 각 요리당 재료 선택 개수(SELECT_COUNT)를 초기화한다.
            ELEMENT_COUNT = Integer.parseInt(br.readLine());
            SELECT_COUNT = ELEMENT_COUNT / 2;

            // 2. 각 재료간 발생하는 시너지를 입력으로 받는다.
            synergy = new int[ELEMENT_COUNT][ELEMENT_COUNT];
            selectIngredient = new boolean[ELEMENT_COUNT];
            for(int row=0; row<ELEMENT_COUNT; row++) {
                st = new StringTokenizer(br.readLine());
                for(int col=0; col<ELEMENT_COUNT; col++) {
                    synergy[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            minDiff = Integer.MAX_VALUE;
            // 3. ELEMENT_COUNT개의 재료 중 SELECT_COUNT개의 재료로 요리를 만들 수 있는 조합을 탐색한다.
            combination(0, 0);
            // 6. 재료의 조합에 따라 갱신된 두 요리의 맛의 차이의 최솟값을 출력한다.
            sb.append(minDiff).append('\n');
        }
        System.out.print(sb);
    }

    private static void combination(int elementIdx, int selectIdx) {
        // 3-0. [기저조건] SELECT_COUNT개의 재료가 선택되면 두 요리의 시너지 맛의 차이를 구해 minDiff를 갱신한다.
        if(selectIdx == SELECT_COUNT) {
            // 4. 한 요리에 들어가는 재료의 시너지 합을 구한다.
            int diff = Math.abs(getSynergyCook1() - getSynergyCook2());
            minDiff = Math.min(minDiff, diff);
            return;
        }
        if(elementIdx == ELEMENT_COUNT) {
            return;
        }

        // 3-1. 첫 번째 요리에 해당하는 재료를 true로 표시한다.
        selectIngredient[elementIdx] = true;
        combination(elementIdx + 1, selectIdx + 1);

        // 3-2. 두 번째 요리에 해당하는 재료를 false로 표시한다.
        selectIngredient[elementIdx] = false;
        combination(elementIdx + 1, selectIdx);
    }

    private static int getSynergyCook1() {
        int totalSynergy = 0;
        for(int row=0; row<ELEMENT_COUNT; row++) {
            // 4-1. 현재 요리에서 선택된 재료가 아니면 continue 한다.
            if(!selectIngredient[row]) continue;
            for(int col=0; col<ELEMENT_COUNT; col++) {
                // 4-2. 시너지 테이블에서 대각선 데이터는 나와 나의 시너지를 나타내므로 continue 한다.
                if(row == col) continue;
                // 4-3. 같은 요리에 선택된 재료면 시너지 합에 두 재료의 시너지를 더해준다.
                if(selectIngredient[col]) {
                    totalSynergy += synergy[row][col];
                }
            }
        }
        return totalSynergy;
    }

    // 5. 4번과 같은 방식으로 두 번째 요리의 시너지 합도 구해준다.
    private static int getSynergyCook2() {
        int totalSynergy = 0;
        for(int row=0; row<ELEMENT_COUNT; row++) {
            if(selectIngredient[row]) continue;
            for(int col=0; col<ELEMENT_COUNT; col++) {
                if(row == col) continue;
                if(!selectIngredient[col]) {
                    totalSynergy += synergy[row][col];
                }
            }
        }
        return totalSynergy;
    }
}
