import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ.17281 야구
 *
 * 1. 이닝 수와 선수들의 결과(스탯)을 입력받는다.
 * 2. 1번 선수를 4번째에 고정한 elementList 생성
 * 3. 가능한 모든 타자 순서 순열 만들기
 *      3-1. 4번째 순서는 변경하지 않기
 * 4. 순열 다 만들었으면 야구 시작
 *      4-1. 이닝 수만큼 게임하기
 *      4-2. 아웃카운트가 3이 되면 현재 이닝 끝내기
 *      4-3. 각 선수의 스탯에 따라 베이스 옮겨주고 점수 계산하기
 *      4-4. 타자가 바뀔 시점에 nowPlayerIdx 업데이트 해주기
 *      4-5. 스코어 계산해서 반환해주기
 * 5. 반환된 스코어 값이 최소면 갱신해주기
 */
public class Main {
    static int result, inningCnt;
    static int[] elementList, sequence;
    static int[][] stats;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1. 이닝 수와 선수들의 결과(스탯)을 입력받는다.
        inningCnt = Integer.parseInt(br.readLine());
        stats = new int[inningCnt][9];
        for(int row=0; row<inningCnt; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col=0; col<9; col++) {
                stats[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. 1번 선수를 4번째에 고정한 elementList 생성
        visited = new boolean[9];
        elementList = new int[] {1, 2, 3, 0, 4, 5, 6, 7, 8};
        sequence = new int[9];
        visited[3] = true;

        result = 0;
        // 3. 가능한 모든 타자 순서 순열 만들기
        permutation(0);
        System.out.println(result);
    }

    static void permutation(int selectIdx) {
        // 3-1. 4번째 순서는 변경하지 않기
        if(selectIdx == 3) selectIdx++;

        if(selectIdx == 9) {
            // 4. 순열 다 만들었으면 야구 시작
            // 5. 반환된 스코어 값이 최소면 갱신해주기
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
        // 4-1. 이닝 수만큼 게임하기
        for(int inning=0; inning<inningCnt; inning++) {
            int outCount = 0;
            boolean[] base = new boolean[4];
            // 4-2. 아웃카운트가 3이 되면 현재 이닝 끝내기
            while(outCount != 3) {
                int stat = stats[inning][sequence[nowPlayerIdx]];
                // 4-3. 각 선수의 스탯에 따라 베이스 옮겨주고 점수 계산하기
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
                // 4-4. 타자가 바뀔 시점에 nowPlayerIdx 업데이트 해주기
                nowPlayerIdx = (nowPlayerIdx + 1) % 9;
            }
        }
        // 4-5. 스코어 계산해서 반환해주기
        return score;
    }
}
