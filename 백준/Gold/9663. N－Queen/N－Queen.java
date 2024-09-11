import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *	SWEA.2806 N-Queen
 *	
 */
public class Main {
	static int n, result;
	static int[] colIdx;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		colIdx = new int[n];
		backtrack(0);
			
		System.out.print(result);
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