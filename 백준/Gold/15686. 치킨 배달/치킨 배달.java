import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m, result = Integer.MAX_VALUE;
    static ArrayList<Point> home, store;
    static boolean[] open;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        home = new ArrayList<>();
        store = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 1) {
                    home.add(new Point(i, j));
                } else if (tmp == 2) {
                    store.add(new Point(i, j));
                }
            }
        }
        open = new boolean[store.size()];

        dfs(0, 0);
        System.out.println(result);
    }

    private static void dfs(int start, int depth) {
        if(depth == m) {
            int tmp = 0;
            for (Point h : home) {
                int min = Integer.MAX_VALUE;
                for(int i=0; i<store.size(); i++) {
                    if(open[i]) {
                        min = Math.min(min, h.getDistance(store.get(i)));
                    }
                }
                tmp += min;
            }
            result = Math.min(result, tmp);
            return;
        }

        for(int i=start; i<store.size(); i++) {
            if(!open[i]) {
                open[i] = true;
                dfs(i + 1, depth + 1);
                open[i] = false;
            }
        }
    }

    static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getDistance(Point p) {
            return Math.abs(this.y - p.y) + Math.abs(this.x - p.x);
        }
    }
}
