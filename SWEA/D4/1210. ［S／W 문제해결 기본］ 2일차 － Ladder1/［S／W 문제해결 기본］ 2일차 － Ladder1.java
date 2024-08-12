import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 사다리게임 -> 양 옆에 길이 있으면 무조건 그 길로 가야 함
 * 2. 양 옆 길은 왼쪽 or 오른쪽 한 곳만 뚫려있음
 * 3. row == 0인 모든 시작점을 완전탐색 해도 되지만 도착점에서 거꾸로 올라가면 시작점이 무조건 나옴
 * 풀이 전략. 도착점부터 윗 방향으로 올라가되, 왼쪽 or 오른쪽에 길이 있으면 왼쪽 끝 or 오른쪽 끝까지 탐색
 *          왼쪽 or 오른쪽으로 가다 막다른 길이 나오면 다시 윗쪽 방향으로 이동
 *          row == 0이 될 때까지 계속 이동
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int tc=1; tc<=10; tc++) {
            br.readLine();
            int[][] map = new int[100][100];
            int[] arrive = new int[2];
            for(int row=0; row<100; row++) {
                st = new StringTokenizer(br.readLine());
                for(int col=0; col<100; col++) {
                    map[row][col] = Integer.parseInt(st.nextToken());
                    // 도착점의 row값과 col값을 arrive 배열에 저장
                    if(map[row][col] == 2) {
                        arrive[0] = row;
                        arrive[1] = col;
                    }
                }
            }

            // 도착점에서 시작해야 하므로 col 값 미리 초기화 해줌
            int col = arrive[1];
            // row는 무조건 99부터 0까지 올라가는 방향이기 때문에 for문으로 해줌
            for(int row=arrive[0]; row >=0; row--) {
                // 왼쪽 방향으로 탐색을 마쳤다면 check = true 대입하여 다시 오른쪽 방향으로 탐색 못하게 막음
                boolean check = false;
                // [왼쪽] 인덱스 범위를 초과하지 않으면서 왼쪽 방향으로 길이 있다면 계속 탐색
                while(col - 1 >= 0 && map[row][col-1] == 1) {
                    col--;
                    check = true;
                }
                // 탐색 마치고 바로 row-1로 이동하게끔(오른쪽 방향으로 탐색 못하게끔) continue
                if(check) continue;

                // [오른쪽] 인덱스 범위를 초과하지 않으면서 오른쪽 방향으로 길이 있다면 계속 탐색
                while(col + 1 <= 99 && map[row][col+1] == 1) {
                    col++;
                }
            }

            // 가장 마지막 col 값이 시작점 위치이다.
            sb.append('#').append(tc).append(' ').append(col).append('\n');
        }
        System.out.print(sb);
    }
}
