import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        for(long i=Math.min(a, b); i<=a*b; i+=Math.min(a, b)) {
            if(i%a == 0 && i%b == 0) {
                System.out.print(i);
                return;
            }
        }
    }
}
