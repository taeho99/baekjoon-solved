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
        int c = Integer.parseInt(st.nextToken());

        long result = pow(a, b, c);
        System.out.println(result);
    }

    static long pow(long a, long b, long c) {
        if(b == 1) {
            return a%c;
        }

        long temp = pow(a, b/2, c);
        if(b%2 == 1) {
            return (((temp*temp%c)%c)*(a%c))%c;
        }
        return (temp%c*temp%c)%c;
    }
}
