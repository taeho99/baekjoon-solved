import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * SWEA.5215 햄버거다이어트_NextPermutation
 *
 * 1. 햄버거 재료의 점수와 칼로리 정보를 입력받는다.
 * 2. 가능한 재료의 조합을 1개~ELEMENT_COUNT개 모두 확인한다.
 *      2-1. selectList[]에는 선택되는 재료를 [0, 0, 1, 1, 0] 과같은 형식으로 저장된다.
 *      2-2. NextPermutation을 사용하기 위해 미리 오름차순으로 선택되는 재료를 저장한다.
 * 3. 재료를 조합 후 제한 칼로리를 초과하지 않는 재료의 점수의 합을 구한다.
 *      3-1. 현재 selectList[idx]가 선택된 재료라면 점수의 합과 칼로리의 합을 구한다.
 *      3-2. 칼로리의 합이 제한 칼로리를 넘으면 중단한다.
 *      3-3. 모든 점수의 합이 칼로리를 넘지 않는 경우 maxScore를 갱신한다.
 * 4. 최대 조합 가능한 재료의 점수의 합을 출력한다.
 */
public class Solution {
    static int ELEMENT_COUNT, SELECT_COUNT, MAX_CALORIE, maxScore;
    static int[] selectList, calorieList, scoreList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            sb.append('#').append(tc).append(' ');
            st = new StringTokenizer(br.readLine());
            ELEMENT_COUNT = Integer.parseInt(st.nextToken());
            MAX_CALORIE = Integer.parseInt(st.nextToken());

            scoreList = new int[ELEMENT_COUNT];
            calorieList = new int[ELEMENT_COUNT];

            // 1. 햄버거 재료의 점수와 칼로리 정보를 입력받는다.
            for(int elementIdx=0; elementIdx<ELEMENT_COUNT; elementIdx++) {
                st = new StringTokenizer(br.readLine());
                scoreList[elementIdx] = Integer.parseInt(st.nextToken());
                calorieList[elementIdx] = Integer.parseInt(st.nextToken());
            }

            maxScore = 0; // 최고 점수를 저장하는 변수 선언
            // 2. 가능한 재료의 조합을 1개~ELEMENT_COUNT개 모두 확인한다.
            for(SELECT_COUNT=1; SELECT_COUNT<=ELEMENT_COUNT; SELECT_COUNT++) {
                // 2-1. selectList[]에는 선택되는 재료를 [0, 0, 1, 1, 0] 과같은 형식으로 저장된다.
                selectList = new int[ELEMENT_COUNT];
                // 2-2. NextPermutation을 사용하기 위해 미리 오름차순으로 선택되는 재료를 저장한다.
                for(int selectIdx=ELEMENT_COUNT-1; selectIdx>=ELEMENT_COUNT-SELECT_COUNT; selectIdx--) {
                    selectList[selectIdx] = 1;
                }

                do {
                    // 3. 재료를 조합 후 제한 칼로리를 초과하지 않는 재료의 점수의 합을 구한다.
                    calcScore();
                } while(np(selectList));
            }

            // 4. 최대 조합 가능한 재료의 점수의 합을 출력한다.
            sb.append(maxScore).append('\n');
        }
        System.out.print(sb);
    }

    static void calcScore() {
        int sumScore = 0;
        int sumCalorie = 0;
        for(int selectIdx=0; selectIdx<ELEMENT_COUNT; selectIdx++) {
            // 3-1. 현재 selectList[idx]가 선택된 재료라면 점수의 합과 칼로리의 합을 구한다.
            if(selectList[selectIdx] == 1) {
                sumScore += scoreList[selectIdx];
                sumCalorie += calorieList[selectIdx];
            }
            // 3-2. 칼로리의 합이 제한 칼로리를 넘으면 중단한다.
            if(sumCalorie > MAX_CALORIE) {
                return;
            }
        }
        // 3-3. 모든 점수의 합이 칼로리를 넘지 않는 경우 maxScore를 갱신한다.
        maxScore = Math.max(maxScore, sumScore);
    }

    static boolean np(int[] selectList) {
        int selectListSize = selectList.length;
        // step1) 꼭대기(i) 찾기
        int i = selectListSize-1;
        while(i>0 && selectList[i-1] >= selectList[i]) i--;
        if(i == 0) return false; // 낭떠러지. 다음 순열 없음

        // step2) 꼭대기 앞 교환위치에 교환할 값(i-1 위치 값보다 큰 값 중 가장 작은 값) 자리 찾기
        int j = selectListSize-1;
        while(selectList[i-1] >= selectList[j]) j--;

        // step3) 두 위치의 수 교환
        swap(selectList, i-1, j);

        // step4) 꼭대기부터 맨 뒤까지 오름차순의 형태로 만들기
        int k = selectListSize-1;
        while(i < k) {
            swap(selectList, i++, k--);
        }
        return true;
    }

    static void swap(int[] list, int a, int b) {
        int temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }

}
