import java.util.*;

public class Main {
    static char[][] arr;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = input.nextInt();
        arr = new char[n][n];
        recur(0, 0, n, false);
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void recur(int x, int y, int n, boolean blank) {
        if(blank) {
            for(int i=x; i<x+n; i++) {
                for(int j=y; j<y+n; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }
        if(n == 1) {
            arr[x][y] = '*';
            return;
        }

        int count = 0;
        for(int i=x; i<x+n; i+=n/3) {
            for(int j=y; j<y+n; j+=n/3) {
                count++;
                if(count == 5) {
                    recur(i, j, n/3, true);
                } else {
                    recur(i, j, n/3, false);
                }
            }
        }
    }
}
