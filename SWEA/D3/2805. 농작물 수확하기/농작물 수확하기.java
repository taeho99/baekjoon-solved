import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
/**
 * SWEA.2805 농작물 수확하기
 * 
 * 1. 농장의 크기와 농작물의 가치를 입력으로 받는다.
 * 2. 가운데 줄을 기준으로 위와 아래를 나누고 row에 따라 col을 계산하여 농작물의 가치를 탐색하여 sum에 더한다.
 * 3. 결과값 sum을 출력한다.
 */
public class Solution {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for(int t=1; t<=testCase; t++) {
        	sb.append('#').append(t).append(' ');
        	
        	// 1. 농장의 크기와 농작물의 가치를 입력으로 받는다.
            int size = Integer.parseInt(br.readLine());
            int[][] map = new int[size][size];
             
            for(int row=0; row<size; row++) {
                String input = br.readLine();
                for(int col=0; col<size; col++) {
                    map[row][col] = input.charAt(col) - '0';
                }
            }
             
            // 2. 가운데 줄을 기준으로 위와 아래를 나누고 row에 따라 col을 계산하여 농작물의 가치를 탐색하여 sum에 더한다.
            int sum = 0;
            for(int row=0; row<size; row++) {
                if(row <= size/2) {
                    for(int col=(size/2) - row; col<=(size/2) + row; col++) {
                        sum += map[row][col];
                    }
                } else {
                    for(int col=(size/2) - (size-row-1); col<=(size/2) + (size-row-1); col++) {
                        sum += map[row][col];
                    }
                }
            }
             
            // 3. 결과값 sum을 출력한다.
            sb.append(sum).append('\n');
        }
        System.out.print(sb);
    }
 
}