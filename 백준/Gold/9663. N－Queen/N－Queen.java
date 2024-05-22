import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int result = 0, n;
    static boolean[] columnSet, plusSet, minusSet;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        columnSet = new boolean[n];
        plusSet = new boolean[2*n];
        minusSet = new boolean[2*n];
        dfs(0);
        System.out.print(result);
    }

    static void dfs(int row) {
        if(row == n) {
            result++;
            return;
        }

        for(int col=0; col<n; col++) {
            if(promise(row, col)) {
                columnSet[col] = true;
                plusSet[col+row] = true;
                minusSet[(n-1)-col+row] = true;
                dfs(row+1);
                columnSet[col] = false;
                plusSet[col+row] = false;
                minusSet[(n-1)-col+row] = false;
            }
        }
    }

    static boolean promise(int row, int col) {
        if(columnSet[col] || plusSet[col+row] || minusSet[(n-1)-col+row])
            return false;
        return true;
    }
}
