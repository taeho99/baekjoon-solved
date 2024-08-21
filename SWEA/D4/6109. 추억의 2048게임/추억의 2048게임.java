import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
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
 
            switch(cmd) {
                case "up":
                    up();
                    break;
                case "down":
                	rotate180();
                	up();
                	rotate180();
                    break;
                case "left":
                	rotate90();
                	up();
                	rotate270();
                    break;
                case "right":
                	rotate270();
                	up();
                	rotate90();
                    break;
            }
        	printArr();
        }
        System.out.print(sb);
    }
 
    private static void up() {
        for(int col=0; col<size; col++) {
            for(int row=0; row<size-1; row++) {
                if(map[row][col] == 0) continue;
                int nextRow = row+1;
 
                while(map[nextRow][col] == 0) {
                    if(nextRow == size-1) break;
                    nextRow++;
                }
 
                if(map[row][col] == map[nextRow][col]) {
                    map[row][col] += map[nextRow][col];
                    map[nextRow][col] = 0;
                    row = nextRow;
                }
            }
        }
 
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