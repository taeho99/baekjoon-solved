import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[] freq = new int[26];
        String original = br.readLine();
        for (char ch : original.toCharArray()) {
            freq[ch-'A']++;
        }

        int result = 0;
        for(int idx=0; idx<size-1; idx++) {
            String target = br.readLine();
            if(Math.abs(target.length() - original.length()) >= 2) continue;
            int[] targetFreq = new int[26];

            for (char ch : target.toCharArray()) {
                targetFreq[ch-'A']++;
            }

            int diffSum = 0, diffCnt = 0;
            for(int i=0; i<26; i++) {
                if(freq[i] != targetFreq[i]) {
                    diffSum += Math.abs(freq[i] - targetFreq[i]);
                    diffCnt++;
                }
            }

            if(diffCnt == 0 || (diffCnt == 1 && diffSum == 1) || (diffCnt == 2 && diffSum == 2)) result++;
        }
        System.out.println(result);
    }
}