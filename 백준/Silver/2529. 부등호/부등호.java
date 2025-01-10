import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int selectCnt;
    static int[] selectList;
    static char[] signList;
    static boolean[] visited;
    static String maxResult, minResult;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        selectCnt = Integer.parseInt(br.readLine()) + 1;
        selectList = new int[selectCnt];
        signList = new char[selectCnt - 1];
        visited = new boolean[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int idx=0; idx<selectCnt - 1; idx++) {
            signList[idx] = st.nextToken().charAt(0);
        }

        permutation(0);
        System.out.println(maxResult);
        System.out.println(minResult);
    }

    private static void permutation(int selectedIdx) {
        if(!isPromise(selectedIdx)) {
            return;
        }

        if(selectedIdx == selectCnt) {
            String result = "";
            for(int idx=0; idx<selectCnt; idx++) {
                result += selectList[idx];
            }
            if(minResult == null) minResult = result;
            maxResult = result;
            return;
        }

        for(int num=0; num<=9; num++) {
            if(visited[num]) continue;
            visited[num] = true;
            selectList[selectedIdx] = num;
            permutation(selectedIdx + 1);
            visited[num] = false;
        }
    }

    private static boolean isPromise(int selectedIdx) {
        for(int signIdx=0; signIdx<selectedIdx-1; signIdx++) {
            if(signList[signIdx] == '<' && selectList[signIdx] > selectList[signIdx+1])
                return false;
            if(signList[signIdx] == '>' && selectList[signIdx] < selectList[signIdx+1])
                return false;
        }
        return true;
    }
}