import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int[] dCol = {-1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            sb.append('#').append(tc).append(' ');
            int K = Integer.parseInt(br.readLine());
            int[][] magnet = new int[4][8];
            for(int row=0; row<4; row++) {
                st = new StringTokenizer(br.readLine());
                for(int col=0; col<8; col++) {
                    magnet[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            while(K-- > 0) {
                st = new StringTokenizer(br.readLine());
                int[] isRotate = new int[4];
                int magnetNum = Integer.parseInt(st.nextToken()) - 1;
                isRotate[magnetNum] = Integer.parseInt(st.nextToken());

                Queue<int[]> queue = new LinkedList<>();
                boolean[] visited = new boolean[4];

                queue.add(new int[] {magnetNum, isRotate[magnetNum]});
                visited[magnetNum] = true;

                while(!queue.isEmpty()) {
                    int[] poll = queue.poll();
                    int pollNS2 = magnet[poll[0]][2];
                    int pollNS6 = magnet[poll[0]][6];
                    int pollRotate = poll[1];

                    for(int idx=0; idx<2; idx++) {
                        int nextMagnetNum = poll[0] + dCol[idx];

                        if(nextMagnetNum < 0 || nextMagnetNum >= 4) continue;

                        if(visited[nextMagnetNum]) continue;

                        // 다음 자석이 왼쪽에 있을 경우
                        if(poll[0] > nextMagnetNum) {
                            // 이전 자석의 6번 위치와 다음 자석의 2번 위치를 비교
                            if(pollNS6 != magnet[nextMagnetNum][2]) {
                                isRotate[nextMagnetNum] = pollRotate * (-1);
                            }
                        } else {
                            if(pollNS2 != magnet[nextMagnetNum][6]) {
                                isRotate[nextMagnetNum] = pollRotate * (-1);
                            }
                        }

                        queue.add(new int[]{nextMagnetNum, isRotate[nextMagnetNum]});
                        visited[nextMagnetNum] = true;
                    }
                }


                for(int idx=0; idx<4; idx++) {
                    if(isRotate[idx] == 0) continue;
                    if(isRotate[idx] == 1) {
                        int tmp = magnet[idx][7];
                        for(int col=7; col>=1; col--) {
                            magnet[idx][col] = magnet[idx][col-1];
                        }
                        magnet[idx][0] = tmp;
                    } else {
                        int tmp = magnet[idx][0];
                        for(int col=0; col<=6; col++) {
                            magnet[idx][col] = magnet[idx][col+1];
                        }
                        magnet[idx][7] = tmp;
                    }
                }
            }

            int result = 0;
            for(int idx=0; idx<4; idx++) {
                if(magnet[idx][0] == 1) {
                    result += (int) Math.pow(2, idx);
                }
            }
            sb.append(result).append('\n');
        }
        System.out.print(sb);
    }
}
