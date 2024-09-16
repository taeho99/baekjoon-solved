import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] freq = new int[201];
            int[][] score = new int[201][7];
            boolean[] finishTeam = new boolean[201];

            st = new StringTokenizer(br.readLine());
            int[] team = new int[N+1];
            for(int idx=1; idx<=N; idx++) {
                team[idx] = Integer.parseInt(st.nextToken());
                freq[team[idx]]++;
                if(freq[team[idx]] == 6) finishTeam[team[idx]] = true;
            }

            int tmp = 1;
            for(int idx=1; idx<=N; idx++) {
                if(finishTeam[team[idx]]) {
                    score[team[idx]][6 - (--freq[team[idx]])] = tmp++;
                    if(score[team[idx]][0] == 0) score[team[idx]][0] = team[idx];
                }
            }

            List<int[]> list = new ArrayList<>();

            for (int[] s : score) {
                if(s[0] != 0) list.add(s);
            }

            Collections.sort(list, (o1, o2) -> {
                int sum1 = o1[1] + o1[2] + o1[3] + o1[4];
                int sum2 = o2[1] + o2[2] + o2[3] + o2[4];
                if(sum1 == sum2) return Integer.compare(o1[5], o2[5]);
                return Integer.compare(sum1, sum2);
            });

            System.out.println(list.get(0)[0]);
        }
    }
}