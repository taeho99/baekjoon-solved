import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 1. 규영이와 인영이가 1~18 적힌 카드를 9장씩 나누어 갖는다.
 * 2. 규영이 가진 카드는 고정. 인영이 가진 카드 조합은 9! 경우의 수 -> 조합
 * 3. 규영이와 인영이가 1R, 2R, ... , 9R 까지 진행해서 총점 계산 -> 규영이의 승리/패배 횟수 구하기
 * 풀이 전략.
 * 인영이가 가질 수 있는 카드 종류를 먼저 구해야 함
 * 인영이가 가진 카드에 대해 모든 경우의 수인 9P9 구하기
 * 1R~9R 까지 카드 값 비교를 통해 총점 계산 -> 규영이의 승리/패배 횟수 기록
 */
public class Solution {
    static final int ELEMENT_COUNT = 9, SELECT_COUNT = 9; // 9P9
    static boolean[] elementUsedCheckList;
    static int[] elementList;
    static int[] gyuCards, inCards;
    static int gyuWin, gyuLose;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            gyuCards = new int[ELEMENT_COUNT];
            inCards = new int[ELEMENT_COUNT];
            elementUsedCheckList = new boolean[ELEMENT_COUNT];
            elementList = new int[ELEMENT_COUNT];
            gyuWin = gyuLose = 0;

            // 규영이 카드와 중복되지 않는 인영이 카드를 뽑기 위한 set 선언 및 초기화
            Set<Integer> set = new HashSet<>();

            // 규영이 카드 입력
            st = new StringTokenizer(br.readLine());
            for(int idx = 0; idx< ELEMENT_COUNT; idx++) {
                gyuCards[idx] = Integer.parseInt(st.nextToken());
                // 규영이 카드를 set에 add
                set.add(gyuCards[idx]);
            }

            // 인영이 카드 목록 구하기
            int idx, cnt = 0;
            for(idx=1; idx<=ELEMENT_COUNT*2; idx++) {
                // idx = 1~18 까지 돌면서 set에 없는 (규영이한테 없는) 카드를 인영이 카드 목록에 추가
                if(!set.contains(idx)) {
                    inCards[cnt++] = idx;
                }
            }

            // 인영이 카드 permutation (9P9)
            permutation(0);
            sb.append('#').append(tc).append(' ').append(gyuWin).append(' ').append(gyuLose).append('\n');
        }
        System.out.print(sb);
    }

    public static void permutation(int selectIdx) {
        if(selectIdx == SELECT_COUNT) {
            // selectIdx가 9가 되면 뽑기가 다 된것이므로 규영이 스코어 계산로직 실행
            calcScore();
            return;
        }

        for(int elementIdx = 0; elementIdx < ELEMENT_COUNT; elementIdx++) {
            if(elementUsedCheckList[elementIdx]) continue; // 이미 방문한 인덱스면 continue

            elementUsedCheckList[elementIdx] = true;
            elementList[selectIdx] = inCards[elementIdx]; // 인영이 카드 목록에서 하나를 뽑아 elementList에 대입
            permutation(selectIdx + 1);
            elementUsedCheckList[elementIdx] = false;
        }
    }

    private static void calcScore() {
        int gyuScore = 0, inScore = 0; // 규영이 스코어, 인영이 스코어
        for(int idx = 0; idx < ELEMENT_COUNT; idx++) {
            // 규영이 카드값이 더 크면 -> 규영이 스코어 += 두 카드의 합
            if(gyuCards[idx] > elementList[idx]) {
                gyuScore += (gyuCards[idx] + elementList[idx]);
            }
            // 인영이 카드값이 더 크면 -> 인영이 스코어 += 두 카드의 합
            else {
                inScore += (gyuCards[idx] + elementList[idx]);
            }
        }

        // 규영이 스코어가 더 높으면 규영이 승리횟수 증가
        // 인영이 스코어가 더 높으면 규영이 패배횟수 증가
        if(gyuScore > inScore) {
            gyuWin++;
        } else if(gyuScore < inScore) {
            gyuLose++;
        }
    }
}
