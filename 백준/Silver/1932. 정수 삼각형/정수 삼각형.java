import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int answer = 0;
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    answer = arr[i][j];
                    continue;
                }
                if (j == 0) {
                    arr[i][j] += arr[i-1][j];
                } else {
                    arr[i][j] += Math.max(arr[i-1][j-1], arr[i-1][j]);
                }
                if(i == n - 1) {
                    answer = Math.max(answer, arr[i][j]);
                }
            }
        }
        System.out.println(answer);
    }
}
