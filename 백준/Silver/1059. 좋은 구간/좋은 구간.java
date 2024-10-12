import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int left = 0, right = 1000;
        for(int idx=0; idx<n; idx++) {
            int num = Integer.parseInt(st.nextToken());
            if(num == target) {
                System.out.println("0");
                return;
            }
            if(num < target) left = Math.max(left, num);
            else right = Math.min(right, num);
        }

        System.out.println((target-left)*(right-target)-1);
    }
}