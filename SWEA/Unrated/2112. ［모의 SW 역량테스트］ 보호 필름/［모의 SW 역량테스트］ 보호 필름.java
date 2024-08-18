import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA.2112 보호 필름
 *
 * 1. rowSize*colSize 크기의 필름을 입력받는다.
 * 2. 최소 약품 개수와 현재 선택된 약품 배열을 선언 및 초기화한다.
 * 3. 약품 없음(-1), 약품 A(0), 약품 B(1)의 모든 경우를 확인한다. 현재 사용된 약품 개수(medicineCnt)도 확인한다.
 *      3-0. [기저조건]
 *          3-0-1. 현재 선택된 약품 개수보다 검사를 통과한 최소 약품 개수가 적다면 종료.
 *          3-0-2. 필름의 높이만큼 약품 투여 여부를 확인했다면 종료.
 *          3-0-3. 상태 검사를 통과했다면 최소 약품 개수 갱신.
 *      3-1. 현재 인덱스(selectIdx)에 약품이 없는 경우
 *      3-2. 현재 인덱스(selectIdx)에 약품이 A인 경우
 *      3-3. 현재 인덱스(selectIdx)에 약품이 B인 경우
 * 4. 약품 투입 여부를 모두 정했다면, 현재 필름이 검사를 통과할 수 있는지 확인한다.
 *      4-1. 현재 약품 특성과 다음 약품 특성을 비교하여 연속된 특성 개수를 cnt에 기록한다.
 *      4-2. 연속된 특성 개수가 합격 기준(K)를 넘으면 현재 현재 열은 통과한 것이다.
 *      4-3. 만약 통과하지 못한 열이 있으면 검사 실패이다.
 *      4-4. 모든 열이 기준을 통과했다면 검사 성공이다.
 * 5. 약품의 최소 투입 횟수를 출력한다.
 *
 * 약품이 2개가 사용된다면 [A, A], [A, B], [B, A], [B, B] 사용될 수 있다. -> 중복 가능한 수열
 * 약품이 투입될 위치를 정해야 한다.
 * D개 중 2개를 뽑아야 하므로 DC2 이다. 만약 DC2 로 성능 검사 합격 못하면 -> DC3, DC4, ... , DCD 까지 해야함
 */
public class Solution {
    static int rowSize, colSize, K;
    static int[][] map;
    static int[] selectMedicine;
    static int minMedicine;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            sb.append('#').append(tc).append(' ');
            st = new StringTokenizer(br.readLine().trim());
            rowSize = Integer.parseInt(st.nextToken());
            colSize = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[rowSize][colSize];

            // 1. rowSize*colSize 크기의 필름을 입력받는다.
            for(int row = 0; row< rowSize; row++) {
                st = new StringTokenizer(br.readLine().trim());
                for(int col = 0; col< colSize; col++) {
                    map[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            // 2. 최소 약품 개수와 현재 선택된 약품 배열을 선언 및 초기화한다.
            minMedicine = Integer.MAX_VALUE;
            selectMedicine = new int[rowSize];

            // 3. 약품 없음(-1), 약품 A(0), 약품 B(1)의 모든 경우를 확인한다. 현재 사용된 약품 개수(medicineCnt)도 확인한다.
            powerSet(0, 0);

            // 5. 약품의 최소 투입 횟수를 출력한다.
            sb.append(minMedicine).append('\n');
        }
        System.out.print(sb);
    }

    private static void powerSet(int elementIdx, int medicineCnt) {
        // 3-0. [기저조건]
        // 3-0-1. 현재 선택된 약품 개수보다 검사를 통과한 최소 약품 개수가 적다면 종료.
        if(medicineCnt >= minMedicine) return;
        // 3-0-2. 필름의 높이만큼 약품 투여 여부를 확인했다면 종료.
        if(elementIdx == rowSize) {
            // 3-0-3. 상태 검사를 통과했다면 최소 약품 개수 갱신.
            if(statusCheck()) {
                minMedicine = medicineCnt;
            }
            return;
        }

        // 3-1. 현재 인덱스(selectIdx)에 약품이 없는 경우
        selectMedicine[elementIdx] = -1;
        powerSet(elementIdx + 1, medicineCnt);

        // 3-2. 현재 인덱스(selectIdx)에 약품이 A인 경우
        selectMedicine[elementIdx] = 0;
        powerSet(elementIdx + 1, medicineCnt + 1);

        // 3-3. 현재 인덱스(selectIdx)에 약품이 B인 경우
        selectMedicine[elementIdx] = 1;
        powerSet(elementIdx + 1, medicineCnt + 1);
    }

    // 4. 약품 투입 여부를 모두 정했다면, 현재 필름이 검사를 통과할 수 있는지 확인한다.
    private static boolean statusCheck() {
        for(int col = 0; col< colSize; col++) {
            int cnt = 1;
            for(int row = 0; row< rowSize -1; row++) {
                // 4-1. 현재 약품 특성과 다음 약품 특성을 비교하여 연속된 특성 개수를 cnt에 기록한다.
                int now = selectMedicine[row] == -1 ? map[row][col] : selectMedicine[row];
                int next = selectMedicine[row+1] == -1 ? map[row+1][col] : selectMedicine[row+1];
                if(now == next) {
                    cnt++;
                    // 4-2. 연속된 특성 개수가 합격 기준(K)를 넘으면 현재 현재 열은 통과한 것이다.
                    if(cnt >= K) {
                        break;
                    }
                } else {
                    cnt = 1;
                }
            }
            // 4-3. 만약 통과하지 못한 열이 있으면 검사 실패이다.
            if(cnt < K) return false;
        }
        // 4-4. 모든 열이 기준을 통과했다면 검사 성공이다.
        return true;
    }
}