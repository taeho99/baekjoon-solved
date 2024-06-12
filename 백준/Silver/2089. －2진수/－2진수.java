import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        if(n == 0) {
            System.out.print(0);
            return;
        }

        while(n != 0) {
            sb.append(Math.abs(n%-2));
            n = (int) Math.ceil((double) n / -2);
        }
        System.out.print(sb.reverse());
    }
}
