import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int t=1; t<=testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            System.out.print("#" + t + " ");
            if(x < l) System.out.println(l - x);
            else if(x > u) System.out.println(-1);
            else System.out.println(0);
        }
    }
}
