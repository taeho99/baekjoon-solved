import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ.2961 도영이가 만든 맛있는 음식 
 *
 * 1. 재료의 개수(ELEMENT_COUNT)와 그 재료의 신맛(elementList[][0]) 쓴맛(elementList[][1])을 입력받는다.
 * 2. 재료의 모든 부분 집합을 탐색한다. 탐색할 때는 신맛과 쓴맛을 파라미터에 담아 저장한다.
 * 2-1. 재료를 아무것도 넣지 않은 경우는 제외한다. (쓴맛의 합이 0인 경우이다. 쓴맛은 항상 양의 정수가 들어오기 때문)
 * 2-2. 신맛(sour)와 쓴맛(bitter)의 차이를 결과값에 갱신한다.
 * 3-1. 현재 재료를 넣은 상태(신맛을 곱하고, 쓴맛을 더한 상태)에서 다음 재료를 탐색한다.
 * 3-2. 현재 재료를 넣지 않은 상태(현재 상태 그대로)에서 다음 재료를 탐색한다.
 * 4. 결과값을 출력한다.
 */
public class Main {
	static int ELEMENT_COUNT, minDiff = Integer.MAX_VALUE;
	static int[][] elementList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 1. 재료의 개수(ELEMENT_COUNT)와 그 재료의 신맛(elementList[][0]) 쓴맛(elementList[][1])을 입력받는다.
		ELEMENT_COUNT = Integer.parseInt(br.readLine());
		elementList = new int[ELEMENT_COUNT][2];
		
		for(int elementIdx=0; elementIdx<ELEMENT_COUNT; elementIdx++) {
			st = new StringTokenizer(br.readLine());
			elementList[elementIdx][0] = Integer.parseInt(st.nextToken());
			elementList[elementIdx][1] = Integer.parseInt(st.nextToken());
		}
		
		// 2. 재료의 모든 부분 집합을 탐색한다. 탐색할 때는 신맛과 쓴맛을 파라미터에 담아 저장한다.
		powerSet(0, 1, 0);
		
		// 4. 결과값을 출력한다.
		System.out.println(minDiff);
	}
	private static void powerSet(int elementIdx, int sour, int bitter) {
		// [기저 조건] 모든 원소를 탐색한 경우
		if(elementIdx == ELEMENT_COUNT) {
			// 2-1. 재료를 아무것도 넣지 않은 경우는 제외한다. (쓴맛의 합이 0인 경우이다. 쓴맛은 항상 양의 정수가 들어오기 때문)
			if(bitter == 0) return;
			
			// 2-2. 신맛(sour)와 쓴맛(bitter)의 차이를 결과값에 갱신한다.
			minDiff = Math.min(minDiff, Math.abs(sour - bitter));
			return;
		}
		
		// 3-1. 현재 재료를 넣은 상태(신맛을 곱하고, 쓴맛을 더한 상태)에서 다음 재료를 탐색한다.
		powerSet(elementIdx + 1, sour * elementList[elementIdx][0], bitter + elementList[elementIdx][1]);
		
		// 3-2. 현재 재료를 넣지 않은 상태(현재 상태 그대로)에서 다음 재료를 탐색한다.
		powerSet(elementIdx + 1, sour, bitter);
	}

}
