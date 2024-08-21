import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
/**
 * 	SWEA.6109 추억의2048게임
 * 
 *  1. 맵의 크기와 방향, 맵의 데이터를 입력받는다.
 *  2. 미는 방향에 따라 4가지 경우로 분류한다. up을 제외한 경우는 배열을 회전한 후 up 한 후 다시 원래 상태로 돌린다.
 *  	2-1. up: 원본 배열을 회전시키지 않고 up 한다.
 *  	2-2. down: 원본 배열을 180도 회전 후 up한 뒤 다시 180도 회전시킨다.
 *  	2-3. left: 원본 배열을 90도 회전시킨 후 up한 뒤 다시 270도 회전시킨다.
 *  	2-4. right: 원본 배열을 270도 회전시킨 후 up한 뒤 다시 90도 회전시킨다.
 *  3. up 방향으로 숫자들을 모두 합친다음에 up 방향으로 민다.
 *  	3-1. 현재 row기준으로 값이 0이 아닌 nextRow를 찾는다.
 *  	3-2. row 값과 nextRow 값이 같으면 합칠 수 있다. row에 합친 후 nextRow를 0으로 바꿔준다.
 *  	3-3. up 방향으로 밀어준다. 0인 칸은 밀지 않고 0이 아닌 경우 위에서부터 차례대로 값을 넣어준다.
 *  4. 완성된 맵을 출력한다.
 */
public class Solution {
    static int size;
    static int[][] map, answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for(int t=1; t<=testCase; t++) {
            sb.append('#').append(t).append('\n');
 
            // 1. 맵의 크기와 방향, 맵의 데이터를 입력받는다.
            st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());
            map = new int[size][size];
            answer = new int[size][size];
            String cmd = st.nextToken();
 
            for(int row=0; row<size; row++) {
                st = new StringTokenizer(br.readLine());
                for(int col=0; col<size; col++) {
                    map[row][col] = Integer.parseInt(st.nextToken());
                }
            }
 
            // 2. 미는 방향에 따라 4가지 경우로 분류한다. up을 제외한 경우는 배열을 회전한 후 up 한 후 다시 원래 상태로 돌린다.
            switch(cmd) {
            	// 2-1. up: 원본 배열을 회전시키지 않고 up 한다.
                case "up":
                    up();
                    break;
                // 2-2. down: 원본 배열을 180도 회전 후 up한 뒤 다시 180도 회전시킨다.
                case "down":
                	rotate180();
                	up();
                	rotate180();
                    break;
                // 2-3. left: 원본 배열을 90도 회전시킨 후 up한 뒤 다시 270도 회전시킨다.
                case "left":
                	rotate90();
                	up();
                	rotate270();
                    break;
                // 2-4. right: 원본 배열을 270도 회전시킨 후 up한 뒤 다시 90도 회전시킨다.
                case "right":
                	rotate270();
                	up();
                	rotate90();
                    break;
            }
            // 4. 완성된 맵을 출력한다.
        	printArr();
        }
        System.out.print(sb);
    }
 
    // 3. up 방향으로 숫자들을 모두 합친다음에 up 방향으로 민다.
    private static void up() {
        for(int col=0; col<size; col++) {
            for(int row=0; row<size-1; row++) {
                if(map[row][col] == 0) continue;
                int nextRow = row+1;
 
                // 3-1. 현재 row기준으로 값이 0이 아닌 nextRow를 찾는다.
                while(map[nextRow][col] == 0) {
                    if(nextRow == size-1) break;
                    nextRow++;
                }
 
                // 3-2. row 값과 nextRow 값이 같으면 합칠 수 있다. row에 합친 후 nextRow를 0으로 바꿔준다.
                if(map[row][col] == map[nextRow][col]) {
                    map[row][col] += map[nextRow][col];
                    map[nextRow][col] = 0;
                    row = nextRow;
                }
            }
        }
 
        // 3-3. up 방향으로 밀어준다. 0인 칸은 밀지 않고 0이 아닌 경우 위에서부터 차례대로 값을 넣어준다.
        for(int col=0; col<size; col++) {
            int nextRow = 0;
            for(int row=0; row<size; row++) {
                if(map[row][col] != 0) {
                    answer[nextRow++][col] = map[row][col];
                }
            }
        }
        map = answer;
    }
    
    private static void rotate90() {
    	int[][] tmpArr = new int[size][size];
    	for(int row=0; row<size; row++){
    		for(int col=0; col<size; col++) tmpArr[col][size-1-row] = map[row][col];
    	}
    	map = tmpArr;
    }
    
    private static void rotate180() {
    	int[][] tmpArr = new int[size][size];
    	for(int row=0; row<size; row++){
    		for(int col=0; col<size; col++) tmpArr[size-1-row][size-1-col] = map[row][col];
    	}
    	map = tmpArr;
    }
    
    private static void rotate270() {
    	int[][] tmpArr = new int[size][size];
    	for(int row=0; row<size; row++){
    		for(int col=0; col<size; col++) tmpArr[size-1-col][row] = map[row][col];
    	}
    	map = tmpArr;
    }
    
    private static void printArr() {
    	for(int row=0; row<size; row++) {
            for(int col=0; col<size; col++) {
                sb.append(map[row][col]).append(' ');
            }
            sb.append('\n');
        }
    }
}