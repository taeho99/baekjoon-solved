import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int t = 1; t<=10; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] height = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }

            int result = 0;
            for(int i=2; i<n-2; i++) {
                int maxLeft = Math.max(height[i-1], height[i-2]);
                int maxRight = Math.max(height[i+1], height[i+2]);
                int max = Math.max(maxLeft, maxRight);
                if(max < height[i])
                    result += height[i] - max;
            }
            System.out.println("#" + t + " " + result);
        }
    }
}
