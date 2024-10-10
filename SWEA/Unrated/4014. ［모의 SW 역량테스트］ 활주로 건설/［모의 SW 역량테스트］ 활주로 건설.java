import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 	SWEA.4104 활주로건설
 * 
 * 	1. 맵의 크기와 경사로 길이 X를 입력받는다.
 * 	2. 가로 방향 확인
 * 		2-1. 오른쪽 위치 칸과 평지일 경우 평지 길이 증가
 * 		2-2. 오르막 길일 경우
 * 			2-2-1. 직전이 오르막길 이면서 평지 길이가 X 이상 || 직전이 내리막길 이면서 평지 길이가 2*X 이상
 * 				2-2-1-1. 내리막길 여부 false 변경 후  평지 길이 초기화
 * 			2-2-2. 활주로 건설 불가능한 경우 isOk를 false로 변경
 * 		2-3. 내리막 길일 경우
 * 			2-3-1. 직전이 오르막길 || 직전이 내리막길이면서 평지 길이가 X 이상
 * 				2-3-1-1. 내리막길 여부 true 변경 후 평지 길이 초기화
 * 			2-3-2. 활주로 건설 불가능한 경우 isOk를 false로 변경
 * 		2-4. 단차가 2 이상 나는 경우
 * 			2-4-1. 활주로 건설 불가능한 경우 isOk를 false로 변경
 * 		2-5. 활주로 건설 불가능하므로 break
 * 		2-6. 마지막이 내리막길인데 평지 길이가 X보다 작으면 활주로 건설 불가능함
 * 		2-7. isOk == true -> 활주로 건설 가능! 결과값 1 증가!
 * 	3. 세로 방향 확인 (과정은 가로와 동일함)
 * 	4. 결과값 출력
 */
public class Solution {
	static int size, X, result;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append('#').append(tc).append(' ');

			// 1. 맵의 크기와 경사로 길이 X를 입력받는다.
			st = new StringTokenizer(br.readLine());
			size = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());

			map = new int[size][size];
			for (int row = 0; row < size; row++) {
				st = new StringTokenizer(br.readLine());
				for (int col = 0; col < size; col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
				}
			}

			result = 0;

			// 2. 가로 방향 확인
			for (int row = 0; row < size; row++) {
				int cnt = 1; // 지금까지 평지 길이
				boolean isDown = false; // 내리막길 여부
				boolean isOk = true; // 활주로 건설 가능 여부
				for (int col = 0; col < size - 1; col++) {
					// 2-1. 오른쪽 위치 칸과 평지일 경우 평지 길이 증가
					if (map[row][col] == map[row][col + 1]) {
						cnt++;
					} 
					
					// 2-2. 오르막 길일 경우
					else if (map[row][col] + 1 == map[row][col + 1]) {
						// 2-2-1. 직전이 오르막길 이면서 평지 길이가 X 이상 || 직전이 내리막길 이면서 평지 길이가 2*X 이상
						if ((!isDown && cnt >= X) || (isDown && cnt >= 2 * X)) {
							// 2-2-1-1. 내리막길 여부 false 변경 후  평지 길이 초기화
							isDown = false;
							cnt = 1;
						} 
						// 2-2-2. 활주로 건설 불가능한 경우 isOk를 false로 변경
						else {
							isOk = false;
						}
					} 
					
					// 2-3. 내리막 길일 경우
					else if (map[row][col] - 1 == map[row][col + 1]) {
						// 2-3-1. 직전이 오르막길 || 직전이 내리막길이면서 평지 길이가 X 이상
						if (!isDown || (isDown && cnt >= X)) {
							// 2-3-1-1. 내리막길 여부 true 변경 후 평지 길이 초기화
							isDown = true;
							cnt = 1;
						} 
						// 2-3-2. 활주로 건설 불가능한 경우 isOk를 false로 변경
						else {
							isOk = false;
						}
					} 
					
					// 2-4. 단차가 2 이상 나는 경우
					else {
						// 2-4-1. 활주로 건설 불가능한 경우 isOk를 false로 변경
						isOk = false;
					}

					// 2-5. 활주로 건설 불가능하므로 break
					if (!isOk)
						break;
				}

				// 2-6. 마지막이 내리막길인데 평지 길이가 X보다 작으면 활주로 건설 불가능함
				if (isDown && cnt < X) 
					isOk = false;
				
				// 2-7. isOk == true -> 활주로 건설 가능! 결과값 1 증가!
				if (isOk)
					result++;
			}

			// 3. 세로 방향 확인 (과정은 가로와 동일함)
			for (int col = 0; col < size; col++) {
				int cnt = 1;
				boolean isDown = false;
				boolean isOk = true;
				for (int row = 0; row < size - 1; row++) {
					if (map[row][col] == map[row+1][col]) {
						cnt++;
					} else if (map[row][col] + 1 == map[row+1][col]) { // 오르막
						if ((!isDown && cnt >= X) || (isDown && cnt >= 2 * X)) {
							isDown = false;
							cnt = 1;
						} else {
							isOk = false;
						}
					} else if (map[row][col] - 1 == map[row+1][col]) { // 내리막
						if (!isDown || (isDown && cnt >= X)) {
							isDown = true;
							cnt = 1;
						} else {
							isOk = false;
						}
					} else {
						isOk = false;
					}
					if (!isOk)
						break;
				}

				if (isDown && cnt < X)
					continue;
				if (isOk)
					result++;
			}
			
			// 4. 결과값 출력
			sb.append(result).append('\n');
		}

		System.out.print(sb);
	}
}