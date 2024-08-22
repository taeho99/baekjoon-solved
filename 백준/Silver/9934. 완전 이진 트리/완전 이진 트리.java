import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] nodeList, resultNodeList;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nodeList = new int[1<<N];
        resultNodeList = new int[1<<N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int idx=1; idx<nodeList.length; idx++) {
            nodeList[idx] = Integer.parseInt(st.nextToken());
        }

        dfs(nodeList.length/2, 1, N);
        for(int row=1; row<(1<<N); row*=2) {
            for(int col=0; col<row; col++) {
                sb.append(resultNodeList[row+col]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void dfs(int idx, int resultIdx, int depth) {
        if(depth == 0) {
            return;
        }

        int tmp = 1<<(depth-2);
        resultNodeList[resultIdx] = nodeList[idx];
        dfs(idx - tmp, resultIdx*2, depth-1);
        dfs(idx + tmp, resultIdx*2+1, depth-1);
    }
}
