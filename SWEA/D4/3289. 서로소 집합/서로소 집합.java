import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  SWEA.3289 서로소집합
 *
 *  1. 서로소 집합의 크기와 연산의 개수를 입력받고 부모 노드를 저장하는 parents 배열을 초기화한다.
 *  2. 초기 집합은 자기 자신이 루트 노드이자 대표자이다. 최소 단위 서로소 집합을 생성한다.
 *  3. 연산의 종류에 따라 연산을 실행한다.
 *      3-1. 합집합 연산을 실행한다. 합집합은 대표자가 다를때만 실행한다.
 *      3-2. 같은 집합에 포함되어 있는지 확인한다. 대표자가 같으면 같은 집합이고 다르면 서로소 집합이다.
 *  4. 결과를 출력한다.
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

            // 1. 서로소 집합의 크기와 연산의 개수를 입력받고 부모 노드를 저장하는 parents 배열을 초기화한다.
            st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());
            cmdCnt = Integer.parseInt(st.nextToken());

            // 2. 초기 집합은 자기 자신이 루트 노드이자 대표자이다. 최소 단위 서로소 집합을 생성한다.
            parents = new int[size+1];
            makeSet();

            while(cmdCnt-- > 0) {
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                // 3. 연산의 종류에 따라 연산을 실행한다.
                switch(cmd) {
                    case 0:
                        // 3-1. 합집합 연산을 실행한다. 합집합은 대표자가 다를때만 실행한다.
                        union(a, b);
                        break;
                    case 1:
                        // 3-2. 같은 집합에 포함되어 있는지 확인한다. 대표자가 같으면 같은 집합이고 다르면 서로소 집합이다.
                        if(findSet(a) == findSet(b)) sb.append(1);
                        else sb.append(0);
                        break;
                }
            }
            sb.append('\n');
        }
        // 4. 결과를 출력한다.
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