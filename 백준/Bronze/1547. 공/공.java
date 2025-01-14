import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        boolean[] cup = new boolean[4];
        cup[1] = true;

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a == b) continue;
            boolean tmp = cup[a];
            cup[a] = cup[b];
            cup[b] = tmp;
        }

        for(int idx=1; idx<=3; idx++) {
            if(cup[idx]) System.out.print(idx);
        }
    }
}