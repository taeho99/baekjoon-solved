import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int white = 0;
    static int blue = 0;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recur(n, 0, 0);
        System.out.println(white);
        System.out.println(blue);
    }
    static void recur(int n, int y, int x) {
        boolean check = true;
        int color = map[y][x];
        for(int i=y; i<y+n; i++) {
            for(int j=x; j<x+n; j++) {
                if(map[i][j] != color)
                    check = false;
            }
        }

        if(check) {
            if(color == 0) white++;
            else blue++;
        } else {
            recur(n/2, y, x);
            recur(n/2, y, x + (n/2));
            recur(n/2, y + (n/2), x);
            recur(n/2, y + (n/2), x + (n/2));
        }
    }
}
