import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;
        while(!(s = br.readLine()).equals("0")) {
            int count = 0;
            int n = Integer.parseInt(s);
            for(int i=n+1; i<=2*n; i++) {
                if(isPrime(i)) count++;
            }
            sb.append(count).append('\n');
        }
        System.out.print(sb);
    }

    private static boolean isPrime(int n) {
        for(int i=2; i<=Math.sqrt(n); i++)
            if(n%i == 0)
                return false;
        return true;
    }
}
