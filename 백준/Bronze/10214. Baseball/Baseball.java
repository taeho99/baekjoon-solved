import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int yonsei = 0, korea = 0;
            for(int idx=0; idx<9; idx++) {
                st = new StringTokenizer(br.readLine());
                yonsei += Integer.parseInt(st.nextToken());
                korea += Integer.parseInt(st.nextToken());
            }
            sb.append(yonsei == korea ? "Draw" : (yonsei > korea ? "Yonsei" : "Korea")).append('\n');
        }
        System.out.print(sb);
    }
}
