import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=1; i<=t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int j = 0; j < 10; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                sum += tmp%2 == 1 ? tmp : 0;
            }
            System.out.println("#" + i + " " + sum);
        }
    }
}