import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String s; int cnt=1;
        while (!(s = br.readLine()).equals("0 0 0")) {
            st = new StringTokenizer(s);
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            System.out.println("Case " + cnt++ + ": " + ((L*(V/P)) + (Math.min(V%P, L))));
        }
    }
}
