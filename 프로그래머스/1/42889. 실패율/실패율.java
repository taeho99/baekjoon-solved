import java.util.*;

class Solution {
        public int[] solution(int N, int[] stages) {
        Stage[] stageList = new Stage[N];
        for(int i=0; i<N; i++) {
            stageList[i] = new Stage(i+1);
        }
        for (int i=0; i<stages.length; i++) {
            if (stages[i] < N+1) {
                stageList[stages[i]-1].failure++;
                stageList[stages[i]-1].success++;
            }
            for(int j=0; j<stages[i]-1; j++) {
                stageList[j].success++;
            }
        }
        for(int i=0; i<N; i++) {
            stageList[i].calcFailRate();
            System.out.println(stageList[i]);
        }
        Arrays.sort(stageList);
        return Arrays.stream(stageList).mapToInt(o -> o.num).toArray();
    }

    class Stage implements Comparable<Stage> {
        int num; // 스테이지 번호
        int success; //스테이지 도달한 수
        int failure; //스테이지에 도달하였으나 클리어 못한 수
        double failRate; // 실패율

        public Stage(int num) {
            this.num = num;
        }

        void calcFailRate() {
            if(success == 0) {
                failRate = 0;
            } else {
                failRate = (double) failure / success;
            }
        }

        @Override
        public String toString() {
            return "Stage{" +
                    "num=" + num +
                    ", success=" + success +
                    ", failure=" + failure +
                    ", failRate=" + failRate +
                    '}';
        }

        @Override
        public int compareTo(Stage o) {
            if(failRate > o.failRate) {
                return -1;
            } else if (failRate < o.failRate) {
                return 1;
            } else {
                return num - o.num;
            }
        }
    }
}