import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int vertexCnt, cmdCnt;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        vertexCnt = Integer.parseInt(st.nextToken());
        cmdCnt = Integer.parseInt(st.nextToken());

        parents = new int[vertexCnt];
        makeSet();

        for(int cmd=1; cmd<=cmdCnt; cmd++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            if(!union(v1, v2)) {
                System.out.print(cmd);
                return;
            }
        }
        System.out.print(0);
    }

    static void makeSet() {
        for(int idx=0; idx<vertexCnt; idx++) {
            parents[idx] = idx;
        }
    }

    static int findSet(int a) {
        if(a == parents[a]) return a;
        return findSet(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }
}