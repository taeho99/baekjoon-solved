import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *	SWEA.5658 보물상자비밀번호
 *
 *	1. 숫자 개수와 k번째 인덱스를 입력받는다.
 *	2. 숫자를 문자열로 입력받는다.
 *		2-1. 숫자를 회전시키는 대신 숫자를 2배 길이로 늘려준다.
 *	3. 한 변의 숫자 개수만큼 회전시켜준다.
 *		3-1. 변 4개 모두 확인
 *			3-1-1. 한 변에 있는 수를 10진수로 변환 후 중복 제거를 위해 set에 넣기
 *	4. set를 list로 변환 후 내림차순 정렬하기
 *	5. k번째 인덱스에 있는 값 출력하기
 */
public class Solution {
	static int size, kIdx;
	static String nums;
	static Set<Integer> set;
	static List<Integer> list;
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			sb.append('#').append(tc).append(' ');
			
			// 1. 숫자 개수와 k번째 인덱스를 입력받는다.
			st = new StringTokenizer(br.readLine());
			size = Integer.parseInt(st.nextToken());
			kIdx = Integer.parseInt(st.nextToken())-1; // 인덱스므로 -1
			
			// 2. 숫자를 문자열로 입력받는다.
			nums = br.readLine();
			// 2-1. 숫자를 회전시키는 대신 숫자를 2배 길이로 늘려준다.
			nums = nums + nums;
			
			set = new HashSet<>();
			int quater = size/4;
			// 3. 한 변의 숫자 개수만큼 회전시켜준다.
			for(int rotate=0; rotate<quater; rotate++) {
				// 3-1. 변 4개 모두 확인
				for(int dir=0; dir<4; dir++) {
					// 3-1-1. 한 변에 있는 수를 10진수로 변환 후 중복 제거를 위해 set에 넣기
					int start = quater*dir + rotate;
					int end = quater*(dir+1) + rotate;
					int num = Integer.parseInt(nums.substring(start, end), 16);
					set.add(num);
				}
			}
			
			// 4. set를 list로 변환 후 내림차순 정렬하기
			list = new ArrayList<>(set);
			Collections.sort(list, Comparator.reverseOrder());
			
			// 5. k번째 인덱스에 있는 값 출력하기
			sb.append(list.get(kIdx)).append('\n');
		}
		System.out.print(sb);
	}
}