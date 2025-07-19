import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[] result = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recur(0, 0, n);
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static void recur(int y, int x, int n) {
        boolean check = true;
        int color = arr[y][x];
        for(int i=y; i<y+n; i++) {
            for(int j=x; j<x+n; j++) {
                if(color != arr[i][j]) {
                    check = false;
                    break;
                }
            }
            if(!check) break;
        }

        if(check) {
            result[color+1]++;
        } else {
            int cut = n/3;
            for(int i=y; i<y+n; i+=cut) {
                for(int j=x; j<x+n; j+=cut) {
                    recur(i, j, cut);
                }
            }
        }
    }
}
