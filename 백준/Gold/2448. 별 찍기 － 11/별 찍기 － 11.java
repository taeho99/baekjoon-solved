import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static char[][] arr;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = input.nextInt();
        arr = new char[n][2*n-1];
        for(int i=0; i<n; i++) {
            Arrays.fill(arr[i], ' ');
        }

        recur(n-1, 0, n);
        for(int i=0; i<n; i++) {
            for(int j=0; j<2*n-1; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void recur(int x, int y, int n) {
        if(n == 3) {
            arr[y][x] = '*';
            arr[y+1][x-1] = arr[y+1][x+1] = '*';
            arr[y+2][x-2] = arr[y+2][x-1] = arr[y+2][x] = arr[y+2][x+1] = arr[y+2][x+2] = '*';
            return;
        }
        recur(x, y, n/2);
        recur(x-n/2, y+n/2, n/2);
        recur(x+n/2, y+n/2, n/2);
    }
}