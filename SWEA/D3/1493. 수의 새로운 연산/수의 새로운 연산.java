import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * 2차원 평면 오른쪽아래 대각선 방향 순으로 좌표에 수를 붙임
 * #(x,y) -> (x,y) 수
 * &(p) -> p번째 수의 좌표
 * #(&(1)+&(5)) 값 출력
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int t=1; t<=testCase; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int[][] map = new int[300][300];
            int[] pNode = null, qNode = null;
            // firstY: x값이 1로 초기화 될 때마다 y좌표 저장
            int[] now = {1,1};
            int firstY = 1;

            // 1부터 10000까지 map 초기화
            for(int num=1; num<=41000; num++) {
                int nowX = now[0];
                int nowY = now[1];
                map[nowX][nowY] = num;
                if(num == p) {
                    pNode = new int[] {nowX,nowY};
                }
                if (num == q) {
                    qNode = new int[] {nowX,nowY};
                }

                // x==1 -> 화살표가 시작하는 지점의 y좌표를 firstY에 저장
                if(nowX == 1) {
                    firstY = nowY;
                }

                // x좌표 y좌표 이동
                now[0]++; now[1]--;

                // 화살표가 바닥에 닿으면 x = 1, y = (저장된 y) + 1
                if(now[1] == 0) {
                    now[0] = 1;
                    now[1] = firstY + 1;
                }
            }

            System.out.println("#" + t + " " + map[pNode[0]+qNode[0]][pNode[1]+qNode[1]]);
        }
    }

}
