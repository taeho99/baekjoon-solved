import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA.2001 파리퇴치
 *
 * 1. N*N 영역의 파리 개수를 입력받을 배열을 선언한다.
 * 1-1. 부분합을 구하기 위해서는 인덱스-1 범위의 데이터가 필요하다. 그래서 배열 사이즈는 (N+1)*(N+1)로 설정한다.
 * 1-2. 나의 왼쪽과 위에 있는 부분합 값을 이용해 나의 부분합 값을 구한다.
 *    1-2-1. 여기서 subTotal[row-1][col-1] 은 중복해서 더해지므로 다시 빼준다.
 * 2. 최댓값을 저장할 변수를 선언 및 초기화한다.
 * 2-1. 파리채의 크기는 M으로 고정이다. 그러므로 row와 col을 M부터 N까지 반복한다.
 * 2-2. subTotal[row][col] 부분합에서 subTotal[row-M][col], subTotal[row][col-M] 부분합을 빼서 파리채 영역의 합을 구한다.
 *    2-2-1. 여기서 subTotal[row-M][col-M] 영역은 중복해서 빼졌으므로 다시 더해준다.
 * 3. maxResult를 최댓값으로 갱신해주면서 결과를 찾는다.
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            sb.append('#').append(tc).append(' ');
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int subSize = Integer.parseInt(st.nextToken());

            // 1. N*N 영역의 파리 개수를 입력받을 배열을 선언한다.
            // 1-1. 부분합을 구하기 위해서는 인덱스-1 범위의 데이터가 필요하다. 그래서 배열 사이즈는 (N+1)*(N+1)로 설정한다.
            int[][] subTotal = new int[size+1][size+1];
            for(int row=1; row<=size; row++) {
                st = new StringTokenizer(br.readLine());
                for(int col=1; col<=size; col++) {
                    // 1-2. 나의 왼쪽과 위에 있는 부분합 값을 이용해 나의 부분합 값을 구한다.
                    // 1-2-1. 여기서 subTotal[row-1][col-1] 은 중복해서 더해지므로 다시 빼준다.
                    subTotal[row][col] = subTotal[row-1][col] + subTotal[row][col-1]
                            - subTotal[row-1][col-1] + Integer.parseInt(st.nextToken());
                }
            }

            // 2. 최댓값을 저장할 변수를 선언 및 초기화한다.
            int maxResult = 0;

            // 2-1. 파리채의 크기는 M으로 고정이다. 그러므로 row와 col을 M부터 N까지 반복한다.
            for(int row=subSize; row<=size; row++) {
                for(int col=subSize; col<=size; col++) {
                    // 2-2. subTotal[row][col] 부분합에서 subTotal[row-M][col], subTotal[row][col-M] 부분합을 빼서 파리채 영역의 합을 구한다.
                    // 2-2-1. 여기서 subTotal[row-M][col-M] 영역은 중복해서 빼졌으므로 다시 더해준다.
                    int total = subTotal[row][col] - subTotal[row-subSize][col] - subTotal[row][col-subSize]
                            + subTotal[row-subSize][col-subSize];

                    // 3. maxResult를 최댓값으로 갱신해주면서 결과를 찾는다.
                    maxResult = Math.max(maxResult, total);
                }
            }
            sb.append(maxResult).append('\n');
        }
        System.out.print(sb);
    }
}
