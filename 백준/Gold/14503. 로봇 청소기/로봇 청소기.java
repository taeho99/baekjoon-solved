import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        while(true) {
            if(arr[r][c] == 0) {
                arr[r][c] = 2;
                result++;
            }

            boolean isAvailClean = false;
            boolean[] whereClean = new boolean[4];
            for(int i=0; i<4; i++) { //북->동->남->서
                int ny = r + dy[i];
                int nx = c + dx[i];
                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(arr[ny][nx] == 0) {
                    isAvailClean = true;
                    whereClean[i] = true;
                }
            }

            if(isAvailClean) {
                do {
                    d = (d + 3) % 4;
                } while (!whereClean[d]);
                r = r + dy[d];
                c = c + dx[d];
            } else {
                int ny = r + dy[(d+2)%4];
                int nx = c + dx[(d+2)%4];
                if(arr[ny][nx] == 1) {
                    break;
                } else {
                    r = ny;
                    c = nx;
                }
            }
        }

        System.out.println(result);
    }
}
