import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static String[] flag;
    static int[] pointer;
    static boolean[] visited;
    static int rowSize, colSize, result;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        
        for(int t=1; t<=testCase; t++) {
        	sb.append('#').append(t).append(' ');
        	st = new StringTokenizer(br.readLine());
        	rowSize = Integer.parseInt(st.nextToken());
        	colSize = Integer.parseInt(st.nextToken());
        	
        	flag = new String[rowSize];
        	pointer = new int[2];
            visited = new boolean[rowSize-1];
            result = Integer.MAX_VALUE;
            
            for(int row=0; row<rowSize; row++) {
            	flag[row] = br.readLine();
            }
            
            dfs(rowSize-1, 2, 0, 0);
            sb.append(result).append('\n');
        }
        
        System.out.print(sb);
    }

    private static void dfs(int n, int m, int depth, int at) {
        if(depth == m) {
            result = Math.min(result, match());
            return;
        }

        for(int i=at; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                pointer[depth] = i+1;
                dfs(n, m, depth+1, i+1);
                visited[i] = false;
            }
        }
    }

	private static int match() {
		int diffCnt = 0;
		
		//white matching
		for(int row=0; row<pointer[0]; row++) {
			for(char ch : flag[row].toCharArray()) {
				if(ch != 'W') diffCnt++;
			}
		}
		
		//blue matching
		for(int row=pointer[0]; row<pointer[1]; row++) {
			for(char ch : flag[row].toCharArray()) {
				if(ch != 'B') diffCnt++;
			}
		}
		
		//red matching
		for(int row=pointer[1]; row<rowSize; row++) {
			for(char ch : flag[row].toCharArray()) {
				if(ch != 'R') diffCnt++;
			}
		}
		
		return diffCnt;
	}
}
