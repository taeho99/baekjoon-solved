import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ.15650 N과 M (2)
 * 
 *  1. N과 M을 입력받는다.
 *  2. N개 중 중복 없이 M개를 고르므로 조합 문제이다.
 *  3. 기저 조건: M개를 모두 선택한 경우 종료한다.
 *  3-1. 선택된 원소를 출력한다.
 *  4-1. 현재 원소를 선택하는 경우 selectList에 (현재인덱스+1)을 담는다.
 *  	4-1-1. 다음 원소를 탐색한다.
 *  4-2. 현재 원소를 선택하지 않는 경우 selectList에 0을 담는다.
 *		4-2.1. 다음 원소를 탐색한다.
 */
public class Main {
	static int ELEMENT_COUNT, SELECT_COUNT;
	static int[] selectList;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 1. N과 M을 입력받는다.
		ELEMENT_COUNT = Integer.parseInt(st.nextToken());
		SELECT_COUNT = Integer.parseInt(st.nextToken());
		selectList = new int[SELECT_COUNT];
		
		// 2. N개 중 중복 없이 M개를 고르므로 조합 문제이다.
		combination(0, 0);
		System.out.print(sb);
	}
	
	private static void combination(int elementIdx, int selectIdx) {
		// 3. 기저 조건: M개를 모두 선택한 경우 종료한다.
		if(selectIdx == SELECT_COUNT) {
			// 3-1. 선택된 원소를 출력한다.
			for(int select : selectList) {
				sb.append(select).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		if(elementIdx == ELEMENT_COUNT) {
			return;
		}
		
		// 4-1. 현재 원소를 선택하는 경우 selectList에 (현재인덱스+1)을 담는다.
		selectList[selectIdx] = elementIdx + 1;
		// 4-1-1. 다음 원소를 탐색한다.
		combination(elementIdx + 1, selectIdx + 1);
		
		// 4-2. 현재 원소를 선택하지 않는 경우 selectList에 0을 담는다.
		selectList[selectIdx] = 0;
		// 4-2-1. 다음 원소를 탐색한다.
		combination(elementIdx + 1, selectIdx);
	}
}
