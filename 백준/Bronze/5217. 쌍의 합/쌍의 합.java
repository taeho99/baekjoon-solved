import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int num = Integer.parseInt(br.readLine());
            int a = 1, b = num-a;

            sb.append("Pairs for ").append(num).append(": ");
            while(a < b) {
                sb.append(a++).append(' ').append(b--).append(", ");
            }
            if(sb.charAt(sb.length()-2) == ',') {
                sb.delete(sb.length()-2, sb.length());
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}