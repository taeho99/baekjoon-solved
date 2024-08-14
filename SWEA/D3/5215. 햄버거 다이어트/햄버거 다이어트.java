import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA.5215 햄버거 다이어트 
 *
 * 1. 햄버거 재료의 점수와 칼로리 정보를 입력받는다.
 * 2. 가능한 재료의 부분집합을 구한다. ( 현재 재료를 선택하거나 선택하지 않거나 -> 부분집합 )
 * 2-1. 가능한 재료 조합의 칼로리 합과 점수 합을 구한다.
 * 2-2. (재료의 칼로리 합 > 제한 칼로리)인 경우 모든 재료가 선택되지 않았어도 종료한다.
 * 2-3. 모든 재료를 확인한 경우 종료
 * 2-3-1. (재료의 칼로리 합 <= 제한 칼로리)인 경우에만 최고 점수를 갱신해 결과를 갱신한다.
 * 3. 최고 점수를 출력한다.
 */
public class Solution {
	static int ELEMENT_COUNT, MAX_CALORIE, maxScore;
	static int[] calorieList, scoreList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');
			st = new StringTokenizer(br.readLine());
			ELEMENT_COUNT = Integer.parseInt(st.nextToken());
			MAX_CALORIE = Integer.parseInt(st.nextToken());

			scoreList = new int[ELEMENT_COUNT];
			calorieList = new int[ELEMENT_COUNT];
			
			// 1. 햄버거 재료의 점수와 칼로리 정보를 입력받는다.
			for(int elementIdx=0; elementIdx<ELEMENT_COUNT; elementIdx++) {
				st = new StringTokenizer(br.readLine());
				scoreList[elementIdx] = Integer.parseInt(st.nextToken());
				calorieList[elementIdx] = Integer.parseInt(st.nextToken());
			}
			
			maxScore = 0; // 최고 점수를 저장하는 변수 선언
			// 2. 가능한 재료의 부분집합을 구한다. ( 현재 재료를 선택하거나 선택하지 않거나 -> 부분집합 )
			powerSet(0, 0, 0);
			
			// 3. 최고 점수를 출력한다.
			sb.append(maxScore).append('\n');
		}
		System.out.print(sb);
	}
	

	// 2-1. 가능한 재료 조합의 칼로리 합과 점수 합을 구한다.
	private static void powerSet(int elementIdx, int sumCalorie, int sumScore) {
		// [가지 치기] 2-2. 이미 (재료의 칼로리 합 <= 제한 칼로리)이면 넘으면 종료한다.
		if(sumCalorie > MAX_CALORIE) return;

		// [기저 조건] 2-3. 모든 재료를 확인한 경우 종료
		if(elementIdx == ELEMENT_COUNT) {
			// 2-3-1. (재료의 칼로리 합 <= 제한 칼로리) 인 경우에만 최고 점수를 갱신해 결과를 갱신한다.
			maxScore = Math.max(maxScore, sumScore);
			return;
		}
		
		// 현재 재료를 선택한 경우
		// 기존 sum 값에 현재 선택한 재료의 칼로리와 점수를 추가해준다.
		powerSet(elementIdx + 1, sumCalorie + calorieList[elementIdx], sumScore + scoreList[elementIdx]);
		
		// 현재 재료를 선택하지 않은 경우
		// 기존 sum 값을 그대로 전달한다.
		powerSet(elementIdx + 1, sumCalorie, sumScore);
	}

}
