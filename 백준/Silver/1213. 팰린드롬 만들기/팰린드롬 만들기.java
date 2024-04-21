import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        int[] alpha = new int[26];
        for(int i=0; i<s.length(); i++) {
            alpha[s.charAt(i) - 'A']++;
        }

        int odd = 0;
        char mid = '0';
        StringBuilder front = new StringBuilder();
        StringBuilder end = new StringBuilder();
        for(int i=0; i<alpha.length; i++) {
            if(alpha[i] != 0 && alpha[i]%2 == 1) {
                odd++;
                if(odd == 2) {
                    sb.append("I'm Sorry Hansoo");
                    break;
                }
                mid = (char) ('A' + i);
            }

            for(int j=0; j<alpha[i]/2; j++) {
                front.append((char)('A' + i));
                end.insert(0, (char)('A' + i));
            }
        }

        if(odd != 2) {
            if(mid == '0')
                sb.append(front).append(end);
            else
                sb.append(front).append(mid).append(end);
        }
        System.out.print(sb);
    }
}
