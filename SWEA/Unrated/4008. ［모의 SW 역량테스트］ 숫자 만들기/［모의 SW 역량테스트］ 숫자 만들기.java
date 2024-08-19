import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA.4008 숫자만들기
 *
 * 1. 숫자의 개수 NUMBER_COUNT를 입력받는다.
 * 		1-1. 연산자의 개수(OP_COUNT)는 NUMBER_COUNT-1이다.
 * 2. 연산자를 opList에 넣어준다.
 * 3. 숫자를 numberList에 넣어준다.
 * 4. 연산자의 순서를 중복순열을 통해 순서를 바꾼다. 파라미터로 중간 결과값을 전달한다.
 * 		4-0. [기저조건] 모든 연산자가 선택되고 결과값까지 계산되었다면 MAX값과 MIN값을 갱신한다.
 * 		4-1. 연산자가 없는 경우는 선택하지 않는다.
 * 		4-2. 현재 선택된 연산자에 따라 중간 결과값에 새로운 수를 더하거나 빼는 등 연산한다.
 * 		4-3. 모든 연산자가 선택될 때까지 재귀반복한다.
 * 5. 최댓값(MAX)과 최솟값(MIN)의 차이를 출력한다.
 */
public class Solution {
	static char[] operator = {'+', '-', '*', '/'};
	static int NUMBER_COUNT, OP_COUNT, MAX, MIN;
	static int[] numberList, opList;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			// 1. 숫자의 개수 NUMBER_COUNT를 입력받는다.
			NUMBER_COUNT = Integer.parseInt(br.readLine());
			// 1-1. 연산자의 개수(OP_COUNT)는 NUMBER_COUNT-1이다.
			OP_COUNT = NUMBER_COUNT - 1;
			
			numberList = new int[NUMBER_COUNT];
			opList = new int[4];
			
			// 2. 연산자를 opList에 넣어준다.
			st = new StringTokenizer(br.readLine());
			for(int opIdx=0; opIdx<opList.length; opIdx++) {
				opList[opIdx] = Integer.parseInt(st.nextToken());
			}
			
			// 3. 숫자를 numberList에 넣어준다.
			st = new StringTokenizer(br.readLine());
			for(int idx=0; idx<NUMBER_COUNT; idx++) {
				numberList[idx] = Integer.parseInt(st.nextToken());
			}
			
			// 4. 연산자의 순서를 중복순열을 통해 순서를 바꾼다. 파라미터로 중간 결과값을 전달한다.
			MAX = Integer.MIN_VALUE;
			MIN = Integer.MAX_VALUE;
			permutation(0, numberList[0]);
			
			sb.append(MAX - MIN).append('\n');
		}
		System.out.print(sb);
	}
	
	static void permutation(int selectIdx, int nowValue) {
		// 4-0. [기저조건] 모든 연산자가 선택되고 결과값까지 계산되었다면 MAX값과 MIN값을 갱신한다.
		if(selectIdx == OP_COUNT) {
			MAX = Math.max(MAX, nowValue);
			MIN = Math.min(MIN, nowValue);
			return;
		}
		
		for(int opIdx=0; opIdx<opList.length; opIdx++) {
			// 4-1. 연산자가 없는 경우는 선택하지 않는다.
			if(opList[opIdx] == 0) continue;
			
			opList[opIdx]--;
			// 4-2. 현재 선택된 연산자에 따라 중간 결과값에 새로운 수를 더하거나 빼는 등 연산한다.
			char nextOperator = operator[opIdx];
			int nextValue = nowValue;
			if(nextOperator == '+') {
				nextValue += numberList[selectIdx + 1];
			} else if (nextOperator == '-') {
				nextValue -= numberList[selectIdx + 1];
			} else if (nextOperator == '*') {
				nextValue *= numberList[selectIdx + 1];
			} else {
				nextValue /= numberList[selectIdx + 1];
			}
			// 4-3. 모든 연산자가 선택될 때까지 재귀반복한다.
			permutation(selectIdx + 1, nextValue);
			opList[opIdx]++;
		}
	}
}
