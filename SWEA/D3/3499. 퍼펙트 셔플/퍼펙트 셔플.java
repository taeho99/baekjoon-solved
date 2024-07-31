import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 카드를 절반으로 나누어 위에서부터 순서대로 셔플
 * 2. 홀수일 경우 먼저 놓은 쪽을 하나 더 들어가게 하기
 * 3. 놓여진 카드를 위에서부터 순서대로 출력
 */
public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		for(int t=1; t<=testCase; t++) {
			sb.append('#').append(t).append(' ');
			//데이터 입력 및 초기화
			int size = Integer.parseInt(br.readLine());
			String[] strArr = new String[size];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int idx=0; idx<size; idx++) {
				strArr[idx] = st.nextToken();
			}
			
			//halfSize: 짝수면 그대로 절반크기 저장, 홀수면 반올림하여 저장
			int halfSize = (size+1)/2;
			
			//(halfSize-1)번 반복문을 돈다.
			//이러면 마지막에 짝수는 카드 2개, 홀수는 카드 1개가 남게 됨
			for(int idx=0; idx<halfSize - 1; idx++) {
				sb.append(strArr[idx]).append(' ');
				sb.append(strArr[idx + halfSize]).append(' ');
			}

			//짝수는 남은 카드 2개 추가, 홀수는 1개만 추가
			sb.append(strArr[halfSize-1]).append(' ');
			if(size%2 == 0)
				sb.append(strArr[size-1]);
			
			sb.append('\n');
		}
		System.out.print(sb);
	}

}
