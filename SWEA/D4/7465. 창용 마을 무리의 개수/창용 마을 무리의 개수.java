import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  SWEA.7465 창용마을무리의개수
 *
 *  0. 하나의 무리를 하나의 집합이라고 가정한다.
 *  1. 사람의 수와 알고 있는 관계의 수를 입력받는다.
 *      1-1. 각 사람을 최소 단위 서로소 집합으로 만든다.
 *  2. 관계는 두 사람(집합)을 하나로 합집합한다.
 *  3. 무리의 개수는 관계를 모두 맺고 난 후의 대표자의 개수이다.
 *      3-1. 현재 부모 노드가 내 노드면 대표자이므로 대표자의 개수를 카운트(+1)한다.
 *  4. 대표자(무리)의 개수를 출력한다.
 */
public class Solution {
    static int size, cmdCnt;
    static int[] parents;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            sb.append('#').append(tc).append(' ');

            // 1. 사람의 수와 알고 있는 관계의 수를 입력받는다.
            st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());
            cmdCnt = Integer.parseInt(st.nextToken());

            // 1-1. 각 사람을 최소 단위 서로소 집합으로 만든다.
            parents = new int[size+1];
            makeSet();

            while(cmdCnt-- > 0) {
                st = new StringTokenizer(br.readLine());
                int person1 = Integer.parseInt(st.nextToken());
                int person2 = Integer.parseInt(st.nextToken());
                // 2. 관계는 두 사람(집합)을 하나로 합집합한다.
                union(person1, person2);
            }

            // 3. 무리의 개수는 관계를 모두 맺고 난 후의 대표자의 개수이다.
            int repCnt = 0; // 대표자의 개수
            for(int idx=1; idx<=size; idx++) {
                // 3-1. 현재 부모 노드가 내 노드면 대표자이므로 대표자의 개수를 카운트(+1)한다.
                if(parents[idx] == idx) repCnt++;
            }
            
            // 4. 대표자(무리)의 개수를 출력한다.
            sb.append(repCnt).append('\n');
        }
        System.out.print(sb);
    }

    private static int findSet(int x) {
        if(x == parents[x]) return x;
        return parents[x] = findSet(parents[x]);
    }

    private static void union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) return;
        parents[bRoot] = aRoot;
    }

    private static void makeSet() {
        for(int idx=1; idx<=size; idx++) {
            parents[idx] = idx;
        }
    }
}