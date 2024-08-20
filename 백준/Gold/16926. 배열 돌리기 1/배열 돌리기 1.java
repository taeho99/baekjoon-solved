import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ.16926 배열돌리기1
 *
 * 1. 세로, 가로 크기와 회전 횟수, 배열 데이터를 입력받는다.
 * 2. 세로, 가로 중 길이가 짧은 곳은 짝수임이 보장된다. 짝수인 부분의 절반만큼 반복한다.
 *      2-1. 왼쪽 위부터 시작하는 달팽이 모양의 리스트를 구한다.
 *      2-2. 달팽이 순서의 리스트를 왼쪽 방향으로 rotateCnt 만큼 회전시킨다.
 *      2-3. 회전된 리스트를 왼쪽 위부터 다시 채워준다.
 * 3. 완성된 배열을 출력한다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 1. 세로, 가로 크기와 회전 횟수, 배열 데이터를 입력받는다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());
        int rotateCnt = Integer.parseInt(st.nextToken());
        int[][] map = new int[rowSize][colSize];
        for(int i=0; i<rowSize; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<colSize; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. 세로, 가로 중 길이가 짧은 곳은 짝수임이 보장된다. 짝수인 부분의 절반만큼 반복한다.
        for(int idx=0; idx<Math.min(rowSize, colSize)/2; idx++) {
            // 2-1. 왼쪽 위부터 시작하는 달팽이 모양의 리스트를 구한다.
            List<Integer> list = new LinkedList<>();
            for(int col=idx; col<colSize - idx; col++)
                list.add(map[idx][col]);
            for(int row=idx+1; row<rowSize-idx-1; row++) {
                list.add(map[row][colSize-idx-1]);
            }
            for(int col=colSize-idx-1; col>=idx; col--) {
                list.add(map[rowSize-idx-1][col]);
            }
            for(int row=rowSize-idx-2; row>=idx+1; row--) {
                list.add(map[row][idx]);
            }

            // 2-2. 달팽이 순서의 리스트를 왼쪽 방향으로 rotateCnt 만큼 회전시킨다.
            Collections.rotate(list, -1*rotateCnt);

            // 2-3. 회전된 리스트를 왼쪽 위부터 다시 채워준다.
            for(int col=idx; col<colSize-idx; col++) {
                map[idx][col] = list.remove(0);
            }
            for(int row=idx+1; row<rowSize-idx-1; row++) {
                map[row][colSize-idx-1] = list.remove(0);
            }
            for(int col=colSize-idx-1; col>=idx; col--) {
                map[rowSize-idx-1][col] = list.remove(0);
            }
            for(int row=rowSize-idx-2; row>idx; row--) {
                map[row][idx] = list.remove(0);
            }
        }

        // 3. 완성된 배열을 출력한다.
        for(int row=0; row<rowSize; row++) {
            for(int col=0; col<colSize; col++) {
                sb.append(map[row][col]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
