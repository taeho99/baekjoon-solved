import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int V;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int cmd = Integer.parseInt(st.nextToken());

        makeSet();
        while(cmd-- > 0) {
            st = new StringTokenizer(br.readLine());

            String op = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(op.equals("0")) {
                union(a, b);
            } else {
                sb.append(findSet(a) == findSet(b) ? "YES" : "NO").append('\n');
            }
        }
        System.out.print(sb);
    }

    static void makeSet() {
        parents = new int[V+1];
        Arrays.fill(parents, -1);
    }

    static int findSet(int a) {
        if(parents[a] < 0) return a;
        return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) return false;

        parents[aRoot] += parents[bRoot];
        parents[bRoot] = aRoot;
        return true;
    }
}