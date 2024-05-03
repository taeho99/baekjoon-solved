import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        arr = new int[n][n];
        visited = new boolean[n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = input.nextInt();
            }
        }
        dfs(0, 0);
        System.out.println(min);
    }

    private static void dfs(int idx, int depth) {
        if(depth == n/2) {
            int team1 = 0;
            int team2 = 0;

            for(int i=0; i<n-1; i++) {
                for(int j=i+1; j<n; j++) {
                    if(visited[i] && visited[j]) {
                        team1 += arr[i][j] + arr[j][i];
                    }
                    else if(!visited[i] && !visited[j]) {
                        team2 += arr[i][j] + arr[j][i];
                    }
                }
            }
            int diff = Math.abs(team1 - team2);
            min = Math.min(diff, min);
            return;
        }
        for(int i=idx; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i+1, depth+1);
                visited[i] = false;
            }
        }
    }
}
