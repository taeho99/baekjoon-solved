import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸으로 규칙에 맞게 점프
 * 2. 각 칸의 수 = 현재 칸에서 갈 수 있는 거리
 * 3. 각 칸의 수만큼 반드시 오른쪽이나 아래쪽으로만 점프 (0은 더이상 진행X)
 * 4. 이동할 수 있는 경로의 개수를 구하시오.
 */
public class Main {
    static int n;
    static int[][] map;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        dp = new long[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;
        //dp[i][j] = (i, x)까지 이동할 수 있는 경우의 수
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i == n-1 && j == n-1) break;
                int nextRightX = map[i][j] + j;
                int nextDownY = map[i][j] + i;

                if(nextRightX < n) {
                    dp[i][nextRightX] += dp[i][j] ;
                }
                if(nextDownY < n) {
                    dp[nextDownY][j] += dp[i][j];
                }
            }
        }

        System.out.println(dp[n-1][n-1]);
    }

    static void print() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------");
    }
}
