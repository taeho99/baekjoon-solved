import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int result, inningCnt;
    static int[] elementList, sequence;
    static int[][] stats;
    static boolean[] visited;
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        inningCnt = Integer.parseInt(br.readLine());
        stats = new int[inningCnt][9];
        for(int row=0; row<inningCnt; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col=0; col<9; col++) {
                stats[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        //3번 고정하고 순열
        visited = new boolean[9];
        elementList = new int[] {1, 2, 3, 0, 4, 5, 6, 7, 8};
        sequence = new int[9];
        visited[3] = true;

        result = 0;
        permutation(0);
        System.out.println(result);
    }

    static void permutation(int selectIdx) {
        if(selectIdx == 3) selectIdx++;
        if(selectIdx == 9) {
            result = Math.max(result, playGame());
            return;
        }

        for(int elementIdx=0; elementIdx<9; elementIdx++) {
            if(visited[elementIdx]) continue;
            visited[elementIdx] = true;
            sequence[selectIdx] = elementList[elementIdx];
            permutation(selectIdx + 1);
            visited[elementIdx] = false;
        }
    }

    static int playGame() {
        int nowPlayerIdx = 0;
        int score = 0;
        for(int inning=0; inning<inningCnt; inning++) {
            int outCount = 0;
            boolean[] base = new boolean[4];
            while(outCount != 3) {
                int stat = stats[inning][sequence[nowPlayerIdx]];
                switch(stat) {
                    case 0:
                        outCount++;
                        break;
                    case 1:
                        if(base[3]) score++;
                        base[3] = base[2];
                        base[2] = base[1];
                        base[1] = true;
                        break;
                    case 2:
                        if(base[3]) score++;
                        if(base[2]) score++;
                        base[3] = base[1];
                        base[2] = true;
                        base[1] = false;
                        break;
                    case 3:
                        if(base[3]) score++;
                        if(base[2]) score++;
                        if(base[1]) score++;
                        base[3] = true;
                        base[2] = false;
                        base[1] = false;
                        break;
                    case 4:
                        for(int idx=1; idx<=3; idx++) {
                            if(base[idx]) score++;
                            base[idx] = false;
                        }
                        score++;
                        break;
                }
                nowPlayerIdx = (nowPlayerIdx + 1) % 9;
            }
        }
        return score;
    }
}
