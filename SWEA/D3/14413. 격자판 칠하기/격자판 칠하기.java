import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N*M 크기 직사각형 격자판을 검은색 or 흰색으로 칠하기
 * # : 검은색, .: 흰색, ?: 둘다 가능
 * ? 칸들에 대해 인접한 두 칸의 색이 모두 다르게 가능한지?
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalCase = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=totalCase; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rowSize = Integer.parseInt(st.nextToken());
            int colSize = Integer.parseInt(st.nextToken());

            char[][] match = new char[rowSize][colSize];
            char[][] input = new char[rowSize][colSize];

            // input 격자판 초기화
            for(int row=0; row<rowSize; row++) {
                String str = br.readLine();
                for(int col=0; col<colSize; col++) {
                    input[row][col] = str.charAt(col);
                }
            }

            // match 격자판 초기화
            char[] ch = {'#', '.'};
            for(int row=0; row<rowSize; row++) {
                for(int col=0; col<colSize; col++) {
                    match[row][col] = ch[(row+col)%2];
                }
            }

            boolean check1 = true, check2 = true;
            for(int row=0; row<rowSize; row++) {
                for(int col=0; col<colSize; col++) {
                    if(input[row][col] == '?') continue;
                    if(input[row][col] != match[row][col])
                        check1 = false;
                    if(input[row][col] == match[row][col])
                        check2 = false;
                }
            }
            
            String result = (check1 || check2) ? "possible" : "impossible";
            System.out.println("#" + testCase + " " + result);
        }

    }
}
