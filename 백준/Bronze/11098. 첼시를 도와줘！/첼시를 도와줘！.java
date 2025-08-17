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
            int maxPrice = 0;
            String maxName = "";
            int playerCnt = Integer.parseInt(br.readLine());

            while(playerCnt-- > 0) {
                st = new StringTokenizer(br.readLine());
                int price = Integer.parseInt(st.nextToken());
                String name = st.nextToken();
                if(price > maxPrice) {
                    maxPrice = price;
                    maxName = name;
                }
            }

            sb.append(maxName).append('\n');
        }
        System.out.print(sb);
    }
}
