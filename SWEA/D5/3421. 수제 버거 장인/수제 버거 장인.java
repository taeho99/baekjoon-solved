import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * SWEA.3421 수제 버거 장인
 *
 * 1. 재료 개수와 궁합이 맞지 않는 개수가 입력으로 들어온다.
 * 2. 재료로 가능한 모든 조합을 살펴본다. (부분집합)
 * 3-1. [가지 치기] 만약 지금까지 선택한 재료 중 궁합이 안맞는 재료가 있으면 종료한다.
 * 3-2. [기저 조건] 모든 재료를 확인해본 경우 종료한다.
 * 3-2-1. 모든 재료를 확인한 경우 조합이 가능한 재료만 있는 경우이므로 만들 수 있는 버거이다. 즉 totalCnt++
 * 4. totalCnt를 출력한다.
 */
public class Solution {
	static int ELEMENT_COUNT, NO_MIX_COUNT, totalCnt;
	static int[][] noMixList;
	static boolean[] elementList;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			// 1. 재료 개수와 궁합이 맞지 않는 개수가 입력으로 들어온다.
			st = new StringTokenizer(br.readLine());
			ELEMENT_COUNT = Integer.parseInt(st.nextToken());
			NO_MIX_COUNT = Integer.parseInt(st.nextToken());
			
			elementList = new boolean[ELEMENT_COUNT];
			noMixList = new int[NO_MIX_COUNT][2];
			
			for(int idx=0; idx<NO_MIX_COUNT; idx++) {
				st = new StringTokenizer(br.readLine());
				noMixList[idx][0] = Integer.parseInt(st.nextToken()) - 1;
				noMixList[idx][1] = Integer.parseInt(st.nextToken()) - 1;
			}
			
			// 2. 재료로 가능한 모든 조합을 살펴본다. (부분집합)
			totalCnt = 0; // 가능한 버거의 가짓 수
			powerSet(0);
			
			// 4. totalCnt를 출력한다.
			sb.append(totalCnt).append('\n');
		}
		System.out.print(sb);
	}
	
	private static void powerSet(int elementIdx) {
		// 3-1. [가지 치기] 만약 지금까지 선택한 재료 중 궁합이 안맞는 재료가 있으면 종료한다.
		if(isNoMix()) {
			return;
		}
		
		// 3-2. [기저 조건] 모든 재료를 확인해본 경우 종료한다.
		if(elementIdx == ELEMENT_COUNT) {
			// 3-2-1. 모든 재료를 확인한 경우 조합이 가능한 재료만 있는 경우이므로 만들 수 있는 버거이다. 즉 totalCnt++
			totalCnt++;
			return;
		}
		
		elementList[elementIdx] = true;
		powerSet(elementIdx + 1);
		
		elementList[elementIdx] = false;
		powerSet(elementIdx + 1);
	}
	
	private static boolean isNoMix() {
		for(int[] noMix : noMixList) {
			if(elementList[noMix[0]] && elementList[noMix[1]])
				return true;
		}
		return false;
	}

}
