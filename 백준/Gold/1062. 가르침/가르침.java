import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int ELEMENT_COUNT, SELECT_COUNT, result;
    static char[] elementList, selectList;
    static String[] words;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int wordsCnt = Integer.parseInt(st.nextToken());
        words = new String[wordsCnt];

        ELEMENT_COUNT = 26;
        SELECT_COUNT = Integer.parseInt(st.nextToken());

        for(int idx=0; idx<wordsCnt; idx++) {
            words[idx] = br.readLine();
        }

        if(SELECT_COUNT < 5) {
            System.out.println("0");
            return;
        }

        elementList = new char[]
                {'a','c','i','n','t','b','d','e','f','g','h','j','k','l','m',
                        'o','p','q','r','s','u','v','w','x','y','z'};
        selectList = new char[SELECT_COUNT];
        for(int idx=0; idx<5; idx++) {
            selectList[idx] = elementList[idx];
        }

        result = 0;
        combination(5, 5);
        System.out.println(result);
    }

    private static void combination(int elementIdx, int selectIdx) {
//        if(selectList[0] != 'a') return;
        if(selectIdx == SELECT_COUNT) {
            HashSet<Character> set = new HashSet<>();
            for (char ch : selectList) {
                set.add(ch);
            }

            int cnt = 0;
            for (String word : words) {
                if(isReadWord(word, set)) cnt++;
            }
            result = Math.max(result, cnt);
            return;
        }
        if(elementIdx == ELEMENT_COUNT) {
            return;
        }

        selectList[selectIdx] = elementList[elementIdx];
        combination(elementIdx + 1, selectIdx + 1);

        combination(elementIdx + 1, selectIdx);
    }

    private static boolean isReadWord(String word, HashSet<Character> set) {

        for (char ch : word.toCharArray()) {
            if (!set.contains(ch)) return false;
        }
        return true;
    }
}
