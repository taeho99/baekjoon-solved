import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *	SWEA.2806 N-Queen
 *	
 */
public class Solution {
	static int n, result;
	static int[] colIdx;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			n = Integer.parseInt(br.readLine());
			
			result = 0;
			colIdx = new int[n];
			backtrack(0);
			
			sb.append(result).append('\n');
		}
		System.out.print(sb);
	}
	
	private static void backtrack(int rowIdx) {
		if(!isPromise(rowIdx-1)) return;
		
		if(rowIdx == n) {
			result++;
			return;
		}
		
	
		for(int col=0; col<n; col++) {
			colIdx[rowIdx] = col;
			backtrack(rowIdx+1);
		}
	}
	
	private static boolean isPromise(int rowIdx) {
		for(int row=0; row<rowIdx; row++) {
			if(colIdx[row] == colIdx[rowIdx] 
					|| rowIdx-row == Math.abs(colIdx[rowIdx]-colIdx[row])) {
				return false;
			}
		}
		return true;
	}
}