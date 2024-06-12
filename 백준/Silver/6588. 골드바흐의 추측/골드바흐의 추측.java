import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean[] primeNumber = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        findPrimeNumber();

        String s;
        while(!(s = br.readLine()).equals("0")) {
            int n = Integer.parseInt(s);
            boolean check = false;
            for(int i=n-1; i>=0; i--) {
                if(primeNumber[i] && primeNumber[n-i]) {
                    sb.append(n).append(" = ").append(n - i).append(" + ").append(i).append('\n');
                    check = true;
                    break;
                }
            }
            if(!check) {
                sb.append("Goldbach's conjecture is wrong.").append('\n');
            }
        }
        System.out.print(sb);
    }

    private static void findPrimeNumber() {
        Arrays.fill(primeNumber, true);
        primeNumber[0] = primeNumber[1] = false;
        for(int i=2; i*i<primeNumber.length; i++) {
            if(primeNumber[i]) {
                for(int j=i*i; j< primeNumber.length; j+=i) {
                    primeNumber[j] = false;
                }
            }
        }
    }
}
