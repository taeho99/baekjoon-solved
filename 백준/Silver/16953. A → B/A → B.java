import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int result = 1;

        while(a != b) {
            if(a > b) {
                System.out.println(-1);
                return;
            }

            String s = String.valueOf(b);
            if(b % 2 == 0) {
                b /= 2;
            } else if (s.charAt(s.length()-1) == '1') {
                b = Integer.parseInt(s.substring(0, s.length()-1));
            } else {
                System.out.println(-1);
                return;
            }
            result++;
        }
        System.out.println(result);
    }
}
