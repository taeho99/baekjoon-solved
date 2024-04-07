import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0, sum = 0;
        for(int i=0; i<10; i++) {
            String[] s = br.readLine().split(" ");
            sum -= Integer.parseInt(s[0]);
            sum += Integer.parseInt(s[1]);
            max = Math.max(max, sum);
        }
        System.out.print(max);
    }
}
