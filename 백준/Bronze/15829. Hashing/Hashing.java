import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1234567891;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        long sum = 0;
        for(int i = 0; i<n; i++) {
            long r = 1;
            for(int j=0; j<i; j++) {
                r *= 31;
                r %= MOD;
            }
            sum += ((s.charAt(i) - 'a' + 1)% MOD * r% MOD)% MOD;
        }
        System.out.print(sum% MOD);
    }
}
