import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int aCnt = 0;
        for (char c : str.toCharArray()) {
            if(c == 'a') aCnt++;
        }

        int result = Integer.MAX_VALUE;
        for(int idx=0; idx<str.length(); idx++) {
            int bCnt = 0;
            for(int j=idx; j<idx+aCnt; j++) {
                if(str.charAt(j%str.length()) == 'b') bCnt++;
            }
            result = Math.min(result, bCnt);
        }

        System.out.print(result);
    }
}