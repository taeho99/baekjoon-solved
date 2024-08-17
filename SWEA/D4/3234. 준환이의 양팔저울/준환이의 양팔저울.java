import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 서로 다른 N개의 무게 추와 양팔 저울
 * 2. 무조건, left >= right (중간에도)
 * 3. 무게 추를 올리는 순서가 있음
 * 4. 무게 추를 올리는 모든 방법의 수
 */
public class Solution {
    static int ELEMENT_COUNT, SELECT_COUNT, totalCnt;
    static int[] elementList, selectList;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            sb.append('#').append(tc).append(' ');
            ELEMENT_COUNT = SELECT_COUNT = Integer.parseInt(br.readLine());
            elementList = new int[ELEMENT_COUNT];
            selectList = new int[SELECT_COUNT];
            visited = new boolean[ELEMENT_COUNT];
            totalCnt = 0;

            st = new StringTokenizer(br.readLine());
            for(int idx=0; idx<ELEMENT_COUNT; idx++) {
                elementList[idx] = Integer.parseInt(st.nextToken());
            }

            permutation(0);
            sb.append(totalCnt).append('\n');
        }
        System.out.print(sb);
    }

    private static void permutation(int selectIdx) {
        if(selectIdx == SELECT_COUNT) {
            powerSet(0, 0, 0);
            return;
        }

        for(int elementIdx=0; elementIdx<ELEMENT_COUNT; elementIdx++) {
            if(visited[elementIdx]) continue;

            visited[elementIdx] = true;
            selectList[selectIdx] = elementList[elementIdx];
            permutation(selectIdx + 1);
            visited[elementIdx] = false;
        }
    }

    private static void powerSet(int selectIdx, int left, int right) {
        if(left < right) return;
        if(selectIdx == SELECT_COUNT) {
            totalCnt++;
            return;
        }
        powerSet(selectIdx + 1, left + selectList[selectIdx], right);
        powerSet(selectIdx + 1, left, right + selectList[selectIdx]);
    }

}
