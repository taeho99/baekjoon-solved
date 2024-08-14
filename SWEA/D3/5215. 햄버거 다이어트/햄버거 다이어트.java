import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA.5215 햄버거 다이어트 
 *
 * 1. 햄버거 재료의 점수와 칼로리 정보를 입력받는다.
 * 2. 가능한 재료의 조합을 1개~ELEMENT_COUNT개 모두 확인해본다.
 * 2-1. 가능한 재료 조합의 칼로리 합과 점수 합을 구한다.
 * 2-2. (재료의 칼로리 합 <= 제한 칼로리) 인 경우에만 최고 점수를 갱신해 결과를 갱신한다.
 * 3. 최고 점수를 출력한다.
 */
public class Solution {
	static int ELEMENT_COUNT, SELECT_COUNT, MAX_CALORIE, maxScore;
	static int[] calorieList, selectList, scoreList;
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
			// 2. 가능한 재료의 조합을 1개~ELEMENT_COUNT개 모두 확인해본다.
			for(SELECT_COUNT=1; SELECT_COUNT<=ELEMENT_COUNT; SELECT_COUNT++) {
				selectList = new int[SELECT_COUNT];
				combination(0, 0, 0, 0);
			}
			
			// 3. 최고 점수를 출력한다.
			sb.append(maxScore).append('\n');
		}
		System.out.print(sb);
	}
	
	private static void combination(int elementIdx, int selectIdx, int sumCalorie, int sumScore) {
		if(sumCalorie > MAX_CALORIE) return;
		
		// 기저 조건: 모든 재료를 선택한 경우 종료
		if(selectIdx == SELECT_COUNT) {
			
			// 2-1. 가능한 재료 조합의 칼로리 합과 점수 합을 구한다.
			// 2-2. (재료의 칼로리 합 <= 제한 칼로리) 인 경우에만 최고 점수를 갱신해 결과를 갱신한다.
			maxScore = Math.max(maxScore, sumScore);
			return;
		}
		
		// 모든 재료를 확인한 경우 종료
		if(elementIdx == ELEMENT_COUNT) {
			return;
		}
		
		// 현재 재료를 선택한 경우
		// 기존 sum 값에 현재 선택한 재료의 칼로리와 점수를 추가해준다.
		selectList[selectIdx] = elementIdx;
		combination(elementIdx + 1, selectIdx + 1, sumCalorie + calorieList[elementIdx], sumScore + scoreList[elementIdx]);
		
		// 현재 재료를 선택하지 않은 경우
		// 기존 sum 값을 그대로 전달한다.
		selectList[selectIdx] = 0;
		combination(elementIdx + 1, selectIdx, sumCalorie, sumScore);
	}

}
