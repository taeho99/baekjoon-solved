import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int answer = 0;

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                boolean check1 = false;
                boolean check2 = false;

                if(Math.pow(startX - x, 2) + Math.pow(startY - y, 2) <= Math.pow(r, 2))
                    check1 = true;
                if(Math.pow(endX - x, 2) + Math.pow(endY - y, 2) <= Math.pow(r, 2))
                    check2 = true;
                if(check1 != check2) answer++;
            }
            sb.append(answer).append('\n');
        }
        System.out.print(sb);
    }
}
