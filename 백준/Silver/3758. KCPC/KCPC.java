import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int teamCnt = Integer.parseInt(st.nextToken());
            int problemCnt = Integer.parseInt(st.nextToken());
            int myTeamId = Integer.parseInt(st.nextToken());
            int logCnt = Integer.parseInt(st.nextToken());

            Team[] teams = new Team[teamCnt];
            for(int idx=0; idx<teamCnt; idx++) {
                teams[idx] = new Team(idx+1, problemCnt);
            }

            for(int submitTime=0; submitTime<logCnt; submitTime++) {
                st = new StringTokenizer(br.readLine());
                int teamId = Integer.parseInt(st.nextToken());
                int problemNo = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                teams[teamId-1].submitCnt++;
                teams[teamId-1].lastSubmit = submitTime;
                teams[teamId-1].score[problemNo-1] = Math.max(teams[teamId-1].score[problemNo-1], score);
            }

            for (Team team : teams) {
                team.calcScoreSum();
            }

            Arrays.sort(teams, (o1, o2) -> {
               if(o1.sumScore == o2.sumScore) {
                   if(o1.submitCnt == o2.submitCnt) return Integer.compare(o1.lastSubmit, o2.lastSubmit);
                   return Integer.compare(o1.submitCnt, o2.submitCnt);
               }
               return Integer.compare(o2.sumScore, o1.sumScore);
            });

            for(int idx=0; idx<teamCnt; idx++) {
                if(teams[idx].id == myTeamId) {
                    sb.append(idx+1).append('\n');
                    break;
                }
            }
        }
        System.out.print(sb);
    }

    static class Team {
        int[] score;
        int id, submitCnt, lastSubmit, sumScore;

        public Team(int id, int scoreCnt) {
            this.id = id;
            this.score = new int[scoreCnt];
            this.submitCnt = 0;
            this.lastSubmit = 0;
            this.sumScore = 0;
        }

        void calcScoreSum() {
            for (int s : score) {
                sumScore += s;
            }
        }
    }
}