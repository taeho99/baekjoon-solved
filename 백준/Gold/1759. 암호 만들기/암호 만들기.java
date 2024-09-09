import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *     BOJ.1759 암호만들기
 *
 *    1. 글자 리스트에 글자 추가 / 모음, 자음 카운팅 
 *    2. 모음 개수 1개 미만 or 자음 개수 2개 미만 -> return
 *    3. 부분집합으로 돌리고 마지막 기저조건에서 모음 갯 1개 미만 or 자음 개수 2개 미만인거 걸러내기
 */
public class Main {
    static int moCnt, pwLen, elementCnt;
    static char[] elementList, selectList;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        pwLen = Integer.parseInt(st.nextToken());
        elementCnt = Integer.parseInt(st.nextToken());

        String tmp = br.readLine();
        elementList = new char[elementCnt];
        for(int idx=0; idx<elementCnt; idx++) {
            elementList[idx] = tmp.charAt(idx*2);
            if(isMo(elementList[idx])) moCnt++;
        }

        if(moCnt < 1 || (elementCnt-moCnt) < 2) return;

        Arrays.sort(elementList);
        selectList = new char[pwLen];
        combination(0, 0, 0, 0); // 부분집합으로 하면 elementCnt 만큼 나와서 조합으로 해야될듯?

        System.out.print(sb);
    }

    private static void combination(int elementIdx, int selectIdx, int moCnt, int jaCnt) {
        if(selectIdx == pwLen) {
            if(moCnt >= 1 && jaCnt >= 2) {
                for (char ch : selectList) {
                    sb.append(ch);
                }
                sb.append('\n');
            }
            return;
        }

        if(elementIdx == elementCnt) {
            return;
        }

        selectList[selectIdx] = elementList[elementIdx];
        if(isMo(selectList[selectIdx])) {
            combination(elementIdx + 1, selectIdx + 1, moCnt + 1, jaCnt);
        } else {
            combination(elementIdx + 1, selectIdx + 1, moCnt, jaCnt + 1);
        }

        selectList[selectIdx] = 0;
        combination(elementIdx + 1, selectIdx, moCnt, jaCnt);
    }

    static boolean isMo(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}