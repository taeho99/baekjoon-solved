import java.util.Scanner;

public class Main {
    static int result = 0, n;
    static boolean[][] queen;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        queen = new boolean[n][n];
        dfs(0);
        System.out.println(result);
    }

    private static void dfs(int row) {
        if(row == n) {
            result++;
            return;
        }

        for(int col=0; col<n; col++) {
            if(promise(row, col)) {
                queen[row][col] = true;
                dfs(row+1);
                queen[row][col] = false;
            }
        }
    }

    private static boolean promise(int row, int col) {
        for(int i=0; i<row; i++) {
            int j;
            for(j=0; j<n; j++) {
                if(queen[i][j]) break;
            }
            if(col == j || Math.abs(j-col) == row - i)
                return false;
        }
        return true;
    }
}
