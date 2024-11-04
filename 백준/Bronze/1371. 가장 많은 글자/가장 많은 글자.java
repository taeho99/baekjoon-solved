import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] freq = new int[26];
        String s;
        while((s = br.readLine()) != null) {
            for (char c : s.toCharArray()) {
                if (Character.isLowerCase(c)) {
                    freq[c - 'a']++;
                }
            }
        }

        int max = 0;
        for(int idx=0; idx<26; idx++) {
            max = Math.max(max, freq[idx]);
        }

        for(int idx=0; idx<26; idx++) {
            if(freq[idx] == max) {
                System.out.print((char)('a' + idx));
            }
        }
    }
}