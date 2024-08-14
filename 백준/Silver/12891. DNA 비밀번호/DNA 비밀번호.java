import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ.12891 DNA 비밀번호 
 *
 * 1. 전체 문자열 길이(sLen), 부분 문자열 길이(pLen), {'A', 'C', 'G', 'T'}를 포함하는 전체 문자열을 입력으로 받는다.
 * 2. 각 문자가 등장해야 하는 최소 개수를 입력받는다.
 * 3-1. 가장 첫번째 부분 문자열의 DNA 등장 횟수를 nowFreq에 기록한다.
 * 3-2. 첫번째 부분 문자열이 최소 조건을 만족하는지 확인한다. 조건에 부합하면 result++ 한다.
 * 4-1. 슬라이딩 윈도우 방식으로 직전 문자열의 "가장 왼쪽 문자의 빈도를 -1", "가장 오른쪽 문자의 빈도를 +1" 한다.
 * 4-2. 다음 부분 문자열이 최소 조건을 만족하는지 확인한다. 조건에 부합하면 result++ 한다.
 * 5. 결과값을 출력한다.
 */
public class Main {
    static char[] dna = {'A', 'C', 'G', 'T'};
    static int[] minFreq, nowFreq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 전체 문자열 길이(sLen), 부분 문자열 길이(pLen), {'A', 'C', 'G', 'T'}를 포함하는 전체 문자열을 입력으로 받는다.
        int sLen = Integer.parseInt(st.nextToken());
        int pLen = Integer.parseInt(st.nextToken());
        char[] sStr = br.readLine().toCharArray();

        minFreq = new int[26]; // 최소 DNA 등장 개수
        nowFreq = new int[26]; // 입력된 DNA 등장 개수

        // 2. 각 문자가 등장해야 하는 최소 개수를 입력받는다.
        st = new StringTokenizer(br.readLine());
        for(int idx=0; idx<4; idx++) {
            minFreq[dna[idx] - 'A'] = Integer.parseInt(st.nextToken());
        }

        int result = 0; // 결과값

        // 3-1. 가장 첫번째 부분 문자열의 DNA 등장 횟수를 nowFreq에 기록한다.
        for(int pIdx=0; pIdx<pLen; pIdx++) {
            nowFreq[sStr[pIdx] - 'A']++;
        }
        // 3-2. 첫번째 부분 문자열이 최소 조건을 만족하는지 확인한다. 조건에 부합하면 result++ 한다.
        if(isDNA()) result++;

        // 4-1. 슬라이딩 윈도우 방식으로 직전 문자열의 "가장 왼쪽 문자의 빈도를 -1", "가장 오른쪽 문자의 빈도를 +1" 한다.
        for(int pIdx=pLen; pIdx<sLen; pIdx++) {
            nowFreq[sStr[pIdx-pLen] - 'A']--;
            nowFreq[sStr[pIdx] - 'A']++;
            // 4-2. 다음 부분 문자열이 최소 조건을 만족하는지 확인한다. 조건에 부합하면 result++ 한다.
            if(isDNA()) result++;
        }

        // 5. 결과값을 출력한다.
        System.out.println(result);
    }

    // 3-2. 해당 부분 문자열의 nowFreq 배열이 완성되었으면, 최소 개수의 조건에 부합하는지 확인한다.
    private static boolean isDNA() {
        return nowFreq[dna[0]-'A'] >= minFreq[dna[0]-'A'] && nowFreq[dna[1]-'A'] >= minFreq[dna[1]-'A']
                && nowFreq[dna[2]-'A'] >= minFreq[dna[2]-'A'] && nowFreq[dna[3]-'A'] >= minFreq[dna[3]-'A'];
    }

}