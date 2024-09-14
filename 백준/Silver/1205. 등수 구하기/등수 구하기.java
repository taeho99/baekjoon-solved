import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int taesuScore = Integer.parseInt(st.nextToken());
        int maxListCnt = Integer.parseInt(st.nextToken());

        if(n == 0) {
            System.out.println(1);
            return;
        }

        int[] list = new int[maxListCnt + 1];
        st = new StringTokenizer(br.readLine());
        for(int idx=1; idx<=maxListCnt; idx++) {
            if(idx <= n) {
                list[idx] = Integer.parseInt(st.nextToken());
            } else {
                list[idx] = -1;
            }
        }

        int rank = 0;
        for(int idx=0; idx<=maxListCnt; idx++) {
            if(idx != maxListCnt && rank == 0 && list[idx] == taesuScore) {
                rank = idx;
                continue;
            }
            if(idx != maxListCnt && rank != 0 && list[idx+1] != taesuScore) {
                System.out.println(rank);
                return;
            }
            if(idx != maxListCnt && list[idx+1] < taesuScore) {
                System.out.println(idx+1);
                return;
            }
        }
        System.out.println(-1);
    }
}