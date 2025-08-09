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
            st = new StringTokenizer(br.readLine());
            float num = Float.parseFloat(st.nextToken());
            while(st.hasMoreTokens()) {
                String op = st.nextToken();
                switch (op) {
                    case "@":
                        num *= 3;
                        break;
                    case "%":
                        num += 5;
                        break;
                    case "#":
                        num -= 7;
                        break;
                }
            }
            sb.append(String.format("%.2f", num)).append('\n');
        }
        System.out.print(sb);
    }
}
