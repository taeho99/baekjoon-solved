import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        for(int i=1; i<n; i++) {
            int r2 = Integer.parseInt(st.nextToken());
            int gcd = r1, b = r2;
            while (b != 0) {
                int r = gcd % b;
                gcd = b;
                b = r;
            }
            System.out.println(r1/gcd + "/" + r2/gcd);
        }
    }
}
