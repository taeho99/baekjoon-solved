import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        long sum = 0;
        for(int i=0; i<n; i++) {
            sum += (s.charAt(i) - 'a' + 1)*(long)Math.pow(31, i);
        }
        System.out.print(sum%1234567891);
    }
}
