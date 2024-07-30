import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 계단 N개에서 인접한 계단의 올라갈 때 최대 높이 차이와 내려갈 때 최대 높이 차이를 출력하라
 */
public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int totalCase = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=totalCase; testCase++) {
			int size = Integer.parseInt(br.readLine());
			int[] block = new int[size];
			int maxUp = 0, maxDown = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			block[0] = Integer.parseInt(st.nextToken());
			for(int idx=1; idx<size; idx++) {
				block[idx] = Integer.parseInt(st.nextToken());
				if(block[idx-1] < block[idx]) { //올라갈 때
					maxUp = Math.max(maxUp, block[idx] - block[idx-1]);
				} else { //내려갈 때
					maxDown = Math.max(maxDown, block[idx-1] - block[idx]);
				}
			}
			
			System.out.println("#" + testCase + " " + maxUp + " " + maxDown);
		}
	}

}
