import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for(int i=0; i<n; i++) {
            String s = br.readLine();
            for(int j=0; j<n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        recur(0, 0, n);
        System.out.print(sb);
    }

    private static void recur(int y, int x, int n) {
        int color = arr[y][x];
        boolean check = true;
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
            sb.append(color);
        } else {
            int cut = n/2;
            sb.append('(');
            recur(y, x, cut);
            recur(y, x+cut, cut);
            recur(y+cut, x, cut);
            recur(y+cut, x+cut, cut);
            sb.append(')');
        }
    }
}
