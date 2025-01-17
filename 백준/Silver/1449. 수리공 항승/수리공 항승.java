import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        int tape = Integer.parseInt(st.nextToken());
        boolean pos[] = new boolean[1001];
        int result = 0;

        st = new StringTokenizer(br.readLine());
        while(cnt-- > 0) {
            pos[Integer.parseInt(st.nextToken())] = true;
        }

        for(int posIdx=1; posIdx<=1000; posIdx++) {
            if(pos[posIdx]) {
                result++;
                posIdx += tape-1;
            }
        }
        System.out.print(result);
    }
}