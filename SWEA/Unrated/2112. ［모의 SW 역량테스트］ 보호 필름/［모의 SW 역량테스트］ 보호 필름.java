import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * SWEA.2112.보호 필름 
 * height: 필름의 세로 크기(두께), width: 필름의 가로 크기, K: 합격 기준
 * 1. height*width 크기의 필름을 입력받는다.
 * 2. 가로로 된 각 셀을 위에서 아래로 충격했을 때, 연속된 특성이 K개 이상 있어야 성능 검사를 통과한다.
 * 3. 모든 column이 통과해야 성능 검사도 합격이다.
 * 4. 중간에 약품을 row 단위로 최소 2개이상 투입해야 한다. 이 약품을 투입하면 그 row의 모든 특성이 A or B로 변경된다.
 * 4-1. 최소로 약품을 투입하여 성능검사를 통과하게끔 해라. 다만, 약품을 투입하지 않을 수는 없다.
 * 5. 약품의 최소 투입 횟수를 출력하시오... 
 *
 * 약품이 2개가 사용된다면 [A, A], [A, B], [B, A], [B, B] 사용될 수 있다. -> 중복 가능한 수열
 * 약품이 투입될 위치를 정해야 한다.
 * D개 중 2개를 뽑아야 하므로 DC2 이다. 만약 DC2 로 성능 검사 합격 못하면 -> DC3, DC4, ... , DCD 까지 해야함
 */
public class Solution {
    static int height, width, K;
    static int[][] map;
    static int[] selectMedicine;
    static int minMedicine;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            sb.append('#').append(tc).append(' ');
            st = new StringTokenizer(br.readLine().trim());
            height = Integer.parseInt(st.nextToken());
            width = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[height][width];

            for(int row=0; row<height; row++) {
                st = new StringTokenizer(br.readLine().trim());
                for(int col=0; col<width; col++) {
                    map[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            minMedicine = Integer.MAX_VALUE;
            selectMedicine = new int[height];
            
            powerSet(0, 0);

            sb.append(minMedicine).append('\n');
        }
        System.out.print(sb);
    }

    private static void powerSet(int elementIdx, int medicineCnt) {
        if(medicineCnt >= minMedicine) return;
        if(elementIdx == height) {
            if(statusCheck()) {
                minMedicine = Math.min(minMedicine, medicineCnt);

            }
            return;
        }

        selectMedicine[elementIdx] = -1;
        powerSet(elementIdx + 1, medicineCnt);

        selectMedicine[elementIdx] = 0;
        powerSet(elementIdx + 1, medicineCnt + 1);

        selectMedicine[elementIdx] = 1;
        powerSet(elementIdx + 1, medicineCnt + 1);
    }

    private static boolean statusCheck() {
        for(int col=0; col<width; col++) {
            int cnt = 1;
            for(int row=0; row<height-1; row++) {
                int now = selectMedicine[row] == -1 ? map[row][col] : selectMedicine[row];
                int next = selectMedicine[row+1] == -1 ? map[row+1][col] : selectMedicine[row+1];
                if(now == next) {
                    cnt++;
                    if(cnt >= K) {
                        break;
                    }
                } else {
                    cnt = 1;
                }
            }
            if(cnt < K) return false;
        }
        return true;
    }
}