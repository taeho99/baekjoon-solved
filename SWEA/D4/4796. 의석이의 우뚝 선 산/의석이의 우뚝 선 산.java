import java.util.Scanner;

/**
 * SWEA.4796 의석이의우뚝선산 
 * 
 * 1. 특정 지점의 개수와 그 지점의 높이를 입력으로 받는다.
 * 2. 특정 두 지점(i,j)이 될 수 있는 조합을 확인한다. (0~N-1) 조합으로 2개 뽑기
 * 3. 두 지점이 붙어있는 경우 제외
 * 4. 투 포인터로 왼쪽과 오른쪽에서 가운데 방향으로 봉우리를 구해 나간다.
 * 		4-1. 왼쪽과 오른쪽이 만나는 위치가 동일하면 우뚝 선 산이다.
 * 5. 우뚝 선 산의 개수를 출력한다.
 */
public class Solution {
	static int heightCount, SELECT_COUNT, totalCnt;
	static int[] heightList, selectPointList;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			// 1. 특정 지점의 개수와 그 지점의 높이를 입력으로 받는다.
			heightCount = sc.nextInt();
			SELECT_COUNT = 2;
			heightList = new int[heightCount];
			selectPointList = new int[SELECT_COUNT];
			
			for(int idx=0; idx<heightCount; idx++) {
				heightList[idx] = sc.nextInt();
			}
			
			totalCnt = 0;
			// 2. 특정 두 지점(i,j)이 될 수 있는 조합을 확인한다. (0~N-1) 조합으로 2개 뽑기
			int start=0;
			int high = heightList[0], low = 0;
			for(start=0; start<heightCount-1; start++) {
				if(heightList[start] < heightList[start+1]) {
					if(start > 1 && heightList[start-1] > heightList[start]) {
						low = 0;
					}
					low++;
					high = heightList[start+1];
				} else {
					if(heightList[start+1] < high) {
						totalCnt+= low;
					}
				}
			}
			
			// 5. 우뚝 선 산의 개수를 출력한다.
			sb.append(totalCnt).append('\n');
		}
		System.out.print(sb);
	}
	
}
