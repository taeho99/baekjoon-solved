import java.util.Scanner;

public class Main {
    static int[][] taste;
    static boolean[] visited;
    static int result, n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        taste = new int[n][2];
        result = Integer.MAX_VALUE;

        for(int i=0; i<n; i++) {
            taste[i][0] = sc.nextInt();
            taste[i][1] = sc.nextInt();
        }

        for(int i=1; i<=n; i++) {
            visited = new boolean[n];
            dfs(0, 0, i);
        }
        System.out.println(result);
    }

    static void dfs(int start, int depth, int len) {
        if(depth == len) {
            int sour = 1;
            int bitter = 0;
            for(int i=0; i<n; i++) {
                if(visited[i]) {
                    sour *= taste[i][0];
                    bitter += taste[i][1];
                }
            }
            result = Math.min(result, Math.abs(sour-bitter));
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            dfs(i+1, depth+1, len);
            visited[i] = false;
        }
    }
}
