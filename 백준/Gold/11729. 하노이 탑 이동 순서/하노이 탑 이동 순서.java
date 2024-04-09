import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger count = new BigInteger("2");
        sb.append(count.pow(n).subtract(new BigInteger("1"))).append('\n');

        if(n <= 20) {
            hanoi(n, 1, 2, 3);
        }
        System.out.print(sb);
    }

    static void hanoi(int n, int a, int b, int c) {
        if(n == 1) {
            sb.append(a).append(' ').append(c).append('\n');
        } else {
            hanoi(n-1, a, c, b);
            sb.append(a).append(' ').append(c).append('\n');
            hanoi(n-1, b, a, c);
        }
    }
}
