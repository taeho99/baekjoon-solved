import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int pisano = 1500000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine()) % pisano;
        long[] fibo = new long[pisano + 1];
        fibo[1] = 1;
        for(int i=2; i<=pisano; i++) {
            fibo[i] = (fibo[i-1] + fibo[i-2]) % 1000000;
        }
        System.out.println(fibo[(int)n]);
    }
}
