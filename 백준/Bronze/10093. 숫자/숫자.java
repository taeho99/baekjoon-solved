import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        if(a == b) {
            System.out.println(0);
            return;
        }

        if(a>b) {
            long tmp = a;
            a = b;
            b = tmp;
        }

        sb.append(b-a-1).append('\n');
        for(long idx=a+1; idx<b; idx++) {
            sb.append(idx).append(' ');
        }
        System.out.print(sb);
    }
}