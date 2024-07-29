import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static final int totalCase = 10;
    static final int SIZE = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int testCase=1; testCase<=totalCase; testCase++) {
            br.readLine();
            int result = 0;

            int[][] map = new int[SIZE][SIZE];
            for(int row=0; row<SIZE; row++) {
                st = new StringTokenizer(br.readLine());
                int sum = 0;
                for(int col=0; col<SIZE; col++) {
                    map[row][col] = Integer.parseInt(st.nextToken());
                    sum += map[row][col];
                }
                result = Math.max(result, sum);
            }

            for(int col=0; col<SIZE; col++) {
                int sum = 0;
                for(int row=0; row<SIZE; row++) {
                    sum += map[row][col];
                }
                result = Math.max(result, sum);
            }

            int sum = 0;
            for(int cnt=0; cnt<SIZE; cnt++) {
                sum += map[cnt][cnt];
            }
            result = Math.max(result, sum);

            sum = 0;
            for(int cnt=0; cnt<SIZE; cnt++) {
                sum += map[cnt][SIZE-cnt-1];
            }
            result = Math.max(result, sum);

            System.out.println("#" + testCase + " " + result);
        }
    }
}
