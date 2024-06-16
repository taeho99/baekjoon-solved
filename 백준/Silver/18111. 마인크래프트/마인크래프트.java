import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int min = 257, max = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(arr[i][j], min);
                max = Math.max(arr[i][j], max);
            }
        }

        int minTime = Integer.MAX_VALUE, maxHeight = 0;
        for(int height = min; height <= max; height++) {
            int time = 0, inventory = b;
            boolean check = true;
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(arr[i][j] > height) {
                        inventory += arr[i][j] - height;
                        time += 2 * (arr[i][j] - height);
                    } else if(arr[i][j] < height) {
                        inventory -= height - arr[i][j];
                        time += height - arr[i][j];
                    }
                }
            }
            if(time <= minTime && inventory >= 0) {
                minTime = time;
                maxHeight = height;
            }
        }
        System.out.println(minTime + " " + maxHeight);
    }
}
