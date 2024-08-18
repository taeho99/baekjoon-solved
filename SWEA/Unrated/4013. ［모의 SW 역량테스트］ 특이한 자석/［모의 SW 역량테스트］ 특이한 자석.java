import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * SWEA.4013 특이한 자석
 *
 * 1. 회전 횟수와 현재 자석 상태를 입력받는다.
 * 2. 회전 횟수만큼 자석을 회전시켜준다.
 * 3. 현재 자석 위치부터 양 옆으로 회전 여부를 확인한다.
 *      3-1. 다음 자석이 0,1,2,3번 자석이 아닌 경우 범위를 초과한 경우 -> continue
 *      3-2. 이미 회전 여부가 이미 확인된 경우 -> continue
 *      3-3. 다음 자석이 현재 자석의 왼쪽에 있으면서
 *          3-3-1. 다음 자석의 2번 극성과 현재 자석의 6번 극성이 다르면 "현재 자석과 반대 방향으로 회전"
 *      3-4. 다음 자석이 현재 자석의 오른쪽에 있으면서
 *          3-4-1. 다음 자석의 6번 극성과 현재 자석의 2번 극성이 다르면 "현재 자석과 반대 방향으로 회전"
 * 4. 이제 모든 자석의 회전 여부와 회전 방향이 정해졌다. (isRotate 배열. 0:회전X / 1:시계 / -1:반시계)
 *      4-1. 현재 자석의 isRotate가 0인 경우 회전하지 않는다. -> continue
 *      4-2. 현재 자석의 isRotate가 1인 경우 시계방향으로 1칸 회전한다.
 *      4-3. 현재 자석의 isRotate가 -1인 경우 반시계방향으로 1칸 회전한다.
 * 5. 모든 자석을 확인한다.
 *      5-1. 0번 극성이 S극(1)일 경우 결과값에 2^(자석 index)를 더해준다.
 * 6. 결과값을 출력한다.
 */
public class Solution {
    static int[] dCol = {-1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            sb.append('#').append(tc).append(' ');

            // 1. 회전 횟수와 현재 자석 상태를 입력받는다.
            int K = Integer.parseInt(br.readLine());
            int[][] magnet = new int[4][8];
            for(int row=0; row<4; row++) {
                st = new StringTokenizer(br.readLine());
                for(int col=0; col<8; col++) {
                    magnet[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            // 2. 회전 횟수만큼 자석을 회전시켜준다.
            while(K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int[] isRotate = new int[4]; // 각 자석의 회전 여부(-1:반시계, 0:회전X, 1:시계)
                int magnetNum = Integer.parseInt(st.nextToken()) - 1; // 회전시킬 자섯 숫자(0, 1, 2, 3)
                isRotate[magnetNum] = Integer.parseInt(st.nextToken()); // 회전시킬 방향

                Queue<int[]> queue = new LinkedList<>();
                boolean[] visited = new boolean[4];

                queue.add(new int[] {magnetNum, isRotate[magnetNum]});
                visited[magnetNum] = true;

                // 3. 현재 자석 위치부터 양 옆으로 회전 여부를 확인한다.
                while(!queue.isEmpty()) {
                    int[] poll = queue.poll(); // 현재 자석
                    int pollNS2 = magnet[poll[0]][2];
                    int pollNS6 = magnet[poll[0]][6];
                    int pollRotate = poll[1];

                    for(int idx=0; idx<2; idx++) {
                        int nextMagnetNum = poll[0] + dCol[idx];

                        // 3-1. 다음 자석이 0,1,2,3번 자석이 아닌 경우 범위를 초과한 경우 -> continue
                        if(nextMagnetNum < 0 || nextMagnetNum >= 4) continue;

                        // 3-2. 이미 회전 여부가 이미 확인된 경우 -> continue
                        if(visited[nextMagnetNum]) continue;

                        // 3-3. 다음 자석이 현재 자석의 왼쪽에 있으면서
                        if(poll[0] > nextMagnetNum) {
                            // 3-3-1. 다음 자석의 2번 극성과 현재 자석의 6번 극성이 다르면 "현재 자석과 반대 방향으로 회전"
                            if(pollNS6 != magnet[nextMagnetNum][2]) {
                                isRotate[nextMagnetNum] = pollRotate * (-1);
                            }
                        }
                        // 3-4. 다음 자석이 현재 자석의 오른쪽에 있으면서
                        else {
                            // 3-4-1. 다음 자석의 6번 극성과 현재 자석의 2번 극성이 다르면 "현재 자석과 반대 방향으로 회전"
                            if(pollNS2 != magnet[nextMagnetNum][6]) {
                                isRotate[nextMagnetNum] = pollRotate * (-1);
                            }
                        }

                        queue.add(new int[]{nextMagnetNum, isRotate[nextMagnetNum]});
                        visited[nextMagnetNum] = true;
                    }
                }

                // 4. 이제 모든 자석의 회전 여부와 회전 방향이 정해졌다. (isRotate 배열. 0:회전X / 1:시계 / -1:반시계)
                for(int idx=0; idx<4; idx++) {
                    // 4-1. 현재 자석의 isRotate가 0인 경우 회전하지 않는다. -> continue
                    if(isRotate[idx] == 0) continue;

                    // 4-2. 현재 자석의 isRotate가 1인 경우 시계방향으로 1칸 회전한다.
                    if(isRotate[idx] == 1) {
                        int tmp = magnet[idx][7];
                        for(int col=7; col>=1; col--) {
                            magnet[idx][col] = magnet[idx][col-1];
                        }
                        magnet[idx][0] = tmp;
                    }
                    // 4-3. 현재 자석의 isRotate가 -1인 경우 반시계방향으로 1칸 회전한다.
                    else {
                        int tmp = magnet[idx][0];
                        for(int col=0; col<=6; col++) {
                            magnet[idx][col] = magnet[idx][col+1];
                        }
                        magnet[idx][7] = tmp;
                    }
                }
            }

            int result = 0;
            // 5. 모든 자석을 확인한다.
            for(int idx=0; idx<4; idx++) {
                // 5-1. 0번 극성이 S극(1)일 경우 결과값에 2^(자석 index)를 더해준다.
                if(magnet[idx][0] == 1) {
                    result += (int) Math.pow(2, idx);
                }
            }

            // 6. 결과값을 출력한다.
            sb.append(result).append('\n');
        }
        System.out.print(sb);
    }
}
